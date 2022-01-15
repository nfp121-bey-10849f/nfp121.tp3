package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    private int ptr;

    public Pile3() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
        if (taille <= 0)
          taille = CAPACITE_PAR_DEFAUT;
        this.v = new Vector<Object>();
        this.ptr = -1;
        this.v.setSize(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        // à compléter
        if(estPleine())
            throw new PilePleineException();
        this.ptr ++;
        this.v.set(this.ptr, o);
    }

    public Object depiler() throws PileVideException {
        // à compléter
        if(estVide())
            throw new PileVideException();
        Object temp = v.elementAt(ptr);
        v.set(ptr, null);
        ptr --;
        return temp;
    }

    public Object sommet() throws PileVideException {
        // à compléter
        if(ptr < 0){
            return null;
        }
        return v.elementAt(ptr);
    }

    public int taille() {
        // à compléter
        return this.ptr+1;
    }

    public int capacite() {
        // à compléter
        return v.size();
    }

    public boolean estVide() {
        // à compléter
        return this.ptr == -1;
    }

    public boolean estPleine() {
        // à compléter
        return  this.ptr == this.v.size()-1;
    }

    public String toString() {
        // à compléter
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr; i >= 0; i--) {
            sb.append(v.get(i));
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object o) {
        // à compléter
        if(o instanceof Pile3){
            if((this.taille() == Pile3.class.cast(o).taille()) &&  (this.capacite() == Pile3.class.cast(o).capacite())){
                for(int i = 0; i<v.size(); i++){
                    if(this.v.get(i) != Pile3.class.cast(o).v.get(i)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    // public boolean equals(Object o) {
        // if (o instanceof PileI) {
          // PileI p = (PileI) o;
          // return this.capacite() == p.capacite()
              // && this.hashCode() == p.hashCode();
        // } else
          // return false;
      // }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
