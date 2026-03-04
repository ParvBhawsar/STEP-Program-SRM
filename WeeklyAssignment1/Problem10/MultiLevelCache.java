import java.util.*;

public class MultiLevelCache {

    // L1 Cache (Fast memory)
    private LinkedHashMap<String, String> L1Cache =
            new LinkedHashMap<>(10, 0.75f, true);

    // L2 Cache (Secondary storage simulation)
    private HashMap<String, String> L2Cache = new HashMap<>();


    public String getVideo(String videoId) {

        // Check L1 cache
        if (L1Cache.containsKey(videoId)) {
            return "L1 Cache HIT → " + L1Cache.get(videoId);
        }

        // Check L2 cache
        if (L2Cache.containsKey(videoId)) {

            String video = L2Cache.get(videoId);

            // Promote to L1
            L1Cache.put(videoId, video);

            return "L2 Cache HIT → Promoted to L1";
        }

        // Simulate database fetch
        String video = "VideoData_" + videoId;

        // Store in L2
        L2Cache.put(videoId, video);

        return "L3 Database HIT → Added to L2";
    }


    public static void main(String[] args) {

        MultiLevelCache cache = new MultiLevelCache();

        System.out.println(cache.getVideo("video123"));
        System.out.println(cache.getVideo("video123"));
        System.out.println(cache.getVideo("video999"));
    }
}