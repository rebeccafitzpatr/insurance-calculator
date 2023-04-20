package nz.ac.auckland.se281;

public abstract class Policy {
    protected int sumInsured;
    protected Profile profile;
    protected int discountPremium;
    protected int totalPremium;

    public Policy(int sumInsured, Profile profile) {
        this.sumInsured = sumInsured;
        this.profile = profile;

    }

    public Profile getProfile() {
        //this method will return a reference to the profile that it is associated with.
        return this.profile;
    }

    public abstract void printPolicy(int totalPremium);
    

    public int discountPremium(Profile userName, int totalPremium) {
        //this method will calculate the discounted premium for the user.

        
        if (userName.getNumberOfPolicies() == 2){
            discountPremium = totalPremium * 9 / 10;            
        } else if (userName.getNumberOfPolicies() >= 3){
            discountPremium = totalPremium * 8 / 10;
        } else{
            discountPremium = totalPremium;
        }
        return discountPremium;

    }

    public int getSumInsured() {
        return this.sumInsured;
    }


}


