
package DAO;

import Facade.FabricaConexoes;
import Interface.IGestao;
import Modelo.NotificacaoMensagem;
import Modelo.ModelCategoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOCategoria implements IGestao{

    private final FabricaConexoes fabrica;
    private NotificacaoMensagem msg;
    
    public DAOCategoria() {
        fabrica = new FabricaConexoes();        
    }
    @Override
    public void Save(Object parametro) {   
        ModelCategoria cat = (ModelCategoria)parametro;        
        try
        {                                
            Statement smt = fabrica.Connectar();  
            if(smt != null)
            {
                smt.executeUpdate("INSERT INTO Categoria(nome_categoria) "
                                + "VALUES ('" + cat.getNomeCategoria() + "')");
                
                msg = new NotificacaoMensagem("Inserido com sucesso", false);                
            }
            else
                msg = new NotificacaoMensagem("Não foi possivel conectar.", true);            
        }
        catch(Exception e)
        {
            msg = new NotificacaoMensagem("Erro: " + e.getMessage(), true);           
        }
        finally
        {
            msg.Notificacao.add(msg);
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
                
                msg = new NotificacaoMensagem(cat.getNomeCategoria() + " alterado com sucesso;", false); 
            }
            else
                msg = new NotificacaoMensagem("Não foi possivel conectar.", true); 
        }
        catch(Exception e)
        {
            msg = new NotificacaoMensagem("Erro: " + e.getMessage(), true);   
        }
        finally
        {
            msg.Notificacao.add(msg);
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
                msg = new NotificacaoMensagem("Deletado com sucesso;", false);
            }
            else
                msg = new NotificacaoMensagem("Não foi possivel conectar.", true);            
        }
        catch(Exception e)
        {
            msg = new NotificacaoMensagem("Erro: " + e.getMessage(), true);         
        }
        finally
        {
            msg.Notificacao.add(msg);
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
                    msg = new NotificacaoMensagem("Arquivo não encontrado!", true);
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
                msg = new NotificacaoMensagem("Não foi possivel conectar.", true);
        }
        catch(SQLException | NumberFormatException e)
        {
            msg = new NotificacaoMensagem("Erro: " + e.getMessage(), true);            
        }
        finally
        {
            msg.Notificacao.add(msg);
            fabrica.FecharConexao();
        }
        return listaCategoria;
    }

    @Override
    public Object ObterPorId(int identificador) {
        try
        {                   
            ModelCategoria c = null;
            Statement smt = fabrica.Connectar(); 
            if(smt != null)
            {
                ResultSet rs = smt.executeQuery("SELECT * FROM Categoria WHERE id_categoria = " + identificador);
                if(!rs.next()){
                    msg = new NotificacaoMensagem("Arquivo não encontrado!", true);
                }
                else{
                    while(rs.next()){
                        c = new ModelCategoria();
                        c.setIdCategoria(Integer.parseInt(rs.getString("id_categoria")));
                        c.setNomeCategoria(rs.getString("nome_categoria"));
                    }
                }                
            }
            else
                msg = new NotificacaoMensagem("Não foi possivel conectar.", true);
            
            return c;
        }
        catch(SQLException | NumberFormatException e)
        {
            msg = new NotificacaoMensagem("Erro: " + e.getMessage(), true);            
        }
        finally
        {
            msg.Notificacao.add(msg);
            fabrica.FecharConexao();
        }
        return null;
    }
}
