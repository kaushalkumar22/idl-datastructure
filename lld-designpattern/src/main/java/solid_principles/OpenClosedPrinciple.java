package solid_principles;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        InsurancePremiumCalculator calculator = new InsurancePremiumCalculator();
        UserProfile userProfile = new HealthInsuranceUserProfile();
        System.out.println(calculator.calculateInsurancePremiumDiscount(userProfile));
    }
}

class InsurancePremiumCalculator{
    public int calculateInsurancePremiumDiscount(UserProfile userProfile){
        if(userProfile.isUserHasClaimed()){
            return 10;
        }
        return 30;
    }
}
interface UserProfile{
    boolean isUserHasClaimed();
}


class HealthInsuranceUserProfile implements UserProfile{

    @Override
    public boolean isUserHasClaimed() {
        return true;
    }
}

class HomeInsuranceUserProfile implements UserProfile{

    @Override
    public boolean isUserHasClaimed() {
        return false;
    }
}
class VehicleInsuranceUserProfile implements UserProfile{

    @Override
    public boolean isUserHasClaimed() {
        return true;
    }
}