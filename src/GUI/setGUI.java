package GUI;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class setGUI extends JFrame{
	public setGUI() {
		setTitle("Ŭ���� ������");
		setResizable(false);
		setLocationRelativeTo(null);

		Container c = this.getContentPane();
		c.setBackground(new Color(250,233,220));
		
		setVisible(true);
	}
public static void main(String[] args) {
	new setGUI();
}
}
