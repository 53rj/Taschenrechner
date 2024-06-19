package rechnerpackage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JPanel textPanel;
    private JTextField inputText, resultText;
    private JButton button1, 
                    button2, 
                    button3, 
                    button4, 
                    button5, 
                    button6, 
                    button7, 
                    button8, 
                    button9, 
                    button10, 
                    button11, 
                    button12, 
                    button13, 
                    button14, 
                    button15, 
                    button16, 
                    button17, 
//                    button18, 
//                    button19, 
//                    button20,
                    button21;

    public MyFrame(String titel) {
        super(titel);

        setLayout(new BorderLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Textfelder
        inputText = new JTextField();
        inputText.setEditable(false);
        inputText.setPreferredSize(new Dimension(400, 50));

        resultText = new JTextField();
        resultText.setEditable(false);
        resultText.setPreferredSize(new Dimension(400, 50));

        // Konfigurieren des textPanels
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(inputText);
        textPanel.add(resultText);

        // Hauptpanel für die Buttons
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(7, 3, 2, 2));

        // Buttoncreation
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        button10 = new JButton("0");
        button11 = new JButton("+");
        button12 = new JButton("-");
        button13 = new JButton("*");
        button14 = new JButton("/");
        button15 = new JButton("=");
        button16 = new JButton(",");
        button17 = new JButton("^");
//        button18 = new JButton("(");
//        button19 = new JButton(")");
//        button20 = new JButton("²");
        button21 = new JButton("Clear");

        // Button-ActionListener
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);
        button11.addActionListener(this);
        button12.addActionListener(this);
        button13.addActionListener(this);
        button14.addActionListener(this);
        button15.addActionListener(this);
        button16.addActionListener(this);
        button17.addActionListener(this);
//        button18.addActionListener(this);
//        button19.addActionListener(this);
//        button20.addActionListener(this);
        button21.addActionListener(this);

        // Hinzufügen der Buttons
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(button4);
        mainPanel.add(button5);
        mainPanel.add(button6);
        mainPanel.add(button7);
        mainPanel.add(button8);
        mainPanel.add(button9);
        mainPanel.add(button10);
        mainPanel.add(button11);
        mainPanel.add(button12);
        mainPanel.add(button13);
        mainPanel.add(button14);
        mainPanel.add(button15);
        mainPanel.add(button16);
        mainPanel.add(button17);
//        mainPanel.add(button18);
//        mainPanel.add(button19);
//        mainPanel.add(button20);
        mainPanel.add(button21);

        // Hinzufügen der Panels zum JFrame
        this.add(textPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String currentText = inputText.getText();

        if (source == this.button1) {
            this.inputText.setText(currentText + "1");
        } else if (source == this.button2) {
            this.inputText.setText(currentText + "2");
        } else if (source == this.button3) {
            this.inputText.setText(currentText + "3");
        } else if (source == this.button4) {
            this.inputText.setText(currentText + "4");
        } else if (source == this.button5) {
            this.inputText.setText(currentText + "5");
        } else if (source == this.button6) {
            this.inputText.setText(currentText + "6");
        } else if (source == this.button7) {
            this.inputText.setText(currentText + "7");
        } else if (source == this.button8) {
            this.inputText.setText(currentText + "8");
        } else if (source == this.button9) {
            this.inputText.setText(currentText + "9");
        } else if (source == this.button10) {
            this.inputText.setText(currentText + "0");
        } else if (source == this.button11) {
            this.inputText.setText(currentText + " + ");
        } else if (source == this.button12) {
            this.inputText.setText(currentText + " - ");
        } else if (source == this.button13) {
            this.inputText.setText(currentText + " * ");
        } else if (source == this.button14) {
            this.inputText.setText(currentText + " / ");
        } else if (source == this.button15) {
            String result = calculate(currentText);
            this.resultText.setText(result);
        } else if (source == this.button16) {
            this.inputText.setText(currentText + ",");
        } else if (source == this.button17) {
            this.inputText.setText(currentText + " ^ ");
//        } else if (source == this.button18) {
//            this.inputText.setText(currentText + "(");
//        } else if (source == this.button19) {
//            this.inputText.setText(currentText + ")");
//        } else if (source == this.button20) {
//            this.inputText.setText(currentText + "²");
        } else if (source == this.button21) {
            this.inputText.setText("");
            this.resultText.setText("");
        }
    }
    
    // Berechnung der Strings
    private String calculate(String input) {
    	
    	//  String wird aufgeteilt und durch Leerzeichen getrennt
        String[] tokens = input.split(" ");
        
        // Double speichert zahlen & String speichert Operatoren
        Stack<Double> values = new Stack<>();
        Stack<String> operators = new Stack<>();
        
        // Im ersten Schritt erfolgt eine Überprüfung der Tokens, wenn das Token eine Zahl ist, wird es als double formatiert und auf den values-Stack gelegt.
        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                values.push(Double.parseDouble(token));
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^")) {
            	
            	//Wenn das Token ein Operator (+, -, *, /) ist, wird überprüft, ob der Operator 
            	// aufgrund der Operatorpräzedenz/Vorrang auf den values-Stack angewendet werden muss.
                while (!operators.isEmpty() && hasPrecedence(token, operators.peek())) {
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(token);
            }
        }
        
        while (!operators.isEmpty()) {
            values.push(applyOp(operators.pop(), values.pop(), values.pop()));
        }
        
        double result = values.pop();
        
        // Prüfung ob die Zahl eine Ganzzahl ist oder eine Dezimalzahl; bei Ganzzahl wird es als %d übergeben, was die Zahl in Integer formatiert
        // und bei einer Kommazahl wird es in %s übergeben, welches als String formatiert wird, da es eine Kommazahl ist
        // tldr:
        // %s = String & %d = Ganzzahlen 
        if (result == (long) result) {
            return String.format("%d", (long) result);
        } else {
            return String.format("%s", result);
        }
    }
    
    
    // Vorrängigkeit prüfen bei . vor -
    private boolean hasPrecedence(String op1, String op2) {
        if ((op1.equals("*") || op1.equals("/") || op1.equals("^")) && (op2.equals("+") || op2.equals("-"))) {
            return false;
        } else {
            return true;
        }
    }
    
    
    // Einsetzen der Operatoren zur Berechnung der Eingabe
    private double applyOp(String op, double b, double a) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                return a / b; 
                } else {
                	// Zeige ein Popup-Fenster mit der Fehlermeldung an
                	JOptionPane.showMessageDialog(null, "DU WILLST DURCH 0 TEILEN?!?!?! XD",
                    "Fehler", JOptionPane.ERROR_MESSAGE);
            	return 0;
            }
            case "^":
                return Math.pow(a,b);
        }
        return 0;
    }
}