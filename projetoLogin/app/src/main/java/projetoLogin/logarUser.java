/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author FELIPECANTINI
 */
public class logarUser {
    
    public static void logarUsuarios(Connection conexao, String nome, String senha) {
        
        String sql = "SELECT senha\n" +
                            "FROM Users\n" +
                            "WHERE nome = '?";
        
         try (Statement stmt = conexao.createStatement();
                
             ResultSet rs = stmt.executeQuery(sql)) {
            
            
        } catch (Exception e) {
            
        }
}
