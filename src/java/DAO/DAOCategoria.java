
package DAO;

import Facade.FabricaConexoes;
import Interface.IGestao;
import Modelo.ModelCategoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

@WebService(serviceName = "DAOCategoria")
public class DAOCategoria implements IGestao{

    private final FabricaConexoes fabrica;
    
    public DAOCategoria() {
        fabrica = new FabricaConexoes();        
    }
    public void Save(Object parametro) {   
        ModelCategoria cat = (ModelCategoria)parametro;        
        try
        {                                
            Statement smt = fabrica.Connectar();  
            if(smt != null)
            {
                smt.executeUpdate("INSERT INTO Categoria(nome_categoria) "
                                + "VALUES ('" + cat.getNomeCategoria() + "')");                
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
        ModelCategoria cat = (ModelCategoria)parametro;           
        try
        {                   
            Statement smt = fabrica.Connectar(); 
            if(smt != null)
            {
                smt.executeUpdate("UPDATE Categoria SET nome_categoria = '"+ cat.getNomeCategoria()
                              + "' WHERE id_categoria = " + cat.getIdCategoria()); 
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
        ModelCategoria cat = new ModelCategoria();
        try
        {                   
            Statement smt = fabrica.Connectar(); 
            if(smt != null)
            {
                smt.executeUpdate("DELETE FROM Categoria WHERE id_categoria = " + identificador);
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
        List<ModelCategoria> listaCategoria = new ArrayList<>();
        try
        {                      
            Statement smt = fabrica.Connectar();             
            if(smt != null)
            {
                ResultSet rs = smt.executeQuery("SELECT * FROM Categoria");
                if(!rs.next()){
                   // msg = new NotificacaoMensagem("Arquivo não encontrado!", true);
                }
                else{                    
                    while(rs.next()){
                        ModelCategoria c = new ModelCategoria();
                        c.setIdCategoria(Integer.parseInt(rs.getString("id_categoria")));
                        c.setNomeCategoria(rs.getString("nome_categoria"));
                        listaCategoria.add(c);                                            
                    }
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
        return listaCategoria;
    }

    @Override
    public Object ObterPorId(int identificador) {
        ModelCategoria cat = null;
        try
        {                   
            Statement smt = fabrica.Connectar(); 
            if(smt != null)
            {
                ResultSet rs = smt.executeQuery("SELECT * FROM Categoria WHERE id_categoria = " + identificador);
                while(rs.next()){
                    cat = new ModelCategoria();
                    cat.setIdCategoria(Integer.parseInt(rs.getString("id_categoria")));
                    cat.setNomeCategoria(rs.getString("nome_categoria"));                    
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
        return cat;
    }
}
