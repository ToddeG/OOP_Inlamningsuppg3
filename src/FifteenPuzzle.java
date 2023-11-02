import javax.swing.*;
import java.awt.*;
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
        newGameButton.addActionListener(new NewGameActionListener(this));
        screenPanel.add(newGameButton);

        return screenPanel;
    }


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
            tiles.setPreferredSize(new Dimension(50, 50));
            tiles.addActionListener(new ActionListenerClass(tiles, panelArray, gridSize));
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

        setSize(300, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }





    public void closeGame() {
        this.dispose();
    }
}
