import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FifteenPuzzle extends JFrame implements ActionListener {

    private final int gridSize = 4;

    private final JPanel[][] panelArray = new JPanel[gridSize][gridSize];

    private final JButton newGameButton = new JButton("Nytt Spel");

    private final JButton testButton  = new JButton("Test");


    public JPanel createGameScreen(JPanel jp) {

        JPanel screenPanel = new JPanel();
        screenPanel.add(jp);
        newGameButton.addActionListener(new NewGameActionListener(this));
        screenPanel.add(newGameButton);
        testButton.addActionListener(this);
        screenPanel.add(testButton);


        return screenPanel;
    }


    public JPanel panelFill(List<JComponent> list) {

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(gridSize, gridSize));

        List<JComponent> jlist = list;
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

        List<JComponent> jcList = setNumbers();
        Random r = new Random();

        int size = jcList.size();
        for (int i = size - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            JComponent tempJC = jcList.get(i);
            jcList.set(i, jcList.get(j));
            jcList.set(j, tempJC);

        }
        return jcList;
    }

    public List<JComponent> setNumbers(){
        List<JComponent> jcList = new ArrayList<>();

        for (int i = 0; i < gridSize*gridSize-1; i++) {
            JButton tiles = new JButton("" + (i+1));
            tiles.setName(""+i);
            tiles.setForeground(Color.white);
            tiles.setBackground(Color.red);
            tiles.setPreferredSize(new Dimension(50, 50));
            tiles.addActionListener(new ActionListenerClass(panelArray, gridSize));
            jcList.add(tiles);
        }
        jcList.add(new JPanel());
        return jcList;
    }

    public FifteenPuzzle() {


        this.add(createGameScreen(panelFill(setRandomNumbers())));

        setTitle("15 Spel");
        setSize(225, 280);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public FifteenPuzzle(boolean test) {

        this.add(createGameScreen(panelFill(setNumbers())));

        setTitle("15 Test");
        setSize(225, 280);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
    public void closeGame() {
        this.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == testButton)){
            boolean test = true;
            FifteenPuzzle testing = new FifteenPuzzle(test);
            createGameScreen(panelFill(setNumbers()));
            closeGame();
        }
    }
}
