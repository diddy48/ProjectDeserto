/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserto.pos;

/**
 *
 * @author FSEVERI\romano3927
 */
public class Pezzo {
    private int energia;
    private int p;
    public Pezzo(int p){
        energia=100;
        this.p=p;
    }
    public boolean distrutto(){
        return energia==0;
    }
    public int getEnergia() {
        return energia;
    }

    public void rmEnergia(int energia) {
        this.energia -= energia;
    }

    @Override
    public String toString() {
        return "Pezzo{" + "energia=" + energia + '}';
    }
    
}
