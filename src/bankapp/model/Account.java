package bankapp.model;

/**
 *  Defines the Account class {@link Account}.
 *  It contains the following fields: {@link #holder}, {@link #iban} and {@link #balance}.
 * @author Panos V.
 * @version 1.0
 */
public class Account {
    private final Holder holder;
    private final String iban;
    private double balance;

    /**
     *  The default constructor.
     */
    public Account() {
        holder = new Holder();
        iban = "";
    }

    /**
     *  The overloaded constructor.
     * @param holder  The typical parameter of the Holder object.
     * @param iban  The typical parameter for the iban.
     */
    public Account(Holder holder, String iban) {
        this.holder = new Holder(holder.getId(), holder.getFirstname(), holder.getLastname(), holder.getSsn());
        this.iban = iban;
    }

//    public Holder getHolder() {
//        return new Holder(holder.getId(), holder.getFirstname(), holder.getLastname(), holder.getSsn());
//    }

    /**
     *  Gets account's IBAN.
     * @return  account's IBAN.
     */
    public String getIban() {
        return iban;
    }

    /**
     *  Gets account's balance.
     * @return  account's balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     *  This method handles the deposits of the account.
     * @param amount   The typical parameter for the amount of money will be deposited.
     * @throws Exception  if the user type a negative amount.
     */
    public void deposit(double amount) throws Exception {
        try {
            if (amount > 0) {
                balance += amount;
            } else {
                throw new Exception("Amount negative or zero.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     *  This method is responsible for the withdrawal actions.
     * @param amount  The typical parameter for the amount of money that will be withdrawn.
     * @param ssn   The Social Security Number.
     * @throws Exception  if user types an amount that is greater than account's balance.
     */
    public void withdraw(double amount, String ssn) throws Exception {
        try {
            if (!isSSNValid(ssn)) throw new Exception("Invalid SSN.");
            if (amount <= balance) {
                balance -= amount;
            } else {
                throw new Exception("Inefficient account balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     *  Checks if the SSN that user typed is same with the SSN that exist in the account's data.
     * @param ssn   The Social Security Number.
     * @return  false if SSN does not match and true if it does.
     */
    public boolean isSSNValid(String ssn) {
        return this.holder.getSsn().equals(ssn);
    }

    /**
     *  Gets account balance.
     * @return  account's balance.
     */
    public double getAccountBalance() {
        return getBalance();
    }

    /**
     *  Displays the state of the object-instance.
     * @return  a String that contains the state of the object.
     */
    public String getAccountState() {
        return "Holder info:\n" + holder.getHolderInfo() + "\nAccount IBAN: " + getIban() + "\nAccount Balance: " + getAccountBalance();
    }
}
