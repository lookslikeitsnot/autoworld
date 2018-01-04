/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

/**
 *
 * @author Bedroom
 */
public class MensException extends RuntimeException{

    public MensException() {
    }

    public MensException(String string) {
        super(string);
    }

    public MensException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public MensException(Throwable thrwbl) {
        super(thrwbl);
    }

    public MensException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
