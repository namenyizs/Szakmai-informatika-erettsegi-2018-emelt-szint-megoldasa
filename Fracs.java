/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forgoracs;

/**
 *
 * @author Naményi Zsolt
 */

import java.io.*;

public class Fracs {
    private int meret = 8;
    private char Kodlemez[][] = new char[meret][meret];
    private char Titkositott[][] = new char[meret][meret];
    public String Titkositando;
    
    public Fracs(String fajl, String t) throws FileNotFoundException, IOException {
        try (RandomAccessFile f = new RandomAccessFile("Z:\\prg\\"+fajl, "rw")) {
            if(f.length() > 0) {
                int n=0;
                for(String sor = f.readLine(); sor != null; sor = f.readLine()) {
                    for(int j = 0; j < meret; j++) {
                        Kodlemez[n][j] = sor.charAt(j);
                    }
                    n++;
                }
            }
            f.close();
        }
        try {
            Titkositando = Atalakit(t);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
    
    public void KiirKodlemez() {
        for(int i = 0; i < meret; i++) {
            for(int j = 0; j < meret; j++) {
                System.out.print(Kodlemez[i][j]);
            }
            System.out.println();
        }
    }
    
    public void KiirTitkositas() {
        for(int i = 0; i < meret; i++) {
            for(int j = 0; j < meret; j++) {
                System.out.print(Titkositott[i][j]);
            }
            System.out.println();
        }
    }
    
    public char[][] ForgatKodlemez() {
        int n = 8;
        char ujKodlemez[][] = new char[n][n];
        for(int sor = 0; sor < n; sor++) {
            for(int oszlop = 0; oszlop < n; oszlop++) {
                ujKodlemez[7-oszlop][sor] = Kodlemez[sor][oszlop];
            }
        }
        return ujKodlemez;
    }
    
    public void Titikosit() {     
        int x = 0;
        int counter=0;
        while(x != 4) {
            for(int i = 0; i < meret; i++) {
                for(int j = 0; j < meret; j++) {
                    if(Kodlemez[j][i] != 'A') continue;
                    Titkositott[j][i] = Titkositando.charAt(counter);
                    counter++;
                }
            }
            Kodlemez = ForgatKodlemez();
            x++;
        }
    }
    
    public static String Atalakit(String s) {
        String s2 = s.replaceAll("\\s+", "");
        s2 = s2.replaceAll("\\,+", "");
        s2 = s2.replaceAll("\\.+", "");
        if(s2.length() > 64)
            throw new IllegalArgumentException("Túl hosszú a titkosítandó szöveg!");
        else {
            int i=s2.length();
            if(i < 64) {
                while(i != 64) {
                    s2 += "X";
                    i++;
                }
            }
            return s2;
        }
    }
    
}
