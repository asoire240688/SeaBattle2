package ru.slavaprograms.seabattle.main.model.ships;

import java.util.HashMap;

public  class Classification {
    static HashMap<String, ShipClassification> shipHash;
    /**
     * Возвращает размер класса корабля
     * @param shipClassification Класс корабля
     * @return Размер класса корабля
     */
    public static int sizeShip(ShipClassification shipClassification){
        HashMap<ShipClassification, Integer> shipHash = new HashMap<>();
        shipHash.put(ShipClassification.SPEEDBOAT, 1);
        shipHash.put(ShipClassification.FREGAT, 2);
        shipHash.put(ShipClassification.CRUISER, 3);
        shipHash.put(ShipClassification.LINKOR, 4);

        return shipHash.get(shipClassification);
    }

    /**
     * Возвращает перечисление класса корабля по идентификатору
     * @param classification Класс корабля
     * @return Класс корабля перечисление
     */
    public static ShipClassification getShipClass(String classification){
        HashMap<String, ShipClassification> shipHash = new HashMap<>();
        shipHash.put("КАТЕР", ShipClassification.SPEEDBOAT);
        shipHash.put("ФРЕГАТ", ShipClassification.FREGAT);
        shipHash.put("КРЕЙСЕР", ShipClassification.CRUISER);
        shipHash.put("ЛИНКОР", ShipClassification.LINKOR);

        return shipHash.get(classification);
    }
}
