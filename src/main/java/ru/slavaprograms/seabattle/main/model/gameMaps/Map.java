package ru.slavaprograms.seabattle.main.model.gameMaps;

import ru.slavaprograms.seabattle.main.model.ships.Classification;
import ru.slavaprograms.seabattle.main.model.ships.ShipClassification;

/*
Игровое поле морского боя
 */
public class Map {
    private final int horizontalCount;
    private final int verticalCount;
    private final String[][] gameMap;


    /**
     * Конструктор Карты игры
     * @param horizontalCount Горизонтальный размер
     * @param verticalCount Вертикальный размер
     */
    public Map(int horizontalCount, int verticalCount) {
        this.horizontalCount = horizontalCount;
        this.verticalCount = verticalCount;

        this.gameMap = new String[this.verticalCount][this.horizontalCount];
        for (int i = 0; i < this.horizontalCount; i++) {
            for (int j = 0; j < this.verticalCount; j++) {
                this.gameMap [j][i] = fillerSea();
            }
        }
    }

    /**
     * Возвращает карту игры
     * @return Карты игры
     */
    public String[][] getGameMap() {
        return gameMap;
    }

    /**
     * Добавляет корабль на карту
     * @param coordinate Координаты
     * @param horizontal Признак горизонтального расположения, если ложь - вертикально
     * @param shipClassification Класс корабля
     */
    public void shipAdd(Coordinate coordinate, boolean horizontal, ShipClassification shipClassification){
        int size = Classification.sizeShip(shipClassification);
        int horizontalPos = coordinate.getHorizontalCoordinate();
        int verticalPos   = coordinate.getVerticalCoordinate();

        if (!ItIsPossibleToAdd(coordinate, horizontal, size)){
            System.out.println("Координаты заняты, выберите другие...");
            return;
        }

        if (horizontal){
            for (int i = horizontalPos; i < (size + horizontalPos); i++) {
                setValueOfCell(new Coordinate(i, verticalPos), fillerShip());
                //this.gameMap[verticalPos][i] = fillerShip();
            }
        }
        else {
            for (int i = verticalPos; i < (size + verticalPos); i++) {
                setValueOfCell(new Coordinate(horizontalPos, i), fillerShip());
                //this.gameMap[i][horizontalPos] = fillerShip();
            }
        }
    }

    /**
     * Выводит карту на экран
     */
    public void outputToScreen(){
        System.out.print("   "); //toDo при указании размера полей выше 10 все разьедется, нужно учесть
        for (int j = 0; j < this.horizontalCount; j++) {
            System.out.print(" " + j + " ");
        }
        System.out.println();
        for (int i = 0; i < this.verticalCount; i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < this.horizontalCount; j++) {
                System.out.print(" " + getValueOfCell(new Coordinate(j, i)) + " ");
                //System.out.print(" " + this.gameMap [i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Возвращает возможность добавления корабля
     * @param coordinate Координата
     * @param horizontal Признак горизонтального расположения
     * @param size Размер корабля
     * @return Признак возможности добавления корабля
     */
    private boolean ItIsPossibleToAdd(Coordinate coordinate, boolean horizontal, int size){
        boolean result = true;
        int horizontalPos = coordinate.getHorizontalCoordinate();
        int verticalPos   = coordinate.getVerticalCoordinate();
        int positionCount;

        // Проверим на занятость ячеек явно
        if (horizontal){
            positionCount = size + horizontalPos;
            // Проверим на границы полей
            if(positionCount > this.horizontalCount){
                System.out.println("Помещаемый корабль выходит за рамки карты по горизонтали...");
                return false;
            }
            for (int i = horizontalPos; i < positionCount; i++) {
                if (!this.gameMap[verticalPos][i].equals(fillerSea())){
                    result = false;
                    break;
                }
                // ToDo Проверим на близкое расположение
            }
        }
        else {
            positionCount = size + verticalPos;
            // Проверим на границы полей
            if(positionCount > verticalCount){
                System.out.println("Помещаемый корабль выходит за рамки карты по вертикали...");
                return false;
            }
            for (int i = verticalPos; i < positionCount; i++) {
                if (!this.gameMap[i][horizontalPos].equals(fillerSea())){
                    result = false;
                    break;
                }
                // ToDo Проверим на близкое расположение
            }
        }

        return result;
    }

    /**
     * Возвращает наполнитель ячейки море
     * @return Наполнитель море
     */
    public static String fillerSea(){
        return "~";
    }

    /**
     * Возвращает наполнитель ячейки корабль
     * @return Наполнитель корабль
     */
    public static String fillerShip(){
        return "O";
    }

    /**
     * Возвращает наполнитель ячейки - Попадание
     * @return Наполнитель попадание
     */
    public static String fillerShot(){
        return "X";
    }

    /**
     * Возвращает наполнитель ячейки - Промах
     * @return Наполнитель промах
     */
    public static String fillerMissed(){
        return "*";
    }

    /**
     * Возвращет количество горизонтальных ячеек
     * @return Количество горизонтальных ячеек
     */
    public int getHorizontalCount() {
        return horizontalCount;
    }

    /**
     * Возвращает количество вертикальных ячеек
     * @return Количество вертикальных ячеек
     */
    public int getVerticalCount() {
        return verticalCount;
    }

    /**
     * Возвращает значение ячейки карты
     * @param coordinate Координаты
     * @return Значение ячейки
     */
    public String getValueOfCell(Coordinate coordinate){
        String result = "";
        try{
            result = this.gameMap[coordinate.getVerticalCoordinate()][coordinate.getHorizontalCoordinate()];
        }catch (Exception e){
            result = fillerSea();
        }
        return result;
    }

    /**
     * Устанавливает значение ячейки
     * @param coordinate Координаты
     * @param value Значение
     */
    public void setValueOfCell(Coordinate coordinate, String value){
        this.gameMap[coordinate.getVerticalCoordinate()][coordinate.getHorizontalCoordinate()] = value;
    }
}
