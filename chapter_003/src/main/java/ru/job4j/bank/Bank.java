package ru.job4j.bank;

import ru.job4j.bank.exception.NoSuchUserAccount;
import ru.job4j.bank.exception.NoSuchUserException;

import java.util.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 2.
 * @since 05.04.2019.
 */
public class Bank {

    private Map<User, ArrayList<Account>> treeMap = new TreeMap<>();

    public void setTreeMap(Map<User, ArrayList<Account>> treeMap) {
        this.treeMap = treeMap;
    }

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
    public User getUser(String passport) throws NoSuchUserException {
        return this.treeMap.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst().orElse(null);
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
     * Метод удаляет счет(Account) пользователя(User).
     *
     * @param passport поле объекта типа User.
     * @param account  ссылка на объект типа Account.
     */
    public void deleteAccountFromUser(String passport, Account account) throws NoSuchUserAccount {
        ArrayList<Account> temp = this.treeMap.get(this.getUser(passport));
        if (temp.indexOf(account) < 0) {
            throw new NoSuchUserAccount("Такого счета у пользователя нет");
        }
        temp.remove(account);
    }

    /**
     * Метод позволяет получить список счетов объекта User.
     *
     * @param passport поле объекта User.
     * @return список пользователей List<Account>.
     */
    private List<Account> getUserAccounts(String passport) {
        return this.treeMap.get(getUser(passport));
    }

    /**
     * Метод возвращает аккаунт по поспорту и реквизитам.
     *
     * @param passport   паспорт пользователя.
     * @param requisites реквизиты аккаунта.
     * @return ссылка на объект типо Account.
     */
    public Account getOneUserAccount(String passport, String requisites) {
        List<Account> temp = this.getUserAccounts(passport);
        Account result = null;
        for (Account item : temp) {
            if (requisites.equals(item.getRequisites())) {
                result = item;
            }
        }
        return result;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт: если счёт не найден
     * или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
     *
     * @param srcPassport   паспорт пользователя от которого перечисляются деньги.
     * @param srcRequisite  реквизиты пользователя со счета которого перечисляются деньги.
     * @param destPassport  паспорт пользователя к которому приходят деньги.
     * @param destRequisite реквизиты пользователя на счет которого приходят деньги.
     * @param amount        сумма транзакции.
     * @return true если транзакция удалась.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rst = false;
        Account src = getOneUserAccount(srcPassport, srcRequisite);
        Account dest = getOneUserAccount(destPassport, destRequisite);
        if (src != null && dest != null) {
            rst = src.transfer(dest, amount);
        }
        return rst;
    }

    @Override
    public String toString() {
        return "Bank{" + "accounts=" + treeMap + "}";
    }
}