import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FlashSaleManager {

    // productId -> stock count
    private ConcurrentHashMap<String, AtomicInteger> inventory = new ConcurrentHashMap<>();

    // productId -> waiting list
    private ConcurrentHashMap<String, Queue<Integer>> waitingList = new ConcurrentHashMap<>();

    // Constructor
    public FlashSaleManager() {
        inventory.put("IPHONE15_256GB", new AtomicInteger(100));
        waitingList.put("IPHONE15_256GB", new LinkedList<>());
    }

    // Check stock
    public int checkStock(String productId) {
        if (inventory.containsKey(productId)) {
            return inventory.get(productId).get();
        }
        return 0;
    }

    // Purchase item
    public String purchaseItem(String productId, int userId) {

        AtomicInteger stock = inventory.get(productId);

        if (stock.get() > 0) {
            stock.decrementAndGet();
            return "Success, " + stock.get() + " units remaining";
        } else {
            Queue<Integer> queue = waitingList.get(productId);
            queue.add(userId);
            return "Added to waiting list, position #" + queue.size();
        }
    }

    public static void main(String[] args) {

        FlashSaleManager manager = new FlashSaleManager();

        System.out.println("Stock: " + manager.checkStock("IPHONE15_256GB"));

        System.out.println(manager.purchaseItem("IPHONE15_256GB", 12345));
        System.out.println(manager.purchaseItem("IPHONE15_256GB", 67890));

        // Simulate stock running out
        for(int i = 0; i < 100; i++) {
            manager.purchaseItem("IPHONE15_256GB", i);
        }

        System.out.println(manager.purchaseItem("IPHONE15_256GB", 99999));
    }
}