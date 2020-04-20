package board.figures;

import static board.BoardConstants.*;

public class Canvas extends AbstractFigure {

  public Canvas(Integer width, Integer height) {
    super(width + 2, height + 2);
  }

  public Character[][] drawInMatriz(Character[][] matriz) {
    matriz = new Character[height][width];
    for (int x = 0; x < height; x++) {
      Character[] line = new Character[width];
      for (int y = 0; y < width; y++) {
        if (isFirtsOrLastRowColumn(y, width)) {
          line[y] = CHAR_COLUMN;
        }
        if (isFirtsOrLastRowColumn(x, height)) {
          line[y] = CHAR_ROW;
        }
        if (!isFirtsOrLastRowColumn(x, height) && !isFirtsOrLastRowColumn(y, width)) {
          line[y] = CHAR_EMPTY;
        }
      }
      matriz[x] = line;
    }
    return matriz;
  }

  private boolean isFirtsOrLastRowColumn(int value, Integer maxValue) {
    return value == 0 || value == maxValue - 1;
  }

}
