/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Facade.FabricaConexoes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author danilo
 */
public class DAOSaldo {
    

    private final FabricaConexoes fabrica;
    
    public DAOSaldo() {
        fabrica = new FabricaConexoes();        
    }
    public void Atualizar() {   
             
        try
        {                                
            Statement smt = fabrica.Connectar();  
            if(smt != null)
            {
                smt.executeUpdate("UPDATE Saldo SET saldo = (SELECT SUM(valor) FROM Movimentacao WHERE MONTH(data) = MONTH(NOW())) where id_saldo = 1" );                
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
    
     public float ObterSaldo() {   
             
         float s=0;
        try
        {                                
            Statement smt = fabrica.Connectar();  
            if(smt != null)
            {
                ResultSet rs = smt.executeQuery("SELECT saldo FROM Saldo where id_saldo=1" );
                
                while(rs.next()){
                  s = rs.getFloat("saldo");
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
        return s;
    }
    
}
