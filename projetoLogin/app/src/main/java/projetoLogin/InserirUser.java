/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author FELIPECANTINI
 */
public class InserirUser {
    
    public static void inserirUsuario(Connection conexao, String nome, String senha) {
        
        String sql = "INSERT INTO Users (nome, senha) VALUES (?, ?)";
        
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            
            pstmt.setString(1, nome); // Substitui o primeiro ? por 'nome'
            pstmt.setString(2, senha); // Substitui o segundo ? por 'email'
            pstmt.executeUpdate();
            
            System.out.println("Usuario inserido com sucesso!");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao inserir usuario: " + e.getMessage());
            
        }
    }
}
