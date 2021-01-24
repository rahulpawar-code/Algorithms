import java.util.Date;

public class Transaction {
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String toString() {
        return new String(who + " " + when + " " + amount);
    }

    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + who.hashCode();
        hash = hash * 31 + when.hashCode();
        hash = hash * 31 + ((Double)amount).hashCode();
        return hash;
    }

    public static void main(String[] args) {
        Transaction t1 = new Transaction("Alice", new Date(), 31.17);
        System.out.println(t1);
        System.out.println("Hash code: " + t1.hashCode());
    }
}
