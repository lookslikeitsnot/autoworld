/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author Bedroom
 */
public class Datum implements Serializable, Comparable<Datum>{
    static final long serialVersionUID = 0L;

    private final int dag;
    private final int maand;
    private final int jaar;

    public Datum(int dag, int maand, int jaar) throws DatumException {
        try {
            if (jaar > 1582 && jaar < 4100) {
                LocalDate ld = LocalDate.of(jaar, maand, dag);
                this.dag = dag;
                this.maand = maand;
                this.jaar = jaar;
            }
            else{
                throw new DatumException();
            }

        } catch (DateTimeException e) {
            throw new DatumException();
        }

    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dag, maand, jaar);
    }

    public int getDag() {
        return dag;
    }

    public int getMaand() {
        return maand;
    }

    public int getJaar() {
        return jaar;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.dag;
        hash = 83 * hash + this.maand;
        hash = 83 * hash + this.jaar;
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
        final Datum other = (Datum) obj;
        if (this.dag != other.dag) {
            return false;
        }
        if (this.maand != other.maand) {
            return false;
        }
        if (this.jaar != other.jaar) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Datum datum) {
        return LocalDate.of(jaar, maand, dag).compareTo(LocalDate.of(datum.jaar, datum.maand, datum.dag));
    }

    
}
