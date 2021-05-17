package com.algorithmstudy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        solution2();

    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String factorsStr = scanner.nextLine();
        String powersStr = scanner.nextLine();

        String[] factorsArr = factorsStr.split(" ");
        String[] powersArr = powersStr.split(" ");

        int a = Integer.parseInt(factorsArr[0]);
        int b = Integer.parseInt(factorsArr[1]);
        int c = Integer.parseInt(factorsArr[2]);

        int[] powers = new int[powersArr.length];
        for (int i = 0; i < powersArr.length; i++) {
            powers[i] = Integer.parseInt(powersArr[i]);
        }

        
    }
}
