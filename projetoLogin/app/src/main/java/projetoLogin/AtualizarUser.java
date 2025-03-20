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
public class AtualizarUser {
    
    public static boolean atualizarUsuarios(Connection conexao, String id, String novoNome, String novaSenha) {
        
        String sql = "UPDATE Users SET nome = ?, senha = ? WHERE id = ?";

        try {

            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                
                pstmt.setString(1, novoNome);
                
                pstmt.setString(2, novaSenha);
                
                pstmt.setString(3, id);

                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {

                    System.out.println("Usuario atualizado com sucesso!");
                    
                    return true;
                    
                } else {

                    System.out.println("Nenhum usuario encontrado com o ID fornecido.");
                }
                
            } catch (Exception e) {

                System.out.println("Erro ao atualizar usuario: " + e.getMessage());
                
            }
        } catch (Exception e) {

            System.out.println("Erro ao conectar ou executar SQL: " + e.getMessage());
        }
        return false;
    }
}
