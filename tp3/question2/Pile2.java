package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;
    
    private int ptr;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        // prevoir le cas <=0
        // a completer
        if (taille <= 0)
          taille = CAPACITE_PAR_DEFAUT;
        this.capacite = taille;
        this.ptr = -1;
        this.stk = new Stack<Object>();
        this.stk.setSize(taille);
    }

    // constructeur fourni
    public Pile2() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        if(estPleine())
            throw new PilePleineException();
        this.ptr ++;
        this.stk.set(this.ptr, o);
    }

    public Object depiler() throws PileVideException {
        // a completer
        if(estVide())
            throw new PileVideException();
        Object temp = stk.elementAt(ptr);
        stk.set(ptr, null);
        ptr --;
        return temp;
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(estVide())
            return null;
        return stk.elementAt(ptr);
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
        return this.ptr == -1;
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // a completer
        return this.ptr == capacite-1;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        // a completer
        for(int i = ptr; i >= 0; i--){
            s += stk.get(i);
            if (i > 0)
                s+=", ";
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        // a completer
        if(o instanceof Pile2){
            if((this.taille() == Pile2.class.cast(o).taille()) &&  (this.capacite() == Pile2.class.cast(o).capacite())){
                for(int i = 0; i<stk.size(); i++){
                    if(this.stk.get(i) != Pile2.class.cast(o).stk.get(i)){
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

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        // a completer
        return this.ptr+1;
    }

    /**
     * Retourne la capacite de cette pile.
     *  
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        return this.capacite;
    }

} // Pile2.java
