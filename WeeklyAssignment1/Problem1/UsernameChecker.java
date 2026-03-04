import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UsernameChecker {

    // Store username -> userId
    private ConcurrentHashMap<String, Integer> users = new ConcurrentHashMap<>();

    // Store username -> attempt frequency
    private ConcurrentHashMap<String, Integer> attempts = new ConcurrentHashMap<>();

    // Constructor (sample existing users)
    public UsernameChecker() {
        users.put("john_doe", 101);
        users.put("admin", 102);
        users.put("user123", 103);
    }

    // Check availability in O(1)
    public boolean checkAvailability(String username) {
        attempts.merge(username, 1, Integer::sum);
        return !users.containsKey(username);
    }

    // Suggest alternatives
    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        if (checkAvailability(username)) {
            suggestions.add(username);
            return suggestions;
        }

        int count = 1;
        while (suggestions.size() < 3) {
            String newName = username + count;
            if (!users.containsKey(newName)) {
                suggestions.add(newName);
            }
            count++;
        }

        String modified = username.replace("_", ".");
        if (!users.containsKey(modified)) {
            suggestions.add(modified);
        }

        return suggestions;
    }

    // Get most attempted username
    public String getMostAttempted() {
        String maxUser = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : attempts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxUser = entry.getKey();
            }
        }
        return maxUser + " (" + maxCount + " attempts)";
    }

    // Main method for testing
    public static void main(String[] args) {
        UsernameChecker checker = new UsernameChecker();

        System.out.println("Check john_doe: " + checker.checkAvailability("john_doe"));
        System.out.println("Check jane_smith: " + checker.checkAvailability("jane_smith"));

        System.out.println("Suggestions for john_doe: " +
                checker.suggestAlternatives("john_doe"));

        // Simulate multiple attempts
        for (int i = 0; i < 5; i++) {
            checker.checkAvailability("admin");
        }

        System.out.println("Most Attempted: " + checker.getMostAttempted());
    }
}