package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;
import java.util.ArrayList;


public class InsuranceSystem {  

  ArrayList<Profile> profiles = new ArrayList<Profile>();

  public InsuranceSystem() {
    // Only this constructor can be used (if you need to initialise fields).

  //ArrayList<String> profiles = new ArrayList<String>();
  }

  public void printDatabase() {
     
    //find the number of profiles in the database and convert this to a string
    int dbLength = profiles.size();
    String dbLength_string = Integer.toString(dbLength);

    if (dbLength == 0) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage("0", "s", ".");

    } else if(dbLength == 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(dbLength_string, ":", " ");

    } else if (dbLength > 1) {
      MessageCli.PRINT_DB_POLICY_COUNT.printMessage(dbLength_string, "s", ":");
    }

    for (Profile profile : profiles) {

      //find the index of the particular profile
      int index = profiles.indexOf(profile) + 1;
      String index_String = Integer.toString(index);

      //now print profile information message    
      String userName = profile.getUsername();
      String age = profile.getAge();

      MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(index_String, userName, age);
/*       
      
    }*/
  }

}
  public String getLength (Profile database){
      // this method will find the number of profiles in the database

      return "";
    }

  public String getIndex (Profile database){
    // this method will return the rank of each profile in the data base
  
    return "";
  }  

  public boolean checkName (String userName){
    // this method will check that the given username is longer than 3 characters, unique

    //first check that the username is longer than 3 characters
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      return false;
    }

    //next check that the username is unique
    if (profiles.size() > 0){
      for (Profile profile : profiles) {
        if (profile.getUsername() == userName) {
          MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
          return false;
        }
      }
    }
    // if the user name meets both criteria, return true.
    return true;
    
  
  }

  public boolean checkAge (String age, String userName){
    //this method will check that the age is an positve integer.if it is valid, it will return true.

    int ageInteger = Integer.valueOf(age);

    if (ageInteger < 0){
      MessageCli.INVALID_AGE.printMessage(age, userName);
      return false;

    }

    return true;
  }

  public String tidyTitlecase (String userName){
    // this method will convert the input name to titlecase and return this
    String tidyUserName = userName.toLowerCase();
    char firstLetter = tidyUserName.charAt(0);
    String firstLetterString = Character.toString(firstLetter);
    String firstLetterStringCapital = firstLetterString.toUpperCase();
    tidyUserName = tidyUserName.replaceFirst(firstLetterString, firstLetterStringCapital );
    
    return tidyUserName; 
  }


  

  public void createNewProfile(String userName, String age) {

    //convert username to title case
    userName = tidyTitlecase(userName);
     

    //check that the userName meets the check conditions:
    //must be unique, must be at least 3 chars long, must be only a single word, process using title case
    //age should be a positive integer

    //if username meets these requirements, then create the new profile and add to the database.
    if ((checkName(userName) == true) && (checkAge(age, userName) == true)){
      Profile username = new Profile(userName, age);

      profiles.add(username);
      
      MessageCli.PROFILE_CREATED.printMessage(userName,age);

    }
    
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
