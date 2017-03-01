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

    public static final int INTERTIME = 5000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        boolean[] arraySabotaggio = {true, false, false, false, false, false, false, false, false, false};
        System.out.println("Benvenuto nella simulazione di una battaglia navale");
        int pezzi;
        //Input dall'utente
        do {
            System.out.println("Inserire il numero di pezzi del carro lineare");
            pezzi = in.nextInt();
        } while (pezzi > 33 || pezzi <= 0);
        int x, y;
        do {
            System.out.println("Inserire la Posizione tra 0 e 33 per le x, mentre tra 0 e 17 per le y\nIndica la prim cella del carro");
            x = in.nextInt();
            y = in.nextInt();
        } while ((x > 33 || x < 0) && (y > 17 || y < 0));
        CarroLineare carroL = new CarroLineare(pezzi, new Posizione(x, y));
        do {
            System.out.println("Inserire il la larghezza del lato del carro Quadrato");
            pezzi = in.nextInt();
        } while (pezzi > 17 || pezzi <= 0);
        do {
            System.out.println("Inserire la Posizione tra 0 e 33 per le x, mentre tra 0 e 17 per le y\nIndica la prim cella del carro");
            x = in.nextInt();
            y = in.nextInt();
        } while ((x > 33 || x < 0) && (y > 17 || y < 0));
        CarroQuadrato carroQ = new CarroQuadrato(pezzi * pezzi, new Posizione(x, y));
        do {
            System.out.println("Inserire il numero di pezzi del carro Talpa");
            pezzi = in.nextInt();
        } while (pezzi > 33 || pezzi <= 0);
        do {
            System.out.println("Inserire la Posizione tra 0 e 33 per le x, mentre tra 0 e 17 per le y\nIndica la prim cella del carro");
            x = in.nextInt();
            y = in.nextInt();
        } while ((x > 33 || x < 0) && (y > 17 || y < 0));
        CarroTalpa carroT = new CarroTalpa(pezzi, new Posizione(x, y));
        do {
            System.out.println("Inserire il numero di pezzi del carro Talpa");
            pezzi = in.nextInt();
        } while (pezzi > 33 || pezzi <= 0);
        do {
            System.out.println("Inserire la Posizione tra 0 e 33 per le x, mentre tra 0 e 17 per le y\nIndica la prim cella del carro");
            x = in.nextInt();
            y = in.nextInt();
        } while ((x > 33 || x < 0) && (y > 17 || y < 0));
        CarroTalpa carroT1 = new CarroTalpa(pezzi, new Posizione(x, y));
        System.out.println("Quante proiettili vuoi sparare?\nConsiglio un numero grande come 5000");
        int n = in.nextInt();
        ArrayList<CarroCantiere> carri = new ArrayList<CarroCantiere>();
        carri.add(carroL);
        carri.add(carroT);
        carri.add(carroQ);
        carri.add(carroT1);
        System.out.println("Vuoi che il primo carro sia nascosto?(Y/N)");
        String a = in.next();
        if (a.equals('Y')) {
            carroT.nascosto();
        }
        System.out.println("Vuoi che il secondo carro sia nascosto?(Y/N)");
        String b = in.next();
        if (b.equals('Y')) {
            carroT1.nascosto();
        }
        System.out.println("La battaglia sta per iniziare");
        for (int d = 10; d > 0; d--) {
            System.out.println(d);
            Thread.sleep(1000);
        }
        Battaglia game = new Battaglia(carri, n);
        Date data = new Date();
        //Ciclo del lancio dei proiettili
        for (int i = 0; i < n; i++) {
            int xRand = rand.nextInt(33) + 1;
            int yRand = rand.nextInt(17) + 1;
            Posizione lancio = new Posizione(xRand, yRand);
            game.updateLog("\n" + data.getHours() + ":" + data.getMinutes() + " Proiettile lanciato in posizione " + xRand + "," + yRand);

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
