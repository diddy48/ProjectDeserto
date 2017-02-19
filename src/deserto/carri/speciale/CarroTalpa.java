/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.carri.speciale;

import deserto.carri.normali.CarroLineare;
import deserto.pos.Posizione;

/**
 *
 * @author FSEVERI\romano3927
 */
public class CarroTalpa extends CarroLineare{
    private boolean sotto=false;
    public CarroTalpa(int n, Posizione coordinate) {
        super(n, coordinate);
    }
    @Override
    public String fuoco(Posizione c){
        return "";
    }
    public void scoperto(){
        sotto=false;
    }
    public void nascosto(){
        sotto=true;
    }
}
