import java.util.List;

/**
 * GenericDao.java
 *
 * A generic interface representing the standard operations in a data persistence layer.
 * Classes implementing this interface provide concrete behavior for finding, retrieving,
 * and inserting entity objects backed by a specific key type.
 *
 * @param <E> the entity type managed by this DAO
 * @param <K> the key type used to identify entities
 *
 * @author Holland, Victoria
 * @version 1.0
 * @since 2026
 */
public interface GenericDao<E, K> {

    /**
     * Retrieves all entities from the data store.
     *
     * @return a List containing all entity objects
     */
    List<E> findAll();

    /**
     * Retrieves a single entity matching the provided key.
     *
     * @param key the unique identifier used to locate the entity
     * @return the entity object matching the given key, or null if not found
     */
    E findBy(K key);

    /**
     * Inserts a new entity into the data store.
     *
     * @param entity the entity object to be added
     */
    void insert(E entity);
}
