import java.util.Scanner;
import java.util.Random;
import Car.Car;

class Driver extends Car{
  private int current_speed, fastest_speed;

  public Driver() {
    super();
    this.current_speed = this.fastest_speed = 0;
  }

  public Driver(int year, int initial_speed, String model, String make, int current_speed, int fastest_speed) {
    super(year, model, make, initial_speed);
    this.current_speed = current_speed;
    this.fastest_speed = fastest_speed;
  }

  public void setDriverInfo(int year, int initial_speed, String model, String make, int current_speed, int fastest_speed) {
    super.setYear(year);
    super.setModel(model);
    super.setMake(make);
    super.setSpeed(initial_speed);
    this.current_speed = current_speed;
    this.fastest_speed = fastest_speed;
  }

  public void setFastestSpeed(int fastest_speed) {
    this.fastest_speed = fastest_speed;
  }

  public int getCurrentSpeed() {
    return this.current_speed;
  }

  public int getFastestSpeed() {
    return this.fastest_speed;
  }

  public int accelerate() {
    this.current_speed = super.accelerate();
    return this.current_speed;
  }

  public int brake() {
    this.current_speed = super.brake();
    return this.current_speed;
  }

  public void displayDriverInfo() {
    super.displayCarInfo();
  }

  public void displayCurrentSpeed() {
    System.out.println("Current speed: " + this.current_speed);
  }

  public void displayFastestSpeed() {
    System.out.println("Fastest speed: " + this.fastest_speed);
  }
}

class DrivingSimulation extends Driver {
  public DrivingSimulation() {
    super();
  }

  public DrivingSimulation(int year, int initial_speed, String model, String make) {
    super(year, initial_speed, model, make, initial_speed, initial_speed);
  }

  public void setCarInfo(int year, int initial_speed, String model, String make) {
    super.setDriverInfo(year, initial_speed, model, make, initial_speed, initial_speed);
  }

  public void displaySimulationInfo() {
    super.displayDriverInfo();
  }
}

public class Race {
  public static void main(String args[]) {

    int year, initial_speed;
    String model, make;

    Scanner keyboard = new Scanner(System.in);

    System.out.println("Car 1 Info: ");
    System.out.println("-----------");
    System.out.println();
    System.out.print("Year: ");
    year = keyboard.nextInt();
    keyboard.nextLine();
    System.out.print("Initial speed: ");
    initial_speed = keyboard.nextInt();
    keyboard.nextLine();
    System.out.print("Model: ");
    model = keyboard.nextLine();
    System.out.print("Make: ");
    make = keyboard.nextLine();
    System.out.println();

    DrivingSimulation car1 = new DrivingSimulation();
    car1.setCarInfo(year, initial_speed, model, make);

    System.out.println("Car 2 Info: ");
    System.out.println("-----------");
    System.out.println();
    System.out.print("Year: ");
    year = keyboard.nextInt();
    keyboard.nextLine();
    System.out.print("Initial speed: ");
    initial_speed = keyboard.nextInt();
    keyboard.nextLine();
    System.out.print("Model: ");
    model = keyboard.nextLine();
    System.out.print("Make: ");
    make = keyboard.nextLine();
    System.out.println();

    DrivingSimulation car2 = new DrivingSimulation(year, initial_speed, model, make);

    Random carOperator = new Random();

    int oneLoopRunInterval = 2;
    int carDistance1 = 0;
    int carDistance2 = 0;

    int beforeAcceleration, afterAcceleration;
    System.out.println("---------------------------------------");
    for(int i = 0; i<5; i++) {
      if( i > 0) {
        carDistance1 += car1.getCurrentSpeed() * oneLoopRunInterval;
        carDistance2 += car2.getCurrentSpeed() * oneLoopRunInterval;
      }
      switch(carOperator.nextInt(4)) {
        case 0:
          beforeAcceleration = car1.getCurrentSpeed();
          afterAcceleration = car1.accelerate();
          if(car1.getCurrentSpeed() > car1.getFastestSpeed())
            car1.setFastestSpeed(car1.getCurrentSpeed());
          System.out.println("Car 1 accelerated by " + (afterAcceleration - beforeAcceleration) + ".");
          break;
        case 1:
          beforeAcceleration = car2.getCurrentSpeed();
          afterAcceleration = car2.accelerate();
          if(car2.getCurrentSpeed() > car2.getFastestSpeed())
            car2.setFastestSpeed(car2.getCurrentSpeed());
          System.out.println("Car 2 accelerated by " + (afterAcceleration - beforeAcceleration) + ".");
          break;
        case 2:
          beforeAcceleration = car1.getCurrentSpeed();
          afterAcceleration = car1.brake();
          System.out.println("Car 1 decelerates by " + Math.abs(afterAcceleration - beforeAcceleration) + ".");
          break;
        case 3:
          beforeAcceleration = car2.getCurrentSpeed();
          afterAcceleration = car2.brake();
          System.out.println("Car 2 decelerates by " + Math.abs(afterAcceleration - beforeAcceleration) + ".");
          break;
      }
    }
    System.out.println();
    System.out.println("----------------Results----------------");
    System.out.println();
    if(carDistance1 > carDistance2)
      System.out.print("*** Car 1 won! ***");
    else
      System.out.println("*** Car 2 won! ***");

    System.out.println();
    System.out.println("Distance travelled by Car 1: " + carDistance1);
    System.out.println("Distance travelled by Car 2: " + carDistance2);
    System.out.println();
    System.out.println("Fastest Speed attained by Car 1: " + car1.getFastestSpeed());
    System.out.println("Fastest Speed attained by Car 2: " + car2.getFastestSpeed());
  }
}
