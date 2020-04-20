package board.figures;

public class Rectangle extends AbstractFigure {

  public Rectangle(Integer x1, Integer y1, Integer x2, Integer y2) {
    super(x1, y1, x2, y2);
  }

  @Override
  public Character[][] drawInMatriz(Character[][] matriz) {
    Line horizontalTop = new Line(x1, y1, x2, y1);
    Line horizontalBotton = new Line(x1, y2, x2, y2);
    Line verticalLeft = new Line(x1, y1, x1, y2);
    Line verticalRight = new Line(x2, y1, x2, y2);
    matriz = horizontalTop.drawInMatriz(matriz);
    matriz = horizontalBotton.drawInMatriz(matriz);
    matriz = verticalLeft.drawInMatriz(matriz);
    matriz = verticalRight.drawInMatriz(matriz);
    return matriz;
  }

}

