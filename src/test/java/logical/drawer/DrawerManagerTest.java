package logical.drawer;

import board.action.FillArea;
import board.figures.Canvas;
import board.figures.Line;
import board.figures.Rectangle;
import logical.drawer.console.ConsoleDrawer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DrawerManagerTest {

  private ByteArrayOutputStream outSpy;

  @Before
  public void init() {
    System.setOut(new PrintStream(outSpy = new ByteArrayOutputStream()));
  }

  @Test
  public void debeDibujarCorrectamenteUnCalvasConUnRectanguloYLlenarTodoExceptoElRectanguloConConsola() {
    DrawerManager drawerManager = new DrawerManager(new ConsoleDrawer());
    String[] paramsCanvas = "C 20 4".split(" ");
    Character[][] draw = drawerManager.draw(paramsCanvas);
    String[] paramsRectangle = "R 16 1 20 3".split(" ");
    drawerManager.draw(paramsRectangle);
    String[] paramsFillArea = "B 1 1 o".split(" ");
    drawerManager.draw(paramsFillArea);
    Assert.assertNotNull(draw);
    String output = obtenerLogEscrito();
    String dibujoEsperado =
      "----------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "----------------------\n" +
        "----------------------\n" +
        "|               xxxxx|\n" +
        "|               x   x|\n" +
        "|               xxxxx|\n" +
        "|                    |\n" +
        "----------------------\n" +
        "----------------------\n" +
        "|oooooooooooooooxxxxx|\n" +
        "|ooooooooooooooox   x|\n" +
        "|oooooooooooooooxxxxx|\n" +
        "|oooooooooooooooooooo|\n" +
        "----------------------\n";
    Assert.assertEquals(dibujoEsperado, output);
  }


  @Test
  public void debeDibujarCorrectamenteUnCalvasConUnRectanguloConConsola() {
    DrawerManager drawerManager = new DrawerManager(new ConsoleDrawer());
    int width = 20;
    int height = 4;
    String[] paramsCanvas = "C 20 4".split(" ");
    Character[][] draw = drawerManager.draw(paramsCanvas);
    String[] paramsRectangle = "R 16 1 20 3".split(" ");
    drawerManager.draw(paramsRectangle);
    Assert.assertNotNull(draw);
    String output = obtenerLogEscrito();
    String dibujoEsperado =
      "----------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "----------------------\n" +
        "----------------------\n" +
        "|               xxxxx|\n" +
        "|               x   x|\n" +
        "|               xxxxx|\n" +
        "|                    |\n" +
        "----------------------\n";
    Assert.assertEquals(dibujoEsperado, output);
  }

  @Test
  public void debeDibujarCorrectamenteUnCalvasConUnaLineaHorizontalYVertialConConsola() {
    DrawerManager drawerManager = new DrawerManager(new ConsoleDrawer());
    int width = 20;
    int height = 4;
    String[] paramsCanvas = "C 20 4".split(" ");
    Character[][] draw = drawerManager.draw(paramsCanvas);
    String[] paramsLineH = "L 1 2 6 2".split(" ");
    drawerManager.draw(paramsLineH);
    String[] paramsLineV = "L 6 3 6 4".split(" ");
    drawerManager.draw(paramsLineV);
    Assert.assertNotNull(draw);
    String output = obtenerLogEscrito();
    String dibujoEsperado =
      "----------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "----------------------\n" +
        "----------------------\n" +
        "|                    |\n" +
        "|xxxxxx              |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "----------------------\n" +
        "----------------------\n" +
        "|                    |\n" +
        "|xxxxxx              |\n" +
        "|     x              |\n" +
        "|     x              |\n" +
        "----------------------\n";
    Assert.assertEquals(dibujoEsperado, output);
  }

  @Test
  public void debeDibujarCorrectamenteUnCalvasConUnaLineaHorizontalConConsola() {
    DrawerManager drawerManager = new DrawerManager(new ConsoleDrawer());
    String[] paramsCanvas = "C 20 4".split(" ");
    Character[][] draw = drawerManager.draw(paramsCanvas);
    String[] paramsLineH = "L 1 2 6 2".split(" ");
    drawerManager.draw(paramsLineH);
    Assert.assertNotNull(draw);
    String output = obtenerLogEscrito();
    String dibujoEsperado =
      "----------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "----------------------\n" +
        "----------------------\n" +
        "|                    |\n" +
        "|xxxxxx              |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "----------------------\n";
    Assert.assertEquals(dibujoEsperado, output);
  }

  @Test
  public void debeDibujarCorrectamenteUnCalvasConConsola() {
    DrawerManager drawerManager = new DrawerManager(new ConsoleDrawer());
    int width = 20;
    int height = 4;
    String[] paramsCanvas = "C 20 4".split(" ");
    Character[][] draw = drawerManager.draw(paramsCanvas);
    Assert.assertNotNull(draw);
    Assert.assertEquals(draw.length, height + 2);
    Assert.assertEquals(draw[0].length, width + 2);
    String output = obtenerLogEscrito();
    String dibujoEsperado =
      "----------------------\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "|                    |\n" +
        "----------------------\n";
    Assert.assertEquals(dibujoEsperado, output);
  }

  private String obtenerLogEscrito() {
    String output = outSpy.toString();
    output = output.replaceAll("\r", "");
    return output;
  }

}
