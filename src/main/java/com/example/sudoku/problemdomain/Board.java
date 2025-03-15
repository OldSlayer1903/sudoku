package com.example.sudoku.problemdomain;

public class Board {
    private static final int SIZE = 9;
    private final int[][] board;

    public Board() {
        this.board = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
    }

    public Board(int[][] board) {
        this.board = board;
    }

    public int getValue(int x, int y) {
        return board[x][y];
    }

    public void setCell(int x, int y, int value) {
        board[x][y] = value;
    }

    public void print() {
        for (int i = 0; i < SIZE; i++) {
            if (i % 3 == 0) System.out.println("-------------------------");
            for (int j = 0; j < SIZE; j++) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print(this.board[i][j] == 0 ? "_ " : this.board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------------------");
    }

    public boolean isValidMove(int row, int col, int num) {
        if (this.getValue(row, col) != 0) return false;
        for (int i = 0; i < SIZE; i++) {
            if (this.getValue(row, i) == num || this.getValue(i, col) == num) return false;
        }
        int boxRow = (row / 3) * 3, boxCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getValue(boxRow + i, boxCol + j) == num) return false;
            }
        }
        return true;
    }
}
