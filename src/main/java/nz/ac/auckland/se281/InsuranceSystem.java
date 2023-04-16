package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;
import java.util.ArrayList;

import org.eclipse.jgit.transport.UserAgent;


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
      boolean profileLoaded = profile.getProfileLoadStatus();

      if (profileLoaded == true){
        MessageCli.PRINT_DB_PROFILE_HEADER_SHORT.printMessage("*** ", index_String, userName, age);
      }else {
        MessageCli.PRINT_DB_PROFILE_HEADER_MINIMAL.printMessage(index_String, userName, age);

      }

    }

  }


  public boolean checkNameLength (String userName){
    // this method will check that the given username is longer than 3 characters, unique

    //first check that the username is not shorter than 3 characters
    if (userName.length() < 3) {
      MessageCli.INVALID_USERNAME_TOO_SHORT.printMessage(userName);
      return false;
    }

    // then return true
    return true;   
  }

  public boolean checkNameUnique (String userName){

    //next check that the username is unique
    if (profiles.size() > 0){
      for (Profile profile : profiles) {
        if (profile.getUsername().equals(userName)) {
          MessageCli.INVALID_USERNAME_NOT_UNIQUE.printMessage(userName);
          return false;
        }
      }
    }
    // if the user name is unique, return true.
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

    //then check that no profile is loaded currently

    for (Profile profile : profiles){
      if (profile.getProfileLoadStatus() == true){
        MessageCli.CANNOT_CREATE_WHILE_LOADED.printMessage(profile.getUsername());
        return;
      }
    }
     

    //check that the userName meets the check conditions:
    //must be unique, must be at least 3 chars long, must be only a single word, process using title case
    //age should be a positive integer

    //if username meets these requirements, then create the new profile and add to the database.
    if ((checkNameLength(userName) == true) && (checkAge(age, userName) && (checkNameUnique(userName)) == true)){
      Profile username = new Profile(userName, age);

      profiles.add(username);
      
      MessageCli.PROFILE_CREATED.printMessage(userName,age);

    }
    
    }

  public void loadProfile(String userName) {
    // TODO: Complete this method.

    userName = tidyTitlecase(userName);


    //check that a profile with that username is in the database

      if (checkNameUnique(userName) == false ){

        //then find the profile and load it, then return the success message
        for (Profile profile : profiles){

          // first unload any currently loaded profiles

          profile.setProfileUnload();

          if (profile.getUsername().equals(userName)){
            profile.setProfileLoad();
            MessageCli.PROFILE_LOADED.printMessage(userName);
          }
        }

        //otherwise print, profile not loaded.
      } else {
        MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);

      }
  }

  public void unloadProfile() {
    // TODO: Complete this method.

    for (Profile profile : profiles) {
      if (profile.getProfileLoadStatus() == true){
        profile.setProfileUnload();
        MessageCli.PROFILE_UNLOADED.printMessage(profile.getUsername());
        return;
      }
    }

    MessageCli.NO_PROFILE_LOADED.printMessage();
    return;
  }

  public void deleteProfile(String userName) {
    // TODO: Complete this method.
  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.
  }
}
