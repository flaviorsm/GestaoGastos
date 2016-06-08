package Modelo;

public class Mensagem {
    private String  Mensagem;
    private Boolean Erro;

    public Mensagem() {
        this.Mensagem = "";
        this.Erro = false;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public Boolean getErro() {
        return Erro;
    }

    public void setErro(Boolean Erro) {
        this.Erro = Erro;
    }
}
