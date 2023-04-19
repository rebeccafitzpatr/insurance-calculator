package nz.ac.auckland.se281;

public class HomePolicy extends Policy {
    String address;
    boolean rental;

    public HomePolicy(int sumInsured, String address, boolean rental) {
        super(sumInsured);

    }
    
    public int HomeBasePremium(boolean rental){
        //if the property is a rental, the base premium is 2% of the sum insured, if not it is 1% of the base premium.
        return 0;
    }
}
