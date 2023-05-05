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

//extends Member so PremiumMeber gets all the instance variables that Member has
public class PremiumMember extends Member{
    
    //premium members are to be tracked if dues
    //are paid so that is what this will do
    private boolean duesPaid;

    /**
     * 
     * @param name
     * @param memberID
     * @param newsletterSubscribed
     * @param duesPaid
     */
    public PremiumMember(String name, int memberID, boolean newsletterSubscribed, boolean duesPaid) {
       
        super(name, memberID, newsletterSubscribed);
        this.duesPaid = duesPaid;
    }

    /**
     * 
     * @return the premiumMember dues paid status
     * returns status on if premium member dues are paid
     */
    public boolean isDuesPaid() {
        return duesPaid;
    }

    /**
     * 
     * @param duesPaid
     * allows you to change the dues paid status
     */
    
    public void setDuesPaid(boolean duesPaid) {
        this.duesPaid = duesPaid;
    }

}

