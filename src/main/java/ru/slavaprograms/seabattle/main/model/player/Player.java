package ru.slavaprograms.seabattle.main.model.player;

import ru.slavaprograms.seabattle.main.model.gameMaps.Map;

public class Player {
    private final String name;
    private final Map map;
    private final Map marksMap;

    /**
     * Конструктор пользователя
     * @param name Имя
     * @param map Карта
     */
    public Player(String name, Map map) {
        this.name = name;
        this.map = map;
        this.marksMap = new Map(map.getHorizontalCount()
        , map.getVerticalCount());
    }

    /**
     * Возвращает имя игрока
     * @return Имя игрока
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает карту игрока
     * @return Карта игрока
     */
    public Map getMap() {
        return map;
    }

    /**
     * Возвращает карту для отметки ударов
     * @return Карта для отметки ударов
     */
    public Map getMarksMap() {
        return marksMap;
    }
}
