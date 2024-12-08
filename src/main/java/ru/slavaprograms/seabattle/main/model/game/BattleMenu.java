package ru.slavaprograms.seabattle.main.model.game;

import ru.slavaprograms.seabattle.main.model.gameMaps.Coordinate;
import ru.slavaprograms.seabattle.main.model.gameMaps.Map;
import ru.slavaprograms.seabattle.main.model.player.Player;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Меню проведения боя
 */
public class BattleMenu {

    /**
     * Открывает меню управления боем
     * @param game Игра
     */
    public void menuOpen(Game game){
        HashMap<String, Player> players = game.getPlayers();
        while (!game.gameOver()){
            System.out.println(ConsoleMenu.splitter);
            Scanner in = new Scanner(System.in);
            System.out.print("Введите имя игрока начинающего стрельбу: ");
            String playerFireName = in.nextLine();
            System.out.print("Введите имя противника: ");
            String playerTargetName = in.nextLine();
            if(playerFireName.equals("EXT") || playerTargetName.equals("EXT")){
                break;
            }
            Player playerFire     = players.get(playerFireName);
            Player playerTarget   = players.get(playerTargetName);
            Coordinate coordinateTarget = Coordinate.enterCoordinate();
            fire(coordinateTarget, playerTarget.getMap(), playerFire.getMarksMap());
        }
    }

    /**
     * Управление огнем
     * @param coordinate Координаты
     * @param targetMap Карта противника для удара
     * @param marksMap Карта для отметки ударов
     */
    public void fire(Coordinate coordinate, Map targetMap, Map marksMap){

        // Стреляем до первого промаха
        boolean stepFire = true;
        while (stepFire){
            if (targetMap.getValueOfCell(coordinate).equals(Map.fillerShip())){
                targetMap.setValueOfCell(coordinate, Map.fillerShot());
                marksMap.setValueOfCell(coordinate, Map.fillerShot());
                System.out.println("Попадание!");
            }else {
                marksMap.setValueOfCell(coordinate, Map.fillerMissed());
                System.out.println("Промах!");
                stepFire = false;
            }
            // Выводим результат
            marksMap.outputToScreen();
            if (stepFire){
                coordinate = Coordinate.enterCoordinate();
            }
        }
    }
}
