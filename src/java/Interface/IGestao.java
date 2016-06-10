package Interface;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.List;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IGestao{

    @WebMethod void Save(Object parametro);
    
    @WebMethod void Atualizar(Object parametro);
    
    @WebMethod void Delete(int identificador);
    
    @WebMethod List ObterLista();
    
    @WebMethod Object ObterPorId(int identificador);    
   
}
