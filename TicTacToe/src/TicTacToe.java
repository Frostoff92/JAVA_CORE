

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] map; //матрица игрового поля
    private static final int SIZE = 3; //размерность игрового поля

    public static final char DOT_EMPTY = '*'; //пустая клетка
    public static final char DOT_X = 'X'; //крестик
    public static final char DOT_O = 'O'; //нолик

    private static final boolean STUPID_PC = false; //тупой компьютер

    private static final Scanner sc = new Scanner(System.in);
    public static Random rnd = new Random();


    public static void main(String[] args) {
        initMap(); //инициализация игры
        printMap(); //вывод поля на экран

        while (true) {
            humanTurn(); //ход игрока
            if (isEndGame(DOT_X)) { //проверка условия выхода из игры
                break;
            }

            botTurn(); //ход компа
            if (isEndGame(DOT_O)) {
                break;
            }
        }
        System.out.println("Game Over");
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты ячейки: ");
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static void botTurn() {
        int x = -1;
        int y = -1;

        if (STUPID_PC) {
            do {
                x = rnd.nextInt(SIZE);
                y = rnd.nextInt(SIZE);
            } while (!isCellValid(x, y));
        } else {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i,j))

                        if (map[i][j] == DOT_O) {
                            System.out.println(i+1 + "" + j+1);
                        }   else {
                            do {
                                x= rnd.nextInt(SIZE);
                                y= rnd.nextInt(SIZE);
                            } while (!isCellValid(x,y));
                        }
                }
            }
        }

        System.out.println("Компьютер выбрал ячейку " + (y + 1) + "" + (x + 1));
        map[y][x] = DOT_O;
    }

    private static boolean isCellValid(int x, int y) {
        boolean result = true;

        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            result = false;
        }

        if (map[y][x] != DOT_EMPTY) {
            result = false;
        }

        return result;

    }

    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        printMap();

        if (checkWin(playerSymbol)) {
            System.out.println("Победили " + playerSymbol);
            result = true;
        }

        if (isMapFull()) {
            System.out.println("Ничья");
            result = true;
        }

        return result;
    }

    private static boolean isMapFull() {
        boolean result = true;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    result = false;
            }
        }

        return result;
    }

    private static boolean checkWin(char playerSymbol) {
        boolean result = false;

        if (
                (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                        (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                        (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                        (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                        (map[2][0] == playerSymbol && map[1][1] == playerSymbol && map[0][2] == playerSymbol)) {
            result = true;
        }

        return result;
    }
}


