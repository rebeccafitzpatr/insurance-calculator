package nz.ac.auckland.se281;

public class HomePolicy extends Policy {
    private String address;
    private boolean rental;
    private int basePremium;

    public HomePolicy(Profile profile, int sumInsured, String address, boolean rental) {
        //initialise variables
        super(sumInsured, profile);
        this.address = address;
        this.rental = rental;

    }
    
    public int HomeBasePremium(boolean rental){
        //if the property is a rental, the base premium is 2% of the sum insured, if not it is 1% of the base premium.

        if (rental == true) {
            basePremium = 2 / 100 * sumInsured;  
        } else {
            basePremium = sumInsured/100;
        }
        return basePremium;
    }
}
