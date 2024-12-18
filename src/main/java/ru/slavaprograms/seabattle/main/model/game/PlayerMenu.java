package ru.slavaprograms.seabattle.main.model.game;

import ru.slavaprograms.seabattle.main.model.gameMaps.Coordinate;
import ru.slavaprograms.seabattle.main.model.gameMaps.Map;
import ru.slavaprograms.seabattle.main.model.player.Player;
import ru.slavaprograms.seabattle.main.model.ships.Classification;
import ru.slavaprograms.seabattle.main.model.ships.ShipClassification;

import java.util.HashMap;
import java.util.Scanner;

public class PlayerMenu {
    public void menuOpen(Game game){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя игрока №1: ");
        String player1Name = in.nextLine();
        System.out.print("Введите имя игрока №2: ");
        String player2Name = in.nextLine();

        game.playerAdd(player1Name);
        game.playerAdd(player2Name);
        shipToPlace(game);

        // Запускает бой
        BattleMenu battleMenu = new BattleMenu();
        battleMenu.menuOpen(game);
    }

    private void shipToPlace(Game game){
        HashMap<String, Player> players = game.getPlayers();
        Scanner in = new Scanner(System.in);
        for (String key : players.keySet()) {
            Player player = players.get(key);

            String text = String.format("Поместите корабли для игрока %s" +
                            ", при вводе EXT расположение прекратится"
                    , player.getName());

            System.out.println(ConsoleMenu.splitter);
            System.out.println(text);
            System.out.println(ConsoleMenu.splitter);
            boolean toDo = true;
            while (toDo){
                System.out.println(String.format("Расположение кораблей игрока %s", player.getName()));
                System.out.println(ConsoleMenu.splitter);
                Map map = player.getMap();
                map.outputToScreen();
                System.out.print("Введите класс корабля: КАТЕР, ФРЕГАТ, КРЕЙСЕР, ЛИНКОР: ");
                String className = in.nextLine();
                if(className.equals("EXT")){
                    toDo = false;
                    break;
                }
                ShipClassification shipClassification = Classification.getShipClass(className);
                Coordinate coordinate = Coordinate.enterCoordinate();

                System.out.print("Введите расположение горизонтальное(0), вертикальное(1): ");
                String vector = in.nextLine();
                boolean horizontal = false;
                if(vector.equals("0")){
                    horizontal = true;
                }
                map.shipAdd(coordinate, horizontal, shipClassification);
                map.outputToScreen();
                System.out.println(ConsoleMenu.splitter);
            }
        }
    }
}
