package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.PolicyType;
import java.util.ArrayList;


public class InsuranceSystem {  

  ArrayList<Profile> profiles = new ArrayList<Profile>();

  ArrayList<Policy> policies = new ArrayList<Policy>();

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
      String age = profile.getAgeString();
      boolean profileLoaded = profile.getProfileLoadStatus();
      int numberOfPolicies = profile.getNumberOfPolicies();
      profile.setTotalPremium(policies);

      //change the spelling of policies depending on the number.
      if (numberOfPolicies == 1){  
        if (profileLoaded == true){
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("*** ", index_String, userName, age, String.valueOf(numberOfPolicies), "y", String.valueOf(profile.getTotalPremium()) );
        }else {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("", index_String, userName, age, String.valueOf(numberOfPolicies), "y", String.valueOf(profile.getTotalPremium()) );
        }
      } else {
        if (profileLoaded == true){
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("*** ", index_String, userName, age, String.valueOf(numberOfPolicies) ,"ies", String.valueOf(profile.getTotalPremium())  );
        }else {
          MessageCli.PRINT_DB_PROFILE_HEADER_LONG.printMessage("", index_String, userName, age, String.valueOf(numberOfPolicies) ,"ies", String.valueOf(profile.getTotalPremium()) );
        }
      }
      //print out all of the policies associated with the profile
      for (Policy policy : policies) {
        if (policy.getProfile() == profile ){

          if (policy instanceof HomePolicy) {
            HomePolicy homePolicy = (HomePolicy) policy;
            //profile.setTotalPremium(homePolicy.HomeBasePremium(homePolicy.getRentalStatus(), homePolicy.getSumInsured()));
            homePolicy.printPolicy(profile.getTotalPremium());
          } else if (policy instanceof CarPolicy) {
            CarPolicy carPolicy = (CarPolicy) policy;
            //profile.setTotalPremium(carPolicy.CarBasePremium(profile, carPolicy.getSumInsured()));
            carPolicy.printPolicy(profile.getTotalPremium());

          } else if (policy instanceof LifePolicy) {
            LifePolicy lifePolicy = (LifePolicy) policy;
            //profile.setTotalPremium(lifePolicy.LifeBasePremium(profile, lifePolicy.getSumInsured()));
            lifePolicy.printPolicy(profile.getTotalPremium());


          }
        }



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
    userName = tidyTitlecase(userName);

        // first unload any currently loaded profiles

        for (Profile profile : profiles){
          profile.setProfileUnload();
        }
          //if (checkNameUnique(userName) == false ){              

          //then find the profile and load it, then return the success message
            for (Profile profile : profiles){     
              
            //check that a profile with that username is in the database       

              if (profile.getUsername().equals(userName)){
                profile.setProfileLoad();
                MessageCli.PROFILE_LOADED.printMessage(userName);
                return;
              }

            }
        

        //otherwise print, profile not loaded.
          MessageCli.NO_PROFILE_FOUND_TO_LOAD.printMessage(userName);

        return;

      
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

    //convert the username to title case
    userName = tidyTitlecase(userName);

    // check that the profile to delete is in the database
    //if (checkNameUnique(userName) == false) {
      for (Profile profile : profiles) {
        if (profile.getUsername().equals(userName)) {

          int deletingIndex = profiles.indexOf(profile);
          //check that the profile is not currently loaded, if it is currently loaded, give an error message
          if (profile.getProfileLoadStatus() == true) {
            MessageCli.CANNOT_DELETE_PROFILE_WHILE_LOADED.printMessage(userName);
            return;

          } else {
            profiles.remove(deletingIndex);
            MessageCli.PROFILE_DELETED.printMessage(userName);
            return;
          }
        }
      }
    // otherwise there is no profile with the username, so give a error message
      MessageCli.NO_PROFILE_FOUND_TO_DELETE.printMessage(userName);
    



  }

  public void createPolicy(PolicyType type, String[] options) {
    // TODO: Complete this method.

    //home policy
    if (type == PolicyType.HOME) {
      //check that a profile is loaded
      for (Profile profile : profiles) {
        if (profile.getProfileLoadStatus() == true) {

          //if it is create the policy and give success message
          HomePolicy homePolicy = new HomePolicy(profile, Integer.valueOf(options[0]), options[1], convertToBoolean(options[2]));
          MessageCli.NEW_POLICY_CREATED.printMessage("home", profile.getUsername());
          profile.setincreaseNumberOfPolicies();
          policies.add(homePolicy);
          homePolicy.setBasePremium(homePolicy.HomeBasePremium(homePolicy.getRentalStatus(), Integer.valueOf(options[0])));
          //homePolicy.setDiscountPremium(profile.getNumberOfPolicies(), homePolicy.HomeBasePremium(homePolicy.getRentalStatus(), Integer.valueOf(options[0])));



          //add to the total premium
          //profile.setTotalPremium(homePolicy.discountPremium(profile, homePolicy.HomeBasePremium(homePolicy.getRentalStatus(), Integer.valueOf(options[0]))));

          return;          
        }
      }
      
      //if not print error message
      MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();

    } else if (type == PolicyType.CAR) {
        for (Profile profile : profiles) {
          if (profile.getProfileLoadStatus() == true) {

            //if it is create the policy and give success message
            CarPolicy carPolicy = new CarPolicy(profile, Integer.valueOf(options[0]), options[1], options[2],  convertToBoolean(options[3]));
            MessageCli.NEW_POLICY_CREATED.printMessage("car", profile.getUsername());
            profile.setincreaseNumberOfPolicies();
            policies.add(carPolicy);
            carPolicy.setBasePremium(carPolicy.CarBasePremium(profile, Integer.valueOf(options[0])));
            //carPolicy.setDiscountPremium(profile.getNumberOfPolicies(), carPolicy.CarBasePremium(profile, Integer.valueOf(options[0])));
            //profile.setTotalPremium(carPolicy.discountPremium(profile, carPolicy.CarBasePremium(profile, Integer.valueOf(options[0]))));
            return;          
          }

        }
        // if the profile is not loaded, give an error message 

        MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();

  } else if (type == PolicyType.LIFE){
      for (Profile profile : profiles) {
        //check that the profile is loaded
        if (profile.getProfileLoadStatus() == true) {

          //check that this user is below 100 years old.
          if (profile.getAgeInteger() <= 100) {

            //check that the user doesn't already have a life policy.
            if (profile.getLifePolicyStatus() == false){
              //if it is create the policy and give success message
                  LifePolicy lifePolicy = new LifePolicy(profile, Integer.valueOf(options[0]));
                  MessageCli.NEW_POLICY_CREATED.printMessage("life", profile.getUsername());
                  profile.setincreaseNumberOfPolicies();
                  policies.add(lifePolicy);
                  lifePolicy.setDiscountPremium(profile.getNumberOfPolicies(),lifePolicy.LifeBasePremium(profile,Integer.valueOf(options[0])));
                  lifePolicy.setBasePremium(lifePolicy.LifeBasePremium(profile, Integer.valueOf(options[0])));//profile.setTotalPremium(lifePolicy.discountPremium(profile, lifePolicy.LifeBasePremium(profile,Integer.valueOf(options[0]))));
                  //also set that the client now has a life policy 
                  profile.setLifePolicyStatus();

                  return;

            } else {
              //if the user already has a life policy give a error message
              MessageCli.ALREADY_HAS_LIFE_POLICY.printMessage(profile.getUsername());
              return;
            }

          } else {
            // if the user is over 100 years old, give an error message
            MessageCli.OVER_AGE_LIMIT_LIFE_POLICY.printMessage(profile.getUsername());
            return;
          }
                    
        }

        // if the profile is not loaded, give an error message 
        MessageCli.NO_PROFILE_FOUND_TO_CREATE_POLICY.printMessage();

      }
    
  }


  }

  public boolean convertToBoolean(String input) {
    //this method will convert the users string input into a boolean true or false
    if (input.equals("yes")) {
      return true;

    }else {
      return false;

    }
    }
  }

