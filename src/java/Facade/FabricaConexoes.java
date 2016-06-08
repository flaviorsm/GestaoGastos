package Facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FabricaConexoes {

    private String status = "Não conectou...";
    
    public FabricaConexoes() {}

    public Connection Conexao() {    
        Connection connection = null;          //atributo do tipo Connection
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");            
            String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase = "gestao";        //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";        //nome de um usuário de seu BD     
            String password = "root";      //sua senha de acesso
            
            connection = DriverManager.getConnection(url, username, password);
 
            if (connection != null) { 
                status = ("STATUS -> Conectado com sucesso!");
            } else {
                status = ("STATUS -> Não foi possivel realizar conexão");
            }
            return connection;
        } 
        catch (ClassNotFoundException e)
        {
            status += " -> O driver expecificado nao foi encontrado.";
            return null;
 
        } 
        catch (SQLException e) 
        {
            status += " -> Nao foi possivel conectar ao Banco de Dados.";
            return null;
        }
    }
    
    public boolean FecharConexao() {
        try 
        {
            this.Conexao().close();
            return true;
        } 
        catch (SQLException e)
        { 
            return false;
        }
    }
    
    public Statement Connectar(){
        try
        {
            Connection con = Conexao();
            return con.createStatement();
        }
        catch(SQLException e)
        {
            return null;
        }
    }

    //Método que retorna o status da sua conexão//
    public String getStatus() {
        return status;
    }
}
