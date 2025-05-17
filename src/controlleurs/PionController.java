package controlleurs;

import vues.BoardView;
import vues.PionView;
import vues.SquareView;
import modeles.GameManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PionController {
    private GameManager gameManager;

    public PionController(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    // Méthode pour connecter un PionView à la logique de clic
    public void attachToPionView(PionView pionView, int row, int col, BoardView boardView) {
        pionView.addPionMouseListener(new MouseAdapter() {
                                          @Override
                                          public void mouseClicked(MouseEvent e) {
                                              // Exemple : sélection ou déplacement
                                              // Ici, vous pouvez appeler une méthode pour gérer la sélection ou le déplacement
                                              System.out.println("Pion cliqué en [" + row + ", " + col + "]");
                                              // Ajoutez ici la logique de sélection/déplacement, par exemple :
                                              // gameManager.movePiece(...);
                                              // boardView.updateBoard();
                                          }
                                      }
        );
    }
}
