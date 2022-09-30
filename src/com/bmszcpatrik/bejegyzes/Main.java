package com.bmszcpatrik.bejegyzes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.err;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static List<Bejegyzes> bejegyzesek = new ArrayList<>();
    public static void main(String[] args) {
        bejegyzesek.add(new Bejegyzes("Magyar Dániel", "Nehéz az élet"));
        bejegyzesek.add(new Bejegyzes("Korcsek Mihály", "Pékség"));
        int darabszam;

        System.out.println("Darabszám: ");
        while(!sc.hasNextInt()){
            System.out.println("A darabszámnak természetes számnak kell lennie!");
        }
        darabszam = sc.nextInt();

        for (int i = 1; i < darabszam+1; i++) {
            System.out.println(i + ". bejegyzés szerzője:");
            String ujSzerzo = sc.nextLine();
            System.out.println(i + ". Bejegyzés tartalma: ");
            String ujTartalom = sc.nextLine();
            bejegyzesek.add(new Bejegyzes(ujSzerzo, ujTartalom));
        }

        FileBekeres();

        Random r = new Random();
        for (int i = 0; i < bejegyzesek.size()*20; i++) {
            bejegyzesek.get(r.nextInt(bejegyzesek.size())).Like();
        }

        System.out.print("Szöveg: ");
        String szoveg = sc.nextLine();
        bejegyzesek.get(1).setTartalom(szoveg);

        System.out.println(bejegyzesek);

    }

    public static void FileBekeres(){
        String filename = "bejegyzesek.csv";
        try {
            FileBeolvasas(filename);
        } catch (FileNotFoundException e) {
            err.printf("%s fájl nem található", filename);
        } catch (IOException e) {
            err.println("Ismeretlen hiba");
        }
    }
    public static void FileBeolvasas(String fajlNev) throws IOException {
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String temp = br.readLine();
        while (temp != null && !temp.equals("")) {
            String[] tomb = temp.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(tomb[0], tomb[1]);
            bejegyzesek.add(bejegyzes);
            temp = br.readLine();
        }
        br.close();
        fr.close();
    }

}
