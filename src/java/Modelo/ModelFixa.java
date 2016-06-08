
package Modelo;

import java.util.Date;

public class ModelFixa {
    private int IdFixa;
    private boolean Status;
    private String Descricao;
    private Date Data;

    public int getIdFixa() {
        return IdFixa;
    }

    public void setIdFixa(int IdFixa) {
        this.IdFixa = IdFixa;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
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
}
