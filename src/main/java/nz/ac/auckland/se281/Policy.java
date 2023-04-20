package nz.ac.auckland.se281;

public abstract class Policy {
    protected int sumInsured;
    protected Profile profile;
    protected int discountPremium;

    public Policy(int sumInsured, Profile profile) {
        this.sumInsured = sumInsured;
        this.profile = profile;

    }

    public Profile getProfile() {
        //this method will return a reference to the profile that it is associated with.
        return this.profile;
    }

    public abstract void printPolicy();
    

    public int discountPremium(String userName) {
        return discountPremium;

    }


}


