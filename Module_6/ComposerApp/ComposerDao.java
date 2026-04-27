/**
 * ComposerDao.java
 *
 * A domain-specific DAO interface for Composer entities.
 * Extends the GenericDao interface with Composer as the entity type
 * and Integer as the key type, representing the operations available
 * in the composer data persistence layer.
 *
 * @author Holland, Victoria
 * @version 1.0
 * @since 2026
 */
public interface ComposerDao extends GenericDao<Composer, Integer> {
    // Inherits findAll(), findBy(Integer key), and insert(Composer entity)
    // from GenericDao. No additional methods are required at this layer.
}
