import javax.swing.*;
import java.awt.*;

public class FifteenPuzzle extends JFrame {
//    JPanel[][] panelArray= new JPanel[4][4];

    JPanel jPan = new JPanel();
    JButton jb1 = new JButton("1");
    JButton jb2 = new JButton("2");
    JButton jb3 = new JButton("3");
    JButton jb4 = new JButton("4");
    JButton jb5 = new JButton("5");
    JButton jb6 = new JButton("6");
    JButton jb7 = new JButton("7");
    JButton jb8 = new JButton("8");
    JButton jb9 = new JButton("9");
    JButton jb10 = new JButton("10");
    JButton jb11 = new JButton("11");
    JButton jb12 = new JButton("12");
    JButton jb13 = new JButton("13");
    JButton jb14 = new JButton("14");
    JButton jb15 = new JButton("15");
    JButton jb16 = new JButton();




    public FifteenPuzzle() {
        this.add(jPan);
        jPan.add(jb1);
        jPan.add(jb2);
        jPan.add(jb3);
        jPan.add(jb4);
        jPan.add(jb5);
        jPan.add(jb6);
        jPan.add(jb7);
        jPan.add(jb8);
        jPan.add(jb9);
        jPan.add(jb10);
        jPan.add(jb11);
        jPan.add(jb12);
        jPan.add(jb13);
        jPan.add(jb14);
        jPan.add(jb15);
        jPan.add(jb16);

        jPan.setLayout(new GridLayout(4,4));

        pack();
        setVisible(true);
        jb16.setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
//    private JPanel getPanel(int size) {
//        JPanel jp = new JPanel();
//        GridLayout grLay = new GridLayout(size, size);
//        jp.setLayout(grLay);
//
//
//
//
//        return jp;
//    }



}
