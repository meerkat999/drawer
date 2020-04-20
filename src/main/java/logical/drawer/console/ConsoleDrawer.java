package logical.drawer.console;

import logical.drawer.IDrawer;

import java.util.stream.Stream;

public class ConsoleDrawer implements IDrawer {

  @Override
  public void draw(Character[][] matriz) {
    Stream.of(matriz).forEach(line -> {
      Stream.of(line).forEach(System.out::print);
      System.out.println("");
    });
  }


}
