package main.java.br.com.gestao;

import java.util.ArrayList;
import java.util.List;

public class Servico {
    private Long id;
    private String nome;
    private double valor;
    private List<Profissional> profissionais; // Lista de profissionais associados

    public Servico(Long id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.profissionais = new ArrayList<>(); // Inicializa a lista
    }

    // Método para adicionar um profissional ao serviço
    public void adicionarProfissional(Profissional profissional) {
        profissionais.add(profissional);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Nome: %s, Valor: %.2f, Profissionais: %s", 
                             id, nome, valor, profissionais);
    }
}
