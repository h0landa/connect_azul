package main.java.br.com.gestao;

import javax.swing.*;
import javax.swing.border.*;
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
    
    // Definindo cores do tema
    private static final Color PRIMARY_COLOR = new Color(70, 130, 180); // Steel Blue
    private static final Color SECONDARY_COLOR = new Color(176, 196, 222); // Light Steel Blue
    private static final Color BACKGROUND_COLOR = new Color(240, 248, 255); // Alice Blue
    private static final Color TEXT_COLOR = new Color(44, 62, 80); // Dark Blue Gray
    
    public MainFrame() {
        setTitle("Sistema de Kerginaldo @ Uninassau");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BACKGROUND_COLOR);
        
        profissionais = new ArrayList<>();
        servicos = new ArrayList<>();
        
        // Configurando o painel principal com margens
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(BACKGROUND_COLOR);
        
        // Configurando a área de texto
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(TEXT_COLOR);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 0));
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(0, 10, 0, 0),
            BorderFactory.createLineBorder(SECONDARY_COLOR)
        ));
        
        // Painel para formulários
        JPanel formsPanel = new JPanel(new GridLayout(2, 1, 0, 20));
        formsPanel.setBackground(BACKGROUND_COLOR);
        
        // Painel de profissionais
        JPanel profissionalPanel = createProfissionalPanel();
        
        // Painel de serviços
        JPanel servicoPanel = createServicoPanel();
        
        formsPanel.add(profissionalPanel);
        formsPanel.add(servicoPanel);
        
        // Botão de listar
        JButton listarButton = createStyledButton("Listar Profissionais e Serviços");
        listarButton.addActionListener(e -> listar());
        
        // Montando o layout
        mainPanel.add(formsPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.EAST);
        mainPanel.add(listarButton, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createProfissionalPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(PRIMARY_COLOR),
                "Cadastro de Profissional",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                PRIMARY_COLOR
            ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Nome
        addFormField(panel, "Nome:", nomeField = createStyledTextField(), gbc, 0);
        
        // Especialidade
        addFormField(panel, "Especialidade:", especialidadeField = createStyledTextField(), gbc, 1);
        
        // Comissão
        addFormField(panel, "Comissão (%):", comissaoField = createStyledTextField(), gbc, 2);
        
        // Botão
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton cadastrarButton = createStyledButton("Cadastrar Profissional");
        cadastrarButton.addActionListener(e -> cadastrarProfissional());
        panel.add(cadastrarButton, gbc);
        
        return panel;
    }
    
    private JPanel createServicoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(PRIMARY_COLOR),
                "Cadastro de Serviço",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 14),
                PRIMARY_COLOR
            ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Nome do Serviço
        addFormField(panel, "Nome do Serviço:", nomeServicoField = createStyledTextField(), gbc, 0);
        
        // Valor do Serviço
        addFormField(panel, "Valor do Serviço:", valorServicoField = createStyledTextField(), gbc, 1);
        
        // Botão
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton cadastrarButton = createStyledButton("Cadastrar Serviço");
        cadastrarButton.addActionListener(e -> cadastrarServico());
        panel.add(cadastrarButton, gbc);
        
        return panel;
    }
    
    private void addFormField(JPanel panel, String label, JComponent field, GridBagConstraints gbc, int row) {
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.3;
        panel.add(new JLabel(label), gbc);
        
        gbc.gridx = 1;
        gbc.weightx = 0.7;
        panel.add(field, gbc);
    }
    
    private JTextField createStyledTextField() {
        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(SECONDARY_COLOR),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        return field;
    }
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(PRIMARY_COLOR);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_COLOR.darker());
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(PRIMARY_COLOR);
            }
        });
        return button;
    }

    private void cadastrarProfissional() {
        String nome = nomeField.getText().trim();
        String especialidade = especialidadeField.getText().trim();
        
        if (nome.isEmpty() || especialidade.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, preencha todos os campos.",
                "Campos Vazios",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double comissao = Double.parseDouble(comissaoField.getText().trim());
            if (comissao < 0 || comissao > 100) {
                throw new NumberFormatException();
            }
            
            Profissional profissional = new Profissional(
                (long) (profissionais.size() + 1),
                nome,
                especialidade,
                comissao
            );
            profissionais.add(profissional);
            textArea.append("✓ Profissional cadastrado com sucesso:\n" + profissional + "\n\n");
            clearProfissionalFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Por favor, insira uma comissão válida entre 0 e 100.",
                "Valor Inválido",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cadastrarServico() {
        String nomeServico = nomeServicoField.getText().trim();

        if (nomeServico.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, preencha o nome do serviço.",
                "Campo Vazio",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double valorServico = Double.parseDouble(valorServicoField.getText().trim());
            if (valorServico <= 0) {
                throw new NumberFormatException();
            }

            Servico servico = new Servico(
                (long) (servicos.size() + 1),
                nomeServico,
                valorServico
            );

            // Seleção de Profissional
            String[] nomesProfissionais = profissionais.stream()
                .map(Profissional::getNome)
                .toArray(String[]::new);

            if (nomesProfissionais.length > 0) {
                String selecionado = (String) JOptionPane.showInputDialog(
                    this,
                    "Selecione um profissional:",
                    "Seleção de Profissional",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    nomesProfissionais,
                    nomesProfissionais[0]
                );

                if (selecionado != null) {
                    // Encontra o profissional selecionado pelo nome
                    Profissional profissionalSelecionado = profissionais.stream()
                        .filter(p -> p.getNome().equals(selecionado))
                        .findFirst()
                        .orElse(null);
                    
                    if (profissionalSelecionado != null) {
                        servico.adicionarProfissional(profissionalSelecionado);
                    }
                }
            }

            servicos.add(servico);
            textArea.append("✓ Serviço cadastrado com sucesso:\n" + servico + "\n\n");
            clearServicoFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Por favor, insira um valor válido maior que zero.",
                "Valor Inválido",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listar() {
        textArea.setText("");
        if (profissionais.isEmpty()) {
            textArea.append("Nenhum profissional cadastrado.\n");
        } else {
            textArea.append("Profissionais Cadastrados:\n");
            for (Profissional p : profissionais) {
                textArea.append(p.toString() + "\n");
            }
        }
        if (servicos.isEmpty()) {
            textArea.append("Nenhum serviço cadastrado.\n");
        } else {
            textArea.append("Serviços Cadastrados:\n");
            for (Servico s : servicos) {
                textArea.append(s.toString() + "\n");
            }
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
