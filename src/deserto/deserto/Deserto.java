/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.deserto;

import deserto.carri.CarroCantiere;
import deserto.carri.normali.CarroLineare;
import deserto.carri.normali.CarroQuadrato;
import deserto.carri.speciale.CarroTalpa;
import deserto.pos.Posizione;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FSEVERI\romano3927
 */
public class Deserto {

    public static final int INTERTIME = 5;
    public final int SABOTATO = 60000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        boolean[] arraySabotaggio = {true, false, false, false, false, false, false, false, false, false};
        CarroLineare carroL = new CarroLineare(3, new Posizione(1, 1));
        CarroQuadrato carroQ = new CarroQuadrato(9, new Posizione(12, 7));
        CarroTalpa carroT = new CarroTalpa(5, new Posizione(7, 10));
        CarroTalpa carroT1 = new CarroTalpa(6, new Posizione(20, 6));
        System.out.println("Benvenuto nella simulazione di una battaglia navale");
        System.out.println("Quante proiettili vuoi sparare?");
        Scanner in = new Scanner(System.in);
        int n =7000;// in.nextInt();
        ArrayList<CarroCantiere> carri = new ArrayList<CarroCantiere>();
        carri.add(carroL);
        carri.add(carroT);
        carri.add(carroQ);
        carri.add(carroT1);
        carroT1.nascosto();
        Battaglia game = new Battaglia(carri, n);
        Date data = new Date();
        for (int i = 0; i < n; i++) {
            int xRand = rand.nextInt(33) + 1;
            int yRand = rand.nextInt(17) + 1;
            Posizione lancio = new Posizione(xRand, yRand);
            game.updateLog("\n" + "Proiettile lanciato in posizione " + xRand + "," + yRand);

            for (int j = 0; j < carri.size(); j++) {
                String risultato = carri.get(j).fuoco(lancio);

                game.updateLog("Un pezzo del " + carri.get(j).getClass().getSimpleName() + " è stato " + risultato);
                game.repaint();
                if (carri.get(j).distrutto()) {
                    game.updateLog("\nIl " + carri.get(j).getClass().getSimpleName() + " è stato ditrutto\n");
                    carri.remove(j);
                } else {
                    game.updateLog("Il " + carri.get(j).getClass().getSimpleName() + " è " + carri.get(j).stato());
                }
                if (carri.size() == 0) {
                    game.updateLog("Tutti i carri sono stati distrutti");
                    Thread.sleep(10000);
                    System.exit(0);
                }
            }
            //Sabotaggio
            if (arraySabotaggio[rand.nextInt(10)]) {
                boolean[] arraySabotaggioTrue = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
                if (arraySabotaggioTrue[rand.nextInt(20)]) {
                    game.updateLog("\nIl cannone è stato sabotato e perde 12 proiettili");
                    n -= 11;
                    for (int k = 0; k < carri.size(); k++) {
                        if (carri.get(k).getClass() == CarroTalpa.class) {
                            CarroTalpa ct = (CarroTalpa) carri.get(k);
                            ct.scoperto();
                        }
                    }
                }
            }
            //Far coprire il carro
            boolean[] arrayCopri = {true, false, false, false, false};
            if (arrayCopri[rand.nextInt(5)]) {
                for (int k = 0; k < carri.size(); k++) {
                    if (carri.get(k).getClass() == CarroTalpa.class) {
                        CarroTalpa ct = (CarroTalpa) carri.get(k);
                        ct.nascosto();
                    }
                }
            }
            try {
                Thread.sleep(Deserto.INTERTIME);
            } catch (InterruptedException ex) {
                Logger.getLogger(Battaglia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        game.updateLog("\n Hai esaurito i proiettili");
    }

}
