/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaDeTarefas.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author FELIPECANTINI
 */
public class CriarTabela {
    
    public static void criarTabelaTarefas(Connection conexao) {
        
        String sql = "CREATE TABLE IF NOT EXISTS tarefas (" +
                          " id INT AUTO_INCREMENT PRIMARY KEY," +
                          "titulo VARCHAR(255) NOT NULL," +
                          "descricao TEXT," +
                          "dataVencimento DATE," +
                          "status VARCHAR(20)" +
                          ");";

        try (Statement stmt = conexao.createStatement()) {
            
            stmt.execute(sql);
            
            System.out.println("Tabela 'tarefas' verificada/criada com sucesso.");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao criar a tabela: " + e.getMessage());
        }
    }

}
