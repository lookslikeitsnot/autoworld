/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Bedroom
 */
public final class Boekentas implements Laadbaar, Serializable {

    private static final long serialVersionUID = -3698381125844719819L;

    private Volume laadvolume;
    private String kleur;

    public Boekentas(String kleur, Volume laadvolume) {
        setLaadvolume(laadvolume);
        setKleur(kleur);
    }

    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume laadvolume) {
        if (laadvolume != null) {
            this.laadvolume = laadvolume;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        if (kleur!=null && !kleur.trim().isEmpty()) {
            this.kleur = kleur;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.laadvolume);
        hash = 23 * hash + Objects.hashCode(this.kleur);
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
        final Boekentas other = (Boekentas) obj;
        if (!Objects.equals(this.kleur, other.kleur)) {
            return false;
        }
        if (!Objects.equals(this.laadvolume, other.laadvolume)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("boekentas %s %s", kleur, laadvolume);
    }

}
