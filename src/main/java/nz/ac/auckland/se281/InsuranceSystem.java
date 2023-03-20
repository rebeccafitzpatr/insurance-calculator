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
    

    //find the number of profiles in the database and convert this to a string
    int dbLength = profiles.size();
    String dbLength_string = Integer.toString(dbLength);


    if (dbLength ==1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(dbLength_string, ":", " ");
    }

    if (dbLength >1){
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(dbLength_string, "s", ":");
    }

    for (String profile :profiles) {

      //find the index of the particular profile
      int index = profiles.indexOf(profile) + 1;
      String index_String = Integer.toString(index);

      String[] entries= profile.split(";");

      //now print profile information
      //change the message slightly depending on how many profiles there are
     
      //MessageCli.PRINT_DB_POLICY_COUNT.printMessage(dbLength_string, ":", " ");
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(index_String, entries[0], entries[1]);
      //MessageCli.PROFILE_CREATED.printMessage(entries[0],entries[1]);
      
    }
  }//System.out.println(String userName);



  

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.

    
    //* *//

    //check that the userName meets the check conditions:



    //make an array list to store the profile information
    //store each profiles information as a string separated by a; semicolon
    
    String profileEntry = userName + ";" + age;
    
    profiles.add(profileEntry);

    
    MessageCli.PROFILE_CREATED.printMessage(userName,age);
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
