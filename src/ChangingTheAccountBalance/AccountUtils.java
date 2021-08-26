package ChangingTheAccountBalance;

import java.lang.reflect.Field;
import java.util.Arrays;

class Account {
    private long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    // some other methods
}

final class AccountUtils {

    private AccountUtils() { }

    public static void increaseBalance(Account account, long amount) {
        // write your code here
        Class accountClass = account.getClass();
        try {
            Field[] fields = accountClass.getDeclaredFields();
            fields[0].setAccessible(true);
            long balanceValue = fields[0].getLong(account);
            fields[0].setLong(account, balanceValue + amount);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Account acc = new Account(120);
        AccountUtils.increaseBalance(acc, 30);
        System.out.println(acc.getBalance());
    }
}
