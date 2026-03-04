import java.util.*;

class Transaction {
    int id;
    int amount;

    Transaction(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }
}

public class TwoSumTransactions {

    // Find two transactions whose sum equals target
    public static void findTwoSum(List<Transaction> transactions, int target) {

        HashMap<Integer, Transaction> map = new HashMap<>();

        for (Transaction t : transactions) {

            int complement = target - t.amount;

            if (map.containsKey(complement)) {

                Transaction other = map.get(complement);

                System.out.println("Pair Found:");
                System.out.println("Transaction " + other.id +
                        " + Transaction " + t.id +
                        " = " + target);

                return;
            }

            map.put(t.amount, t);
        }

        System.out.println("No matching transactions found.");
    }

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(1, 500));
        transactions.add(new Transaction(2, 300));
        transactions.add(new Transaction(3, 200));
        transactions.add(new Transaction(4, 150));

        findTwoSum(transactions, 500);
    }
}