package app;

import logical.drawer.DrawerManager;
import logical.drawer.console.ConsoleDrawer;
import util.GraphicalException;
import util.InputException;

import java.util.Scanner;

public class DrawerConsoleMain {

  public static void main(String[] args) {
    DrawerManager drawerManager = new DrawerManager(new ConsoleDrawer());
    Scanner scanner = new Scanner(System.in);
    System.out.print("enter command: ");
    while (scanner.hasNextLine()) {
      String params = scanner.nextLine();
      if (params.length() != 0 && params.charAt(0) == 'Q') {
        System.out.println("Bye");
        return;
      }
      try {
        drawerManager.draw(params.split(" "));
      } catch (GraphicalException | InputException e) {
        System.out.println("It couldn't be printed");
      }
      System.out.print("enter command: ");
    }
    scanner.close();
  }

}
