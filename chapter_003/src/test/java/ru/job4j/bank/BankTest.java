package ru.job4j.bank;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 05.04.2019.
 */
public class BankTest {

    @Test
    public void whenAddTwoUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Stepan", "343333"));
        bank.addUser(new User("Ivan", "245511"));
        assertThat(bank.getUser("343333").getName(), is("Stepan"));
    }

    @Test
    public void whenAddThreeUserAndDeleteOne() {
        Bank bank = new Bank();
        bank.addUser(new User("Stepan", "343333"));
        bank.addUser(new User("Ivan", "245511"));
        bank.addUser(new User("Roman", "321678"));
        bank.deleteUser(bank.getUser("321678"));
        assertNull(bank.getUser("321678"));
    }

    @Test
    public void whenAddThreeUserAndCantFindUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Stepan", "343333"));
        bank.addUser(new User("Ivan", "245511"));
        bank.addUser(new User("Roman", "321678"));
        assertNull(bank.getUser("111111"));
    }

    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Stepan", "343333"));
        bank.addUser(new User("Ivan", "245511"));
        bank.addAccountToUser("245511", new Account(1000, "qwerty"));
        Account expected = new Account(1000, "qwerty");
        assertThat(bank.getOneUserAccount("245511", "qwerty"), is(expected));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        Bank bank = new Bank();
        bank.addUser(new User("Stepan", "343333"));
        bank.addUser(new User("Ivan", "245511"));
        bank.addAccountToUser("245511", new Account(1000, "qwerty"));
        bank.addAccountToUser("245511", new Account(100, "asd"));
        bank.deleteAccountFromUser("245511", bank.getOneUserAccount("245511", "asd"));
        bank.getOneUserAccount("245511", "asd");
        assertNull(bank.getOneUserAccount("245511", "asd"));
    }

    @Test
    public void whenGetOneUserAccount() {
        Bank bank = new Bank();
        bank.addUser(new User("Stepan", "343333"));
        bank.addUser(new User("Ivan", "245511"));
        bank.addAccountToUser("245511", new Account(1000, "qwerty"));
        bank.addAccountToUser("245511", new Account(100, "asd"));
        Account expected = new Account(100, "asd");
        assertThat(bank.getOneUserAccount("245511", "asd"), is(expected));
    }

    @Test
    public void whenTransferFromOneUserToAnotherThenTrue() {
        Bank bank = new Bank();
        bank.addUser(new User("Stepan", "343333"));
        bank.addUser(new User("Ivan", "245511"));
        bank.addAccountToUser("245511", new Account(1000, "qwerty"));
        bank.addAccountToUser("343333", new Account(100, "asd"));
        assertTrue(bank.transferMoney("343333", "asd", "245511", "qwerty", 50));
    }

    @Test
    public void whenTransferFromOneUserToAnotherButNotEnoughThenFalse() {
        Bank bank = new Bank();
        bank.addUser(new User("Stepan", "343333"));
        bank.addUser(new User("Ivan", "245511"));
        bank.addAccountToUser("245511", new Account(1000, "qwerty"));
        bank.addAccountToUser("343333", new Account(100, "asd"));
        assertFalse(bank.transferMoney("343333", "asd", "245511", "qwerty", 500));
    }
}
