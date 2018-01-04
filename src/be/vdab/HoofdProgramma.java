/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import be.vdab.util.Datum;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;
import be.vdab.util.mens.Mens;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;
import static be.vdab.util.mens.Rijbewijs.*;
import be.vdab.voertuigen.Pickup;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bedroom
 */
public class HoofdProgramma {

    public static void main(String[] args) {
        Set<Voertuig> voertuigen = new TreeSet<>();
        voertuigen.add(new Personenwagen("Toyota", new Datum(1, 2, 3456), 12000, 4, Color.blue, new Mens("Amadeus", A, B)));
        voertuigen.add(new Personenwagen("Ford", new Datum(1, 12, 2456), 101000, 4, Color.gray, new Mens("Pol", B)));
        try {
            voertuigen.add(new Pickup("Ford", new Datum(1, 12, 2455), 14000, 4, Color.gray, new Volume(5, 1, 1, Maat.meter), new Mens("Pol", B)));
            voertuigen.add(new Pickup("Chevrolet", new Datum(1, 12, 2457), 15000, 4, Color.gray, new Volume(4, 2, 1, Maat.meter), new Mens("Pol", B)));
            voertuigen.add(new Vrachtwagen("Renault", new Datum(1, 12, 2456), 110000, 2, new Volume(5, 2, 10, Maat.meter), 32000, 4, new Mens("Pol", C)));
            voertuigen.add(new Vrachtwagen("MAN", new Datum(1, 12, 2456), 11000, 2, new Volume(5, 20, 1, Maat.meter), 32000, 4, new Mens("Mike", CE)));
        } catch (VolumeException ex) {
            Logger.getLogger(HoofdProgramma.class.getName()).log(Level.SEVERE, null, ex);
        }
        voertuigen.forEach(System.out::println);
        
        Set<Voertuig> sortedByAankoopprijsR = new TreeSet<>(Comparator.comparing(Voertuig::getAankoopprijs).reversed());
        sortedByAankoopprijsR.addAll(voertuigen);
        System.out.println("Sorted by aankoopprijs:");
        sortedByAankoopprijsR.forEach(System.out::println);

        Set<Voertuig> sortedByMerk = new TreeSet<>(Comparator.comparing(Voertuig::getMerk).thenComparing(Voertuig::compareTo));
        sortedByMerk.addAll(voertuigen);
        System.out.println("Sorted by merk:");
        sortedByMerk.forEach(System.out::println);
        
        System.out.println("Read from file:");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("wagenpark.ser"));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("wagenpark.ser"))){
            oos.writeObject(voertuigen);
            Object obj = ois.readObject();
            @SuppressWarnings("unchecked")
            Set<Voertuig> readVoertuigen = (Set<Voertuig>)ois.readObject();
            readVoertuigen.forEach(System.out::println);
        }catch(IOException | ClassNotFoundException e){
            System.out.println("Something went wrong");
        }
    }
}
