/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Bedroom
 */
public class Mens implements Comparable<Mens>, Serializable {

    private String naam;
    private Set<Rijbewijs> rijbewijs;

    public Mens(String naam, Rijbewijs... rijbewijs) {
        this.naam = naam;
        this.rijbewijs = new TreeSet<>(Arrays.asList(rijbewijs));
    }

    public String getNaam() {
        return naam;
    }

    public Rijbewijs[] getRijbewijs() {
        return rijbewijs.toArray(new Rijbewijs[rijbewijs.size()]);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.naam);
        hash = 29 * hash + Objects.hashCode(this.rijbewijs);
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
        final Mens other = (Mens) obj;
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        if (!Objects.equals(this.rijbewijs, other.rijbewijs)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public int compareTo(Mens mens) {
        return this.naam.equals(mens.naam) ? this.rijbewijs.size() - mens.rijbewijs.size() : this.naam.compareTo(mens.naam);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(naam);
        if (!rijbewijs.isEmpty()) {
            str.append("(");
            String prefix = "";
            for (Rijbewijs rb : rijbewijs) {
                str.append(prefix);
                prefix = ", ";
                str.append(rb.toString());
            }
            str.append(")");
        }
        return str.toString();
    }

}
