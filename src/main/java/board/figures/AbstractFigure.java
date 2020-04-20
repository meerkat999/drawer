package board.figures;

import board.IBoardItem;

public abstract class AbstractFigure implements IBoardItem {

  Integer x1 = null;
  Integer x2 = null;
  Integer y1 = null;
  Integer y2 = null;
  Integer width = null;
  Integer height = null;

  public AbstractFigure(Integer width, Integer height) {
    this.width = width;
    this.height = height;
  }

  public AbstractFigure(Integer x1, Integer y1, Integer x2, Integer y2) {
    this.x1 = x1;
    this.x2 = x2;
    this.y1 = y1;
    this.y2 = y2;
  }

}
