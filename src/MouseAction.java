import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MouseAction extends MouseAdapter {

    JButton jb;

    public MouseAction(JButton jb){
        this.jb = jb;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == jb){
            
        }


    }
    public void actionPerformed(ActionEvent e, FifteenPuzzle fp) {
        if (e.getSource() == fp.newGameButton) {

            fp.panelFill();

            fp.repaint();

        }
    }

}
