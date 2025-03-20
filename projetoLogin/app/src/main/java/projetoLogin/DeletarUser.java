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
public class DeletarUser {
    
    public static boolean deletarUsuario(Connection conexao, String id) {
        
        String sql = "DELETE FROM Users WHERE id = ?";
        
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            
            pstmt.setString(1, id);
            
            int rowsDeleted = pstmt.executeUpdate();
            
            if (rowsDeleted > 0) { 

                System.out.println("Usuario deletado com sucesso!");
                
                return true;
                
            } else {

                System.out.println("Nenhum usuario encontrado com o ID fornecido.");
                
            }
            
        } catch (Exception e) {
            
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        }
        return false;
    }
}
