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
    ArrayList<Pezzo> carro;
    Posizione coordinate;

    public CarroCantiere(int n,Posizione coordinate) {
        carro=new ArrayList<Pezzo>(n);
        for(int i=0;i<carro.size();i++) carro.add(new Pezzo());
        this.coordinate = coordinate;
    }
    public abstract String stato();
    public abstract boolean distrutto();
    public abstract String fuoco(Posizione c);

    @Override
    public String toString() {
        return "CarroCantiere{" + "carro=" + carro + ", coordinate=" + coordinate + '}';
    }
}
