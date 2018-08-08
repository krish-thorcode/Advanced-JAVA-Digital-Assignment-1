import java.util.Random;

// Class declaration
class Car {
	int year;
	String model;
	String make;
	int speed;

  // Default constructor
	Car() {
		this.year = 2018;
		this.model = "";
		this.make = "";
		this.speed = 0;
	}

  // Parameterised constructor
	Car(int year, String model, String make, int speed) {
		this.year = year;
		this.model = model;
		this.make = make;
		this.speed = speed;
	}

  // Setters
	void setYear(int year) {
		this.year = year;
	}

	void setModel(String model) {
		this.model = model;
	}

	void setMake(String make) {
		this.make = make;
	}

	void setSpeed(int speed) {
		this.speed = speed;
	}

  // Getters
  int getYear() {
    return this.year;
  }

  String getModel(String model) {
    return this.model;
  }

  String getMake(String make) {
    return this.make;
  }

  int getSpeed(int speed) {
    return this.speed;
  }

  // Accelerate
	void accelerate() {
		Random random = new Random();
		this.speed += random.nextInt(25) + 5;
	}

  // Brake
  void brake() {
    Random random = new Random();
    this.speed -= random.nextInt(25) - 5;
  }
}
