/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

/**
 *
 * @author 13151000162
 */
public class Mensagem {
    private String conteudo;
    private int destinario;
    private int remetente;
    private int code;
    private Timestamp data;
    private Boolean status;
    
    public Mensagem(String conteudo, int destinario, int remetente) {
        this.conteudo = conteudo;
        this.destinario = destinario;
        this.remetente = remetente;
    }
    public Mensagem(){
    
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getDestinario() {
        return destinario;
    }

    public void setDestinario(int destinario) {
        this.destinario = destinario;
    }

    public int getRemetente() {
        return remetente;
    }

    public void setRemetente(int remetente) {
        this.remetente = remetente;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
}
