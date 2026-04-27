/**
 * Composer.java
 *
 * This class represents a musical composer with an id, name, and genre.
 * It follows JavaBean conventions with private fields and public accessors.
 *
 * @author Holland, Victoria
 * @version 1.0
 * @since 2026
 */
public class Composer {

    /** Unique identifier for the composer. */
    private int id;

    /** Full name of the composer. */
    private String name;

    /** Musical genre associated with the composer. */
    private String genre;

    /**
     * No-argument constructor that initializes a default Composer.
     * The id defaults to 0, and name and genre default to empty strings.
     */
    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    /**
     * Argument constructor that initializes a Composer with all three fields.
     *
     * @param id    the unique integer identifier for the composer
     * @param name  the full name of the composer
     * @param genre the musical genre of the composer
     */
    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    /**
     * Returns the composer's id.
     *
     * @return the integer id of the composer
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the composer's name.
     *
     * @return the name of the composer
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the composer's genre.
     *
     * @return the musical genre of the composer
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns a formatted string representation of the Composer object.
     * Each field is displayed on a separate line with a 2-space leading indent.
     *
     * @return a string containing the composer's id, name, and genre
     */
    @Override
    public String toString() {
        return "  Id: " + id + "\n" +
               "  Name: " + name + "\n" +
               "  Genre: " + genre;
    }
}
