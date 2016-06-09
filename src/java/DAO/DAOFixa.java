package DAO;

import Facade.FabricaConexoes;
import Interface.IGestao;
import Modelo.ModelFixa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aluno
 */
public class DAOFixa implements IGestao{

    private final FabricaConexoes fabrica;
    
    public DAOFixa() {
        fabrica = new FabricaConexoes();
    }
    
    @Override
    public void Save(Object parametro) {
        ModelFixa model = (ModelFixa)parametro;
        try
        {                                
            Statement smt = fabrica.Connectar();  
            if(smt != null)
            {
                smt.executeUpdate("INSERT INTO fixa(dia, descricao, valor, id_categoria) "
                                + "VALUES ('" + model.getData() + "', '"+ model.getDescricao() +"', "
                                + ""+ model.getValor() +", " + model.getIdCategoria() + ")");                
            }
            else
                throw new RuntimeException(fabrica.getStatus());
        }
        catch (SQLException e) 
        { 
            throw new RuntimeException(e);        
        }
        finally
        {            
            fabrica.FecharConexao();
        }
    }

    @Override
    public void Atualizar(Object parametro) {
        ModelFixa model = (ModelFixa)parametro;         
        try
        {                   
            Statement smt = fabrica.Connectar(); 
            if(smt != null)
            {
                smt.executeUpdate("UPDATE fixa SET dia = '"+ model.getData()+ "',"
                                                + "descricao =  '" + model.getDescricao() +"',"
                                                + "valor = " + model.getValor() + ","
                                                + "id_categoria = " + model.getIdCategoria()
                        + " WHERE id_fixa = " + model.getIdFixa()); 
            }
            else
                throw new RuntimeException(fabrica.getStatus()); 
        }
        catch (SQLException e) 
        { 
            throw new RuntimeException(e);        
        }
        finally
        {
            fabrica.FecharConexao();
        }
    }

    @Override
    public void Delete(int identificador) {
        ModelFixa cat = new ModelFixa();
        try
        {                   
            Statement smt = fabrica.Connectar(); 
            if(smt != null)
            {
                smt.executeUpdate("DELETE FROM Fixa WHERE id_fixa = " + identificador);
            }
            else
                throw new RuntimeException(fabrica.getStatus()); 
        }
        catch (SQLException e) 
        { 
            throw new RuntimeException(e);        
        }
        finally
        {
            fabrica.FecharConexao();
        }
    }

    @Override
    public List ObterLista() {
        
        List<ModelFixa> lista = new ArrayList<>();
        try
        {                      
            Statement smt = fabrica.Connectar(); 
            
            if(smt != null)
            {
                ResultSet rs = smt.executeQuery("SELECT * FROM fixa");                   
                while(rs.next()){
                    ModelFixa c = new ModelFixa();
                    c.setIdFixa(Integer.parseInt(rs.getString("id_fixa")));
                    c.setData(rs.getDate("dia"));                        
                    c.setDescricao(rs.getString("descricao"));
                    c.setValor(Float.parseFloat(rs.getString("valor")));
                    c.setIdCategoria(Integer.parseInt(rs.getString("id_categoria")));
                    lista.add(c);
                }                                        
            }
            else
                throw new RuntimeException(fabrica.getStatus()); 
        }
        catch (SQLException e) 
        { 
            throw new RuntimeException(e);        
        }
        finally
        {
            fabrica.FecharConexao();
        }
        return lista;
    }

    @Override
    public Object ObterPorId(int identificador) {
        ModelFixa fix = null;
        try
        {                   
            Statement smt = fabrica.Connectar(); 
            if(smt != null)
            {
                ResultSet rs = smt.executeQuery("SELECT * FROM fixa WHERE id_fixa = " + identificador);
                while(rs.next()){
                    fix = new ModelFixa();
                    fix.setIdFixa(Integer.parseInt(rs.getString("id_fixa")));
                    fix.setData(rs.getDate("dia"));                        
                    fix.setDescricao(rs.getString("descricao"));
                    fix.setValor(Float.parseFloat(rs.getString("valor")));
                    fix.setIdCategoria(Integer.parseInt(rs.getString("id_categoria")));
                }
            }
            else
                throw new RuntimeException(fabrica.getStatus());           
        }
        catch (SQLException | RuntimeException e) 
        { 
            throw new RuntimeException(e);        
        }
        finally
        {
            fabrica.FecharConexao();
        }
        return fix;
    }
    
}
