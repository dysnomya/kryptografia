package com.github.dysnomya;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class lab1 {

    public static void main(String[] args) throws IOException {
        generate();


//    testPojedynczychBitow(); // 9841

//        testSerii(); // 2549, 1261, 611, 293, 170, 148

//        testDlugiejSerii(); // najdłuższa -> 12

        testPokerowy(); // x = 15.904
    }

    public static void generate() {
        long p = 1483019;
        long q = 2614103;
        long x = 2147483647;
        BlumBlumSnub bbs = new BlumBlumSnub(p, q, x);

        try (FileWriter writer = new FileWriter("generated.txt", false)) {
            for (int i = 0; i < 20000; i++) {
                writer.write(String.valueOf(bbs.generateNext()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void testPojedynczychBitow() {

        try (Scanner scanner = new Scanner(new File("generated.txt"))) {
            scanner.useDelimiter("");

            int ones = 0;
            int zeros = 0;
            while (scanner.hasNext()) {
                if (Integer.parseInt(scanner.next()) == 1) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            System.out.println("- TEST POJEDYNCZYCH BITOW");
            System.out.println("0: " + zeros);
            System.out.println("1: " + ones);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSerii() {
        try (Scanner scanner = new Scanner(new File("generated.txt"))) {
            int[] series = new int[6];
            scanner.useDelimiter("");

            int seriesLength = 0;
            int previous = Integer.parseInt(scanner.next());

            while (scanner.hasNext()) {
                int number = Integer.parseInt(scanner.next());
                if (number == previous) {
                    seriesLength++;
                } else {

                    if (seriesLength > 0) {
                        if (seriesLength < 6) {
                            series[seriesLength - 1] += 1;
                        } else {
                            series[5] += 1;
                        }
                    }

                    seriesLength = 0;
                    previous = number;
                }
            }

            System.out.println("- TEST SERII");
            System.out.println("1:  " + series[0]);
            System.out.println("2:  " + series[1]);
            System.out.println("3:  " + series[2]);
            System.out.println("4:  " + series[3]);
            System.out.println("5:  " + series[4]);
            System.out.println("6+: " + series[5]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void testDlugiejSerii() {
        try (Scanner scanner = new Scanner(new File("generated.txt"))) {
            scanner.useDelimiter("");

            int seriesLength = 0;
            int previous = Integer.parseInt(scanner.next());
            int maxSeriesLength = Integer.MIN_VALUE;

            while (scanner.hasNext()) {
                int number = Integer.parseInt(scanner.next());
                if (number == previous) {
                    seriesLength++;
                } else {
                    if (seriesLength > maxSeriesLength) {
                        maxSeriesLength = seriesLength;
                    }

                    seriesLength = 0;
                    previous = number;
                }
            }

            System.out.println("- TEST DŁUGIEJ SERII");
            System.out.println("Najdłuższa seria: " + maxSeriesLength);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testPokerowy() {
        try (Scanner scanner = new Scanner(new File("generated.txt"))) {
            scanner.useDelimiter("");

            HashMap<Integer, Integer> count = new HashMap<>();
            for (int i = 0; i < 16; i++) {
                count.put(i, 0);
            }

            int totalBlocks = 0;
            while(scanner.hasNext()) {
                int a = Integer.parseInt(scanner.next());
                int b = Integer.parseInt(scanner.next());
                int c = Integer.parseInt(scanner.next());
                int d = Integer.parseInt(scanner.next());

                int number = (8 * a) + (4 * b) + (2 * c) + d;
                count.put(number, count.get(number) + 1);
                totalBlocks++;
            }


            double sum = 0;
            for (int val : count.values()) {
                sum += (val * val);
            }

            double x = ((16.0 / 5000) * sum) - 5000;

            System.out.println("- TEST POKEROWY");
            System.out.println("Wartość x: " + x);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}