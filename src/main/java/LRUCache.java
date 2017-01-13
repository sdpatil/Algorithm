import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sunilpatil on 1/9/17.
 */
public class LRUCache<Key,Value> extends LinkedHashMap<Key,Value>{
    private int cacheSize;

    public LRUCache(int cacheSize) {
        super(cacheSize, 0.75f,true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Key, Value> eldest) {
        return size() > cacheSize;
    }

    public static void main(String[] argv){
        LRUCache<String, String> cache = new LRUCache<String,String>(3);

        Map<String,String> map = Collections.synchronizedMap(cache);
        cache.put("First","1");
        cache.put("Second","2");
        cache.put("Third","3");
        System.out.println(cache);
        cache.get("First");
        cache.get("Second");
        cache.put("Fourth","4");
        System.out.println(cache);
        cache.put("Fifth","5");
        System.out.println(cache);
    }
}
