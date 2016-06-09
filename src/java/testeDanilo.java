
import DAO.DAOCategoria;
import DAO.DAOMovimentacao;
import DAO.DAOSaldo;
import Modelo.ModelCategoria;
import Modelo.ModelMovimentacao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ws.wsGestaodeGastos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author danilo
 */
public class testeDanilo {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        DAOMovimentacao dm = new DAOMovimentacao();
        ModelMovimentacao m = new ModelMovimentacao();

        // String data = "21/10/1989";
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Date d = sdf.parse(data);
        //m.setData(d);
        //m.setDescricao("Teste2 09/06");
        //m.setValor(3500);
        //m.setIdCategoria(1);(SELECT SUM(valor) FROM Movimentacao WHERE MONTH(data) = MONTH(NOW()), where id_saldo = " + 1
        // m.setIdMovimentacao(1);
        List<ModelMovimentacao> list = new ArrayList<>();
        wsGestaodeGastos ws = new wsGestaodeGastos();
        //   list = (List<ModelMovimentacao>) ws.ObterLista("movimentacao");
        for (ModelMovimentacao modelMovimentacao : list) {
            System.out.println(modelMovimentacao.getClass());
        }

        DAOSaldo ds = new DAOSaldo();
        ds.Atualizar();
        //ModelMovimentacao m1 = new ModelMovimentacao();
        //m1 = (ModelMovimentacao) dm.ObterPorId(2);
        //System.out.println(m1.getNomeCategoria());

        //dm.Save(m);
    }

}
