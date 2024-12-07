package ru.slavaprograms.seabattle.main.model.ships;

import java.util.HashMap;

public  class Classification {
    /**
     * Возвращает размер класса корабля
     * @param shipClassification Класс корабля
     * @return Размер класса корабля
     */
    public static int sizeShip(ShipClassification shipClassification){
        HashMap<ShipClassification, Integer> shipHash= new HashMap<>();
        shipHash.put(ShipClassification.SPEEDBOAT, 1);
        shipHash.put(ShipClassification.FREGAT, 2);
        shipHash.put(ShipClassification.CRUISER, 3);
        shipHash.put(ShipClassification.LINKOR, 4);

        return shipHash.get(shipClassification);
    }
}
