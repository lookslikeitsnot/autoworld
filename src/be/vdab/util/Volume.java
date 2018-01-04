/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Bedroom
 */
public final class Volume implements Serializable, Comparable<Volume> {

    private final int hoogte;
    private final int breedte;
    private final int diepte;
    private final Maat maat;

    public Volume(int hoogte, int breedte, int diepte, Maat maat) throws VolumeException {
        if (hoogte >= 0 && breedte >= 0 && diepte >= 0) {
            this.hoogte = hoogte;
            this.breedte = breedte;
            this.diepte = diepte;
            this.maat = maat;
        } else {
            throw new VolumeException();
        }
    }

    public long getVolume() {
        return hoogte * breedte * diepte * (long) Math.pow(10, 3 * maat.ordinal());
    }

    public int getHoogte() {
        return hoogte;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getDiepte() {
        return diepte;
    }

    public Maat getMaat() {
        return maat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.hoogte;
        hash = 79 * hash + this.breedte;
        hash = 79 * hash + this.diepte;
        hash = 79 * hash + Objects.hashCode(this.maat);
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
        final Volume other = (Volume) obj;
        if (this.hoogte != other.hoogte) {
            return false;
        }
        if (this.breedte != other.breedte) {
            return false;
        }
        if (this.diepte != other.diepte) {
            return false;
        }
        if (this.maat != other.maat) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Volume volume) {

        return (int) (getVolume() - volume.getVolume());
    }

    @Override
    public String toString() {

        return String.format("%d(h)x%d(b)x%d(d) %s", hoogte, breedte, diepte, maat);
    }

}
