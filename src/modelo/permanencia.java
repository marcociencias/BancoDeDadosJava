/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author marco.junior
 */
public class permanencia {
    
    private int id_permanencia;
    private String periodo;
    private String inicio;
    private String fim;
    private String quantidade;
    private String total;

    public permanencia() {
    }

    public permanencia(int id_permanencia, String periodo, String inicio, String fim, String quantidade, String total) {
        this.id_permanencia = id_permanencia;
        this.periodo = periodo;
        this.inicio = inicio;
        this.fim = fim;
        this.quantidade = quantidade;
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getId_permanencia() {
        return id_permanencia;
    }

    public void setId_permanencia(int id_permanencia) {
        this.id_permanencia = id_permanencia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    
}
