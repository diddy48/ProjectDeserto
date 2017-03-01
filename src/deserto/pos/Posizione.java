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
public class Posizione {
    private int x,y;
    /**
     * Costruttore senza parametri della posizione
     */
    public Posizione() {
    }
    /**
     * Costruttore con paramtri della posizione
     * @param x ascissa
     * @param y ordinata
     */
    public Posizione(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Costruttore di una posizione mediante un'altra posizione
     * @param posizione posizione da copiare
     */
    public Posizione(Posizione posizione) {
        this.x=posizione.getX();
        this.y=posizione.getY();
    }
    /**
     * Restituisce la x
     * @return ascissa
     */
    public int getX() {
        return x;
    }
    /**
     * Restituisce la y
     * @return ordinata
     */
    public int getY() {
        return y;
    }
    /**
     * Confronta due posizioni
     * @param obj altra posizione
     * @return true se sono uguali e false altrimnti
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Posizione other = (Posizione) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    /**
     * Restituisce una stringa che rappresenta ila posizione
     * @return stringa che rappresenta il posizione
     */
    @Override
    public String toString() {
        return "Posizione{" + "x=" + x + ", y=" + y + '}';
    }
    /**
     * Aggiunge i alla x
     * @param i numero da aggiungere alla x
     */
    public void addX(int i) {
        x+=i;
    }
    /**
     * Aggiunge i alla y
     * @param i numero da aggiungere alla y
     */
    public void addY(int i) {
        y+=i;
    }
    /**
     * Setta la ascissa
     * @param x nuova x
     */
    public void setX(int x){
        this.x=x;
    }
}
