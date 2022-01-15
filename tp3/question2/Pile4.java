package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
    /** la liste des Maillons/Elements */
    private Maillon stk;
    /** la capacité de la pile */
    private int capacite;
    /** le nombre */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est une
     * proposition, vous pouvez l'ignorer !
     */
    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    /**
     * Création d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
        this.nombre = 0;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        // à compléter
        if(estVide()){
            stk = new Maillon(o, null);
        }else{
            Maillon n = new Maillon(o, null);
            n.suivant = stk;
            stk = n;
        }
        this.nombre ++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        // à compléter
        Object temp = stk.element();
        stk = stk.suivant();
        this.nombre --;
        return temp;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.element(); // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk == null; // à compléter
    }

    /**
     * Effectue un test de l'état de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return nombre == capacite; // à compléter
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     * 
     * @return une représentation en String d'une pile
     */
    public String toString() {

        String s = "[";
        // à compléter
        if(!estVide()){
            Maillon temp = stk;
            while(temp != null){
                s += temp.element();
                if(temp.suivant() != null)
                    s += ", ";
                temp = temp.suivant();
            }
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        if (o instanceof Pile4) {
            // à compléter
            if((this.taille() == Pile4.class.cast(o).taille()) &&  (this.capacite() == Pile4.class.cast(o).capacite())){
                Maillon temp = stk;
                Maillon temp1 = Pile4.class.cast(o).stk;
                while(temp != null && temp1 != null){
                    if(temp.element() != temp1.element()){
                        return false;
                    }
                    temp = temp.suivant();
                    temp1 = temp1.suivant();
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

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}