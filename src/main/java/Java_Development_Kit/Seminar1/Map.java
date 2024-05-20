package Java_Development_Kit.Seminar1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Map extends JPanel{
    private static final Random RANDOM = new Random();
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private static final int EMPTY_DOT = 0;
    private final int DOT_PADDING = 2;
    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер";
    private static final String MSG_DRAW = "Ничья";
    private static String gameOverMessage;
    private static int fieldSize;
    private int winCount;
    private static boolean isGameover = false;
    private static char[][] field = new char[3][3];
    int cellHeight;
    int cellWidth;
    int panelWidth;
    int panelHeight;
    Map() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        if(!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
        repaint();
        if(checkWin((char) HUMAN_DOT, winCount)) {
            isGameover = true;
            gameOverMessage = MSG_WIN_HUMAN;
            return;
        }
        checkDraw();
        repaint();
        aiTurn();
        repaint();
        if(checkWin((char) AI_DOT, winCount)){
            isGameover = true;
            gameOverMessage = MSG_WIN_AI;
            return;
        }
        checkDraw();
        repaint();
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d",
                mode, fSzX, fSzY, wLen);
        isGameover = false;
        winCount = wLen;
        fieldSize = fSzX;
        initMap();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g ){
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellHeight = panelHeight/3;
        cellWidth = panelWidth/3;
        g.setColor(Color.BLACK);
        for (int h = 0; h< 3; h++){
            int y = h * cellHeight;
            g.drawLine(0, y , panelWidth, y);
        }
        for (int w = 0; w< 3; w++){
            int x = w * cellWidth;
            g.drawLine(x, 0 , x, panelHeight);
        }

        for(int x = 0; x < fieldSize; x++){
            for (int y = 0; y < fieldSize; y++) {
                if(field[y][x] == EMPTY_DOT) continue;

                if (field[y][x] == HUMAN_DOT){
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == AI_DOT){
                    g.setColor(new Color(0xff0000));
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " + field[y][x] +
                            " in cell: x=" + x + " in cell: y" + y);
                }
            }
        }
        if(isGameover) showMessageGameOver(g, this.gameOverMessage);
    }

    /**
     * Game logic
     */

    private void initMap() {
        fieldSize = 3;
        field = new char[fieldSize][fieldSize];
        for(int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y){
        return x >= 0 && y < fieldSize;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn() {
        if(!isGameover) {
            for (int y = 0; y < fieldSize; y++) {
                for (int x = 0; x < fieldSize; x++) {
                    if (field[y][x] == EMPTY_DOT) {
                        field[y][x] = AI_DOT;
                        if (checkWin((char) AI_DOT, winCount))
                            return;
                        else
                            field[y][x] = EMPTY_DOT;
                    }
                }
            }

            boolean f = checkWin((char) HUMAN_DOT, winCount - 1);

            for (int y = 0; y < fieldSize; y++) {
                for (int x = 0; x < fieldSize; x++) {
                    if (field[y][x] == EMPTY_DOT) {
                        field[y][x] = HUMAN_DOT;
                        if (checkWin((char) HUMAN_DOT, winCount - (f ? 0 : 1))) {
                            field[y][x] = AI_DOT;
                            return;
                        } else
                            field[y][x] = EMPTY_DOT;
                    }
                }
            }

            int x, y;
            do {
                x = RANDOM.nextInt(fieldSize);
                y = RANDOM.nextInt(fieldSize);
            } while (!isEmptyCell(x, y));
            field[y][x] = AI_DOT;
        }
    }

    static boolean checkWin(char dot, int winCount){
        int x;
        int y;
        ArrayList<Integer> dots = getNotEmptyDots(field, dot);
        if(!(dots.isEmpty())){
            int winRate;
            int tempX;
            int tempY;
            for (int i = 0; i < dots.size() -1; i+=2) {
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
                            //System.out.println(winCount - winRate + "До победы по вертикали");
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
                            //System.out.println(winCount - winRate + "До победы по горизонтали");
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
                 * Проверяем диагональ вправо
                 */
                for(int m = 0; m < fieldSize; m++){
                    if(tempX < fieldSize -1 && tempY < fieldSize -1){
                        if(field[++tempX][++tempY] == dot){
                            winRate++;
                            //System.out.println(winCount - winRate  + "До победы по диагонали");
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
                 * Проверяем диагональ влево
                 */
                for(int h = 0; h < fieldSize; h++){
                    if(tempX < fieldSize -1 && tempY >= 1){
                        if(field[++tempX][--tempY] == dot){
                            winRate++;
                            //System.out.println(winCount - winRate  + "До победы по диагонали");
                            if (winRate == winCount){
                                return true;
                            }
                        }
                    }
                }
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
    static void checkDraw(){
        int emptyCells = 0;
        for(int x = 0; x < fieldSize; x++){
            for (int y = 0; y < fieldSize; y++){
                if (isEmptyCell(x, y)){
                    emptyCells++;
                }
            }
        }
        if(emptyCells == 0){
            gameOverMessage = MSG_DRAW;
            isGameover = true;
        }
    }

    private void showMessageGameOver(Graphics g, String message){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 24));
        g.drawString(message, 80, getHeight() / 2);
    }
}
