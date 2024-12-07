package ru.slavaprograms.seabattle.main.model.gameMaps;

import ru.slavaprograms.seabattle.main.model.ships.ShipClassification;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    public static void main(String[] args) {
        Map map = new Map(10,10);
       // map.outputToScreen();

        Coordinate coordinate = new Coordinate(3,0);
        map.shipAdd(coordinate, true, ShipClassification.CRUISER);

        Coordinate coordinate2 = new Coordinate(1,1);
        map.shipAdd(coordinate2, false, ShipClassification.LINKOR);

        Coordinate coordinate3 = new Coordinate(1,1);
        map.shipAdd(coordinate3, false, ShipClassification.SPEEDBOAT);

        Coordinate coordinate4 = new Coordinate(3,5);
        map.shipAdd(coordinate4, false, ShipClassification.CRUISER);

        Coordinate coordinate5 = new Coordinate(3,3);
        map.shipAdd(coordinate5, true, ShipClassification.FREGAT);

        Coordinate coordinate6 = new Coordinate(9,3);
        map.shipAdd(coordinate6, false, ShipClassification.CRUISER);

        map.outputToScreen();
    }
}