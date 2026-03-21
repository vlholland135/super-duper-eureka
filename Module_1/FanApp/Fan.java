public class Fan {
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed = STOPPED;
    private boolean on = false;
    private double radius = 6;
    private String color = "white";

    public Fan() {
    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public boolean isOn() { return on; }
    public void setOn(boolean on) { this.on = on; }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    @Override
    public String toString() {
        if (on) {
            return "The fan speed is set to " + speed + " with a color of " + color + " and a radius of " + radius;
        } else {
            return "The fan is " + color + " with a radius of " + radius + " and the fan is off";
        }
    }
}