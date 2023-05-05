/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spradlingdavisproject2;

/**
 *
 * @author Davis Spradling 
 */
public class Cat extends Pet{
    /**
     *
     * @author Adam Whaley and
     */
    
        private String breed;
        
        /**
         * 
         * @param name
         * @param breed
         * @param sex
         * @param age
         * @param weight
         * @param ID
         * @param price
         */
        public Cat(String name, String breed, String sex, int age, double weight, int ID, double price) {
            super(name,sex,age,weight,ID,price);
            this.breed = breed;
        }
    
        /**
         * 
         * @return the breed of cat
         * allows us to get the breed of a cat
         * this method must be seperate because not all pets will
         * need to get the species only cat and dog
         */

        public String getBreed() {
            return breed;
        }
    
        /**
         * 
         * @param breed
         * allows us to set the breed of a cat
         */
        public void setBreed(String breed) {
            this.breed = breed;
        }
    }