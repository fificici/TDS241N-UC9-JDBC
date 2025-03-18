/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaDeTarefas.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author FELIPECANTINI
 */
public class TarefaDAO {
    
    private Connection conexao;

    public TarefaDAO() {
        
        conexao = ConexaoSQLite.conectar();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        
        String sql = "INSERT INTO tarefas (titulo, descricao, dataVencimento) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getDataVencimento());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Tarefa inserida com sucesso!");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao adicionar tarefa: " + e.getMessage());
        }
    }
        
        public ArrayList<Tarefa> listarTarefas() {
            
            ArrayList<Tarefa> tarefas = new ArrayList<>();
            String sql = "SELECT * FROM tarefas";
            
            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                
                ResultSet rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    
                    String titulos = rs.getString("titulo");
                    String descricoes = rs.getString("descricao");
                    String datas = rs.getString("dataVencimento");
                    int id = rs.getInt("id");
                    String statuss = rs.getString("status");
                    
                    Tarefa tarefa = new Tarefa(titulos, descricoes, datas);
                    
                    tarefa.setId(id);
                    tarefa.setStatus(statuss);
                    tarefas.add(tarefa);

                }
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            return tarefas;
        }       
}
