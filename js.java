import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraIMC extends JFrame implements ActionListener {
    private JLabel labelPeso, labelAltura, labelResultado, labelClassificacao;
    private JTextField campoPeso, campoAltura;
    private JButton botaoCalcular;

    public CalculadoraIMC() {
        super("Calculadora de IMC");

        // Configurações da janela
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criação dos componentes
        JPanel panelDados = new JPanel(new GridLayout(2, 2));
        labelPeso = new JLabel("Peso (kg):");
        campoPeso = new JTextField();
        labelAltura = new JLabel("Altura (m):");
        campoAltura = new JTextField();
        panelDados.add(labelPeso);
        panelDados.add(campoPeso);
        panelDados.add(labelAltura);
        panelDados.add(campoAltura);

        botaoCalcular = new JButton("Calcular");
        botaoCalcular.addActionListener(this);

        JPanel panelResultado = new JPanel(new GridLayout(2, 1));
        labelResultado = new JLabel("Seu IMC é: ");
        labelClassificacao = new JLabel("Sua classificação é: ");
        panelResultado.add(labelResultado);
        panelResultado.add(labelClassificacao);

        // Adição dos componentes à janela
        add(panelDados, BorderLayout.CENTER);
        add(botaoCalcular, BorderLayout.SOUTH);
        add(panelResultado, BorderLayout.NORTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == botaoCalcular) {
            double peso = Double.parseDouble(campoPeso.getText());
            double altura = Double.parseDouble(campoAltura.getText());
            double imc = peso / (altura * altura);

            labelResultado.setText("Seu IMC é: " + String.format("%.2f", imc));
            labelClassificacao.setText("Sua classificação é: " + classificarIMC(imc));
        }
    }

    private String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade grau 1";
        } else if (imc < 40) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }
    }

    public static void main(String[] args) {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
    }
}
