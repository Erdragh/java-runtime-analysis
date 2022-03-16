package com.github.erdragh.jra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci {
    public static long fibRek(int n) {
        if (n<3) {
            return 1;
        }else{
            return fibRek(n-1) + fibRek(n-2);
        }
    }    

    public static long fibIt(int n){
        long x = 1;
        long y = 1;
        long ergebnis = 1;
        for (int i=3; i<=n; i++){
            ergebnis = x + y;
            x = y;
            y = ergebnis;
        }
        return ergebnis;
    }

    public static long fibRekMessung(int n){
        long start = System.nanoTime();
        fibRek(n);
        return  (System.nanoTime() - start);// / 1_000_000_000;
    }

    public static long fibItMessung(int n){
        long start = System.nanoTime();
        fibIt(n);
        return  (System.nanoTime() - start);// / 1_000_000_000;
    }

    public static void tableRek(int n) throws IOException {
        File f = new File("tableRek.csd");
        if (!f.exists()) {
            f.createNewFile();
        }

        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i <= n; i++) {
            String result = i + "\t" + fibRekMessung(i);
            System.out.println(result);
            bw.append(result + "\n");
        }
        bw.close();
        fw.close();
    }
    public static void tableIt(int n) throws IOException {
        File f = new File("tableIt.csd");
        if (!f.exists()) {
            f.createNewFile();
        }

        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i <= n; i++) {
            String result = i + "\t" + fibItMessung(i);
            System.out.println(result);
            bw.append(result + "\n");
        }
        bw.close();
        fw.close();
    }
}
