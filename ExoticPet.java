/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spradlingdavisproject2;


/**
 *
 * @author Davis Spradling
 */

 public class ExoticPet extends Pet{
    private String species;
    
    /**
     * 
     * @param name
     * @param species
     * @param sex
     * @param age
     * @param weight
     * @param ID
     * @param price
     */
    public ExoticPet(String name, String species, String sex, int age, double weight, int ID, double price) {
        super(name,sex,age,weight,ID,price);
        this.species = species;
    }

    /**
     * 
     * @return exotic pet specieis
     * allows us to get the species of a exotic pet
     * this method must be seperate because not all pets will
     * need to get the species
     */

    public String getSpecies() {
        return species;
    }

    /**
     * 
     * @param species
     * allows us to set the species of an exotic pet if want 
     * to change it
     */

    public void setSpecies(String species) {
        this.species = species;
    }
}
