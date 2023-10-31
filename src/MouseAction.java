import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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

}
