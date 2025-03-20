/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author FELIPECANTINI
 */
public class LogarUser {
    
     public static boolean logarUsuarios(Connection conexao, String nome, String senha) {
        
        String sql = "SELECT senha FROM Users WHERE nome = ?";
        
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            
            pstmt.setString(1, nome);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
 
                String senhaUser = rs.getString("senha");
                
                if (senhaUser.equals(senha)) {
                    
                    System.out.println("Bem-vindo!");
                    
                    return true;
                    
                } else {
                    
                    System.out.println("Senha incorreta.");
                }
            } else {

                System.out.println("Nenhum usuario encontrado com o nome fornecido.");
                
            }
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao conferir usuário: " + e.getMessage());
            
        }
        return false;
    }
}
