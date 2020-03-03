package com.company;

import java.util.Scanner;

public class TicTacToe {

    //GAME BOARD
    public  int row, col;
    public Scanner scan = new Scanner(System.in);
    public  char [][] board = new char [3][3];
    public  char turn = 'X';


    //MAIN METHOD
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

    //PLAYING THE GAME, INVOLVES USER INPUT
    public void Play() {

        boolean playing = true;

        PrintBoard();
        System.out.println("Please enter a row and a column: ");

        while (playing) {

            //System.out.println("Please enter a row and a column: ");

           row = scan.nextInt() - 1;
           col = scan.nextInt() - 1;



           if ((row < 0 || row > 2) && (col < 0 || col > 2))  {
                throw new java.lang.ArrayIndexOutOfBoundsException("Row and Column value is outside board");
                //System.out.println("Place is outside the board");
            }

            if ((board[row][col] != '_' )) {
                throw new java.lang.RuntimeException("Place is occupied");
               // System.out.println("Place is occupied");

            }

             board[row][col] = turn;


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

    //PRINTING THE BOARD
    public void PrintBoard() {
        for (int i=0; i<3; i++) {
            System.out.println();
            for (int j=0; j<3; j++) {
                if (j==0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " | ");
            }
        }
        System.out.println();
    }

    //CHECKING TO SEE WHO WINS THE GAME
    public boolean GameOver(int rMove, int cMove) {

        //CHECKING FOR ALL POSSIBILITIES OF VICTORY

        //check for perpendicular victory
        if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove]) {
            return true;
        }
        if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2]) {
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

