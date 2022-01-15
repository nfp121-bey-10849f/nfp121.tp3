package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        // a completer
        if (taille <= 0)
          taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
         if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        // a completer
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        // a completer
        return zone[ptr-1];
    }

    public int capacite() {
        // a completer
        return zone.length;
    }

    public int taille() {
        // a completer
        return ptr;
    }

    public boolean estVide() {
        // a completer
        return ptr == 0;
    }

    public boolean estPleine() {
        // a completer
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        // a completer
        if(o instanceof Pile){
            if((this.taille() == Pile.class.cast(o).taille()) &&  (this.capacite() == Pile.class.cast(o).capacite())){
                for(int i = 0; i<zone.length; i++){
                    if(this.zone[i] != Pile.class.cast(o).zone[i]){
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

    public String toString() {
        // a completer
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i]);
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}