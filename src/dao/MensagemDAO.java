/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Mensagem;
import conexao.BancoDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class MensagemDAO {  
    public ArrayList consultar(int codUsuario){
        PreparedStatement sql; 
        ArrayList<Mensagem> mensagens = new ArrayList();
        try{
            sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
            ("SELECT * FROM mensagem,usuario WHERE mensagem.idDestinatario=usuario.idUsuario AND usuario.idUsuario="+codUsuario);
            System.out.println(codUsuario);
            ResultSet rs = sql.executeQuery();
            while(rs.next()){
                Mensagem mensagem = new Mensagem();
                mensagem.setCode(rs.getInt("idMensagem"));
                mensagem.setConteudo(rs.getString("conteudoMensagem"));
                mensagem.setDestinario(rs.getInt("idDestinatario"));
                mensagem.setRemetente(rs.getInt("idRemetente"));
                mensagem.setData(rs.getTimestamp("dataMensagem"));
                mensagem.setStatus(rs.getBoolean("status"));
                mensagens.add(mensagem);
            }// fim do while

        }// fim do try
        catch(SQLException ex) {
          System.out.println(ex);
        }
        return mensagens;
    }
    
    public ArrayList consultarPropriasMsgs(int codUsuario){
        PreparedStatement sql; 
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
                mensagem.setDestinario(rs.getInt("idDestinatario"));
                mensagem.setRemetente(rs.getInt("idRemetente"));
                mensagem.setData(rs.getTimestamp("dataMensagem"));
                mensagem.setStatus(rs.getBoolean("status"));
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

