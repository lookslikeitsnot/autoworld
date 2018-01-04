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
import java.awt.Color;

/**
 *
 * @author Bedroom
 */
public class Pickup extends Personenwagen implements Laadbaar {

    private Volume laadvolume;

    public Pickup(String merk, Datum datum, int aankoopprijs, int zitplaatsen, Color kleur, Volume laadvolume, Mens bestuurder, Mens... mensen) {
        super(merk, datum, aankoopprijs, zitplaatsen, kleur, bestuurder, mensen);
        setLaadvolume(laadvolume);
    }

    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume volume) {
        if (volume != null) {
            laadvolume = volume;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + laadvolume;
    }

}
