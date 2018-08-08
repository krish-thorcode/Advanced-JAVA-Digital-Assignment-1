package Car;
import java.util.Random;

// Class declaration
public class Car {
	int year;
	String model;
	String make;
	int speed;
	private Random accelerator = new Random();
  // Default constructor
	public Car() {
		this.year = 0;
		this.model = "";
		this.make = "";
		this.speed = 0;
	}

  // Parameterised constructor
	public Car(int year, String model, String make, int speed) {
		this.year = year;
		this.model = model;
		this.make = make;
		this.speed = speed;
	}

  // Setters
	public void setYear(int year) {
		this.year = year;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

  // Getters
  public int getYear() {
    return this.year;
  }

  public String getModel(String model) {
    return this.model;
  }

  public String getMake(String make) {
    return this.make;
  }

  public int getSpeed(int speed) {
    return this.speed;
  }

  // Accelerate
	public int accelerate() {
		this.speed += accelerator.nextInt(25) + 5;
		return this.speed;
	}

  // Brake
  public int brake() {
    this.speed -= accelerator.nextInt(25) - 5;
		return this.speed;
  }

	public void displayCarInfo() {
		System.out.println("Year: " + this.year);
    System.out.println("Initial speed: " + this.speed);
    System.out.println("Model: " + this.model);
    System.out.println("Make: " + this.make);
	}
}
