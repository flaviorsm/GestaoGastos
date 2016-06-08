/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Facade.FabricaConexoes;
import Interface.IGestao;
import Modelo.ModelCategoria;
import Modelo.ModelFixa;
import java.sql.Statement;
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
                smt.executeUpdate("INSERT INTO Fixa(Data, Descricao, Valor, id_categoria) "
                                + "VALUES (STR_TO_DATE('" + model.getData() + "', '%d-%m-%Y'), '"+ model.getDescricao() +"', "
                                + ""+ model.getValor() +", " + model.getIdCategoria() + ")");
                //MensagemErro("Inserido com sucesso;");
            }
            //else
                //MensagemErro("Não foi possivel conectar.");
        }
        catch(Exception e)
        {
            //MensagemErro("Erro: " + e.getMessage());
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
            //else
              //  MensagemErro("Não foi possivel conectar.");
        }
        catch(Exception e)
        {
            //MensagemErro("Erro: " + e.getMessage());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
