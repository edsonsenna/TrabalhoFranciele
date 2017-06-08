/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author USER
 */
public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private int code;

    public Usuario(String nome, String login, String senha, int code) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.code = code;
    }

    public Usuario() {
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    
    
    
}
