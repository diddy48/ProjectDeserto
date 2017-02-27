/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.deserto;

import deserto.carri.normali.CarroLineare;
import deserto.carri.normali.CarroQuadrato;
import deserto.carri.speciale.CarroTalpa;
import deserto.pos.Posizione;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FSEVERI\romano3927
 */
public class Deserto {
    public final int ITERTIME=1000;
    public final int SABOTATO=60000;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        CarroLineare carroL = new CarroLineare(3, new Posizione(3, 1));
        CarroQuadrato carroQ = new CarroQuadrato(9, new Posizione(12, 7));
        CarroTalpa carroT = new CarroTalpa(5, new Posizione(7, 10));
        
        System.out.println("Quante proiettili vuoi sparare?");
        Scanner in = new Scanner(System.in);
        int n = 5;//in.nextInt();
        Battaglia game = new Battaglia();
        for (int i = 0; i < n; i++) {
            //System.out.println("Ciao");
            Thread.sleep(1000);
        }
    }

}
