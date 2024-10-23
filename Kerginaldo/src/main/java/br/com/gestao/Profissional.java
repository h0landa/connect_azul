package main.java.br.com.gestao;

public class Profissional {
    private Long id;
    private String nome;
    private String especialidade;
    private double comissao;

    public Profissional(Long id, String nome, String especialidade, double comissao) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.comissao = comissao;
    }

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

    @Override
    public String toString() {
        return String.format("ID: %d, Nome: %s, Especialidade: %s, Comissão: %.2f%%", id, nome, especialidade, comissao);
    }
}
