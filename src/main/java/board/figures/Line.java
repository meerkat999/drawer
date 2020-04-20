package board.figures;

import static board.BoardConstants.CHAR_LINE;

public class Line extends AbstractFigure {
  
  public Line(Integer x1, Integer y1, Integer x2, Integer y2) {
    super(x1, y1, x2, y2);
  }

  @Override
  public Character[][] drawInMatriz(Character[][] matriz) {
    int minX = Math.min(x1, x2);
    int maxX = Math.max(x1, x2);
    int minY = Math.min(y1, y2);
    int maxY = Math.min(Math.max(y1, y2), matriz.length);
    for (int y = minY; y <= maxY; y++) {
      Character[] line = matriz[y];
      maxX = Math.min(maxX, line.length);
      for (int x = minX; x <= maxX; x++) {
        line[x] = CHAR_LINE;
      }
    }
    return matriz;
  }

}

