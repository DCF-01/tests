public class Car {
    private int numberOfWheels;
    private int numberOfDoors;
    private int horsePower;
    private int distanceDriven = 0;
    public boolean needsService = false;

    public Car(int numberOfWheels, int numberOfDoors, int horsePower){

        this.numberOfWheels = numberOfWheels;
        this.numberOfDoors = numberOfDoors;
        this.horsePower = horsePower;
    }

    public int DriveDistance(int distance){
        int timeToDestination = 0;
        int newDistanceDriven = 0;

        if(numberOfWheels != 4){
            return timeToDestination;
        }

        if(horsePower < 1){
            return timeToDestination;
        }

        for (double i = 0;i  < distance; i += this.horsePower * 0.1){
            newDistanceDriven += i;
            timeToDestination += 1;
        }

        if(newDistanceDriven > 1000){
            needsService = true;
        }

        distanceDriven += newDistanceDriven;

        return timeToDestination;
    }

    public boolean IsCoupe(){
        return numberOfDoors == 2;
    }

    public boolean IsFast(){
        return horsePower >= 500;
    }
}


