package nz.ac.auckland.se281;

public class HomePolicy extends Policy {
  private String address;
  private int basePremium;
  private boolean rental;

  public HomePolicy(Profile profile, int sumInsured, String address, boolean rental) {
    //initialise variables
    super(sumInsured, profile);
    this.address = address;
    this.rental = rental;

  }
  
  public int homeBasePremium(boolean rental, int sumInsured) {
    //if the property is a rental, the base premium is 2% of the sum insured,
    //if not it is 1% of the base premium.

    if (rental == true) {
      basePremium = (2 * sumInsured / 100);  
    } else {
      basePremium = (sumInsured / 100);
    }
    return basePremium;
  }

  public boolean getRentalStatus() {
    return this.rental;
  }

  @Override
  public void printPolicy(int totalPremium) {
    MessageCli.PRINT_DB_HOME_POLICY.printMessage(
        this.address, String.valueOf(this.sumInsured),
            String.valueOf(homeBasePremium(rental, this.sumInsured)),
            String.valueOf(discountPremium(profile, basePremium)));
  }
}
