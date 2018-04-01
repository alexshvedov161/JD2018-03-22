package by.it.sgolovach.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scaner.nextInt();
        }

        step1(mas);
        step2(mas);
        step3(mas);

    }


    private static void step1(int[] mas) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int element : mas) {
            if (min > element) min = element;
            if (max < element) max = element;
        }
        System.out.println(min + " " + max);

    }

    private static void step2(int[] mas) {
        double avg = 0;
        for (int element : mas) {
            avg = avg + element;
        }

        avg = avg / mas.length;

        for (int element : mas) {
            if (element < avg) System.out.print(element + " ");
        }
        System.out.println();

    }

    private static void step3(int[] mas) {

        int min = Integer.MAX_VALUE;
        for (int element : mas) {
            if (min > element) min = element;
        }

        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min) System.out.print(i + " ");
        }
        System.out.println();
    }

}