/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC.controller;

import biblioMVC.model.Livro;
import biblioMVC.model.LivroDAO;
import java.util.ArrayList;


/**
 *
 * @author FELIPECANTINI
 */
public class LivroController {
    
    private LivroDAO livroDAO;
    
    public LivroController() {
        this.livroDAO = new LivroDAO();
    }
    
    public String adicionarLivro(String titulo, String autor, String anoTexto) {
        
        try {
            
            int ano = Integer.parseInt(anoTexto);
            
            Livro livro = new Livro(titulo, autor, ano);
            
            livroDAO.adicionarLivro(livro);
            
            return "Livro adicionado com sucesso!";
            
        } catch (NumberFormatException e) {
        
            return "Erro: " + e.getMessage();
        }
    }
    
    public ArrayList<String> listarLivros() {
        
        ArrayList<String> listaLivros = new ArrayList<>();
                
        try {
                      
            for (Livro livro: livroDAO.listarLivros()) {
                
                String detalhes = livro.getTitulo() + " | " + livro.getAutor() + " | " + livro.getAnoPublicacao() + " | ID: " + livro.getId();
                
                listaLivros.add(detalhes);
            }
            
            
            
        } catch (NumberFormatException e) {
        
            System.out.println("Erro: " + e.getMessage());
        }
        
        return listaLivros;
    }
}
