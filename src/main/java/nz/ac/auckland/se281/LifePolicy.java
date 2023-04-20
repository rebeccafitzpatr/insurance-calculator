package nz.ac.auckland.se281;

public class LifePolicy extends Policy {
    private int basePremium;

    public LifePolicy(int sumInsured, Profile profile) {
        super(sumInsured, profile);
        //TODO Auto-generated constructor stub
    }
    

    @Override
    public void printPolicy() {
        

        MessageCli.PRINT_DB_LIFE_POLICY.printMessage(String.valueOf(sumInsured), String.valueOf(basePremium), String.valueOf(discountPremium));
    }
}
