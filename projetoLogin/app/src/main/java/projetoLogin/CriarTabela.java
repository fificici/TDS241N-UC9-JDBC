/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author FELIPECANTINI
 */
public class CriarTabela {
        
    public static void criarTabelaUsers(Connection conexao) {
        
        String sql = "CREATE TABLE IF NOT EXISTS Users ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "nome TEXT NOT NULL, "
                   + "senha TEXT NOT NULL)";
        
        try (Statement stmt = conexao.createStatement()) {
            
            stmt.execute(sql);           
            System.out.println("Tabela 'Users' criada ou ja existente.");
            
        } catch (Exception e) {
            
            System.out.println("Erro ao criar tabela: " + e.getMessage());
            
        }
    }
}
