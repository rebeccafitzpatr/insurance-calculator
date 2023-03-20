package nz.ac.auckland.se281;


import nz.ac.auckland.se281.Main.PolicyType;

import java.util.ArrayList;

public class InsuranceSystem {  

  ArrayList<String> profiles = new ArrayList<String>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

  //ArrayList<String> profiles = new ArrayList<String>();
  }

  public void printDatabase() {
    // TODO: Complete this method.

    //System.out.println("Database has 0 profiles.");
    
    if (profiles.size() == 0){
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    }

    for (String profile :profiles) {

      String[] entries= profile.split(";");

      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("1", ".", " ");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage("%s: %s, %s", "1", entries[0], entries[1]);
      
    }
  }//System.out.println(String userName);



  

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.

    
    //* *//
    //make an array list to store the profile information
    //store each profiles information as a string separated by a; semicolon
    //ArrayList<String> profiles = new ArrayList<String>();
    String profileEntry = userName + ";" + age;

    //String profile = "profile";

    //System.out.println(profileEntry);

    
    profiles.add(profileEntry);

    //System.out.println(profiles);

    //* */

  }

  public void loadProfile(String userName) {
    // TODO: Complete this method.
  }

  public void unloadProfile() {
    // TODO: Complete this method.
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
