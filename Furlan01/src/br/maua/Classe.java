package br.maua;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Janela implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JButton button;
    private String senha;
    private JLabel labelAprovado;
    private JLabel labelRejeitado;

    /**
     * Construtor da Janela
     */
    public Janela() {
        //Cria uma janela para testar senhas
        frame = new JFrame("Teste de senhas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        //Define o layout da janela
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        //Cria a área para inserção da senha
        textField = new JTextField(20);
        textField.setText("Insira sua senha");
        frame.add(textField);

        //Cria um botão para verificar a senha
        button = new JButton("Verificar");
        frame.add(button);
        button.addActionListener(this);

        //Cria uma resposta para o botão
        labelAprovado = new JLabel("APROVADO");
        frame.add(labelAprovado);
        labelAprovado.setVisible(false);
        labelRejeitado = new JLabel("REJEITADO");
        frame.add(labelRejeitado);
        labelRejeitado.setVisible(false);

        //Torna a janela e seus componentes visível
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button)
            //Lê o input do usuário
            senha = textField.getText();

        labelAprovado.setVisible(false);
        labelRejeitado.setVisible(false);

        //Estabelece o padrão de senha aceito
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$&*])(?=.*[0-9]).{8,}$");
        Matcher matcher = pattern.matcher(senha);

        //Verifica se a senha é aceita ou não
        if(matcher.find()){
            labelAprovado.setVisible(true);
        }
        else{
            labelRejeitado.setVisible(true);
        }
    }
}
