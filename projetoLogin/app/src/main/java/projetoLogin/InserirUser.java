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
public class InserirUser {
    
    public static boolean inserirUsuario(Connection conexao, String nome, String senha) {
        
 String sql = "SELECT nome FROM Users WHERE nome = ?";

        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            
            pstmt.setString(1, nome);
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                
                System.out.println("Usuario ja registrado! Tente outra opcao.");
                
            } else {

                String sql2 = "INSERT INTO Users (nome, senha) VALUES (?, ?)";
                
                try (PreparedStatement pstmt2 = conexao.prepareStatement(sql2)) {
                    
                    pstmt2.setString(1, nome);  // Substitui o primeiro ? por 'nome'
                    pstmt2.setString(2, senha); // Substitui o segundo ? por 'senha'
                    pstmt2.executeUpdate();
                    
                    System.out.println("Usuario cadastrado com sucesso!");
                    
                    return true;
                    
                } catch (Exception e) {
                    
                    System.out.println("Erro ao inserir usuario: " + e.getMessage());
                    
                }
            }

        } catch (SQLException e) {
            
            System.out.println("Erro ao conferir usuario: " + e.getMessage());
        }
        
        return false;
    }
}
