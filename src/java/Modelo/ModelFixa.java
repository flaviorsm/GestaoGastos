
package Modelo;

import java.io.Serializable;
import java.util.Date;


public class ModelFixa extends ModelCategoria implements Serializable{
    private int IdFixa;
    private String Descricao;
    private Date Data;
    private float valor;
    
     @Override
    public int getIdCategoria() {
       return super.getIdCategoria();
    }

    @Override
    public void setIdCategoria(int IdCategoria) {
        super.setIdCategoria(IdCategoria);
    }

    @Override
    public String getNomeCategoria() {
        return super.getNomeCategoria();
    }

    @Override
    public void setNomeCategoria(String NomeCategoria) {
       super.setNomeCategoria(NomeCategoria);
    }

    public int getIdFixa() {
        return IdFixa;
    }

    public void setIdFixa(int IdFixa) {
        this.IdFixa = IdFixa;
    }


    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
