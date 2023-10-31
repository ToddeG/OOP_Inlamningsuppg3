import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FifteenPuzzle extends JFrame {
    int gridSize = 4;
    JPanel[][] panelArray= new JPanel[4][4];
    JButton tiles = new JButton();

    public JPanel randomPanelFill(int gridSize){

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(gridSize, gridSize));

        List<JComponent> randomList = randomNumbers(gridSize);
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


    public List<JComponent> randomNumbers(int size){

        List<JComponent> jcList = new ArrayList<>();
        for (int i = 0; i < size*size-1; i++) {
            tiles = new JButton("" + (i+1));
            tiles.setName(""+i);
            jcList.add(tiles);
        }
        jcList.add(new JPanel());
        return jcList;
    }


    public FifteenPuzzle() {

        this.add(randomPanelFill(gridSize));
        tiles.addMouseListener(new MouseAction(tiles));

        setSize(300, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
