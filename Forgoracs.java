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

public class Forgoracs {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile("Z:\\prg\\szoveg.txt", "rw")) {
            String tszoveg = null;
            file.seek(0);
            if(file.length() > 0)
                tszoveg = file.readLine();
            file.close();
            
            if(tszoveg != null) {
                Fracs f = new Fracs("kodlemez.txt", tszoveg);
                System.out.println("5. feladat:\n"+tszoveg);
                System.out.println("\n7. feladat:");
                f.KiirKodlemez();
                System.out.println("\n8. feladat:\n"+f.Titkositando);
                f.Titikosit();
                System.out.println("\n10. feladat:");
                f.KiirTitkositas();
            } else
                System.out.println("A titkosítandó szöveg beolvasása sikertelen volt!");
            
        }
    }
    
}
