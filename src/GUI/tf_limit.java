package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class tf_limit extends JFrame implements KeyListener{


private JTextArea ta;
private JScrollPane sc;
private JLabel label;
private JPanel panel;
private int count = 0;

public tf_limit() {

                // ������ �⺻����

this.setTitle("����");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



//����� ������Ʈ ��üȭ

ta = new JTextArea(20, 30);

sc = new JScrollPane(ta);                 //TextArea ��ü�� ScrollPane �� �־��༭ ����!

panel = new JPanel();

label = new JLabel("���ڼ� : " + count);


   //������Ʈ �Ӽ� ����

sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//���� ��ũ�� �Ⱦ�����.
sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

ta.setLineWrap(true);                                           //������ �����ٷ� ���� ����.
panel.setLayout(new FlowLayout(FlowLayout.RIGHT));      //���ڼ� ������ĭ ���������� ���� ����.



   //�̺�Ʈó�� ����

ta.addKeyListener(this);


this.add(sc, BorderLayout.CENTER);

panel.add(label);

this.add(panel, BorderLayout.SOUTH);

this.pack();


this.setVisible(true);


}





@Override

public void keyPressed(KeyEvent e) {

count = ta.getText().length();

label.setText("���ڼ� : " + count);

}



@Override

public void keyReleased(KeyEvent e) {

count = ta.getText().length();

label.setText("���ڼ� : " + count);

}



@Override

public void keyTyped(KeyEvent e) {

count = ta.getText().length();

label.setText("���ڼ� : " + count);

}





public class Test {

public void main(String[] args) {

 new  tf_limit();

}

}
}
