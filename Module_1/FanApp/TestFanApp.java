public class TestFanApp {
    public static void main(String[] args) {
        Fan fan1 = new Fan();

        Fan fan2 = new Fan(Fan.MEDIUM, true, 8.0, "Blue");

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}