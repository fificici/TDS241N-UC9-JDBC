/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC.model;

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
public class LivroDAO {
    
    private Connection conexao;

    public LivroDAO() {
        
        conexao = ConexaoSQLite.conectar();
    }

    public void adicionarLivro(Livro livro) {
        
        String sql = "INSERT INTO Livros (titulo, autor, anoPublicacao) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAnoPublicacao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao adicionar livro: " + e.getMessage());
        }
    }
        
        public ArrayList<Livro> listarLivros() {
            
            ArrayList<Livro> livros = new ArrayList<>();
            String sql = "SELECT * FROM Livros";
            
            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                
                ResultSet rs = pstmt.executeQuery();
                
                while (rs.next()) {
                    
                    String titulos = rs.getString("titulo");
                    String autores = rs.getString("autor");
                    int anos = rs.getInt("anoPublicacao");
                    int id = rs.getInt("id");
                    
                    Livro livro = new Livro(titulos, autores, anos);
                    livro.setId(id);
                    livros.add(livro);

                }
                
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            return livros;
        }       
    }

