/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.carri.speciale;

import deserto.carri.normali.CarroLineare;
import deserto.pos.Pezzo;
import deserto.pos.Posizione;
import java.util.ArrayList;

/**
 *
 * @author FSEVERI\romano3927
 */
public class CarroTalpa extends CarroLineare {

    private boolean sotto = false;

    public CarroTalpa(int n, Posizione coordinate) {
        super(n, coordinate);
    }

    @Override
    public String fuoco(Posizione c) {
        Posizione o = getPosizione();
        for (int i = 0; i < getCarro().size(); i++) {
            if (!getPezzo(i).distrutto()) {
                if (o.equals(c)) {
                    if(sotto){
                        getPezzo(i).rmEnergia(25);
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
                            return "colpito";
                        }
                    }
                }
                o.addX(1);
            }
        }
        return "sabbia";
    }

    public void scoperto() {
        sotto = false;
    }

    public void nascosto() {
        sotto = true;
    }
}
