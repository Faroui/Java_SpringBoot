package com.ds;

import java.util.Arrays;

public class WorkingWith2DArray {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                board[i][j]='_';
            }
        }
        char[][] boardTwo = new char[][] {
                new char[] {'_','_','_'},
                new char[] {'_','_','_'},
                new char[] {'_','_','_'}
        };
        int[][] matrix={{3,5},{5,6},{4,6},{9,0}};
        System.out.println(Arrays.deepToString(matrix));
        board[0][0]='0';
        board[1][0]='0';
        board[2][0]='0';
        board[0][1]='x';
        board[1][1]='0';
        board[2][1]='x';
        board[0][2]='x';
        board[1][2]='x';
        board[2][2]='0';
        for(int i=0;i<3;i++){
            System.out.print("|");
            for (int j=0;j<3;j++){
                System.out.print(board[i][j]+"|");
            }
            System.out.println();
        }
    }
}
