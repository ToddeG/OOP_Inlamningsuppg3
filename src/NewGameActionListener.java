import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameActionListener implements ActionListener {

    private FifteenPuzzle fp;


    public NewGameActionListener(FifteenPuzzle fp) {

        this.fp = fp;
    }

    public void actionPerformed(ActionEvent e) {
        FifteenPuzzle newGame = new FifteenPuzzle();
        fp.closeGame();

    }
}
