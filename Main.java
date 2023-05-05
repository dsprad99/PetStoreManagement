/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spradlingdavisproject2;
import java.util.*;

/**
 *
 * @author Davis Spradling
 */


public class Main {

    public static void main(String[] args) {
        int choice;
        Scanner scnr = new Scanner(System.in);
        //pet store object created 
        PetStore ps = new PetStore("Insert Petstore name here");
        System.out.println("**** Welcome to " + ps.getStoreName() + "****");
        while (true) {

            System.out.println("Please select from one of the following menu otions");
            System.out.println("\t1. Buy a new pet");
            System.out.println("\t2. Register a new member");
            //allows us to add pets to an adoption drive using the 
            //adoptionDrive method from the petStoreSpecification interface
            System.out.println("\t3. Start adoption drive (add new pets)");
            //allows us to check pets in our inventory by printing out a list
            System.out.println("\t4. Check current inventory");
            //allows us to print out the value of our total pet inventory
            //using the inventoryValue method from the petStoreSpecification interface
            System.out.println("\t5. Check current value of inventory");
            //here we can add a pet to a member object 
            System.out.println("\t6. Register new pet to Owner profile");
            //using the compareTo method and the Comparable interface, allows 
            //us to compare the pets price
            System.out.println("\t7. Compare pets price");
            //these are gonna be pets that were added through our adoption drive
            System.out.println("\t8. Check pets available for adoption");
            System.out.println("\t9. Exit");

            choice = scnr.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("-----------------------------------");
                    System.out.println("What is your name?");
                    String memberName = scnr.next();
                    System.out.println("Are you a premium member?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int memberOption = scnr.nextInt();
                    switch (memberOption) {
                        case 1:
                            //forces user to enter a valid membername 
                            //in order to move on
                            while ((!ps.isPremiumMember(memberName))) {
                                System.out.println("Enter a valid member name");
                                memberName = scnr.next();
                            }
                            int premiumMemberIndex = ps.getPremiumMember(memberName);
                            System.out.println("What kind of pet would you like to purchase?");
                            ps.printPets();
                            System.out.println("Please enter the number below of the pet you would like.");
                            int petNumber = scnr.nextInt();
                            //forces user to enter a valid pet number to move on
                            while (petNumber < 0 || petNumber > ps.availablePets.size()) {
                                System.out.println("Please enter a valid number");
                                petNumber = scnr.nextInt();
                            }
                            ps.premiumPurchase(petNumber,premiumMemberIndex);
                            break;

                        case 2:
                            while ((!ps.isMember(memberName))) {
                                System.out.println("Enter a valid member name");
                                memberName = scnr.next();
                            }
                            int memberIndex = ps.getMember(memberName);
                            System.out.println("What kind of pet would you like to purchase?");
                            ps.printPets();
                            System.out.println("Please enter the number below of the pet you would like.");
                            petNumber = scnr.nextInt();
                            while (petNumber < 0 || petNumber > ps.availablePets.size()) {
                                System.out.println("Please enter a valid number");
                                petNumber = scnr.nextInt();
                            }
                            ps.purchase(petNumber, memberIndex);
                            break;
                            
                    }

                    break;
                case 2:
                    System.out.println("-----------------------------------");
                    ps.registerNewMember(ps, scnr);
                    break;
                case 3:
                    System.out.println("How many pets would you like to add to the adoption drive?");
                    int amountPets = scnr.nextInt();
                    //we pass both the adoptionDrivePrice and adoptionDrivePets into the adoptionDrive method
                    //as they both corelate together and will have the same index so a user can add the index of
                    //the pet they would like to pull out from available pets and enter the price of that pet
                    //into the new array so they can be called from the same index of the petAdoptionList
                    double adoptionDrivePrice[] = new double[amountPets];
                    ArrayList<Pet> adoptionDrivePets = new ArrayList();
                    for (int i = 0; i < adoptionDrivePrice.length; i++) {
                        ps.printPets();
                        System.out.println("Which pet number do you want to add for adoption?");
                        int addAdoptionPetIndex = scnr.nextInt();
                        System.out.println("How much would you like to list this pet for adoption?");
                        int adoptionPetPrice = scnr.nextInt();
                        adoptionDrivePets.add(ps.availablePets.get(addAdoptionPetIndex));
                        adoptionDrivePrice[i] = adoptionPetPrice;
                        ps.availablePets.remove(addAdoptionPetIndex);
                    }
                    //pass in methods here?
                    ps.adoptionDrive(adoptionDrivePets, adoptionDrivePrice);
                    break;
                case 4:
                    //prints all of the pets in the specified category the user chooses
                    System.out.println("What would you like to check the inventory of?");
                    System.out.println("1. Dog");
                    System.out.println("2. Cat");
                    System.out.println("3. Exotic Pet");
                    int answer = scnr.nextInt();
                    switch(answer){
                        case 1:
                            ps.dogInventoryList();
                            break;
                        case 2:
                            ps.catInventoryList();
                            break;
                        case 3:
                            ps.exoticPetInventoryList();
                            break;
                    }
                    break;
                case 5:
                    //checks the inventory value of either a specific pet or all of them
                    System.out.println("What would you like to check the inventory value of?");
                    System.out.println("1. Dog");
                    System.out.println("2. Cat");
                    System.out.println("3. Exotic Pet");
                    System.out.println("4. All inventory");
                    int answer2 = scnr.nextInt();
                    switch(answer2){
                        case 1:
                            System.out.println("Dog inventory value: $"+ps.dogInventoryValue());
                            break;
                        case 2:
                            System.out.println("Cat inventory value: $"+ps.catInventoryValue());
                            break;
                        case 3:
                            System.out.println("Exotic Pet inventory value: $"+ps.exoticPetInventoryValue());
                            break;
                        case 4:
                            //this was required method we had to implement from the petStoreSpecification interface
                            System.out.println("Total pet inventory value: $"+ps.inventoryValue());
                            break;
                    }
                    break;

                case 6:
                    //breaks down by asking the user what kind of pet they have and then based on that it will
                    //it will ask if they are a premium member and then ask for which member they are by giving them
                    //a number next to each option based off this it knows the index of where to add a pet to what member
                    System.out.println("What kind of pet would you like to add to your profile?");
                    System.out.println("1. Dog");
                    System.out.println("2. Cat");
                    System.out.println("3. Exotic Pet");
                    int petType = scnr.nextInt();

                    switch(petType){
                        case 1:
                            System.out.println("Are you a premium member?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int answer12 = scnr.nextInt();
                            switch(answer12){
                                case 1:
                                    ps.listOfPremiumMembers();
                                    System.out.println("Which premium member are you? EnterID:");
                                    int answer13 = scnr.nextInt();
                                    System.out.println("What is the dogs name?");
                                    String name = scnr.next();
                                    System.out.println("What is the dogs age?");
                                    int age = scnr.nextInt();
                                    System.out.println("What is the dogs weight?");
                                    int weight = scnr.nextInt();
                                    System.out.println("What is the dogs sex?");
                                    String sex = scnr.next();
                                    System.out.println("What is the dogs breed?");
                                    String breed = scnr.next();
                                    
                                    if(ps.registerPremiumMemberDog(answer13,name, breed,sex,age,weight)==true){
                                        System.out.println("Success your pet has been added!");
                                    }
                                    else{
                                        System.out.println("Your pet was not registered, invalid ID");
                                    }
                                    break;
        
                                case 2:
                                    ps.listOfMembers();
                                    System.out.println("Which member are you? Enter ID:");
                                    int answer14 = scnr.nextInt();
                                    System.out.println("What is the dogs name?");
                                    String name1 = scnr.next();
                                    System.out.println("What is the dogs age?");
                                    int age1 = scnr.nextInt();
                                    System.out.println("What is the dogs weight?");
                                    int weight1 = scnr.nextInt();
                                    System.out.println("What is the dogs sex?");
                                    String sex1 = scnr.next();
                                    System.out.println("What is the dogs breed?");
                                    String breed1 = scnr.next();
                                    
                                    if(ps.registerMemberDog(answer14,name1, breed1,sex1,age1,weight1)==true){
                                        System.out.println("Success your pet has been added!");
                                    }
                                    else{
                                        System.out.println("Your pet was not registered, invalid ID");
                                    }
                                break;
                                }
                                break;
                        case 2:
                            System.out.println("Are you a premium member?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int answer15 = scnr.nextInt();
                            switch(answer15){
                                case 1:
                                    ps.listOfPremiumMembers();
                                    System.out.println("Which premium member are you? Enter ID:");
                                    int answer13 = scnr.nextInt();
                                    System.out.println("What is the cats name?");
                                    String name = scnr.next();
                                    System.out.println("What is the cats age?");
                                    int age = scnr.nextInt();
                                    System.out.println("What is the cats weight?");
                                    int weight = scnr.nextInt();
                                    System.out.println("What is the cats sex?");
                                    String sex = scnr.next();
                                    System.out.println("What is the cats breed?");
                                    String breed = scnr.next();
                                    
                                    if(ps.registerPremiumMemberCat(answer13,name, breed,sex,age,weight)==true){
                                        System.out.println("Success your pet has been added!");
                                    }
                                    else{
                                        System.out.println("Your pet was not registered, invalid ID");
                                    }
                                    break;
        
                                case 2:
                                    ps.listOfMembers();
                                    System.out.println("Which member are you? Enter ID:");
                                    int answer14 = scnr.nextInt();
                                    System.out.println("What is the cats name?");
                                    String name1 = scnr.next();
                                    System.out.println("What is the cats age?");
                                    int age1 = scnr.nextInt();
                                    System.out.println("What is the cats weight?");
                                    int weight1 = scnr.nextInt();
                                    System.out.println("What is the cats sex?");
                                    String sex1 = scnr.next();
                                    System.out.println("What is the cats breed?");
                                    String breed1 = scnr.next();
                                    
                                    if(ps.registerMemberCat(answer14,name1, breed1,sex1,age1,weight1)==true){
                                        System.out.println("Success your pet has been added!");
                                    }
                                    else{
                                        System.out.println("Your pet was not registered, invalid ID");
                                    }
                                break;
                                }
                                break;
                        
                        case 3:
                            System.out.println("Are you a premium member?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            int answer16 = scnr.nextInt();
                            switch(answer16){
                                case 1:
                                    ps.listOfPremiumMembers();
                                    System.out.println("Which premium member are you? Enter ID:");
                                    int answer13 = scnr.nextInt();
                                    System.out.println("What is the exotic pets name?");
                                    String name = scnr.next();
                                    System.out.println("What is the exotic pets age?");
                                    int age = scnr.nextInt();
                                    System.out.println("What is the exotic pets weight?");
                                    int weight = scnr.nextInt();
                                    System.out.println("What is the exotic pets sex?");
                                    String sex = scnr.next();
                                    System.out.println("What is the exotic pets species?");
                                    String species = scnr.next();
                                    
                                    if(ps.registerPremiumMemberExoticPet(answer13,name, species,sex,age,weight)==true){
                                        System.out.println("Success your pet has been added!");
                                    }
                                    else{
                                        System.out.println("Your pet was not registered, invalid ID");
                                    }
                                    break;
        
                                case 2:
                                    ps.listOfMembers();
                                    System.out.println("Which member are you? Enter ID:");
                                    int answer14 = scnr.nextInt();
                                    System.out.println("What is the exotic pets name?");
                                    String name1 = scnr.next();
                                    System.out.println("What is the exotic pets age?");
                                    int age1 = scnr.nextInt();
                                    System.out.println("What is the exotic pets weight?");
                                    int weight1 = scnr.nextInt();
                                    System.out.println("What is the exotic pets sex?");
                                    String sex1 = scnr.next();
                                    System.out.println("What is the exotic pets breed?");
                                    String breed1 = scnr.next();
                                    
                                    if(ps.registerMemberExoticPet(answer14,name1, breed1,sex1,age1,weight1)==true){
                                        System.out.println("Success your pet has been added!");
                                    }
                                    else{
                                        System.out.println("Your pet was not registered, invalid ID");
                                    }
                                break;
                                }
                                break;
                    }
                    break;

                case 7:
                    //allows a user to compare two pets based of there index with a number beside each
                    //other using the compareTo method from the Comparable interface implemented in the Pet class
                    System.out.println("Pick from the pets you would like to comapre below.");
                    ps.printPets();                    
                    System.out.println("What is the first pet you would like to compare?");
                    int answer11 = scnr.nextInt();
                    //this makes sure a user enters a valid index size within the size of the array list
                    while (answer11 < 0 || answer11 > ps.availablePets.size()) {
                        System.out.println("Please enter a valid value");
                        answer11 = scnr.nextInt();
                    }
                    System.out.println("What is the second pet you would like to compare?");
                    int answer17 = scnr.nextInt();
                    while (answer17 < 0 || answer17 > ps.availablePets.size()) {
                        System.out.println("Please enter a valid value");
                        answer17 = scnr.nextInt();
                    }
                    ps.availablePets.get(answer11).compareTo(ps.availablePets.get(answer17));
    
                    break;
                    
                //this will print all the dogs on the adoption list
                case 8:
                    System.out.println("-----------------------------------");
                    ps.printAdoptionDrive();
                    break;
                
                case 9:
                    System.out.println("Thanks for visiting!");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

}
