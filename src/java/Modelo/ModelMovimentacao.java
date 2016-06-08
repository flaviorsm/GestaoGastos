
package Modelo;

import java.util.Date;

public class ModelMovimentacao extends ModelCategoria{
    private int IdMovimentacao;
    private float Valor;
    private Date Data;
    private String Descricao;
    private boolean status;
    

    public int getIdMovimentacao() {
        return IdMovimentacao;
    }

    public void setIdMovimentacao(int IdMovimentacao) {
        this.IdMovimentacao = IdMovimentacao;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
