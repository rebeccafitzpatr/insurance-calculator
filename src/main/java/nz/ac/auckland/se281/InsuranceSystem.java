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
    
    if (profiles.size() == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");
    }
    

    //find the number of profiles in the database and convert this to a string
    int dbLength = profiles.size();
    String dbLength_string = Integer.toString(dbLength);


    if (dbLength == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(dbLength_string, ":", " ");
    }

    if (dbLength > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(dbLength_string, "s", ":");
    }

    for (String profile : profiles) {

      //find the index of the particular profile
      int index = profiles.indexOf(profile) + 1;
      String index_String = Integer.toString(index);

      String[] entries = profile.split(";");

      

      //now print profile information
      
     
      
      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(index_String, entries[0], entries[1]);
      
      
    }
  }



  

  public void createNewProfile(String userName, String age) {
    // TODO: Complete this method.

    
    //* *//

    //check that the userName meets the check conditions:
    //* must be unique, must be at least 3 chars long, must be only a single word, process using title case */
    //age should be a positive integer

    //first tidy the User's name so that it has title case.
    String tidyUserName = userName.toLowerCase();
    
    char firstLetter = tidyUserName.charAt(0);
    String firstLetterString = Character.toString(firstLetter);
    String firstLetterStringCapital = firstLetterString.toUpperCase();
    tidyUserName = tidyUserName.replaceFirst(firstLetterString, firstLetterStringCapital );
    

   // check if the username is long enough
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(tidyUserName);
      return;

    // check there is no duplicate of user names
    }else if(profiles.isEmpty() == false){

      for (String profile:profiles) {
        String[] entries= profile.split(";");
        
        //check that the user name is unique
      
        
        if (tidyUserName.equals(entries[0])) {
          System.out.println(entries[0]);
          MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(tidyUserName);

          return;
        
        }
      }
    }


    //check that the age input is a positive number

    int ageInteger = Integer.valueOf(age);

    if (ageInteger < 0){
      MessageCli.INVALID_AGE.printMessage(age, tidyUserName);
      return;
    }


      
    //make an array list to store the profile information
    //store each profiles information as a string separated by a; semicolon
    
    String profileEntry = tidyUserName + ";" + age;
    
    profiles.add(profileEntry);

    MessageCli.PROFILE_CREATED.printMessage(tidyUserName,age);
    
    //userNameArray[0] = (userNameArray[0]).toUpperCase()

    

    
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
