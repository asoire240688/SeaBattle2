package ru.slavaprograms.seabattle.main.model.gameMaps;

import ru.slavaprograms.seabattle.main.model.game.ConsoleMenu;

import java.util.Scanner;

public class Coordinate {
    private final int horizontalCoordinate;
    private final int verticalCoordinate;

    public Coordinate(int horizontalCoordinate, int verticalCoordinate) {
        this.horizontalCoordinate = horizontalCoordinate;
        this.verticalCoordinate = verticalCoordinate;
    }

    public int getHorizontalCoordinate() {
        return horizontalCoordinate;
    }

    public int getVerticalCoordinate() {
        return verticalCoordinate;
    }

    /**
     * Возвращает введенные координаты
     * @return Координаты
     */
    public static Coordinate enterCoordinate(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите координаты горизонтали, вертикали " +
                "через запятую например 0,1: ");
        String coordinates = in.nextLine();
        String[] crds = coordinates.split(",");
        int horizontalCrd = Integer.parseInt(crds[0]);
        int verticalCrd = Integer.parseInt(crds[1]);

        return new Coordinate(horizontalCrd, verticalCrd);
    }
}
