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
    /**
     * Costruttore del pezzo
     * @param p posizione del pezzo nel carro
     */
    public Pezzo(int p){
        energia=100;
        this.p=p;
    }
    /**
     * Controlla se il pezzo è stato distrutto
     * @return true se il pezzo è distrutto e false altrimenti
     */
    public boolean distrutto(){
        return energia <=0;
    }
    /**
     * Restituisce l'energia del pezzo
     * @return energia del pezzo
     */
    public int getEnergia() {
        return energia;
    }
    /**
     * Restituisce la posizione del pezzo nel carro
     * @return posizione del pezzo nel carro
     */
    public int getPos() {
        return p;
    }
    /**
     * Rimuove energia dal pezzo
     * @param energia energia da rimuovere
     */
    public void rmEnergia(int energia) {
        this.energia -= energia;
    }
    /**
     * Restituisce una stringa che rappresenta il pezzo
     * @return stringa che rappresenta il pezzo
     */
    @Override
    public String toString() {
        return "Pezzo{" + "energia=" + energia + ", posizione=" + p + '}';
    }
}
