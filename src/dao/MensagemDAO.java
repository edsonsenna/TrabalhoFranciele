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
    public ArrayList consultar(int idUsuario){
    PreparedStatement sql; 
    ArrayList<Mensagem> mensagens = new ArrayList();
    try{
        sql=(PreparedStatement) BancoDados.getInstance().prepareStatement
        ("SELECT * FROM mensagem, usuario WHERE mensagem.idDestinatario=usuario.idUsuario AND usuario.idUsuario="+idUsuario);
        ResultSet rs = sql.executeQuery();

        while(rs.next()){
            Mensagem mensagem = new Mensagem();
            mensagem.setCode(rs.getInt("idMensagem"));
            mensagem.setConteudo(rs.getString("conteudoMensagem"));
            mensagem.setDestinario(rs.getInt("idDestinatario"));
            mensagem.setRemetente(rs.getInt("idRemetente"));
            mensagem.setData(rs.getDate("dataMensagem"));
            mensagens.add(mensagem);
        }// fim do while

    }// fim do try
    catch(SQLException ex) {
      System.out.println(ex);
    }
    return mensagens;
    }
   }
