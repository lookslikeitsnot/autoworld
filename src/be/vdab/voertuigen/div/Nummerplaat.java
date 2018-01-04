/*
* @Autor Frank
* Dit is een oefening.
 */

package be.vdab.voertuigen.div;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author frank.roelants
 */
public final class Nummerplaat implements Serializable, Comparable<Nummerplaat>{
    static final long serialVersionUID = 0L;
    private String plaat;

    Nummerplaat(String plaat) {
        setPlaat(plaat);
    }

    public void setPlaat(String plaat) {
        if(!plaat.trim().isEmpty()){
            this.plaat = plaat;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getPlaat() {
        return plaat;
    }

    @Override
    public String toString() {
        return plaat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.plaat);
        return hash;
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
        final Nummerplaat other = (Nummerplaat) obj;
        if (!Objects.equals(this.plaat, other.plaat)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Nummerplaat nummerplaat) {
        return this.plaat.compareTo(nummerplaat.plaat);
    }
}
