package com.algorithmstudy.leetcode.programmers.dp;

import java.util.*;

public class LargestSquare {
    int boardX, boardY;
    public int solution(int[][] board) {
        int answer = 0;
        boardX = board.length;
        boardY = board[0].length;

        int[][] status = new int[boardX][boardY];
        for (int[] s : status) Arrays.fill(s, 0);

//        for (int[] s : status) {
//            for (int k : s) System.out.print(k + " ");
//            System.out.println();
//        }

        for (int i = 0; i < boardX; i++) {
            status[i][0] = board[i][0];
            answer = Math.max(answer, status[i][0]);
        }
        for (int i = 0; i < boardY; i++) {
            status[0][i] = board[0][i];
            answer = Math.max(answer, status[0][i]);
        }

        for (int i = 1; i < boardX; i++) {
            for (int j = 1; j < boardY; j++) {
                if (board[i][j] != 0) {
                    status[i][j] = Math.min(status[i-1][j], Math.min(status[i-1][j-1], status[i][j-1])) + 1;
                    answer = Math.max(answer, status[i][j]);
                }
            }
        }
        return answer*answer;
    }

//        for (int i = boardX-1; i >= 0; i--) {
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        int count = 0;
//        for (int j = boardY-1; j >= 0; j--) {
//            if (status[i][j] == 0) {
//                if (count >= min) answer = Math.max(answer, min);
//                min = Integer.MAX_VALUE;
//                count = 0;
//                continue;
//            }
//            if (status[i][j] < min) {
//                if (count >= min) answer = Math.max(answer,min);
//                min = status[i][j];
//            } //else count++;
//            count++;
//        }
//        if (count >= min) answer = Math.max(answer, min);
//    }


}
