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

    public Posizione() {
    }

    public Posizione(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Posizione(Posizione posizione) {
        this.x=posizione.getX();
        this.y=posizione.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
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

    @Override
    public String toString() {
        return "Posizione{" + "x=" + x + ", y=" + y + '}';
    }

    public void addX(int i) {
        x+=i;
    }

    public void addY(int i) {
        y+=i;
    }
    public void setX(int x){
        this.x=x;
    }
}
