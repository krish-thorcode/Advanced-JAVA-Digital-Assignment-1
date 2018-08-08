import java.util.Scanner;
import java.util.Random;

class Driver {
  private int current_speed, fastest_speed;
  private Random accelerator = new Random();

  public Driver() {
    this.current_speed = this.fastest_speed = 0;
  }

  public Driver(int current_speed, int fastest_speed) {
    this.current_speed = current_speed;
    this.fastest_speed = fastest_speed;
  }

  public void setDriverInfo(int current_speed, int fastest_speed) {
    this.current_speed = current_speed;
    this.fastest_speed = fastest_speed;
  }

  public void setFastestSpeed(int fastest_speed) {
    this.fastest_speed = fastest_speed;
  }

  public void accelerate() {
    // Accerate by adding a random speed by 5 to 30 (inclusive)
    this.current_speed += this.accelerator.nextInt(25) + 5;
  }

  public void brake() {
    this.current_speed -= this.accelerator.nextInt(25) + 5;
  }

  public int getCurrentSpeed() {
    return this.current_speed;
  }

  public int getFastestSpeed() {
    return this.fastest_speed;
  }

  public void displayCurrentSpeed() {
    System.out.println("Current speed: " + this.current_speed);
  }

  public void displayFastestSpeed() {
    System.out.println("Fastest speed: " + this.fastest_speed);
  }
}

class DrivingSimulation extends Driver {
  private int year, initial_speed;
  private String model, make;

  public DrivingSimulation() {
    super();
    this.year = this.initial_speed = 0;
    this.model = this.make = "";
  }

  public DrivingSimulation(int year, int initial_speed, String model, String make) {
    super(initial_speed, initial_speed);
    this.year = year;
    this.initial_speed = initial_speed;
    this.model = model;
    this.make = make;
  }

  public void setCarInfo(int year, int initial_speed, String model, String make) {
    super.setDriverInfo(initial_speed, initial_speed);
    this.year = year;
    this.initial_speed = initial_speed;
    this.model = model;
    this.make = make;
  }

  public void displayCarInfo() {
    System.out.println("Year: " + this.year);
    System.out.println("Initial speed: " + this.initial_speed);
    System.out.println("Model: " + this.model);
    System.out.println("Make: " + this.make);
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
    // System.out.println();
    System.out.print("Model: ");
    model = keyboard.nextLine();
    // System.out.println();
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
    // System.out.println();
    System.out.print("Initial speed: ");
    initial_speed = keyboard.nextInt();
    keyboard.nextLine();
    // System.out.println();
    System.out.print("Model: ");
    model = keyboard.nextLine();
    // System.out.println();
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
          car1.accelerate();
          if(car1.getCurrentSpeed() > car1.getFastestSpeed())
            car1.setFastestSpeed(car1.getCurrentSpeed());
          afterAcceleration = car1.getCurrentSpeed();
          System.out.println("Car 1 accelerated by " + (afterAcceleration - beforeAcceleration) + ".");
          break;
        case 1:
          beforeAcceleration = car2.getCurrentSpeed();
          car2.accelerate();
          if(car2.getCurrentSpeed() > car2.getFastestSpeed())
            car2.setFastestSpeed(car2.getCurrentSpeed());
          afterAcceleration = car2.getCurrentSpeed();
          System.out.println("Car 2 accelerated by " + (afterAcceleration - beforeAcceleration) + ".");
          break;
        case 2:
          beforeAcceleration = car1.getCurrentSpeed();
          car1.brake();
          afterAcceleration = car1.getCurrentSpeed();
          System.out.println("Car 1 decelerates by " + Math.abs(afterAcceleration - beforeAcceleration) + ".");
          break;
        case 3:
          beforeAcceleration = car2.getCurrentSpeed();
          car2.brake();
          afterAcceleration = car2.getCurrentSpeed();
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
