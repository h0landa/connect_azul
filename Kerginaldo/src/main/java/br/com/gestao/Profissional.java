package main.java.br.com.gestao;

import java.util.ArrayList;
import java.util.List;

public class Profissional {
    private Long id;
    private String nome;
    private String especialidade;
    private double comissao;
    private List<Servico> servicos; 

    public Profissional(Long id, String nome, String especialidade, double comissao) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.comissao = comissao;
        this.servicos = new ArrayList<>(); 
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public double getComissao() {
        return comissao;
    }

    public List<Servico> getServicos() {
        return servicos; // Retorna a lista de serviços
    }

    // Método para adicionar um serviço à lista
    public void adicionarServico(Servico servico) {
        servicos.add(servico);
        servico.adicionarProfissional(this);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Nome: %s, Especialidade: %s, Comissão: %.2f%%", id, nome, especialidade, comissao);
    }
}
