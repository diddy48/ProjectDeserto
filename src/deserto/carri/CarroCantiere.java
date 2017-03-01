/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.carri;

import deserto.pos.Pezzo;
import deserto.pos.Posizione;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author FSEVERI\romano3927
 */
public abstract class CarroCantiere {
    private ArrayList<Pezzo> carro;
    private Posizione coordinate;
    /**
     * Costruttore
     * @param n numero di pezzi
     * @param coordinate coordinate della prima cella
     */
    public CarroCantiere(int n,Posizione coordinate) {
        carro=new ArrayList<Pezzo>();
        for(int i=0;i<n;i++) carro.add(new Pezzo(i));
        this.coordinate = coordinate;
    }
    /**
     * Restituisce una stringa rappresentante lo stato del carro
     * @return stringa che rappresenta lo stato del carro
     */
    public abstract String stato();
    /**
     * Controlla se il carro è stato distrutto
     * @return true se ditrutto e false altrimenti
     */
    public abstract boolean distrutto();
    /**
     * Controlla se il carro è stato colpito
     * @param c posizione del proiettile
     * @return stringa che indica se il carro è stato colpito, sistrutto o mancato
     */
    public abstract String fuoco(Posizione c);
    /**
     * Restituisce le coordinate della prima cella del carro
     * @return coordinate della prima cella del carro
     */
    public Posizione getPosizione(){
        return coordinate;
    }
    /**
     * Restituisce il carro
     * @return carro
     */
    public ArrayList<Pezzo> getCarro(){
        return carro;
    }
    /**
     * Restituisce il pezzo in posizione i del carro
     * @param i numero della cella del carro
     * @return pezzo in posizione i
     */
    public Pezzo getPezzo(int i){
        return carro.get(i);
    }
    /**
     * Restituisce una rappresentazione in forma di stringa del carro
     * @return stringa che rappresenta il carro
     */
    @Override
    public String toString() {
        return "CarroCantiere{" + "carro=" + carro + ", coordinate=" + coordinate + '}';
    }
}
