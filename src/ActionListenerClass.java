import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class ActionListenerClass extends JFrame implements ActionListener {
    private final JPanel[][] panelArray;
    private final int gridSize;

    public ActionListenerClass(JPanel[][] panelArray, int i) {
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
        b.setVisible(true);

        panelArray[x1][y1].remove(0);

        panelArray[x][y].add(b);
        panelArray[x1][y1].add(a);
        b.setVisible(false);


        if (thingsAreInPlace(panelArray)) {


            JLabel jl = new JLabel("Grattis, du vann!");
            jl.setForeground(Color.magenta);


            JPanel jp = new JPanel();
            jp.add(jl);

            JFrame victoryScreen = new JFrame();
            victoryScreen.add(jp);
            victoryScreen.setLocationRelativeTo(null);
            victoryScreen.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            victoryScreen.setSize(200, 80);
            victoryScreen.setVisible(true);
        }

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

    private boolean areAdjacent(int x, int x1, int y, int y1) {

        return Math.abs(x - x1) == 1 && y == y1 || Math.abs(y - y1) == 1 && x == x1;
    }

    private boolean thingsAreInPlace(JPanel[][] jPA) {

        int value = 1;
        int checker = 0;


        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {

                Component temp = jPA[i][j].getComponent(0);
                JButton button = null;

                if (temp instanceof JButton) {
                    button = (JButton) temp;
                }
                if (button != null) {
                    if (Integer.parseInt(button.getText()) == value) {
                        checker++;
                    }
                }
                if (checker == 15) {
                    return true;

                }
                value++;
            }

        }
        return false;
    }
}