package Interface;

import java.util.List;

public interface IGestao{
    /**
     * Salva os dados no banco de dados
     * @param parametro = objeto a ser enviado
     */
    public void Save(Object parametro);
    
    public void Atualizar(Object parametro);
    
    public void Delete(int identificador);
    
    public List ObterLista();
    
    public Object ObterPorId(int identificador);    
}
