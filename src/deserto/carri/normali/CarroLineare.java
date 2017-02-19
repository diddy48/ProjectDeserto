/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.carri.normali;

import deserto.carri.CarroCantiere;
import deserto.pos.Posizione;

/**
 *
 * @author FSEVERI\romano3927
 */
public class CarroLineare extends CarroCantiere{

    public CarroLineare(int n, Posizione coordinate) {
        super(n, coordinate);
    }

    @Override
    public String stato() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean distrutto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String fuoco(Posizione c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
