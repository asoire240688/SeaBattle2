package ru.slavaprograms.seabattle.main.model.gameMaps;

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
}
