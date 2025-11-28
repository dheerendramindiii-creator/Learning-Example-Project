package paralleltesting;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyExample {
    @Test
    void startCar(){
        System.out.println("Starting Car");
        Assert.fail();
    }
    @Test(dependsOnMethods = {"startCar"})
    void driveCar(){
        System.out.println("Driving Car");
    }
    @Test(dependsOnMethods = {"driveCar"})
    void stopCar(){
        System.out.println("Stopping Car");
    }
    @Test(dependsOnMethods = {"driveCar", "stopCar"}, alwaysRun = true)
    void parkCar(){
        System.out.println("Car Parked");
    }

}
