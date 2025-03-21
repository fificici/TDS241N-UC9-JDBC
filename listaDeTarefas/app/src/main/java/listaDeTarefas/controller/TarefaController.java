/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaDeTarefas.controller;

import java.sql.Connection;
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
            
            return "Tarefa adicionada com sucesso!";
            
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
    
    public String deletarTarefa(int index) {
        
        try {
            ArrayList<Tarefa> tarefas = tarefaDAO.listarTarefas();

        
            if (index >= 0 && index < tarefas.size()) {
                
                int idTarefa = tarefas.get(index).getId(); 
                
                tarefaDAO.deletarTarefa(idTarefa); 
                
                return "Tarefa deletada com sucesso!";
            } else {
                
                return "Erro: Indice invalido!";
            }
            
        } catch (Exception e) {
            
            return "Erro ao deletar tarefa: " + e.getMessage();
        }
    }
    
    public String atualizarTarefa(String id, String novoTitulo, String novaDescricao, String novaData) {
    
    try {
        
        ArrayList<Tarefa> tarefas = tarefaDAO.listarTarefas();
        
        
        for (Tarefa tarefa : tarefas) {
            
            if (Integer.toString(tarefa.getId()).equals(id)) {
                
                
                tarefaDAO.atualizarTarefa(id, novoTitulo, novaDescricao, novaData);
                
                return "Tarefa atualizada com sucesso!";
            }
        }
        
        return "Erro: Tarefa não encontrada!";
        
    } catch (Exception e) {
        
        return "Erro ao atualizar tarefa: " + e.getMessage();
    }
}
    
    public String[] buscarTarefa(int id) {
        
        String[] arrayTarefa = tarefaDAO.buscarTarefa(id);
        
        return arrayTarefa;
    }
    
     public String atualizarStatus(String id,  String novoStatus) {
    
    try {
        
        ArrayList<Tarefa> tarefas = tarefaDAO.listarTarefas();
        
        
        for (Tarefa tarefa : tarefas) {
            
            if (Integer.toString(tarefa.getId()).equals(id)) {
                
                
                tarefaDAO.atualizarStatus(id, novoStatus);
                
                return "Status atualizado com sucesso!";
            }
        }
        
            return "Erro: Tarefa não encontrada!";
        
        } catch (Exception e) {
        
        return "Erro ao atualizar tarefa: " + e.getMessage();
        }
    }
}
