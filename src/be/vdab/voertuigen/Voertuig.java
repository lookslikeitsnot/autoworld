/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.voertuigen.div.DIV;
import be.vdab.voertuigen.div.Nummerplaat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Bedroom
 */
public abstract class Voertuig implements Comparable<Voertuig>, Serializable {

    static final long serialVersionUID = 0L;
    protected final Nummerplaat nummerplaat;
    protected String merk;
    protected Datum datumEersteIngebruikname;
    protected int aankoopprijs;
    protected final int zitplaatsen;
    protected List<Mens> inzittenden;

    public Voertuig(String merk, Datum datum, int aankoopprijs, int zitplaatsen, Mens bestuurder, Mens... mensen) {
        setMerk(merk);
        this.datumEersteIngebruikname = datum;
        setAankoopprijs(aankoopprijs);
        if (datum != null && zitplaatsen > 0 && zitplaatsen <= getMAX_ZITPLAATSEN()) {
            this.zitplaatsen = zitplaatsen;
        } else {
            throw new IllegalArgumentException();
        }
        this.nummerplaat = DIV.INSTANCE.getNummerplaat();
        this.inzittenden = new ArrayList<>();

        setBestuurder(bestuurder);

        addIngezetene(mensen);

    }

    protected abstract Rijbewijs[] getToegestaneRijbewijzen();

    protected abstract int getMAX_ZITPLAATSEN();

    public Mens getBestuurder() {
        return inzittenden.get(0);
    }

    public final void setBestuurder(Mens mens) {
        if (!Collections.disjoint(Arrays.asList(mens.getRijbewijs()), Arrays.asList(getToegestaneRijbewijzen()))) {
            if (inzittenden.contains(mens)) {
                Collections.swap(inzittenden, 0, inzittenden.indexOf(mens));
            } else if (inzittenden.size() + 1 <= zitplaatsen) {
                inzittenden.add(0, mens);
            } else {
                throw new MensException();
            }
        } else {
            throw new MensException();
        }
    }

    public final void addIngezetene(Mens... mensen) {
        List<Mens> resterendeMensen = new ArrayList<>();
        for (Mens mens : mensen) {
            if (!inzittenden.contains(mens)) {
                resterendeMensen.add(mens);
            }
        }
        if (resterendeMensen.size() + inzittenden.size() > zitplaatsen) {
            throw new MensException();
        } else {
            inzittenden.addAll(resterendeMensen);
        }
    }

    public final boolean isIngezetene(Mens mens) {
        return inzittenden.contains(mens);
    }

    public final Set<Mens> getIngezetenen() {
        return new TreeSet<>(inzittenden);
    }

    public final Set<Mens> getIngezeteneExclusiefBestuurder() {
        return new TreeSet<>(inzittenden.subList(1, inzittenden.size()));
    }

    public String getMerk() {
        return merk;
    }

    public final void setMerk(String merk) {
        if (!merk.trim().isEmpty()) {
            this.merk = merk;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Datum getDatumEersteIngebruikname() {
        return datumEersteIngebruikname;
    }

    public void setDatumEersteIngebruikname(Datum datumEersteIngebruikname) {
        this.datumEersteIngebruikname = datumEersteIngebruikname;
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public final void setAankoopprijs(int aankoopprijs) {
        if (aankoopprijs > 0) {
            this.aankoopprijs = aankoopprijs;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }

    public int getZitplaatsen() {
        return zitplaatsen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nummerplaat);
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
        final Voertuig other = (Voertuig) obj;
        if (!Objects.equals(this.nummerplaat, other.nummerplaat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(nummerplaat);
        str.append(' ');
        str.append(merk);
        str.append(' ');
        str.append(datumEersteIngebruikname);
        str.append(' ');
        str.append(aankoopprijs);
        str.append(' ');
        str.append(getBestuurder());
        if (!getIngezeteneExclusiefBestuurder().isEmpty()) {
            str.append(' ');
            str.append(getIngezeteneExclusiefBestuurder());
        }

        return str.toString();
    }

    @Override
    public int compareTo(Voertuig voertuig) {
        return this.nummerplaat.compareTo(voertuig.nummerplaat);
    }

    public static MerkComparator getMerkComparator() {
        return new MerkComparator();
    }

    static AankoopprijsComparator getAankoopprijsComparator() {
        return new AankoopprijsComparator();
    }

    public static class MerkComparator {

        public int compare(Voertuig v1, Voertuig v2) {
            return v1.merk.compareTo(v2.merk);
        }
    }

    public static class AankoopprijsComparator {

        public int compare(Voertuig v1, Voertuig v2) {
            return v1.aankoopprijs - v2.aankoopprijs;
        }
    }
}
