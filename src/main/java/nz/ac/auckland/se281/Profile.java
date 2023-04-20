package nz.ac.auckland.se281;

public class Profile{
    private String username;
    private String age;
    private boolean profileLoaded;
    private int numberOfPolicies = 0;
    private int totalPremium = 0;

    public Profile(String username, String age){

        this.username = username;
        this.age = age;
        profileLoaded = false;
    }


    public String getUsername() {
        return this.username;

    }

    public String getAge(){
        return this.age;
    }

    public void setProfileLoad(){
        //if profile is currently unloaded, then load it, if it is loaded, then unload it
        if (this.profileLoaded == false) {
            this.profileLoaded = true;
            return;

        }
    }
    
    public void setProfileUnload(){
        if (this.profileLoaded == true){
            this.profileLoaded = false;
            return;
        }

    }
    

    public boolean getProfileLoadStatus(){
        return profileLoaded;
    } 

    public void setincreaseNumberOfPolicies(){
        this.numberOfPolicies = this.numberOfPolicies + 1;

    }

    public int getNumberOfPolicies(){
        return numberOfPolicies;
    }

    public void setTotalPremium(int addition){
        totalPremium = totalPremium + addition;
    }

    public int getTotalPremium(){
        return this.totalPremium;
    }
    
    
}