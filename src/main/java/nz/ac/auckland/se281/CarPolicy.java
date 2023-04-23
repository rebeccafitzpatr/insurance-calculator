package nz.ac.auckland.se281;

public class CarPolicy extends Policy {
  private String model;
  private int basePremium;
  private String licencePlate;
  private Boolean mechanicalBreakdown;

  public CarPolicy(Profile profile
      , int sumInsured, String model
      , String licencePlate, Boolean mechanicalBreakdown) {

    super(sumInsured, profile);
    this.model = model;
    this.licencePlate = licencePlate;
    this.mechanicalBreakdown = mechanicalBreakdown;

  }

  public int carBasePremium(Profile profile, int sumInsured) {

    //this method will calculate the base premium for the car policy, d
    //dependant on the clients age and mechanical breakdown status.
    if (profile.getAgeInteger() < 25) {
      // if clients age is less than 25, base premium is 15% of suminsured
      basePremium = (15 * sumInsured / 100);  
    } else {
      // if clients age is greater than 25, base premium is 10% of sum insures
      basePremium = (10 * sumInsured / 100);
    }

    if (this.mechanicalBreakdown == true) {
      // if the car is to be covered for breakdown, reduce the premium further
      basePremium = basePremium + 80;
    }
    return basePremium;
  }
  
  @Override
  public void printPolicy(int totalPremium) {
    MessageCli.PRINT_DB_CAR_POLICY.printMessage(this.model, String.valueOf(this.sumInsured), 
        String.valueOf(carBasePremium(profile, this.sumInsured)), 
        String.valueOf(discountPremium(profile, basePremium)));
  }
}
