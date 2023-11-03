import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameActionListener implements ActionListener {

    private final FifteenPuzzle fp;


    public NewGameActionListener(FifteenPuzzle fifp) {

        this.fp = fifp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fp.closeGame();
        FifteenPuzzle newGame = new FifteenPuzzle();


    }
}
