import java.util.*;

class Transaction {
    String id, ts;
    double fee;

    Transaction(String id, double fee, String ts) {
        this.id = id;
        this.fee = fee;
        this.ts = ts;
    }

    public String toString() {
        return id + ":" + fee + "@" + ts;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        ArrayList<Transaction> list = new ArrayList<>();
        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        // Bubble Sort by fee
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        System.out.println("Bubble Sort: " + list);

        // High fee outliers
        System.out.print("High-fee outliers: ");
        for (Transaction t : list) {
            if (t.fee > 50)
                System.out.print(t + " ");
        }
    }
}