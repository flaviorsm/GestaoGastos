package Modelo;

import java.io.Serializable;

public class ModelCategoria implements Serializable {
    private int IdCategoria;
    private String NomeCategoria;    

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNomeCategoria() {
        return NomeCategoria;
    }

    public void setNomeCategoria(String NomeCategoria) {
        this.NomeCategoria = NomeCategoria;
    }

}
