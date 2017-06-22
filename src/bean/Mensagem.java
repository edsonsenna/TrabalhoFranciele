/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author 13151000162
 */
public class Mensagem {
    private String conteudo;
    private Usuario destinario;
    private Usuario remetente;
    private int code;
    private GregorianCalendar data;
    private Boolean status;
    
    public Mensagem(String conteudo, Usuario destinario, Usuario remetente) {
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

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Usuario getDestinario() {
        return destinario;
    }

    public void setDestinario(Usuario destinario) {
        this.destinario = destinario;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
}
