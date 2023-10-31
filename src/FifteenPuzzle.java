import javax.swing.*;
import java.awt.*;

public class FifteenPuzzle extends JFrame {
    JPanel[][] panelArray= new JPanel[gridSize][gridSize];


    public FifteenPuzzle() {

//    private JPanel getPanel(int size) {
//        JPanel jp = new JPanel();
//        GridLayout grLay = new GridLayout(size, size);
//        jp.setLayout(grLay);
//
//
//
//
//
//        return jp;
    }
    private void swapButton(int x, int y, int emptyIndex) {
        Component a = panelArray[x][y].getComponent(0);

        int x1 = emptyIndex / gridSize;
        int y1 = emptyIndex % gridSize;

        Component b = panelArray[x1][y1].getComponent(0);

        panelArray[x][y].remove(0);
        panelArray[x1][y1].remove(0);

        panelArray[x][y].add(b);
        panelArray[x1][y1].add(a);

        b.requestFocus();
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

//


}
