package DAO;

import Facade.FabricaConexoes;
import Interface.IGestao;
import Modelo.ModelFixa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                smt.executeUpdate("INSERT INTO Fixa(Data, Descricao, Valor, id_categoria) "
                                + "VALUES (STR_TO_DATE('" + model.getData() + "', '%d-%m-%Y'), '"+ model.getDescricao() +"', "
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
                smt.executeUpdate("UPDATE Fixa SET Data = STR_TO_DATE('"+ model.getData()+ "', '%d-%m-%Y')"
                                                + "Descricao =  '" + model.getDescricao() +"'"
                                                + "Valor = " + model.getValor()
                                                + "id_categoria = " + model.getIdCategoria()
                        + "WHERE id_categoria = " + model.getIdCategoria()); 
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
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            if(smt != null)
            {
                ResultSet rs = smt.executeQuery("SELECT * FROM Fixa");                   
                while(rs.next()){
                    ModelFixa c = new ModelFixa();
                    c.setIdFixa(Integer.parseInt(rs.getString("id_fixa")));
                    c.setData((Date)formato.parse(rs.getString("Data")));                        
                    c.setDescricao(rs.getString("Descricao"));
                    c.setValor(Float.parseFloat(rs.getString("Valor")));
                    c.setIdCategoria(Integer.parseInt(rs.getString("id_categoria")));
                    lista.add(c);
                }                                        
            }
            else
                throw new RuntimeException(fabrica.getStatus()); 
        }
        catch (SQLException | ParseException e) 
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
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            if(smt != null)
            {
                ResultSet rs = smt.executeQuery("SELECT * FROM Fixa WHERE id_fixa = " + identificador);
                while(rs.next()){
                    fix = new ModelFixa();
                    fix.setIdFixa(Integer.parseInt(rs.getString("id_fixa")));
                    fix.setData((Date)formato.parse(rs.getString("Data")));                        
                    fix.setDescricao(rs.getString("Descricao"));
                    fix.setValor(Float.parseFloat(rs.getString("Valor")));
                    fix.setIdCategoria(Integer.parseInt(rs.getString("id_categoria")));
                }
            }
            else
                throw new RuntimeException(fabrica.getStatus());           
        }
        catch (SQLException | RuntimeException | ParseException e) 
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
