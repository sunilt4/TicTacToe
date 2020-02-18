package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicTacToeTest {

    TicTacToe t1;

    @BeforeEach
    void setupGame() {
        t1 = new TicTacToe();


        for (int i=0; i<3; i++) {
            for (int j =0; j<3; j++){
                t1.board[i][j] = '_';
            }
        }
    }

    @Test
    void testPrintBoard() {
        try {
            t1.PrintBoard();
        }
        catch (Exception e) {
            e.printStackTrace();
            fail("PrintBoard() threw exceptio");
        }
    }

    @Test
    void testPlay() {
        try {

            int[] customInputs = new int[] {0, 0, 1, 0, 0, 1, 1, 1, 0, 2};
            int i = 0;

            //Play Method

            boolean playing = true;

            t1.PrintBoard();

            while (playing) {

                System.out.println("Please enter a t1.row and a t1.column: ");

                t1.row = customInputs[i];
                t1.col = customInputs[i+1];
                i += 2;

                t1.board[t1.row][t1.col] = t1.turn;

                if (t1.GameOver(t1.row, t1.col)) {
                    playing = false;
                    System.out.println("GAME OVER! PLAYER " + t1.turn + " WINS!");
                }

                t1.PrintBoard();

                if (t1.turn=='X') {
                    t1.turn = 'O';
                }
                else {
                    t1.turn = 'X';
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            fail("Play() threw exception");
        }
    }

    @Test
    void testGameOver() {
        //vertical victory
        t1.board[0][0] = 'X';
        t1.board[1][0] = 'X';
        t1.board[2][0] = 'X';
        assert(t1.GameOver(2, 0));
        t1.board[0][0] = '_';
        t1.board[1][0] = '_';
        t1.board[2][0] = '_';

        //horizontal victory
        t1.board[1][0] = 'X';
        t1.board[1][1] = 'X';
        t1.board[1][2] = 'X';
        assert(t1.GameOver(1, 2));
        t1.board[1][0] = '_';
        t1.board[1][1] = '_';
        t1.board[1][2] = '_';

        //diagonal victory
        t1.board[0][0] = 'X';
        t1.board[1][1] = 'X';
        t1.board[2][2] = 'X';
        assert(t1.GameOver(2, 2));
        t1.board[0][0] = '_';
        t1.board[2][2] = '_';

        t1.board[0][2] = 'X';
        t1.board[2][0] = 'X';
        assert(t1.GameOver(2, 0));
    }

}
