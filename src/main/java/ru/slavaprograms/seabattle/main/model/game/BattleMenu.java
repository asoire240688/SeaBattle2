package ru.slavaprograms.seabattle.main.model.game;

import ru.slavaprograms.seabattle.main.model.gameMaps.Coordinate;
import ru.slavaprograms.seabattle.main.model.gameMaps.Map;

import java.util.Scanner;
import java.util.SortedMap;

/**
 * Меню проведения боя
 */
public class BattleMenu {

    /**
     * Открывает меню управления боем
     * @param game Игра
     */
    public void menuOpen(Game game){
        Scanner in = new Scanner(System.in);
        System.out.println(ConsoleMenu.splitter);
        System.out.print("Введите размер карты по горизонтали: ");
        int horizontalSize = in.nextInt();
        System.out.print("Введите размер карты по вертикали: ");
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
