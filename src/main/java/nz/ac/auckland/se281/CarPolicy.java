package nz.ac.auckland.se281;

public class CarPolicy extends Policy {
    private String model;
    private int basePremium;



    public CarPolicy(int sumInsured, Profile profile) {
        super(sumInsured, profile);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public void printPolicy() {
        

        MessageCli.PRINT_DB_CAR_POLICY.printMessage(model, String.valueOf(sumInsured), String.valueOf(basePremium), String.valueOf(discountPremium));
    }
}
