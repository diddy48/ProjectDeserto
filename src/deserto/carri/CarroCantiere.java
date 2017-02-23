/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.carri;

import deserto.pos.Pezzo;
import deserto.pos.Posizione;
import java.util.ArrayList;

/**
 *
 * @author FSEVERI\romano3927
 */
public abstract class CarroCantiere {
    private ArrayList<Pezzo> carro;
    private Posizione coordinate;

    public CarroCantiere(int n,Posizione coordinate) {
        carro=new ArrayList<Pezzo>(n);
        for(int i=0;i<carro.size();i++) carro.add(new Pezzo(i));
        this.coordinate = coordinate;
    }
    public abstract String stato();
    public abstract boolean distrutto();
    public abstract String fuoco(Posizione c);
    
    public Posizione getPosizione(){
        return coordinate;
    }
    
    public ArrayList<Pezzo> getCarro(){
        return carro;
    }
    public Pezzo getPezzo(int i){
        return carro.get(i);
    }
    @Override
    public String toString() {
        return "CarroCantiere{" + "carro=" + carro + ", coordinate=" + coordinate + '}';
    }
}
