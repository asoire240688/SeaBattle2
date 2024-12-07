package ru.slavaprograms.seabattle.main.model.player;

import ru.slavaprograms.seabattle.main.model.gameMaps.Map;

public class Player {
    private final String name;
    private final Map map;

    /**
     * Конструктор пользователя
     * @param name Имя
     * @param map Карта
     */
    public Player(String name, Map map) {
        this.name = name;
        this.map = map;
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
}
