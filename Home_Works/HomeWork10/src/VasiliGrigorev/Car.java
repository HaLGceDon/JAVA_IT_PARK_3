package VasiliGrigorev;

public class Car {

    private String manufacturer;
    private String model;
    private  String color;
    private int power;
    private int torque;
    private int maxSpeed;
    private  int acceleration;
    private int fuelConsumption;
    private int fuelAmount;


   private Car (Builder builder) {
        this.manufacturer = builder.manufacturer;
        this.model = builder.model;
        this.color = builder.color;
        this.power = builder.power;
        this.torque = builder.torque;
        this.maxSpeed = builder.maxSpeed;
        this.acceleration = builder.acceleration;
        this.fuelConsumption = builder.fuelConsumption;
        this.fuelAmount = builder.fuelAmount;
    }



    public static class Builder {
        private String manufacturer;
        private String model;
        private  String color;
        private int power;
        private int torque;
        private int maxSpeed;
        private  int acceleration;
        private int fuelConsumption;
        private int fuelAmount;

        public Builder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder model (String model) {
            this.model = model;
            return this;
        }

        public Builder color(String color){
            this.color = color;
            return this;
        }

        public Builder power (int power) {
            this.power = power;
            return this;
        }

        public Builder torque (int torque) {
            this.torque = torque;
            return this;
        }

        public Builder maxSpeed (int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public Builder acceleration (int acceleration) {
            this.acceleration = acceleration;
            return this;
        }

        public Builder fuelConsumption (int fuelConsumption) {
            this.fuelConsumption = fuelConsumption;
            return this;
        }

        public Builder fuelAmount (int fuelAmount) {
            this.fuelAmount = fuelAmount;
            return this;
        }

        public Car build() {
            return new Car (this);
        }
    }



    public static Builder builder() {
        return new Builder();
    }



    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
}


