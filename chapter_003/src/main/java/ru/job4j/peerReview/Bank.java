package ru.job4j.peerReview;

import ru.job4j.comparator.User;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//нет JavaDoc
public class Bank {

    private TreeMap<User, ArrayList<Account>> treemap = new TreeMap<>(); //некоректное название, сделал бы treeMap

    public void addUser(User user) {
        this.treemap.put(user, new ArrayList<>());
    }

    public void delete(User user) { //переименовал бы deleteUser
        this.treemap.remove(user);
    }

    public void add(User user, Account account) { //переименовал бы addAccount
        this.treemap.get(user).add(account);
    }

    //нет JavaDoc
    private Account getActualAccount(User user, Account account) {
        ArrayList<Account> list = this.treemap.get(user);
        return list.get(list.indexOf(account));
    }

    public void deleteAccount(User user, Account account) {
        this.treemap.get(user).remove(account);
    }

    public List<Account> getAccounts(User user) { //переименовал бы getUser
        return this.treemap.get(user);
    }

    //нет JavaDoc
    public boolean transfer(User user1, Account account1,
                            User user2, Account account2, double amount) {
        return this.treemap.get(user1).contains(account1)
                && this.treemap.get(user2).contains(account2)
                && getActualAccount(user1, account1).transfer(
                getActualAccount(user2, account2), amount);
    }

    //не обозначено @Override
    public String toString() {
        return "Bank{" + "accounts=" + treemap + "}";
    }
}