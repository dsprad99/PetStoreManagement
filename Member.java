/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spradlingdavisproject2;


import java.util.ArrayList;


/**
 *
 * @author Davis Spradling
 */
public class Member {
    
    private String name;
    private int memberID;
    private boolean newsletterSubscribed;
    
    //keeps track of all the pets that are owned
    //by a member
    private ArrayList<Pet> petsOwned = new ArrayList();
    private double amountSpent = 0;

    /**
     * 
     * @param name
     * @param memberID
     * @param newsletterSubscribed
     */
    public Member(String name, int memberID, boolean newsletterSubscribed) {
        this.name = name;
        this.memberID = memberID;
        this.newsletterSubscribed = newsletterSubscribed;
    }

    /**
     * 
     * @return the member name
     * allows us to get the name of a member
     */
    
    public String getName() {
        return name;
    }

    /**
     * 
     * @return the member ID
     * allows us to get the ID of a member
     */
    
    public int getMemberID() {
        return memberID;
    }

    /**
     * 
     * @return the status of if a member wants a news letter
     * allows us to see if the member is subscribed to a newsletter or not
     */
    
    public boolean isNewsletterSubscribed() {
        return newsletterSubscribed;
    }

    /**
     * 
     * @return the pets that a member owns
     * return the pet owned by a member from the array list 
     */
    
    public ArrayList<Pet> getPetsOwned() {
        return petsOwned;
    }

    /**
     * 
     * @return the amount a member has spent
     * allows us to get the amount spent by a member
     */
    
    public double getAmountSpent() {
        return amountSpent;
    }

    /**
     * 
     * @param name
     * allows us to set the member name
     */
    
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @param memberID
     * allows us to set the member ID
     */
    
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    /**
     * 
     * @param newsletterSubscribed
     * allows us to set if the member is subscribed or not to newsletters
     */
    
    public void setNewsletterSubscribed(boolean newsletterSubscribed) {
        this.newsletterSubscribed = newsletterSubscribed;
    }

    /**
     * 
     * @param amountSpent
     * allows us to set the amount spent 
     */
    
    public void setAmountSpent(double amountSpent) {
        this.amountSpent = this.amountSpent + amountSpent;
    }
     
    /**
     * 
     * @param pet
     * allows us to add a pet to the pets that a member owns
     */
    
     public void addPet(Pet pet) {
         petsOwned.add(pet);
     }


}

