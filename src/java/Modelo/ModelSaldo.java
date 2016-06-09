/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author aluno
 */
public class ModelSaldo implements Serializable {
    private Integer IdSaldo;
    private Float Saldo;

    public Integer getIdSaldo() {
        return IdSaldo;
    }

    public void setIdSaldo(Integer IdSaldo) {
        this.IdSaldo = IdSaldo;
    }

    public Float getSaldo() {
        return Saldo;
    }

    public void setSaldo(Float Saldo) {
        this.Saldo = Saldo;
    }
}
