public class Customer {

    private String name;
    private String address;
    private String city;
    private String zip;

    // No-argument constructor
    public Customer() {
        this.name = "Default";
        this.address = "Default";
        this.city = "Default";
        this.zip = "00000";
    }

    // Argument constructor
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    // Accessor methods
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getZip() { return zip; }

    // toString override
    @Override
    public String toString() {
        return "--Customer Details--\n" +
               "Name: " + name + "\n" +
               "Address: " + address + "\n" +
               "City: " + city + "\n" +
               "Zip: " + zip;
    }
}
