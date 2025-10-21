package Sprint_2;

public class Sprint_2 {
    private int boardSize;
    private String gameMode;
    private char[][] board;
    private String currentPlayer; // blue or red
    private static final char EMPTY = ' ';

    public Sprint_2(int boardSize, String gameMode) {
        this.boardSize = boardSize;
        this.gameMode = gameMode;
        this.board = new char[boardSize][boardSize];
        this.currentPlayer = "blue";
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            return false;
        }
        return board[row][col] == EMPTY;
    }

    public boolean makeMove(int row, int col, char letter) {
        if (!isValidMove(row, col)) {
            return false;
        }
        if (letter != 'S' && letter != 'O') {
            return false;
        }
        board[row][col] = letter;
        return true;
    }

    public void switchPlayer() {
        currentPlayer = currentPlayer.equals("blue") ? "red" : "blue";
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public int getBoardSize() {
        return boardSize;
    }

    public String getGameMode() {
        return gameMode;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    public void resetGame() {
        initializeBoard();
        currentPlayer = "blue";
    }
}