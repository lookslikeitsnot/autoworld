/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.Rijbewijs;
import java.awt.Color;

/**
 *
 * @author Bedroom
 */
public class Personenwagen extends Voertuig{
    private Color kleur;

    public Personenwagen(String merk, Datum datum, int aankoopprijs, int zitplaatsen, Color kleur, Mens bestuurder, Mens... mensen) {
        super(merk, datum, aankoopprijs, zitplaatsen, bestuurder, mensen);
        setKleur(kleur);
    }

    public Color getKleur() {
        return kleur;
    }

    public final void setKleur(Color kleur) {
        if(kleur != null) {
            this.kleur = kleur;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    
    

    @Override
    protected Rijbewijs[] getToegestaneRijbewijzen() {
            return new Rijbewijs[]{Rijbewijs.B, Rijbewijs.BE};
        }

    @Override
    protected int getMAX_ZITPLAATSEN() {
        return 8;
    }

    @Override
    public String toString() {
        return super.toString() + " " + zitplaatsen;
    }
    
    
    
}
