package ru.slavaprograms.seabattle.main.model.game;
import java.util.Scanner;

public class ConsoleMenu {
    static String splitter = "---------------------------------------" +
            "---------------------------------------";
    public void menuOpen(){

        System.out.println(splitter);
        System.out.println("Добро пожаловать в игру Морской бой!");
        System.out.println(splitter);

        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер карты по горизонтали: ");
        int horizontalSize = in.nextInt();
        System.out.print("Введите размер карты по вертикали: ");
        int verticalSize = in.nextInt();

        Game game = new Game(verticalSize, horizontalSize);

        PlayerMenu playerMenu = new PlayerMenu();
        playerMenu.menuOpen(game);

    }
}
