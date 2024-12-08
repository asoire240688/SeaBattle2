package ru.slavaprograms.seabattle.main.model.game;

import ru.slavaprograms.seabattle.main.model.gameMaps.Map;
import ru.slavaprograms.seabattle.main.model.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();
    private final int verticalCount;
    private final int horizontalCount;

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

    public boolean gameOver(){
        // Обойдем все ячейки игроков, если останется всего один игрок
        // значит игра окончена и победитель определен
        boolean result = false;
        HashMap<String, Player> players = this.players;
        ArrayList<Player> finalPlayers = new ArrayList<>();
        for (String key : players.keySet()) {
            Player player = players.get(key);
            Map map = player.getMap();
            String[][] gameMap = map.getGameMap();
            boolean findResult = true;
            for (int i = 0; i < map.getHorizontalCount(); i++) {
                for (int j = 0; j < map.getVerticalCount(); j++) {
                    String resultCell = gameMap[j][i];
                    if(resultCell.equals(Map.fillerShip())){
                        finalPlayers.add(player);
                        findResult = false;
                        break;
                    }
                }
                if (!findResult){
                    break;
                }
            }
        }
        // Проверим коллекию игроков, если количество = 1 то победитель определен
        // игра окончена
        if (finalPlayers.size() == 1){
            result = true;
            System.out.println("Победителем игры обьявлен: " + finalPlayers.get(0)
                    .getName());
            finalPlayers = null;
        }
        return  result;
    }
}
