/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;

/**
 *
 * @author Bedroom
 */
public class Vrachtwagen extends Voertuig implements Laadbaar {

    private Volume laadvolume;
    private int maximaalToegelatenMassa;
    private int aantalAssen;

    public Vrachtwagen(String merk, Datum datum, int aankoopprijs, int zitplaatsen, Volume laadvolume, int maximaalToegelatenMassa, int aantalAssen, Mens bestuurder, Mens... mensen) {
        super(merk, datum, aankoopprijs, zitplaatsen, bestuurder, mensen);
        setLaadvolume(laadvolume);
        setMaximaalToegelatenMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
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

    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        if (maximaalToegelatenMassa >= 0) {
            this.maximaalToegelatenMassa = maximaalToegelatenMassa;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        if (aantalAssen > 1) {
            this.aantalAssen = aantalAssen;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    protected Rijbewijs[] getToegestaneRijbewijzen() {
        return new Rijbewijs[]{Rijbewijs.C, Rijbewijs.CE};
    }

    @Override
    protected int getMAX_ZITPLAATSEN() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" assen:%s, maximaal toegelaten massa:%s, laadvolume:%s", aantalAssen, maximaalToegelatenMassa, laadvolume);
    }

    
}
