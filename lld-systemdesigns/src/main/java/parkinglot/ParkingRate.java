package parkinglot;

public class ParkingRate {
    public static double calculate(double hours){
        double charge =0l;
        if(hours<=1){
            charge+= 4l;
        }
        if(hours>1){
            charge+= (hours-1)*3;
        }
        if(hours>2){
            charge+= (hours-2)*2;
        }
        return charge;
    }
}
