/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spradlingdavisproject2;

import java.util.*;

/**
 * @author Davis Spradling
* forces the PetStore class that implements this
* interface to use the methods in the interface
 */

public interface PetStoreSpecification {
    /**
     * 
     * @param p
     * @param price
     */
    void adoptionDrive(ArrayList<Pet> p, double price[]);

    /**
     * 
     * @return value of all pets in the inventory
     */
    double inventoryValue();
}
