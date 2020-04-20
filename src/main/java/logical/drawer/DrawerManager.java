package logical.drawer;

import board.BoardBuilder;
import board.IBoardItem;
import util.GraphicalException;
import util.InputException;

public class DrawerManager {

  private IDrawer drawer;
  private Character[][] matriz = new Character[0][0];

  public DrawerManager(IDrawer drawer) {
    this.drawer = drawer;
  }

  public Character[][] draw(String[] params) {
    return draw(BoardBuilder.getBoardItem(params));
  }

  private Character[][] draw(IBoardItem action) {
    try {
      matriz = action.drawInMatriz(matriz);
    } catch (RuntimeException e) {
      throw new GraphicalException(e);
    }
    drawer.draw(matriz);
    return matriz;
  }

}
