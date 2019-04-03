package ru.job4j.peerReview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 03.04.2019.
 */
public class Bank {

    private TreeMap<User, ArrayList<Account>> treeMap = new TreeMap<>();

    /**
     * Метод добавляет пользователя.
     *
     * @param user ссылка на объект типа User.
     */
    public void addUser(User user) {
        this.treeMap.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя.
     *
     * @param user ссылка на объект типа User.
     */
    public void deleteUser(User user) {
        this.treeMap.remove(user);
    }

    /**
     * Метод позволяет по полю объекта User вернуть ссылку на объект User.
     *
     * @param passport поле объекта User.
     * @return ссылка на объект типо User.
     */
    private User getUser(String passport) {
        User result = null;
        for (Map.Entry<User, ArrayList<Account>> item : this.treeMap.entrySet()) {
            if (passport.equals(item.getKey().getPassport())) {
                result = item.getKey();
            }
        }
        return result;
    }

    /**
     * Метод добавляет счет(Account) пользователю(User).
     *
     * @param passport поле объекта типа User.
     * @param account  ссылка на объект типа Account.
     */
    public void addAccountToUser(String passport, Account account) {
        this.treeMap.get(getUser(passport)).add(account);
    }

    /**
     * Метод проверяет есть ли этот счет у пользователя, возвращает актуальный счет.
     *
     * @param user    сылка на объект типа User.
     * @param account ссылка на объект типа Account.
     * @return ссылка на объект типо Account.
     */
    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treeMap.get(user);
        return list.get(list.indexOf(account));
    }

    /**
     * Метод удаляет счет(Account) пользователя(User).
     *
     * @param passport поле объекта типа User.
     * @param account  ссылка на объект типа Account.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.treeMap.get(getUser(passport)).remove(account);
    }

    /**
     * Метод позволяет получить список счетов объекта User.
     *
     * @param passport поле объекта User.
     * @return список пользователей List<Account>.
     */
    public List<Account> getUserAccounts(String passport) {
        return this.treeMap.get(getUser(passport));
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт: если счёт не найден
     * или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
     *
     * @param user1    пользователь от которого перечисляются деньги.
     * @param account1 счет пользователя с которого перечисляются деньги.\
     * @param user2    пользователь к которому приходят деньги.
     * @param account2 счет пользователя на который приходят деньги.
     * @param amount   сумма транзакции.
     * @return true если транзакция удалась.
     */
    public boolean transferMoney(User user1, Account account1,
                                 User user2, Account account2, double amount) {
        return this.treeMap.get(user1).contains(account1)
                && this.treeMap.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }

    @Override
    public String toString() {
        return "Bank{" + "accounts=" + treeMap + "}";
    }
}