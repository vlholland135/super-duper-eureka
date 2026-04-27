import java.util.ArrayList;
import java.util.List;

/**
 * MemComposerDao.java
 *
 * An in-memory implementation of the ComposerDao interface.
 * This class manages a List of Composer objects, simulating a data persistence
 * layer without requiring an external database. It provides concrete implementations
 * of findAll, findBy, and insert operations as defined by the GenericDao interface.
 *
 * @author Holland, Victoria
 * @version 1.0
 * @since 2026
 */
public class MemComposerDao implements ComposerDao {

    /** In-memory list of Composer objects serving as the data store. */
    private List<Composer> composers;

    /**
     * No-argument constructor that initializes the composers list with
     * five default Composer objects representing classical composers.
     */
    public MemComposerDao() {
        composers = new ArrayList<>();
        composers.add(new Composer(1007, "Ludwig Van Beethoven", "Classical"));
        composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
    }

    /**
     * Returns the complete list of all Composer objects in the data store.
     *
     * @return a List of all Composer objects
     */
    @Override
    public List<Composer> findAll() {
        return composers;
    }

    /**
     * Finds and returns a single Composer object matching the provided id.
     * Returns null if no composer with the given id exists.
     *
     * @param key the Integer id used to locate the desired Composer
     * @return the matching Composer object, or null if not found
     */
    @Override
    public Composer findBy(Integer key) {
        for (Composer c : composers) {
            if (c.getId() == key) {
                return c;
            }
        }
        return null;
    }

    /**
     * Adds a new Composer object to the in-memory list.
     *
     * @param entity the Composer object to be inserted into the data store
     */
    @Override
    public void insert(Composer entity) {
        composers.add(entity);
    }
}
