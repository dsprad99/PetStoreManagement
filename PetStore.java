/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spradlingdavisproject2;

/**
 *
 * @author Davis Spradling
 */

import java.util.*;

import javax.print.attribute.standard.PagesPerMinute;

public class PetStore implements PetStoreSpecification {

    private String storeName;

    //keep track of all pets that are available at the
    //pet store
    ArrayList<Pet> availablePets = new ArrayList();
    //list to keep track of all members
    private ArrayList<Member> memberList = new ArrayList();
    //list to keep track of all pets up for adoption
    private ArrayList<Pet> petAdoptionList = new ArrayList();
    //list to keep track of all premium members
    private ArrayList<PremiumMember> premiumMemberList = new ArrayList();
    //starts at 1 and increments with the getNextPetID()
    private static int nextPetID = 1;
    //starts at 1 and increments with the getNextMemberID()
    private static int nextMemberID = 1;

    /**
     * 
     * @param storeName
     */
    public PetStore(String storeName) {
        this.storeName = storeName;
        Dog dog1 = new Dog("Waffle","German Shepherd","Female",12,85,getNextPetID(),500);
        Dog dog3 = new Dog("Baster", "Lab", "Male", 4, 50, getNextPetID(), 550);
        Dog dog2 = new Dog("Poe", "Corgi", "Male", 3, 35, getNextPetID(), 450);
        Cat cat1 = new Cat("Karma","Orange Tabby","Female",6,15,getNextPetID(),200);
        Cat cat2 = new Cat("Kit", "Maine Coon", "Male", 6, 18, getNextPetID(), 150);
        ExoticPet ep1 = new ExoticPet("Pancake","Bearded Dragon","Male",6,0.8,getNextPetID(),75);
        ExoticPet ep2 = new ExoticPet("Noodle","Ball Python","Male",4,2,getNextPetID(),95);

        availablePets.add(dog1);
        availablePets.add(dog2);
        availablePets.add(dog3);
        availablePets.add(cat1);
        availablePets.add(cat2);
        availablePets.add(ep1);
        availablePets.add(ep2);

        Member member1 = new Member("Jo", getNextMemberID(), true);
        member1.addPet(new Cat("Valjean", "White tabby", "Male", 1, 10, 0, 0));
        memberList.add(member1);

        PremiumMember member2 = new PremiumMember("Sage", getNextMemberID(), false, false);
        premiumMemberList.add(member2);
        member2.addPet(new ExoticPet("Smaug", "Bearded Dragon", "Male", 5, 1, 0, 0));

    }

    /**
     * 
     * @return the next ID of a pet
     * increment our pet ID
     */
    
    public static int getNextPetID() {
        nextPetID++;
        return nextPetID - 1;
    }

    /**
     * 
     * @return next ID of a member
     * increment our member ID
     */
    
    public static int getNextMemberID() {
        nextMemberID++;
        return nextMemberID - 1;
    }

    /**
     * 
     * @return store name
     * retreive our storeName
     */
    
    public String getStoreName() {
        return storeName;
    }

    /**
     * 
     * @param storeName
     * set our store name if we want to change it
     */
    
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * 
     * @return available dogs
     * from the avaialablePets list we can retreive the pet "dog"
     */
    
    public ArrayList<Pet> getAvailableDogs() {
        ArrayList<Pet> dogs = new ArrayList<>();
        for (Pet p : availablePets) {
            if(p instanceof Dog) {
                dogs.add((Dog) p);
            }
        }
        return dogs;
    }

    /**
     * 
     * @return available cats
     * from the avaialablePets list we can retreive the pet "cat"
     */
    
    public ArrayList<Pet> getAvailableCats() {
        ArrayList<Pet> cats = new ArrayList<>();
        for (Pet p : availablePets) {
            if (p instanceof Cat) {
                cats.add((Cat) p);
            }
        }
        return cats;
    }

    /**
     * 
     * @return available exotic pets
     * from the avaialablePets list we can retreive the pet "exotic pet"
     */
    
    public ArrayList<Pet> getAvailableExoticPets() {
        ArrayList<Pet> exoticPets = new ArrayList<>();
        for (Pet p : availablePets) {
            if (p instanceof ExoticPet) {
                exoticPets.add((ExoticPet) p);
            }
        }
        return exoticPets;
    }

    /**
     * 
     * @return the list of members
     * allows us to retreive our member list
     */
    
    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    /**
     * 
     * @param memberList
     * allows us to set a member list
     */
    
    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    /**
     * 
     * @return the list of premium members
     * allows us to retreive our member list 
     */
       
    public ArrayList<PremiumMember> getPremiumMemberList() {
        return premiumMemberList;
    }

    /**
     * 
     * @param premiumMemberList
     * allows us to set a premium member list
     */
    
    public void setPremiumMemberList(ArrayList<PremiumMember> premiumMemberList) {
        this.premiumMemberList = premiumMemberList;
    }

    /**
     * 
     * @param type the type of pet
     * @param index where that pet is in the list
     * allows us to remove a pet from the pet store 
     */

    public void removePet(String type, int index) {
        if (type.equals("dog"))
            getAvailableDogs().remove(index);
        else if (type.equals("cat"))
            getAvailableCats().remove(index);
        else if (type.equals("exoticPet"))
            getAvailableExoticPets().remove(index);

    }

    /**
     * 
     * @param name
     * @param premium
     * allows us to add a new member by passing in all the fields 
     * that a member will have
     */
    
    public void addNewMember(String name, boolean premium) {
        if (premium) {
            premiumMemberList.add(new PremiumMember(name, getNextMemberID(), false, false));
        } else {
            memberList.add(new Member(name, getNextMemberID(), false));
        }
    }

    //lets us retreive our dog inventory list by name
    public void dogInventoryList() {
        for (int i = 0; i < getAvailableDogs().size(); i++) {
            System.out.println((i + 1) + ". name: " + getAvailableDogs().get(i).getName());
        }
    }

    //lets us retreive our cat inventory list by name
    public void catInventoryList() {
        for (int i = 0; i < getAvailableCats().size(); i++) {
            System.out.println((i + 1) + ". name: " + getAvailableCats().get(i).getName());
        }
    }

    //lets us retreive our exotic pet inventory list by name
    public void exoticPetInventoryList() {
        for (int i = 0; i < getAvailableExoticPets().size(); i++) {
            System.out.println((i + 1) + ". name: " + getAvailableExoticPets().get(i).getName());
        }
    }

    /**
     * @return total inventory value of all pets
     * retreives our total inventory value
     * this being one of the required methods
     * from the interface petStoreSpecification
     */

    public double inventoryValue() {
        double total = 0;
        for (Pet p : availablePets) {
            total = p.getPrice() + total;
        }
        return total;
    }

    /**
     * 
     * @return total value of all dogs
     * retreives our dog inventory value
     */
    
    public double dogInventoryValue() {
        double total = 0;
        for (Pet d : availablePets) {
            if (d instanceof Dog) {
                total = d.getPrice() + total;
            }
        }
        return total;
    }

    /**
     * 
     * @return value of all cats
     * retreives our cat inventory value
     */
    
    public double catInventoryValue() {
        double total = 0;
        for (Pet c : availablePets) {
            if (c instanceof Cat) {
                total = c.getPrice() + total;
            }
        }
        return total;
    }

    /**
     * 
     * @return value of all exotic pets
     * retreives our exotic pet inventory value
     */
    
    public double exoticPetInventoryValue() {
        double total = 0;
        for (Pet ep : availablePets) {
            if (ep instanceof ExoticPet)
                total = ep.getPrice() + total;
        }
        return total;
    }

    //allows us to move a pet from the petStore to the petAdoptionlist
    //also allows us to set the price of a dog that is being put on 
    //the adoption drive
    public void adoptionDrive(ArrayList<Pet> adoptPet, double[] p) {
        for (Pet ap : adoptPet) {
            petAdoptionList.add(ap);
        }
        for (int i = 0; i < p.length; i++) {
            petAdoptionList.get(i).setPrice(p[i]);
        }
        System.out.println("------------------------");
        System.out.println("For adoption: ");
        System.out.println("------------------------");
        for (Pet ap : petAdoptionList) {
            System.out.println("Name: " + ap.getName() + " Price:" + ap.getPrice());
        }
    }
    
    //prints all pets on the adoptionList
    public void printAdoptionDrive(){
        for (Pet pt : petAdoptionList) {
            System.out.println("Name: " + pt.getName() + " Price: " + pt.getPrice());
        }
    }

    //prints out all of our members with indexes next to each
    public void listOfMembers() {
        for (int i = 0; i < memberList.size(); i++) {
            System.out
                    .println("ID: #" + (i) + memberList.get(i).getMemberID() + " Name: " + memberList.get(i).getName());
        }
    }

    //prints out all of our premium members with indexes next to each
    public void listOfPremiumMembers() {
        for (int i = 0; i < premiumMemberList.size(); i++) {
            System.out.println("ID: #" + (i) + premiumMemberList.get(i).getMemberID() + " Name: "
                    + premiumMemberList.get(i).getName());
        }
    }

    /**
     * 
     * @param id
     * @param name
     * @param breed
     * @param sex
     * @param age
     * @param weight
     * @return whether the premium member has an id or not and the pet has been added
     * allows us to register a premium member dog when registering pets to an owner
     */
    
    public boolean registerPremiumMemberDog(int id, String name, String breed, String sex, int age, int weight) {
        for (PremiumMember pm : premiumMemberList) {
            if (id == pm.getMemberID()) {
                pm.addPet(new Dog(name, breed, sex, age, weight, 0, 0));
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param id
     * @param name
     * @param breed
     * @param sex
     * @param age
     * @param weight
     * @return whether the premium member has an id or not and the pet has been added
     * allows us to register a premium member cat when registering pets to an owner
     */
    
    public boolean registerPremiumMemberCat(int id, String name, String breed, String sex, int age, int weight) {
        for (PremiumMember pm : premiumMemberList) {
            if (id == pm.getMemberID()) {
                pm.addPet(new Cat(name, breed, sex, age, weight, 0, 0));
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param id
     * @param name
     * @param breed
     * @param sex
     * @param age
     * @param weight
     * @return whether the member has an id or not and the pet has been added
     * allows us to register a member cat when registering pets to an owner
     */
    
    public boolean registerMemberCat(int id, String name, String breed, String sex, int age, int weight) {
        for (Member m : memberList) {
            if (id == m.getMemberID()) {
                m.addPet(new Cat(name, breed, sex, age, weight, 0, 0));
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param id
     * @param name
     * @param breed
     * @param sex
     * @param age
     * @param weight
     * @return whether the premium member has an id or not and the pet has been added
     * allows us to register a premium member exotic pet when registering pets to an owner
     */
    
    public boolean registerPremiumMemberExoticPet(int id, String name, String breed, String sex, int age, int weight) {
        for (PremiumMember pm : premiumMemberList) {
            if (id == pm.getMemberID()) {
                pm.addPet(new ExoticPet(name, breed, sex, age, weight, 0, 0));
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param id
     * @param name
     * @param breed
     * @param sex
     * @param age
     * @param weight
     * @return whether the member has an id or not and the pet has been added
     * allows us to register a member dog when registering pets to an owner
     */
    
    public boolean registerMemberDog(int id, String name, String breed, String sex, int age, int weight) {
        for (Member m : memberList) {
            if (id == m.getMemberID()) {
                m.addPet(new Dog(name, breed, sex, age, weight, 0, 0));
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param id
     * @param name
     * @param breed
     * @param sex
     * @param age
     * @param weight
     * @return whether the member has an id or not and the pet has been added
     * allows us to register a member exotic pet when registering pets to an owner
     */
    
    public boolean registerMemberExoticPet(int id, String name, String species, String sex, int age, int weight) {
        for (Member m : memberList) {
            if (id == m.getMemberID()) {
                m.addPet(new ExoticPet(name, species, sex, age, weight, 0, 0));
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param name
     * @return whethere the name is a valid member
     * this will take in a member name and compares it to all names
     * in the member list and if it is in the list it will 
     * return the index of where at in the list
     */
    
    public boolean isMember(String name) {
        for (Member member : memberList) {
            if (member.getName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    /**
     * 
     * @param name
     * @return where the name is a valid premium member
     * this will take in a premium member name and compares it to all names
     * in the member list and if it is in the list it will 
     * return the index of where at in the list
     */
    
    public boolean isPremiumMember(String name) {
        for (PremiumMember member : premiumMemberList) {
            if (member.getName().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    /**
     * 
     * @param id
     * @return the pet object of the ID of the pet
     * this takes in a pet ID and returns the index of that pet
     */

    public int getPet(int id) {
        for (Pet pett : availablePets) {
            if (pett.getID() == id) {
                return availablePets.indexOf(pett);
            }
        }
        return -1;
    }

    //prints all pets from the availablePets list 
    //and will print the index next to them
    public void printPets() {
        int i = 0;
        for (Pet pett : availablePets) {
            System.out.println(i + ". " + pett.getName());
            i += 1;
        }
    }


    /**
     * 
     * @param name
     * @return the index of a member
     * get the index of a member when you put in there name
     */

    public int getMember(String name) {
        for (Member m : memberList) {
            if (m.getName().equalsIgnoreCase(name)) {
                return memberList.indexOf(m);
            }
        }
        return -1;
    }

    /**
     * 
     * @param name
     * @return the index of a premium member
     * get the index of a premium member when you put in there name
     */

    public int getPremiumMember(String name) {
        for (PremiumMember m : premiumMemberList) {
            if (m.getName().equalsIgnoreCase(name)) {
                return premiumMemberList.indexOf(m);
            }
        }
        return -1;
    }

    /**
     * 
     * @param petIndex
     * @param memberIndex
     * allows us to purchase a pet as a member and will remove the pet from 
     * the available pets list while adding the pet to the members owned pets
     * and displaying a total for the user
     */

    public void purchase(int petIndex, int memberIndex) {

        memberList.get(memberIndex).addPet(availablePets.get(petIndex));
        System.out.println("Your total is $" + availablePets.get(petIndex).getPrice());
        System.out.println("Thank you for shopping with us!");
        availablePets.remove(petIndex);

    }
    
    /**
     * 
     * @param petIndex
     * @param memberIndex
     * allows us to purchase a pet as a premium member and will remove the pet from 
     * the available pets list while adding the pet to the members owned pets
     * and displaying a total for the user
     */
    
    public void premiumPurchase(int petIndex, int memberIndex) {
            
            premiumMemberList.get(memberIndex).addPet(availablePets.get(petIndex));
            System.out.println("Your total is $" + ((availablePets.get(petIndex).getPrice())/100)*95);
            System.out.println("Thank you for shopping with us!");
            availablePets.remove(petIndex);

        }

        /**
         * 
         * @param petStore
         * @param scnr
         * @return whethther the user is a premium member or not
         * allows us to register a new member as a premium member or a member
         */

        public boolean registerNewMember(PetStore petStore, Scanner scnr) {
            // prompt user to select membership type
            System.out.println("Let's get you registered as a new Member!");
            System.out.println("Would you like to register as a free-tier or premium member?");
            System.out.println("\t1. Free-tier");
            System.out.println("\t2. Premium");

            // user selection
            int choice1 = scnr.nextInt();
            // if user selects a wrong choice 
            if (choice1 > 2 || choice1 < 1) {
                System.out.println("Invalid choice.");
                registerNewMember(petStore, scnr); // try again

            } else {
                // prompt user for name 
                System.out.println("Please enter your name:");
                scnr.nextLine();
                String name = scnr.nextLine();
                System.out.println("Welcome to our membership program! Thank you for registering.");
                if (choice1 == 1) { // regular membership
                    petStore.addNewMember(name, false);
                    return false;
                } else { // user entered 2 - premimum membership
                    petStore.addNewMember(name, true);
                    return true;
                }
            }
            return false;
        }

}
