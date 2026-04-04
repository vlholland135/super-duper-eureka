public class CustomerDB {

    public static Customer getCustomer(Integer id) {
        if (id == 1007) {
            return new Customer("Jennifer Patterson", "8422 Grover Ave.", "Bellevue", "68123");
        } else if (id == 1008) {
            return new Customer("Marcus Rivera", "301 Oak Street", "Omaha", "68102");
        } else if (id == 1009) {
            return new Customer("Sandra Lee", "554 Maple Drive", "Lincoln", "68501");
        } else {
            return new Customer();
        }
    }
}
