import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionListenerClass extends JFrame implements ActionListener {
    JPanel[][] panelArray;
    JButton jb;
    int gridSize;
    public ActionListenerClass(JButton jb, JPanel[][] panelArray, int i){
        this.jb = jb;
        this.panelArray = panelArray;
        this.gridSize = i;
    }

    public void actionPerformed(ActionEvent e) {
        JButton pressedButton = (JButton) e.getSource();
        int x = -1;
        int y = -1;

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if(panelArray[i][j].getComponent(0) == pressedButton){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        if(x != -1 && y != -1){
           int x1 = findEmptyIndex() / gridSize;
           int y1 = findEmptyIndex() % gridSize;
           if(areAdjacent(x, x1, y, y1)){
               swapButton(x, y, findEmptyIndex());
           }
        }
    }

    private void swapButton(int x, int y, int emptyIndex) {
        Component a = panelArray[x][y].getComponent(0);
        panelArray[x][y].remove(0);

        int x1 = emptyIndex / gridSize;
        int y1 = emptyIndex % gridSize;

        Component b = panelArray[x1][y1].getComponent(0);

        panelArray[x1][y1].remove(0);
        b.setVisible(false);
        panelArray[x][y].add(b);
        panelArray[x1][y1].add(a);

        this.repaint();
    }

    private int findEmptyIndex() {
        for (int index = 0; index < gridSize * gridSize; index++) {
            int i = index / gridSize;
            int j = index % gridSize;
            if (!(panelArray[i][j].getComponent(0) instanceof JButton)) {
                return index;
            }
        }
        return 0;
    }

    public boolean areAdjacent(int x, int x1, int y, int y1){

        if(Math.abs(x - x1) == 1 && y == y1 || Math.abs(y - y1) == 1 && x == x1){
            return true;
        }else return false;
    }
}
