/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Usuario;
import conexao.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class UsuarioDAO {  
    public ArrayList consultar(String user){
    PreparedStatement sql; 
    ArrayList<Usuario> usuarios = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM usuario WHERE usuario.loginUsuario like '%"+user+"%';");
        ResultSet rs = sql.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setCode(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nomeUsuario"));
            usuario.setLogin(rs.getString("loginUsuario"));
            usuario.setSenha(rs.getString("senhaUsuario"));
            usuarios.add(usuario);
        }// fim do while

    }// fim do try// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return usuarios;
    }
    
    public String consultar(int codUser){
    PreparedStatement sql; 
    ArrayList<Usuario> usuarios = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM usuario WHERE usuario.idUsuario =" + codUser);
        ResultSet rs = sql.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setCode(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nomeUsuario"));
            usuario.setLogin(rs.getString("loginUsuario"));
            usuario.setSenha(rs.getString("senhaUsuario"));
            usuarios.add(usuario);
        }// fim do while

    }// fim do try// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return usuarios.get(0).getNome();
    }
    
    public ArrayList consultar(){
    PreparedStatement sql; 
    ArrayList<Usuario> usuarios = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM usuario");
        ResultSet rs = sql.executeQuery();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setCode(rs.getInt("idUsuario"));
            usuario.setNome(rs.getString("nomeUsuario"));
            usuario.setLogin(rs.getString("loginUsuario"));
            usuario.setSenha(rs.getString("senhaUsuario"));
            usuarios.add(usuario);
        }// fim do while

    }// fim do try// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return usuarios;
    }
   }

