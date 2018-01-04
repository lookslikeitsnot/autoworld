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
public class VolumeException extends Exception{

    public VolumeException() {
    }

    public VolumeException(String string) {
        super(string);
    }

    public VolumeException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public VolumeException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
