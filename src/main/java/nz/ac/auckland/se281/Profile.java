package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Profile {
  private String username;
  private String age;
  private boolean profileLoaded;
  private int numberOfPolicies = 0;
  private int totalPremium = 0;
  private boolean lifePolicyStatus = false;

  public Profile(String username, String age) {

    this.username = username;
    this.age = age;
    profileLoaded = false;
  }


  public String getUsername() {
    return this.username;

  }

  public String getAgeString() {
    return this.age;
  }

  public int getAgeInteger() {
    return Integer.valueOf(this.age);
  }

  public void setProfileLoad() {
    //if profile is currently unloaded, then load it, if it is loaded, then unload it
    if (this.profileLoaded == false) {
      this.profileLoaded = true;
      return;

    }
  }
    
  public void setProfileUnload() {
    if (this.profileLoaded == true) {
      this.profileLoaded = false;
      return;
    }

  }
    

  public boolean getProfileLoadStatus() {
    return profileLoaded;
  } 

  public void setincreaseNumberOfPolicies() {
    this.numberOfPolicies = this.numberOfPolicies + 1;

  }

  public int getNumberOfPolicies() {
    return numberOfPolicies;
  }

  public void setTotalPremium(ArrayList<Policy> policies) {
    for (Policy policy : policies) {
      // look at every policy, and if each profile, calculate the total premium
      //calculate this by adding all discount premiums that the user has
      if (policy.getProfile().getUsername() == this.username) {
        this.totalPremium = this.totalPremium + policy.setDiscountPremium(this.numberOfPolicies, policy.getBasePremium());
      }
    }
  }

  public int getTotalPremium() {
    return this.totalPremium;
  }

  public void setLifePolicyStatus() {
    this.lifePolicyStatus = true;
  }

  public boolean getLifePolicyStatus() {
    return this.lifePolicyStatus;
  }


}