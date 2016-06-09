/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import DAO.DAOCategoria;
import DAO.DAOFixa;
import DAO.DAOMovimentacao;
import DAO.DAOSaldo;
import Modelo.ModelCategoria;
import Modelo.ModelFixa;
import Modelo.ModelMovimentacao;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author danilo
 */
@WebService(serviceName = "GestaodeGastos")
public class wsGestaodeGastos {

    /**
     * This is a sample web service operation
     *
     * @param txt
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "savecategoria")
    public void SaveCategoria(@WebParam(name = "objeto") ModelCategoria parametro) {

        DAOCategoria dao = new DAOCategoria();
        dao.Save(parametro);
    }

    @WebMethod(operationName = "savemovimentacao")
    public void SaveMovimentacao(@WebParam(name = "objeto") ModelMovimentacao parametro) {
        DAOMovimentacao dao = new DAOMovimentacao();
        dao.Save(parametro);
    }

    @WebMethod(operationName = "savefixa")
    public void SaveFixa(@WebParam(name = "objeto") ModelFixa parametro) {
        DAOFixa dao = new DAOFixa();
        dao.Save(parametro);

    }

    @WebMethod(operationName = "atualizarcategoria")
    public void AtualizarCategoria(@WebParam(name = "objeto") ModelCategoria parametro) {

        DAOCategoria dao = new DAOCategoria();
        dao.Atualizar(parametro);
    }

    @WebMethod(operationName = "atualizarmovimentacao")
    public void AtualizarMovimentacao(@WebParam(name = "objeto") ModelMovimentacao parametro) {
        DAOMovimentacao dao = new DAOMovimentacao();
        dao.Atualizar(parametro);
    }

    @WebMethod(operationName = "atualizarfixa")
    public void AtualizarFixa(@WebParam(name = "objeto") ModelFixa parametro) {
        DAOFixa dao = new DAOFixa();
        dao.Atualizar(parametro);
    }

    @WebMethod(operationName = "deletecategoria")
    public void DeleteCategoria(@WebParam(name = "id") int id) {

        DAOCategoria dao = new DAOCategoria();
        dao.Delete(id);
    }

    @WebMethod(operationName = "deletemovimentacao")
    public void DeleteMovimentacao(@WebParam(name = "id") int id) {
        DAOMovimentacao dao = new DAOMovimentacao();
        dao.Delete(id);
    }

    @WebMethod(operationName = "deletefixa")
    public void DeleteFixa(@WebParam(name = "id") int id) {
        DAOFixa dao = new DAOFixa();
        dao.Delete(id);
    }

    @WebMethod(operationName = "obterlistacategoria")
    public List<ModelCategoria> ObterListaCategoria() {

        List<ModelCategoria> lista = null;
        DAOCategoria dao = new DAOCategoria();
        lista = dao.ObterLista();
        return lista;

    }

    @WebMethod(operationName = "obterlistamovimentacao")
    public List<ModelMovimentacao> ObterListaMovimentacao() {
        List<ModelMovimentacao> lista = null;
        DAOMovimentacao dao = new DAOMovimentacao();
        lista = dao.ObterLista();
        return lista;
    }

    @WebMethod(operationName = "obterlistafixa")
    public List<ModelFixa> ObterListaFixa() {

        List<ModelFixa> lista = null;
        DAOFixa dao = new DAOFixa();
        dao.ObterLista();
        return lista;

    }

    @WebMethod(operationName = "obtersaldo")
    public float ObterSaldo() {

        DAOSaldo dao = new DAOSaldo();
        dao.Atualizar();

        return dao.ObterSaldo();

    }

}
