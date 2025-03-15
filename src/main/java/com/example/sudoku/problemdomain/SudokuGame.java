package com.example.sudoku.problemdomain;

import java.util.Scanner;

public class SudokuGame {

    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.print();
            System.out.println("Enter row (0-8), column (0-8), and number (1-9) or -1 to exit:");
            int row = scanner.nextInt();
            if (row == -1) break;
            int col = scanner.nextInt();
            int num = scanner.nextInt();

            if (board.isValidMove(row, col, num)) {
                board.setCell(row, col, num);
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }
}
