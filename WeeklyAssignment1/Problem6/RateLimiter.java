import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class TokenBucket {

    int tokens;
    long lastRefillTime;

    TokenBucket(int maxTokens) {
        tokens = maxTokens;
        lastRefillTime = System.currentTimeMillis();
    }
}

public class RateLimiter {

    private static final int MAX_REQUESTS = 1000;

    private ConcurrentHashMap<String, TokenBucket> clients = new ConcurrentHashMap<>();


    public String checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(MAX_REQUESTS));

        TokenBucket bucket = clients.get(clientId);

        long currentTime = System.currentTimeMillis();

        // Reset tokens every hour
        if (currentTime - bucket.lastRefillTime > 3600000) {
            bucket.tokens = MAX_REQUESTS;
            bucket.lastRefillTime = currentTime;
        }

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return "Allowed (" + bucket.tokens + " requests remaining)";
        } else {
            return "Denied (Rate limit exceeded)";
        }
    }


    public static void main(String[] args) {

        RateLimiter limiter = new RateLimiter();

        System.out.println(limiter.checkRateLimit("client123"));
        System.out.println(limiter.checkRateLimit("client123"));
        System.out.println(limiter.checkRateLimit("client123"));
    }
}