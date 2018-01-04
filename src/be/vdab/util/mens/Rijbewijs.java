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
public enum Rijbewijs {
    A, B, BE('B', 'E'), C, CE('C', 'E'), D, DE('D', 'E');

    String rijbewijsText;

    private Rijbewijs() {
        rijbewijsText = this.name();
    }

    Rijbewijs(char a, char b) {
        rijbewijsText = a + "+" + b;
    }

    @Override
    public String toString() {
        return rijbewijsText;
    }

}
