/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaDeTarefas.model;

/**
 *
 * @author FELIPECANTINI
 */
public class Tarefa {
    
    private int id;
    private String titulo;
    private String descricao;
    private String dataVencimento;
    private String status;

    // Construtor
    public Tarefa( String titulo, String autor, String descricao) {
        
        this.titulo = titulo;
        this.descricao = autor;
        this.descricao = descricao;
        
    }

    // Métodos Getters e Setters para acessar os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
