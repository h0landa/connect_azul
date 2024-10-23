package main.java.br.com.gestao;

public class Servico {
    private Long id;
    private String nome;
    private double valor;

    public Servico(Long id, String nome, double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
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

    @Override
    public String toString() {
        return String.format("ID: %d, Nome: %s, Valor: R$ %.2f", id, nome, valor);
    }
}
