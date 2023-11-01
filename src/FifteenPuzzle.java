import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FifteenPuzzle extends JFrame {

    int gridSize = 4;

    JPanel[][] panelArray = new JPanel[gridSize][gridSize];
    JButton tiles = new JButton();

    JButton newGameButton = new JButton("Nytt Spel");
    public JPanel createGameScreen() {
        JPanel screenPanel = new JPanel();
        screenPanel.add(panelFill());
        screenPanel.add(newGameButton);

        return screenPanel;
    }


//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == newGameButton) {
//
//            repaint();
//
//        }
//    }

    public JPanel panelFill() {

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(gridSize, gridSize));

        List<JComponent> list = setRandomNumbers();
        int addingNr = 0;

        for (int i = 0; i < gridSize; i++) {
            panelArray[i] = new JPanel[gridSize];
            for (int j = 0; j < gridSize; j++) {
                panelArray[i][j] = new JPanel();
                panelArray[i][j].setLayout(new GridLayout(1,1));
                panelArray[i][j].add(list.get(addingNr++));

                gamePanel.add(panelArray[i][j]);
            }
        }
        return gamePanel;
    }

    public List<JComponent> setRandomNumbers() {

        List<JComponent> jcList = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < gridSize*gridSize-1; i++) {
            tiles = new JButton("" + (i+1));
            tiles.setName(""+i);
            jcList.add(tiles);
        }
        jcList.add(new JPanel());
        int size = jcList.size();
        for (int i = size - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            JComponent tempJC = jcList.get(i);
            jcList.set(i, jcList.get(j));
            jcList.set(j, tempJC);

        }

        return jcList;
    }

    public FifteenPuzzle() {


        this.add(createGameScreen());
        tiles.addMouseListener(new MouseAction(tiles));

        setSize(300, 300);
        setVisible(true);
        setLocationRelativeTo(null);


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


}
