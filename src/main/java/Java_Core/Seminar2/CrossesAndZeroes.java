package Java_Core.Seminar2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CrossesAndZeroes {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static int winCount;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static int fieldSize;
    private static char[][] field;

    private static int turn = 0;


    public static void main(String[] args) {
        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (checkState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, "Победил компьютер!"))
                    break;
                turn += 1;
            }
            System.out.println("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                turn = 0;
                break;
        }

    }

    /**
     * Инициализация объектов игры
     */
    static void initialize(){
        System.out.println("Введите размер квадратного поля => ");
        fieldSize = scanner.nextInt();
        System.out.println("Введите количество символов для победы => ");
        winCount = scanner.nextInt();
        field = new char[fieldSize][fieldSize];
        for(int x = 0; x < fieldSize; x++){
            for (int y = 0; y < fieldSize; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField(){
        System.out.print("+");
        for(int x = 0; x < fieldSize; x++){
            System.out.print("-" + (x + 1));
        }
        System.out.println("-");


        for(int x = 0; x < fieldSize; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSize; y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for(int x = 0; x < fieldSize * 2 + 2; x++){
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn(){
        int x;
        int y;
        do{
            System.out.println("Введите координаты хода X и Y\n(от 1 до 3) через пробел: ");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }


    /**
     * Проверка, является ли ячейка игрового поля пустой
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSize && y >= 0 && y < fieldSize;
    }


    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn(){
        int x;
        int y;
        do{
            x = random.nextInt(fieldSize);
            y = random.nextInt(fieldSize);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка на ничью
     * @return
     */
    static boolean checkDraw(){
        for(int x = 0; x < fieldSize; x++){

            for (int y = 0; y < fieldSize; y++){
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    /**
     * TODO: Переработать в рамках домашней работы
     * Метод проверки победы
     * @param dot фишка игрока
     * @return
     */
    static boolean checkWin(char dot){
        int x;
        int y;
        ArrayList<Integer> dots = getNotEmptyDots(field, dot);
        if(!(dots.isEmpty())){
            System.out.println(dots);
            int winRate;
            int tempX;
            int tempY;
            for (int i = 0; i < fieldSize - 2; i+=2) {
                x = dots.get(i);
                y = dots.get(i + 1);
                tempX = x;
                tempY = y;
                /**
                 * Проверяем горизонталь
                 */
                winRate = 1;
                for(int j = 0; j < fieldSize; j++){
                    if(tempX < fieldSize -1){
                        if(field[++tempX][y] == dot){
                            winRate++;
                            System.out.println(winCount - winRate + "До победы по вертикали");
                            if (winRate == winCount){
                                return true;
                            }
                        }
                    }
                }
                winRate = 1;
                /**
                 * Проверяем вертикаль
                 */
                for(int k = 0; k < fieldSize; k++){
                    if(tempY < fieldSize -1){
                        if(field[x][++tempY] == dot){
                            winRate++;
                            System.out.println(winCount - winRate + "До победы по горизонтали");
                            if (winRate == winCount){
                                return true;
                            }
                        }
                    }
                }
                tempX = x;
                tempY = y;
                winRate = 1;
                /**
                 * Проверяем диагональ
                 */
                for(int m = 0; m < fieldSize; m++){
                    if(tempX < fieldSize -1 && tempY < fieldSize -1){
                        if(field[++tempX][++tempY] == dot){
                            winRate++;
                            System.out.println(winCount - winRate  + "До победы по диагонали");
                            if (winRate == winCount){
                                return true;
                            }
                        }
                    }
                }
                winRate = 0;
            }
        }
        return false;
    }

    private static ArrayList<Integer> getNotEmptyDots(char[][] field, char dot) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                if(field[i][j] == dot){
                    result.add(i);
                    result.add(j);
                }
            }
        }
        return result;
    }


    /**
     * Проверка состояния игры
     * @param dot фишка игрока
     * @param s победный слоган
     * @return
     */
    static boolean checkState(char dot, String s){
        if (checkWin(dot)){
            System.out.println(s);
            return true;
        }
        else if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }
}
