package Modelo;

import java.util.List;

public class NotificacaoMensagem {

    public NotificacaoMensagem(String Mensagem, Boolean Erro) {
        this.Mensagem = Mensagem;
        this.Erro = Erro;
    }
    
    public String  Mensagem;
    public Boolean Erro;
    public List<NotificacaoMensagem> Notificacao;

}
