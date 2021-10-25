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

                // 프레임 기본세팅

this.setTitle("연습");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



//사용할 컴포넌트 객체화

ta = new JTextArea(20, 30);

sc = new JScrollPane(ta);                 //TextArea 객체를 ScrollPane 에 넣어줘서 적용!

panel = new JPanel();

label = new JLabel("글자수 : " + count);


   //컴포넌트 속성 세팅

sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//수평 스크롤 안쓰게함.
sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

ta.setLineWrap(true);                                           //꽉차면 다음줄로 가게 해줌.
panel.setLayout(new FlowLayout(FlowLayout.RIGHT));      //글자수 나오는칸 오른쪽으로 가게 해줌.



   //이벤트처리 연결

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

label.setText("글자수 : " + count);

}



@Override

public void keyReleased(KeyEvent e) {

count = ta.getText().length();

label.setText("글자수 : " + count);

}



@Override

public void keyTyped(KeyEvent e) {

count = ta.getText().length();

label.setText("글자수 : " + count);

}





public class Test {

public void main(String[] args) {

 new  tf_limit();

}

}
}
