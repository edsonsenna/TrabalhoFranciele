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
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class MensagemDAO {  
    public ArrayList consultar(int codUsuario){
    PreparedStatement sql; 
    ArrayList<Mensagem> mensagens = new ArrayList();
    try{
        //String teste = "SELECT * FROM mensagem WHERE mensagem.idDestinatario=usuario.idUsuario AND usuario.loginUsuario="+user+";";
        //System.out.println(teste);
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

