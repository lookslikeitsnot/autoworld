/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

/**
 *
 * @author Bedroom
 */
public class DatumException extends RuntimeException{

    public DatumException() {
    }

    public DatumException(String string) {
        super(string);
    }

    public DatumException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DatumException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
