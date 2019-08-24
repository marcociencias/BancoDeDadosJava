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
public class banco {

     private String bancoDeDados;
     
    public banco() {
    }

    public banco(String bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }
   

    public String getBancoDeDados() {
        return bancoDeDados;
    }

    public void setBancoDeDados(String bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }
    
}
