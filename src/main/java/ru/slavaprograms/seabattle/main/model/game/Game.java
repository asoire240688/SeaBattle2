package ru.slavaprograms.seabattle.main.model.game;

import ru.slavaprograms.seabattle.main.model.gameMaps.Map;
import ru.slavaprograms.seabattle.main.model.player.Player;

import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();
    private int verticalCount;
    private int horizontalCount;

    /**
     * Конструктор игры
     * @param verticalCount размер карты по вертикали
     * @param horizontalCount размер карты по горизонтали
     */
    public Game(int verticalCount, int horizontalCount) {
        this.verticalCount = verticalCount;
        this.horizontalCount = horizontalCount;
    }

    /**
     * Добавляет игрока
     * @param name Имя игрока
     */
    public void playerAdd(String name){
        Player player = new Player(name, new Map(horizontalCount, verticalCount));
        players.put(name, player);
    }

    /**
     * Возвращает игрока по имени
     * @param name Имя игрока
     * @return Игрок
     */
    public Player getPlayer(String name){
        return players.get(name);
    }

    /**
     * Возвращает игроков
     * @return Коллекция игроков
     */
    public HashMap<String, Player> getPlayers() {
        return players;
    }
}
