package rechnerpackage;

import javax.swing.*;

public class RechnerStart {


public static void main(String[] args) {
	JFrame hauptfenster = new MyFrame("Taschenrechner");
	
	hauptfenster.setSize(500, 500);
	hauptfenster.setVisible(true);
	hauptfenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}