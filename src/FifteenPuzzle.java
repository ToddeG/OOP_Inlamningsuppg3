import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FifteenPuzzle extends JFrame {

    int gridSize = 4;
    JPanel[][] panelArray= new JPanel[gridSize][gridSize];
    JButton tiles = new JButton();

    public JPanel randomPanelFill(){

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(gridSize, gridSize));

        List<JComponent> randomList = setNumbers(gridSize);
        int addingNr = 0;

        for (int i = 0; i < gridSize; i++) {
            panelArray[i] = new JPanel[gridSize];
            for (int j = 0; j < gridSize; j++) {
                panelArray[i][j] = new JPanel();
                panelArray[i][j].setLayout(new GridLayout(1,1));
                panelArray[i][j].add(randomList.get(addingNr++));

                gamePanel.add(panelArray[i][j]);
            }
        }
        return gamePanel;
    }


    public List<JComponent> setNumbers(){

        List<JComponent> jcList = new ArrayList<>();
        for (int i = 0; i < gridSize*gridSize-1; i++) {
            tiles = new JButton("" + (i+1));
            tiles.setName(""+i);
            jcList.add(tiles);
        }
        jcList.add(new JPanel());
        return jcList;
    }





    public FifteenPuzzle() {


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

        this.add(randomPanelFill());
        tiles.addMouseListener(new MouseAction(tiles));

        setSize(300, 300);
        setVisible(true);
        setLocationRelativeTo(null);


    }
}
