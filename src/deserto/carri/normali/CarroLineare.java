/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.carri.normali;

import deserto.carri.CarroCantiere;
import deserto.pos.Pezzo;
import deserto.pos.Posizione;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author FSEVERI\romano3927
 */
public class CarroLineare extends CarroCantiere {
    /**
     * Costruttore
     * @param n numero di pezzi
     * @param coordinate coordinate della prima cella
     */
    public CarroLineare(int n, Posizione coordinate) {
        super(n, coordinate);
    }
    /**
     * Restituisce una stringa rappresentante lo stato del carro
     * @return stringa che rappresenta lo stato del carro
     */
    @Override
    public String stato() {
        ArrayList<Pezzo> carro = super.getCarro();
        int c = 0;
        for (int i = 0; i < carro.size(); i++) {
            c += getPezzo(i).getEnergia();
        }
        if (c == 0) {
            return "distrutto";
        } else if (c == (carro.size() * 100)) {
            return "integro";
        } else {
            return "danneggiato";
        }
    }
    /**
     * Controlla se il carro è stato distrutto
     * @return true se ditrutto e false altrimenti
     */
    @Override
    public boolean distrutto() {
        int en = 0;
        for (int i = 0; i < getCarro().size(); i++) {
            en += getPezzo(i).getEnergia();
        }
        return en <= 0;
    }
    /**
     * Controlla se il carro è stato colpito
     * @param c posizione del proiettile
     * @return stringa che indica se il carro è stato colpito, sistrutto o mancato
     */
    @Override
    public String fuoco(Posizione c) {
        Posizione o = new Posizione(getPosizione());
        for (int i = 0; i < getCarro().size(); i++) {
            if (!getPezzo(i).distrutto()) {
                if (o.equals(c)) {
                    if (getPezzo(i).getEnergia() == 50) {
                        getPezzo(i).rmEnergia(50);
                        return "distrutto";
                    } else {
                        getPezzo(i).rmEnergia(50);
                        return "colpito";
                    }
                }
                o.addX(1);
            }
        }
        return "mancato";
    }
    /**
     * Disegna il carro
     * @param g2 contesto grafico
     */
    public void draw(Graphics2D g2) {
        ArrayList<Pezzo> carro = getCarro();
        Posizione p = new Posizione(getPosizione());
        for (int i = 0; i < carro.size(); i++) {
            if (carro.get(i).distrutto()==false) {
                g2.setColor(Color.RED);
                g2.fillRect(p.getX() * 20+20, p.getY() * 20+20, 20, 20);
                g2.setColor(Color.BLACK);
                g2.drawRect(p.getX() * 20+20, p.getY() * 20+20, 20, 20);
                g2.drawString("" + carro.get(i).getPos() + "", p.getX() * 20 + 5+20, p.getY() * 20 + 15+20);
                p.addX(1);
            }
        }
    }
}
