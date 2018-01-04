/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen.div;

/**
 *
 * @author Bedroom
 */
public enum DIV {
    INSTANCE;

    static int nummer = 0;

    public Nummerplaat getNummerplaat() {
        return maakNummerPlaat();
    }

    private Nummerplaat maakNummerPlaat() {
        DIV.nummer++;
        if(nummer%1000==0){
            nummer++;
        }
//        int rest = (int) (nummer / 1000);
//        int firstChar = rest / 676;
//        int secondChar = rest / 26 - firstChar * 26;
//        int thirdChar = rest % 26;
//
//        return new Nummerplaat(String.format("%c%c%c%03d",
//                (char) (firstChar + 65),
//                (char) (secondChar + 65),
//                (char) (thirdChar + 65),
//                nummer % 1000));
        return new Nummerplaat(String.format("AAA%03d",nummer % 1000));
    }
}