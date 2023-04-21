package nz.ac.auckland.se281;

public class LifePolicy extends Policy {
    private int basePremium;

    public LifePolicy( Profile profile, int sumInsured) {
        super(sumInsured, profile);
        //TODO Auto-generated constructor stub
    }

    public int LifeBasePremium(Profile profile, int sumInsured) {
        //base premium = (1 + age/100)% of suminsured
        basePremium = (sumInsured + sumInsured * profile.getAgeInteger() /100)/100; 
        return basePremium;
    }
    

    @Override
    public void printPolicy(int totalPremium) {
        

        MessageCli.PRINT_DB_LIFE_POLICY.printMessage(String.valueOf(sumInsured), String.valueOf(LifeBasePremium(profile, this.sumInsured)), String.valueOf(discountPremium(profile, basePremium)));
    }
}
