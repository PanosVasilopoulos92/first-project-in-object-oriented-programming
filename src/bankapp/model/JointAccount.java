package bankapp.model;

/**
 *  This class was designed so that it allows two holders to share a common account.
 *  It contains the following fields: {@link #holder1}, {@link #holder2}, {@link #iban}, {@link #balance}.
 * @author Panos V.
 * @version 1.0
 */
public class JointAccount {
    private final Holder holder1;
    private final Holder holder2;
    private final String iban;
    private double balance;

    /**
     *  The default constructor.
     */
    public JointAccount() {
        holder1 = new Holder();
        holder2 = new Holder();
        iban = "";
    }

    /**
     *  The overloaded constructor.
     * @param holder1    The typical parameter of the Holder object.
     * @param holder2    The typical parameter of the Holder object.
     * @param iban    The typical parameter for the IBAN.
     */
    public JointAccount(Holder holder1, Holder holder2, String iban) {
        this.holder1 = new Holder(holder1.getId(), holder1.getFirstname(), holder1.getLastname(), holder1.getSsn());
        this.holder2 = new Holder(holder2.getId(), holder2.getFirstname(), holder2.getLastname(), holder2.getSsn());
        this.iban = iban;
    }

    /**
     *  Gets holder1 object.
     * @return  holder1.
     */
    public Holder getHolder1() {
        return holder1;
    }

    /**
     *  Gets holder2 object.
     * @return  holder2.
     */
    public Holder getHolder2() {
        return holder2;
    }

    /**
     *  Gets account's balance.
     * @return  account's balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     *  Gets account's IBAN.
     * @return  account's IBAN.
     */
    public String getIban() { return iban;}

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
        return (this.holder1.getSsn().equals(ssn)) || (this.holder2.getSsn().equals(ssn));
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
    public String getJointAccountState() {
        return "\nHolders: " + holder1.getFirstname() +" " + holder1.getLastname() + " and " + holder2.getFirstname() + " " + holder2.getLastname() +
                "\nIBAN: " + getIban() + "\nAccount balance: " + getBalance() + "\n" +
                "\nHolder 1 info:\n" + holder1.getHolderInfo() + "\n\nHolder 2 info:\n" + holder2.getHolderInfo();
    }
}
