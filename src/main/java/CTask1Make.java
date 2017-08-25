package main.java;

import java.util.ArrayList;
import java.util.Scanner;

class CTask1Make implements Runnable
{
    private ArrayList <Integer> Str_mem = new ArrayList<Integer>();
    private Thread t_read = new Thread(this);

    public CTask1Make(){
        t_read.start();
        Strread();
    }

    private int ConvStrToInt(String Str_in){
        int num = 0;
        int k = 1;
        String[] StrParts = Str_in.trim().split("\\s+");

        for (int i = StrParts.length - 1; i > -1; i--) {
            if (StrParts[i].contains("hundred")){
                 k = 100; continue;
            }
            else if (StrParts[i].contains("thousand")){
                k = 1000; continue;
            }

            switch (StrParts[i]) {
                case "one": {
                    num += 1*k;
                    break;
                }
                case "two": {
                    num += 2*k;
                    break;
                }
                case "three": {
                    num += 3*k;
                    break;
                }
                case "four": {
                    num += 4*k;
                    break;
                }
                case "five": {
                    num += 5*k;
                    break;
                }
                case "six": {
                    num += 6*k;
                    break;
                }
                case "seven": {
                    num += 7*k;
                    break;
                }
                case "eight": {
                    num += 8*k;
                    break;
                }
                case "nine": {
                    num += 9*k;
                    break;
                }
                case "ten": {
                    num += 10;
                    break;
                }
                case "eleven": {
                    num += 11;
                    break;
                }
                case "twelve": {
                    num += 12;
                    break;
                }
                case "thirteen": {
                    num += 13;
                    break;
                }
                case "fourteen": {
                    num += 14;
                    break;
                }
                case "fifteen": {
                    num += 15;
                    break;
                }
                case "sixteen": {
                    num += 16;
                    break;
                }
                case "seventeen": {
                    num += 17;
                    break;
                }
                case "eighteen": {
                    num += 18;
                    break;
                }
                case "nineteen": {
                    num += 19;
                    break;
                }
                case "twenty": {
                    num += 20;
                    break;
                }
                case "thirty": {
                    num += 30;
                    break;
                }
                case "forty": {
                    num += 40;
                    break;
                }
                case "fifty": {
                    num += 50;
                    break;
                }
                case "sixty": {
                    num += 60;
                    break;
                }
                case "seventy": {
                    num += 70;
                    break;
                }
                case "eighty": {
                    num += 80;
                    break;
                }
                case "ninety": {
                    num += 90;
                    break;
                }
            }
        }
        return num;
    }

    private void Strread(){
        Scanner sc = new Scanner(System.in);
        String Str_in = "String";

        for(int i = 0;i > -1;i++){
            System.out.print("\nEnter the numbers: ");

            if (Str_in.equals("exit")) {
                System.out.printf("\n\n### Exit ###");
                i = -2;
                t_read.interrupt();
            } else if (Str_in.equals("")) {
            }else{
                Str_in = sc.nextLine().toLowerCase();
                Str_mem.add(ConvStrToInt(Str_in));
            }
        }
    }

    synchronized public void run(){
        try {
            while (true) {
                Thread.sleep(5000);
                if (Str_mem.size() != 0) {
                    int min = MinimalNum();
                    System.out.printf("\n\n### The least number is: " + Str_mem.get(min) + " (number removed!) ###\n");
                    Str_mem.remove(min);
                }
                else{
                    System.out.printf("\n\n### The List is empty. Number was not removed! ###\n");
                }
                System.out.print("\nEnter the numbers: ");
            }
        } catch (InterruptedException ie){}
    }

    synchronized private int MinimalNum(){
        int minI = 0;
        int min = Str_mem.get(0);
        for (int i = 0; i < Str_mem.size(); i++){
           if (Str_mem.get(i) < min){
               min = Str_mem.get(i);
               minI = i;
           }
        }
        return minI;
    }
}