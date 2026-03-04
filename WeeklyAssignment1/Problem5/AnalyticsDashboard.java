import java.util.*;

public class AnalyticsDashboard {

    // page URL -> visit count
    private HashMap<String, Integer> pageViews = new HashMap<>();

    // page URL -> unique visitors
    private HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();

    // traffic source -> count
    private HashMap<String, Integer> trafficSources = new HashMap<>();


    // Process page view event
    public void processEvent(String url, String userId, String source) {

        // Count page views
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        // Track unique visitors
        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        // Count traffic sources
        trafficSources.put(source, trafficSources.getOrDefault(source, 0) + 1);
    }


    // Show dashboard
    public void getDashboard() {

        System.out.println("Top Pages:");

        for (String page : pageViews.keySet()) {

            int views = pageViews.get(page);
            int unique = uniqueVisitors.get(page).size();

            System.out.println(page + " - " + views + " views (" + unique + " unique)");
        }

        System.out.println("\nTraffic Sources:");

        for (String source : trafficSources.keySet()) {

            System.out.println(source + " : " + trafficSources.get(source));
        }
    }


    public static void main(String[] args) {

        AnalyticsDashboard dashboard = new AnalyticsDashboard();

        dashboard.processEvent("/article/breaking-news", "user123", "google");
        dashboard.processEvent("/article/breaking-news", "user456", "facebook");
        dashboard.processEvent("/sports/championship", "user789", "direct");
        dashboard.processEvent("/article/breaking-news", "user123", "google");

        dashboard.getDashboard();
    }
}