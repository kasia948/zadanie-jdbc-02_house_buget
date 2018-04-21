import java.util.ArrayList;
import java.util.Scanner;

public class HomeBudget {

    Scanner scanner = new Scanner(System.in);
    TransactionDao transactionDao = new TransactionDao();

    public static void main(String[] args) {

        HomeBudget homeBudget = new HomeBudget();
        homeBudget.options();
    }

    void options() {
        System.out.println("1 - dodaj transakcję");
        System.out.println("2 - wyświetl przychody");
        System.out.println("3 - wyświetl wydatki");
        System.out.println("4 - wczytaj wydatki/przychody powyżej kwoty");
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                save();
                break;
            case 2:
                read(true);
                break;
            case 3:
                read(false);
                break;
            case 4:
                readAboveAmount();
                break;
        }
    }

    void save() {
        Transaction transaction = new Transaction();
        readTransactionData(transaction);
        transactionDao.addTransaction(transaction);
    }

    void read(boolean positive) {
        ArrayList<Transaction> transaction = transactionDao.readTransaction(positive);
        for (Transaction t : transaction)
            System.out.println(t);
    }

    void readTransactionData(Transaction transaction) {
        System.out.println("Podaj typ wpisu (tj. wydatek lub przychód)");
        transaction.setType(scanner.nextLine());
        System.out.println("Podaj opis transakcji");
        transaction.setDescription(scanner.nextLine());
        System.out.println("Podaj kwotę transakcji");
        transaction.setAmount(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Podaj rok");
        transaction.setYear(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Podaj miesiąc");
        transaction.setMonth(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Podaj dzień");
        transaction.setDay(scanner.nextInt());
        scanner.nextLine();

    }

    void readAboveAmount() {
        System.out.println("Podaj kwotę");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        ArrayList<Transaction> transactions = transactionDao.readAboveAmount(amount);
        for (Transaction t : transactions)
            System.out.println(t);
    }
}
