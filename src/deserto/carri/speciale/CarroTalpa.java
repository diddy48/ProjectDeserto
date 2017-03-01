/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.carri.speciale;

import deserto.carri.normali.CarroLineare;
import deserto.pos.Pezzo;
import deserto.pos.Posizione;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author FSEVERI\romano3927
 */
public class CarroTalpa extends CarroLineare {

    private boolean sotto = false;
    /**
     * Costruttore
     * @param n numero di pezzi
     * @param coordinate coordinate della prima cella
     */
    public CarroTalpa(int n, Posizione coordinate) {
        super(n, coordinate);
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
                    if(sotto){
                        getPezzo(i).rmEnergia(25);
                        scoperto();
                        if(getPezzo(i).distrutto()) return "distrutto";
                        else return "colpito";
                    }
                    else{
                        if(getPezzo(i).getEnergia()==25){
                            getPezzo(i).rmEnergia(25);
                            return "distrutto";
                        }
                        else{
                            getPezzo(i).rmEnergia(50);
                            if(getPezzo(i).distrutto()) return "distrutto";
                            else return "colpito";
                        }
                    }
                }
                o.addX(1);
            }
        }
        return "mancato";
    }
    /**
     * Scopre il carro
     */
    public void scoperto() {
        sotto = false;
    }
    /**
     * Nasconde il carro
     */
    public void nascosto() {
        sotto = true;
    }
    /**
     * Disegna il carro
     * @param g2 contesto grafico
     */
    @Override
    public void draw(Graphics2D g2) {
        ArrayList<Pezzo> carro = getCarro();
        Posizione p = new Posizione(getPosizione());
        for (int i = 0; i < carro.size(); i++) {
            if (carro.get(i).distrutto()==false) {
                if(!sotto) g2.setColor(Color.BLUE);
                else g2.setColor(Color.GRAY);
                g2.fillRect(p.getX() * 20+20, p.getY() * 20+20, 20, 20);
                g2.setColor(Color.BLACK);
                g2.drawRect(p.getX() * 20+20, p.getY() * 20+20, 20, 20);
                g2.drawString("" + carro.get(i).getPos() + "", p.getX() * 20 + 5+20, p.getY() * 20 + 15+20);
                p.addX(1);
            }
        }
    }
}
