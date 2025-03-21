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
        
        String sql = "INSERT INTO tarefas (titulo, descricao, dataVencimento, status) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getDataVencimento());
            stmt.setString(4, tarefa.getStatus());
            
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
                    
                    Tarefa tarefa = new Tarefa(titulos, descricoes, datas, statuss);
                    
                    tarefa.setId(id);
                    tarefas.add(tarefa);

                }
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            return tarefas;
        } 
        
        public void deletarTarefa(int id) {
            
            String sql = "DELETE FROM tarefas WHERE id = ?";
        
            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int rowsDeleted = pstmt.executeUpdate();
            
            if (rowsDeleted > 0) { 

                JOptionPane.showMessageDialog(null, "Tarefa deletada com sucesso!");
                
            } else {

                JOptionPane.showMessageDialog(null, "Erro!");
                
            }
            
            } catch (Exception e) {
            
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        
        public void atualizarTarefa(String id, String novoTitulo, String novaDescricao, String novaData) {
        
        String sql = "UPDATE tarefas SET titulo = ?, descricao = ?, dataVencimento = ? WHERE id = ?";

        try {

            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                
                pstmt.setString(1, novoTitulo);
                
                pstmt.setString(2, novaDescricao);
                
                pstmt.setString(3, novaData);
                
                pstmt.setString(4, id);

                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {

                    JOptionPane.showMessageDialog(null, "Tarefa atualizada com sucesso!");
                    
                    
                } else {

                    JOptionPane.showMessageDialog(null, "Erro!");
                }
                
            } catch (Exception e) {

                 JOptionPane.showMessageDialog(null, e.getMessage());
                
            }
        } catch (Exception e) {

             JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
        
    public String[] buscarTarefa(int idTarefa) {
        
        String[] dadosTarefa = new String[4]; 
        
        String sql = "SELECT id, titulo, descricao, dataVencimento FROM tarefas WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, idTarefa);

            try (ResultSet rs = stmt.executeQuery()) {
                
                if (rs.next()) {
                    
                    int idResult = rs.getInt("id");
                    
                    dadosTarefa[0] = Integer.toString(idResult);
                    dadosTarefa[1] = rs.getString("titulo");
                    dadosTarefa[2] = rs.getString("descricao");
                    dadosTarefa[3] = rs.getString("dataVencimento");
                    
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Erro!");
                }
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao buscar tarefa: " + e.getMessage());
        }

        return dadosTarefa;
    }
    
    public void atualizarStatus(String id, String novoStatus) {
        
        String sql = "UPDATE tarefas SET status = ? WHERE id = ?";

        try {

            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                
                pstmt.setString(1, novoStatus);
                
                
                pstmt.setString(2, id);

                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {

                    JOptionPane.showMessageDialog(null, "Status atualizado com sucesso!");
                    
                    
                } else {

                    JOptionPane.showMessageDialog(null, "Erro!");
                }
                
            } catch (Exception e) {

                 JOptionPane.showMessageDialog(null, e.getMessage());
                
            }
        } catch (Exception e) {

             JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
