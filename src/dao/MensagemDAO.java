/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Mensagem;
import bean.Usuario;
import conexao.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author USER
 */
public class MensagemDAO {  
    public ArrayList consultar(int codUsuario){
        PreparedStatement sql, sql2, sql3;
        int idDestinatario, idRemetente;
        Usuario aux = new Usuario();
        ArrayList<Mensagem> mensagens = new ArrayList();
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("SELECT * FROM mensagem,usuario WHERE mensagem.idDestinatario=usuario.idUsuario AND usuario.idUsuario="+codUsuario);
            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                Mensagem mensagem = new Mensagem();
                mensagem.setCode(rs.getInt("idMensagem"));
                mensagem.setConteudo(rs.getString("conteudoMensagem"));
                mensagem.setData(Utils.toGregorianCalendar(rs.getTimestamp("dataMensagem")));
                mensagem.setStatus(rs.getBoolean("status"));
                idDestinatario = rs.getInt("idDestinatario");
                idRemetente = rs.getInt("idRemetente");
                sql2 = (PreparedStatement) BancoDados.getInstance().prepareStatement
                    ("SELECT * FROM usuario WHERE usuario.idUsuario="+idDestinatario);
                ResultSet rsAux = sql.executeQuery();
                if(rsAux.next()){
                    aux.setCode(rsAux.getInt("idUsuario"));
                    aux.setNome(rsAux.getString("nomeUsuario"));
                    aux.setLogin(rsAux.getString("loginUsuario"));
                    aux.setSenha(rsAux.getString("senhaUsuario"));
                }
                mensagem.setDestinario(aux);
                sql3 = (PreparedStatement) BancoDados.getInstance().prepareStatement
                    ("SELECT * FROM usuario WHERE usuario.idUsuario="+idRemetente);
                ResultSet rsAux2 = sql.executeQuery();
                if(rsAux2.next()){
                    aux.setCode(rsAux2.getInt("idUsuario"));
                    aux.setNome(rsAux2.getString("nomeUsuario"));
                    aux.setLogin(rsAux2.getString("loginUsuario"));
                    aux.setSenha(rsAux2.getString("senhaUsuario"));
                }
                mensagem.setRemetente(aux);
                mensagens.add(mensagem);
            }// fim do while

        }// fim do try
        catch(SQLException ex) {
          System.out.println(ex);
        }
        return mensagens;
    }
    
    public ArrayList consultarPropriasMsgs(int codUsuario){
        PreparedStatement sql, sql2;
        Usuario aux = new Usuario();
        int idDestinatario, idRemetente;
        ArrayList<Mensagem> mensagens = new ArrayList();
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("SELECT * FROM mensagem,usuario WHERE mensagem.idRemetente=usuario.idUsuario AND usuario.idUsuario="+codUsuario);
            System.out.println(codUsuario);
            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                Mensagem mensagem = new Mensagem();
                mensagem.setCode(rs.getInt("idMensagem"));
                mensagem.setConteudo(rs.getString("conteudoMensagem"));
                mensagem.setData(Utils.toGregorianCalendar(rs.getTimestamp("dataMensagem")));
                mensagem.setStatus(rs.getBoolean("status"));
                idDestinatario = rs.getInt("idDestinatario");
                idRemetente = rs.getInt("idRemetente");
                sql2 = (PreparedStatement) BancoDados.getInstance().prepareStatement
                    ("SELECT * FROM usuario WHERE usuario.idUsuario="+idDestinatario);
                ResultSet rsAux = sql.executeQuery();
                if(rsAux.next()){
                    aux.setCode(rsAux.getInt("idUsuario"));
                    aux.setNome(rsAux.getString("nomeUsuario"));
                    aux.setLogin(rsAux.getString("loginUsuario"));
                    aux.setSenha(rsAux.getString("senhaUsuario"));
                }
                mensagem.setDestinario(aux);
                sql2 = (PreparedStatement) BancoDados.getInstance().prepareStatement
                    ("SELECT * FROM usuario WHERE usuario.idUsuario="+idRemetente);
                rsAux = sql.executeQuery();
                if(rsAux.next()){
                    aux.setCode(rsAux.getInt("idUsuario"));
                    aux.setNome(rsAux.getString("nomeUsuario"));
                    aux.setLogin(rsAux.getString("loginUsuario"));
                    aux.setSenha(rsAux.getString("senhaUsuario"));
                }
                mensagem.setRemetente(aux);
                mensagens.add(mensagem);
            }// fim do while

        }// fim do try
        catch(SQLException ex) {
          System.out.println(ex);
        }
        return mensagens;
    }
    
    public void alterarStatusMensagem(int idMensagem){
        PreparedStatement sql;
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("UPDATE mensagem SET status = 1 WHERE mensagem.idMensagem =" + idMensagem);
            sql.executeUpdate();
        }
        catch(SQLException ex){
            System.err.println(ex);
        }
    }

    public void enviarMensagem(int idRem, int idDest, String mensagem){
        PreparedStatement sql; 
        ArrayList<Mensagem> mensagens = new ArrayList();
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("INSERT INTO mensagem VALUES (null, ?, ?, ?, now(), 0);");
            sql.setString(1, mensagem);
            sql.setInt(2, idDest);
            sql.setInt(3, idRem);
            sql.execute();
        }// fim do try
        catch(SQLException ex) {
          System.out.println(ex);
        }
    }
   }

