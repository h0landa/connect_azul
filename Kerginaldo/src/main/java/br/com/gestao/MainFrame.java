package main.java.br.com.gestao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private JTextArea textArea;
    private JTextField nomeField, especialidadeField, comissaoField;
    private JTextField nomeServicoField, valorServicoField;
    private List<Profissional> profissionais;
    private List<Servico> servicos;

    public MainFrame() {
        setTitle("Gestão de Profissionais e Serviços");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        profissionais = new ArrayList<>();
        servicos = new ArrayList<>();

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Painel para cadastro de profissionais
        JPanel profissionalPanel = new JPanel();
        profissionalPanel.setLayout(new GridLayout(5, 2));
        profissionalPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        profissionalPanel.add(nomeField);
        
        profissionalPanel.add(new JLabel("Especialidade:"));
        especialidadeField = new JTextField();
        profissionalPanel.add(especialidadeField);
        
        profissionalPanel.add(new JLabel("Comissão (%):"));
        comissaoField = new JTextField();
        profissionalPanel.add(comissaoField);
        
        JButton cadastrarProfissionalButton = new JButton("Cadastrar Profissional");
        cadastrarProfissionalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProfissional();
            }
        });
        profissionalPanel.add(cadastrarProfissionalButton);

        // Painel para cadastro de serviços
        JPanel servicoPanel = new JPanel();
        servicoPanel.setLayout(new GridLayout(4, 2));
        servicoPanel.add(new JLabel("Nome do Serviço:"));
        nomeServicoField = new JTextField();
        servicoPanel.add(nomeServicoField);
        
        servicoPanel.add(new JLabel("Valor do Serviço:"));
        valorServicoField = new JTextField();
        servicoPanel.add(valorServicoField);
        
        JButton cadastrarServicoButton = new JButton("Cadastrar Serviço");
        cadastrarServicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarServico();
            }
        });
        servicoPanel.add(cadastrarServicoButton);

        // Botão para listar profissionais e serviços
        JButton listarButton = new JButton("Listar Profissionais e Serviços");
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listar();
            }
        });

        // Adicionando os painéis e a área de texto à janela
        add(profissionalPanel, BorderLayout.NORTH);
        add(servicoPanel, BorderLayout.CENTER);
        add(listarButton, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.EAST);
    }

    private void cadastrarProfissional() {
        String nome = nomeField.getText();
        String especialidade = especialidadeField.getText();
        double comissao;

        try {
            comissao = Double.parseDouble(comissaoField.getText());
            Profissional profissional = new Profissional((long) (profissionais.size() + 1), nome, especialidade, comissao);
            profissionais.add(profissional);
            textArea.append("Profissional cadastrado: " + profissional + "\n");
            clearProfissionalFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor válido para a comissão.");
        }
    }

    private void cadastrarServico() {
        String nomeServico = nomeServicoField.getText();
        double valorServico;

        try {
            valorServico = Double.parseDouble(valorServicoField.getText());
            Servico servico = new Servico((long) (servicos.size() + 1), nomeServico, valorServico);
            servicos.add(servico);
            textArea.append("Serviço cadastrado: " + servico + "\n");
            clearServicoFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor válido para o valor do serviço.");
        }
    }

    private void listar() {
        textArea.append("\n--- Profissionais Cadastrados ---\n");
        for (Profissional p : profissionais) {
            textArea.append(p + "\n");
        }

        textArea.append("\n--- Serviços Cadastrados ---\n");
        for (Servico s : servicos) {
            textArea.append(s + "\n");
        }
    }

    private void clearProfissionalFields() {
        nomeField.setText("");
        especialidadeField.setText("");
        comissaoField.setText("");
    }

    private void clearServicoFields() {
        nomeServicoField.setText("");
        valorServicoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
