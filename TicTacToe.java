package com.company;

import java.util.Scanner;

public class TicTacToe {

    //GAME BOARD
    public  int row, col;
    public Scanner scan = new Scanner(System.in);
    public  char [][] board = new char [3][3];
    public  char turn = 'X';


    public static void main(String[] args) {
        // write your code here
        TicTacToe t1 = new TicTacToe();


        for (int i=0; i<3; i++) {
            for (int j =0; j<3; j++){
                t1.board[i][j] = '_';
            }
        }

        t1.Play();

    }

    public void Play() {

        boolean playing = true;

        PrintBoard();

        while (playing) {

            System.out.println("Please enter a row and a column: ");

            boolean entryValid = false;

            while (!entryValid) {
                row = scan.nextInt() - 1;
                col = scan.nextInt() - 1;

                try {
                    board[row][col] = turn;
                }
                catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    System.out.println("Out of bounds. Reenter.");
                    continue;
                }

                entryValid = true;
            }

            if (GameOver(row, col)) {
                playing = false;
                System.out.println("GAME OVER! PLAYER " + turn + " WINS!");
            }

            PrintBoard();

            if (turn=='X') {
                turn = 'O';
            }
            else {
                turn = 'X';
            }
        }
    }

    public void PrintBoard() {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (j==0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean GameOver(int rMove, int cMove) {

        //check for perpendicular victory
        if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove] && board[0][cMove] != '_') {
            return true;
        }
        if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2] && board[rMove][0] != '_') {
            return true;
        }
        //check for diagonal victory
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]
                && board[1][1] != '_')
            return true;
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]
                && board[1][1] != '_')
            return true;

        return false;

    }
}