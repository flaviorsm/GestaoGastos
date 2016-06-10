package DAO;

import Facade.FabricaConexoes;
import Interface.IGestao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface = "ws.IGestao")
public class DAOSaldo implements IGestao{
    
    private final FabricaConexoes fabrica;
    
    public DAOSaldo() {
        fabrica = new FabricaConexoes();        
    }
    
    @Override
    public void Save(Object parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Atualizar(Object parametro) {
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

    @Override
    public void Delete(int identificador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List ObterLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ObterPorId(int identificador) {
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
