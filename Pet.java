/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spradlingdavisproject2;

/**
 *
 * @author Davis Spradling
 */

public abstract class Pet implements Comparable<Pet> {
    private String name;
    private String sex;
    private int age;
    private double weight;
    private int ID;
    private double price;

    public Pet(String name, String sex, int age, double weight, int ID, double price) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.ID = ID;
        this.price = price;
    }
    
    /**
     * 
     * @return ID of pet
     * allows us to get the ID of a pet
     */
    
    public int getID() {
        return ID;
    }
    
    /**
     * 
     * @param ID
     * allows us to set the ID of a pet if we want to change it
     */
     
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * 
     * @return price of pet
     * allows us to get the price of a pet
     */

    public double getPrice() {
        return price;
    }

    /**
     * 
     * @param price 
     * allows us to set the price of a pet if we want to change it
     */
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * 
     * @return name of pet
     * allows us to get the name of a pet
     */
    
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     * allows us to set the name of a pet to change it
     */
    
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return sex of pet
     * allows us to get the sex of a pet
     */

    public String getSex() {
        return sex;
    }
    
    /**
     * 
     * @param sex
     * allows us to set the sex of a pet to change it
     */

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 
     * @return age of pet
     * allows us to get the age of a pet
     */
    
    public int getAge() {
        return age;
    }

    /**
     * 
     * @param age
     * allows us to set the age of a pet to change it
     */

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 
     * @return weight of pet
     * allows us to get the weight of a pet
     */
    
    public double getWeight() {
        return weight;
    }

    /**
     * 
     * @param weight
     * allows us to set the weight of a pet to change it
     */
    
    public void setWeight(double weight) {
        this.weight = weight;
    }

    //compare to method allows us to compare the pets price 
    //this method comes from implementing Comparable 
    public int compareTo(Pet pet){
        if (pet.getPrice() > this.getPrice()) {
            System.out.println(pet.getName()+" is more expensive than "+this.getName());
            return 1;
        }
        else if (pet.getPrice() < this.getPrice()) {
            System.out.println(this.getName()+" is more expensive than "+pet.getName());
            return -1;
        }
        System.out.println(this.getName()+" is the same price as "+pet.getName());
        return 0;
    }

}