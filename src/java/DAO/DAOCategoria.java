
package DAO;

import Facade.FabricaConexoes;
import Interface.IGestao;
import Modelo.Mensagem;
import Modelo.ModelCategoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOCategoria implements IGestao{

    private final FabricaConexoes fabrica;
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
                MensagemErro("Inserido com sucesso;");
            }
            else
                MensagemErro("Não foi possivel conectar.");
        }
        catch(Exception e)
        {
            MensagemErro("Erro: " + e.getMessage());
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
                cat.setMensagem(cat.getNomeCategoria() + " alterado com sucesso;");
            }
            else
                MensagemErro("Não foi possivel conectar.");
        }
        catch(Exception e)
        {
            MensagemErro("Erro: " + e.getMessage());
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
                cat.setMensagem("Deletado com sucesso;");
            }
            else
                MensagemErro("Não foi possivel conectar.");
        }
        catch(Exception e)
        {
            MensagemErro("Erro: " + e.getMessage());
        }
    }

    @Override
    public List ObterLista() {
        try
        {                      
            Statement smt = fabrica.Connectar(); 
            List<ModelCategoria> listaCategoria = new ArrayList<>();
            if(smt != null)
            {
                ResultSet rs = smt.executeQuery("SELECT * FROM Categoria");
                if(rs != null)
                {                     
                    while(rs.next()){
                        ModelCategoria c = new ModelCategoria();
                        c.setIdCategoria(Integer.parseInt(rs.getString("id_categoria")));
                        c.setNomeCategoria(rs.getString("nome_categoria"));
                        listaCategoria.add(c);
                    }
                }
                else
                    MensagemErro("Arquivo não encontrado!");                                
            }
            else
                MensagemErro("Não foi possivel conectar.");
            
            return listaCategoria;
        }
        catch(SQLException | NumberFormatException e)
        {
            MensagemErro(e.getMessage());            
            return null;
        }
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
                    MensagemErro("Arquivo não encontrado!");
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
                MensagemErro("Não foi possivel conectar.");
            
            return c;
        }
        catch(SQLException | NumberFormatException e)
        {           
            MensagemErro("Erro: " + e.getMessage());
            return null;
        }
    }

    private void MensagemErro(String msg) {
        Mensagem m = new Mensagem();
        m.setErro(Boolean.TRUE);
        m.setMensagem(msg);
    }
    
    
}
