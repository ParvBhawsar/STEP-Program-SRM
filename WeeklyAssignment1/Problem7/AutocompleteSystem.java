import java.util.*;

public class AutocompleteSystem {

    // query -> frequency
    private HashMap<String, Integer> queryFrequency = new HashMap<>();

    // Add or update query
    public void updateFrequency(String query) {
        queryFrequency.put(query, queryFrequency.getOrDefault(query, 0) + 1);
    }

    // Get suggestions based on prefix
    public List<String> search(String prefix) {

        List<String> suggestions = new ArrayList<>();

        for (String query : queryFrequency.keySet()) {
            if (query.startsWith(prefix)) {
                suggestions.add(query);
            }
        }

        // Sort suggestions based on frequency (highest first)
        suggestions.sort((a, b) ->
                queryFrequency.get(b) - queryFrequency.get(a));

        // Return top 10 suggestions
        return suggestions.size() > 10 ? suggestions.subList(0, 10) : suggestions;
    }

    public static void main(String[] args) {

        AutocompleteSystem system = new AutocompleteSystem();

        system.updateFrequency("java tutorial");
        system.updateFrequency("javascript tutorial");
        system.updateFrequency("java download");
        system.updateFrequency("java tutorial");
        system.updateFrequency("java features");

        System.out.println("Suggestions for 'jav':");

        List<String> results = system.search("jav");

        for (String s : results) {
            System.out.println(s);
        }
    }
}