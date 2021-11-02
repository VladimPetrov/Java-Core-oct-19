package lesson4;

import java.util.Random;
import java.util.Scanner;

public class gameTicTacToe {
    private static final char DOT_X='X';
    private static final char DOT_O='O';
    private static final char DOT_Empty='.';
    private static final Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int scoreHuman;
    private static int scoreAi;
    private static int winSize;
    private static int roundCounter;
    private static char dotHuman;
    private static char dotAi;

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        while (true) {
            playRound();
            System.out.printf("SCORE: HUMAN        AI\n" +
                            "         %d          %d\n",scoreHuman,
                    scoreAi);
            System.out.printf("Wanna play again& Y and N >>>");
            if (!scanner.next().toLowerCase().equals("y")) {
                System.out.printf("Good bye!");
                break;
            }
        }
    }

    private static void playRound() {
        System.out.printf("Round#%d\n", roundCounter++);
        System.out.print("Please enter size field by horizontal and vertical >>> ");
        fieldSizeX = scanner.nextInt();
        fieldSizeY = scanner.nextInt();
        System.out.print("Please enter winning size >>> ");
        winSize = scanner.nextInt();
        initField(fieldSizeX, fieldSizeY);
        System.out.print("Please enter 'x' if you want to play with X, and something else for O >>> ");
        String x = scanner.next();
        if (x.toLowerCase().equals("x")) {
            dotHuman = DOT_X;
            dotAi = DOT_O;
        } else {
            dotHuman = DOT_O;
            dotAi = DOT_X;
        }

        printField();

        while (true) {
            if (dotHuman == DOT_X) {
                humanTurn();
                printField();
                if (checkAll(dotHuman)) break;
                aiTurn();
                printField();
                if (checkAll(dotAi)) break;
            } else {
                aiTurn();
                printField();
                if (checkAll(dotAi)) break;
                humanTurn();
                printField();
                if (checkAll(dotHuman)) break;
            }
        }
    }

    private static boolean checkAll(char dot) {
        if (checkWin(dot)) {
            if (dot == dotHuman) {
                System.out.println("Human Win!!!");
                scoreHuman++;
            } else {
                System.out.println("Ai Win!!!");
                scoreAi++;
            }
            return true;
        }
        if (checkDraw()) return true;
        return false;
    }

    private static boolean checkDraw() {
        for (int y =0; y < fieldSizeY; y++) {
            for(int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) return false;
            }
        }
        System.out.println("DRAW");
        return true;
    }

    private static boolean checkWin(char dot) {
        int seqWin;
        int seqWin2;

        //горизонталь
        for (int y = 0; y < fieldSizeY; y++) {
            seqWin = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == dot) {
                    seqWin++;
                    if (seqWin == winSize) return true;
                } else seqWin = 0;
            }
        }

        //вертикаль
        for (int x = 0; x < fieldSizeX; x++) {
            seqWin = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == dot) {
                    seqWin++;
                    if (seqWin == winSize) return true;
                } else seqWin = 0;
            }
        }

        //диагональ
        for (int y = 0; y < fieldSizeY - winSize + 1; y++) {
            seqWin = 0;
            seqWin2 = 0;
            for (int x = 0; x < fieldSizeX - y; x++) {
                if (field[y+x][x] == dot) {
                    seqWin++;
                    if (seqWin == winSize) return true;
                } else seqWin = 0;
                if (field[x][x+y] == dot) {
                    seqWin2++;
                    if (seqWin2 == winSize) return true;
                } else seqWin2 = 0;
            }
        }
        for (int y = winSize - 1; y < fieldSizeY; y++) {
            seqWin = 0;
            seqWin2 = 0;
            for (int x = 0; x < fieldSizeX - (fieldSizeY - 1 - y); x++) {
                if (field[y-x][x] == dot) {
                    seqWin++;
                    if (seqWin == winSize) return true;
                } else seqWin = 0;
                if (field[fieldSizeY-x-1][x+fieldSizeX-y-1] == dot) {
                    seqWin2++;
                    if (seqWin2 == winSize) return true;
                } else seqWin2 = 0;
            }
        }

        return false;
    }

    private static void aiTurn() {
        if (!blockWinHuman()) aiTurnRandom();

    }

    private static void aiTurnRandom() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellValid(y, x) || !isCellEmpty(y, x));
        field[y][x] = DOT_O;
    }

    private static boolean blockWinHuman() {
        int sumHumanDot;
        int blockLine = 0;
        boolean checkSum = false;

        // проверка по горизонтали

        for (int y = 0; y < fieldSizeY; y++) {
            sumHumanDot = 0;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == dotHuman) {
                    sumHumanDot++;
                    if (sumHumanDot == winSize -1) {
                        checkSum = true;
                        blockLine = y;
                        break;
                    }
                }
            }
        }
        if (checkSum) {
                for (int x = 0; x < fieldSizeX; x++) {
                    if (isCellEmpty(blockLine, x)) {
                        field[blockLine][x] = DOT_O;
                        return true;
                    }
                }
        }

        // Проверка по вертикали

        for (int x = 0; x < fieldSizeX; x++) {
            sumHumanDot = 0;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == dotHuman) {
                    sumHumanDot++;
                    if (sumHumanDot == winSize -1) {
                        checkSum = true;
                        blockLine = x;
                        break;
                    }
                }
            }
        }
        if (checkSum) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(y, blockLine)) {
                    field[y][blockLine] = DOT_O;
                    return true;
                }
            }
        }

        // Проверка по диагонали

        for (int y = 0; y < fieldSizeY - winSize + 1; y++) {
            sumHumanDot = 0;
            for (int x = 0; x < fieldSizeX - y; x++) {
                if (field[y+x][x] == dotHuman) {
                    sumHumanDot++;
                    if (sumHumanDot == winSize-1) {
                        checkSum = true;
                        blockLine = y;
                        break;
                    }
                }
            }
        }
        if (checkSum) {
            for (int x = 0; x < fieldSizeX - blockLine; x++) {
                if (isCellEmpty(blockLine+x,x)) {
                    field[blockLine+x][x] = DOT_O;
                    return true;
                }
            }
        }
        for (int y = 0; y < fieldSizeY - winSize + 1; y++) {
            sumHumanDot = 0;
            for (int x = 0; x < fieldSizeX - y; x++) {
                if (field[x][x+y] == dotHuman) {
                    sumHumanDot++;
                    if (sumHumanDot == winSize-1) {
                        checkSum = true;
                        blockLine = y;
                        break;
                    }
                }
            }
        }
        if (checkSum) {
            for (int x = 0; x < fieldSizeX - blockLine; x++) {
                if (isCellEmpty(x,blockLine+x)) {
                    field[x][blockLine+x] = DOT_O;
                    return true;
                }
            }
        }
        for (int y = winSize - 1; y < fieldSizeY; y++) {
            sumHumanDot = 0;
            for (int x = 0; x < fieldSizeX - (fieldSizeY - 1 - y); x++) {
                if (field[y-x][x] == dotHuman) {
                    sumHumanDot++;
                    if (sumHumanDot == winSize -1) {
                        checkSum = true;
                        blockLine = y;
                        break;
                    }
                }
            }
        }
        if (checkSum) {
            for (int x = 0; x < fieldSizeX - (fieldSizeY - 1 - blockLine); x++) {
                if (isCellEmpty(blockLine-x,x)) {
                    field[blockLine-x][x] = DOT_O;
                    return true;
                }
            }
        }
        for (int y = winSize - 1; y < fieldSizeY; y++) {
            sumHumanDot = 0;
            for (int x = 0; x < fieldSizeX - (fieldSizeY - 1 - y); x++) {
                if (field[fieldSizeY-x-1][x+fieldSizeX-y-1] == dotHuman) {
                    sumHumanDot++;
                    if (sumHumanDot == winSize - 1) {
                        checkSum = true;
                        blockLine = y;
                        break;
                    }
                }
            }
        }
        if (checkSum) {
            for (int x = 0; x < fieldSizeX - (fieldSizeY - 1 - blockLine); x++) {
                if (isCellEmpty(fieldSizeY-x-1,x+fieldSizeX-blockLine-1)) {
                    field[fieldSizeY-x-1][x+fieldSizeX-blockLine-1] = DOT_O;
                    return true;
                }
            }
        }

        return false;

    }

    private static void humanTurn() {
        int x;
        int y;
        boolean isFirstTry = true;
        do {
            if (!isFirstTry) {
                System.out.println("Wrong coordinates? try again!");
            }
            isFirstTry = false;
            System.out.print("Please enter coordinates of yuor turn x & y>>>>>");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x) || !isCellEmpty(y, x));
        field[y][x] = DOT_X;

    }

    private static boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_Empty;
    }

    private static void initField(int sizeX, int sizeY) {
        fieldSizeX = sizeX;
        fieldSizeY = sizeY;
        field = new char[sizeX][sizeY];
        for (int i =0; i <fieldSizeY;i++) {
            for (int j =0; j <fieldSizeY;j++) {
                field[i][j] = DOT_Empty;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

