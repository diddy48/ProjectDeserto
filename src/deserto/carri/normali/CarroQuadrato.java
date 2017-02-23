/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.carri.normali;

import deserto.carri.CarroCantiere;
import deserto.pos.Pezzo;
import deserto.pos.Posizione;
import java.util.ArrayList;

/**
 *
 * @author FSEVERI\romano3927
 */
public class CarroQuadrato extends CarroCantiere{
    private int col ;
    public CarroQuadrato(int n, Posizione coordinate) {
        super(n, coordinate);
        col = (int) Math.sqrt(n);
    }

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

    @Override
    public boolean distrutto() {
        int en=0;
        for(int i=0;i<getCarro().size();i++){
            en+=getPezzo(i).getEnergia();
        }
        return en==0;
    }
    public int getCols(){
        return col;
    }
    @Override
    public String fuoco(Posizione c) {
        Posizione o = getPosizione();
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
        return "sabbia";
    }
    
}
