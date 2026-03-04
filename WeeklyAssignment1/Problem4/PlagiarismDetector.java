import java.util.*;

public class PlagiarismDetector {

    // n-gram -> list of document IDs
    private HashMap<String, Set<String>> index = new HashMap<>();

    private int N = 5; // size of n-gram

    // Add document to index
    public void addDocument(String docId, String text) {

        String[] words = text.split(" ");

        for (int i = 0; i <= words.length - N; i++) {

            String ngram = "";

            for (int j = i; j < i + N; j++) {
                ngram += words[j] + " ";
            }

            ngram = ngram.trim();

            index.putIfAbsent(ngram, new HashSet<>());
            index.get(ngram).add(docId);
        }
    }

    // Compare document similarity
    public double analyzeDocument(String docId, String text) {

        String[] words = text.split(" ");

        int total = 0;
        int matches = 0;

        for (int i = 0; i <= words.length - N; i++) {

            String ngram = "";

            for (int j = i; j < i + N; j++) {
                ngram += words[j] + " ";
            }

            ngram = ngram.trim();

            total++;

            if (index.containsKey(ngram) && index.get(ngram).contains(docId)) {
                matches++;
            }
        }

        return (matches * 100.0) / total;
    }

    public static void main(String[] args) {

        PlagiarismDetector detector = new PlagiarismDetector();

        String doc1 = "this project explains data structures and algorithms in detail";
        String doc2 = "this project explains data structures and algorithms very clearly";

        detector.addDocument("essay_001", doc1);

        double similarity = detector.analyzeDocument("essay_001", doc2);

        System.out.println("Similarity: " + similarity + "%");

        if (similarity > 50) {
            System.out.println("PLAGIARISM DETECTED");
        }
    }
}