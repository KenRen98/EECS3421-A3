package DB_project;
import java.util.HashMap;
import java.util.UUID;

/**
 * A Standard Singleton Cache
 */
public class Cache {
    // @TODO: To be complete by students for caching layer
    private static Cache INSTANCE = null;
    private static final HashMap<String, CFP> LocalCache = new HashMap<String, CFP>();

    private Cache(){
    }

    /**
     * @return the instance of the Singleton
     * Create one and return it if it is null
     */
    public static synchronized Cache getInstance()
    {
        if (Cache.INSTANCE == null)
        {
            Cache.INSTANCE = new Cache();
        }
        return Cache.INSTANCE;

    }

    /**
     * @param uuid The UUID needs to be searched
     * @return A instance of the Singleton
     * search from the singleton map by given ID
     */
    public CFP getByID(String uuid){
        return LocalCache.get(uuid);
    }

    /**
     * @param id The UUID needs to be placed
     * @param mls the corresponding MLS record that maps to the ID
     * Create a element in the singleton map
     */
    public void putValue(String id, CFP mls){
        LocalCache.put(id,mls);
    }
}
