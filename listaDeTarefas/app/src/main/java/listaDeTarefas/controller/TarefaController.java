/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaDeTarefas.controller;

import java.util.ArrayList;
import listaDeTarefas.model.Tarefa;
import listaDeTarefas.model.TarefaDAO;

/**
 *
 * @author FELIPECANTINI
 */
public class TarefaController {
    
    private TarefaDAO tarefaDAO;
    
    public TarefaController() {
        
        this.tarefaDAO = new TarefaDAO();
        
    }
    
    public String adicionarTarefa(String titulo, String descricao, String dataVencimento, String status) {
        
        try {
            
            Tarefa tarefa = new Tarefa(titulo, descricao, dataVencimento, status);
            
            tarefaDAO.adicionarTarefa(tarefa);
            
            return "Tarefa adicionado com sucesso!";
            
        } catch (NumberFormatException e) {
        
            return "Erro: " + e.getMessage();
        }
    }
    
    public ArrayList<String> listarTarefas() {
        
        ArrayList<String> listaTarefas = new ArrayList<>();
                
        try {
                      
            for (Tarefa tarefa: tarefaDAO.listarTarefas()) {
                
                String detalhes = tarefa.getTitulo() + " | " + tarefa.getDescricao() + " | " + tarefa.getDataVencimento() + " | " + tarefa.getStatus() + " | ID: " + tarefa.getId();
                
                listaTarefas.add(detalhes);
            }
            
            
            
        } catch (NumberFormatException e) {
        
            System.out.println("Erro: " + e.getMessage());
        }
        
        return listaTarefas;
    }
}
