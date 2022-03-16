package com.github.erdragh.jra;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Recursive:");
            Fibonacci.tableRek(46);
            System.out.println("Iterative:");
            Fibonacci.tableIt(200000);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
