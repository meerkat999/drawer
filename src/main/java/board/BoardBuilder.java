package board;

import board.action.FillArea;
import board.figures.Canvas;
import board.figures.Line;
import board.figures.Rectangle;
import util.InputException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BoardBuilder {

  private static Map<Character, Function<String[], IBoardItem>> mapOfItems;

  private static Function<String[], IBoardItem> builderCanvas = (params) ->
    new Canvas(Integer.parseInt(params[1]), Integer.parseInt(params[2]));

  private static Function<String[], IBoardItem> builderLine = (params) ->
    new Line(Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]), Integer.parseInt(params[4]));

  private static Function<String[], IBoardItem> builderRectangle = (params) ->
    new Rectangle(Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]), Integer.parseInt(params[4]));

  private static Function<String[], IBoardItem> builderFill = (params) ->
    new FillArea(Integer.parseInt(params[1]), Integer.parseInt(params[2]), params[3].charAt(0));

  static {
    mapOfItems = new HashMap<>();
    mapOfItems.put('C', builderCanvas);
    mapOfItems.put('L', builderLine);
    mapOfItems.put('R', builderRectangle);
    mapOfItems.put('B', builderFill);
  }

  public static IBoardItem getBoardItem(String[] params) {
    try {
      return mapOfItems.get(params[0].charAt(0)).apply(params);
    } catch (RuntimeException e) {
      throw new InputException(e);
    }
  }

}
