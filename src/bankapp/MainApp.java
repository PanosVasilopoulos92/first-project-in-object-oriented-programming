package bankapp;

import bankapp.model.Account;
import bankapp.model.Holder;
import bankapp.model.JointAccount;
import bankapp.model.OverdraftAccount;

/**
 *  This class was created in order to check the functionality of the imported classes into the main method and
 *  of course in order to display them into the console.
 *  It contains the following classes: {@link Holder}, {@link Account}, {@link JointAccount}, {@link OverdraftAccount}
 * @author Panos V.
 * @version 1.0
 */
public class MainApp {

    public static void main(String[] args) throws Exception {
        Holder holder1 = new Holder(1L, "Panos", "Vasilopoulos", "SSN4433");    // Creates a new instance of type Holder and passes the necessary arguments.
        Holder holder2 = new Holder(2L, "Angeliki", "Vasilopoulou", "SSN4422");
        Account account = new Account(holder1, "GR44556677");           // It creates a new instance of type Account and passes the necessary arguments.
        Account account2 = new Account(holder2, "GR44556600");
        JointAccount jointAccount = new JointAccount(holder1, holder2, "GR40404399999");    // It creates a new instance of type JointAccount and passes the necessary arguments.

        OverdraftAccount overdraftAccount = new OverdraftAccount(holder1, "GR200800");       // Creates a new instance of type OverdraftAccount and passes the necessary arguments.
        OverdraftAccount overdraftAccount2 = new OverdraftAccount(holder2, "GR200801");

        overdraftAccount.deposit(2000);     // Makes a deposit into the "overdraftAccount" object.
        System.out.println("Balance: " + overdraftAccount.getAccountBalance());
        overdraftAccount.withdraw(600, "SSN4433");      // Makes a withdrawal from the "overdraftAccount" object, using the SSN as verification process.
        System.out.println("Balance: " + overdraftAccount.getAccountBalance());

        System.out.println();
        System.out.println(jointAccount.getJointAccountState());

        jointAccount.deposit(4000d);
        System.out.println(jointAccount.getAccountBalance());
    }
}
