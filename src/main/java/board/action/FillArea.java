package board.action;

import board.IBoardItem;

public class FillArea implements IBoardItem {

  private Integer x;
  private Integer y;
  private Character color;
  private Integer maxColums;
  private Integer maxRows;

  public FillArea(Integer x, Integer y, Character color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  @Override
  public Character[][] drawInMatriz(Character[][] matriz) {
    this.prepareLimits(matriz);
    return fillNeigbor(this.x, this.y, matriz);
  }

  private void prepareLimits(Character[][] matriz) {
    this.maxRows = matriz.length;
    if (this.maxRows > 0) {
      this.maxColums = matriz[0].length;
      if (this.maxColums <= 0) {
        throwMatrizError();
      }
    } else {
      throwMatrizError();
    }
  }

  private void throwMatrizError() {
    throw new RuntimeException("Matriz is wrong builded");
  }

  private Character[][] fillNeigbor(Integer x, Integer y, Character[][] matriz) {
    if (x < 0 || x > this.maxColums || y < 0 || y > this.maxRows) {
      return matriz;
    }
    if (matriz[y][x] != ' ') {
      return matriz;
    }
    matriz[y][x] = this.color;
    fillNeigbor(x + 1, y + 1, matriz);
    fillNeigbor(x + 1, y, matriz);
    fillNeigbor(x, y + 1, matriz);
    fillNeigbor(x, y - 1, matriz);
    fillNeigbor(x - 1, y, matriz);
    fillNeigbor(x - 1, y - 1, matriz);
    fillNeigbor(x - 1, y + 1, matriz);
    fillNeigbor(x + 1, y - 1, matriz);
    return matriz;
  }


}

