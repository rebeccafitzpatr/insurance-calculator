package nz.ac.auckland.se281;

public abstract class Policy {
    protected int sumInsured;
    protected Profile profile;
    protected int discountPremium;
    protected int basePremium;

    public Policy(int sumInsured, Profile profile) {
        this.sumInsured = sumInsured;
        this.profile = profile;

    }

    public Profile getProfile() {
        //this method will return a reference to the profile that it is associated with.
        return this.profile;
    }

    public abstract void printPolicy(int basePremium);
    

    public int discountPremium(Profile profile, int basePremium) {
        //this method will calculate the discounted premium for the user.

        
        if (profile.getNumberOfPolicies() == 2){
            discountPremium = basePremium * 9 / 10;            
        } else if (profile.getNumberOfPolicies() >= 3){
            discountPremium = basePremium * 8 / 10;
        } else{
            discountPremium = basePremium;
        }
        return discountPremium;

    }

    public int getSumInsured() {
        return this.sumInsured;
    }


}


