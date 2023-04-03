package bankapp.model;

/**
 *  Defines a customer of a bank {@link Holder}.
 * @author Panos V.
 * @version 1.0
 */
public class Holder {
    private final Long id ;
    private final String firstname;
    private final String lastname;
    private final String ssn;

    /**
     *  The default constructor.
     */
    public Holder() {
        id = 0L;
        firstname = "";
        lastname = "";
        ssn = "";
    }

    /**
     *  The overloaded constructor.
     * @param id  The typical parameter of holder's id.
     * @param firstname The typical parameter for the holder's firstname.
     * @param lastname  The typical parameter for the holder's lastname.
     * @param ssn   The typical parameter for the holder's SSN(Social Security Number).
     */
    public Holder(Long id, String firstname, String lastname, String ssn) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
    }

    /**
     *  Gets holder's ID.
     * @return holder's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     *  Gets holder's firstname.
     * @return  holder's firstname.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *  Gets holder's lastname.
     * @return  holder's lastname.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Gets holder's SSN.
     * @return  holder's SSN.
     */
    public String getSsn() {
        return ssn;
    }

    /**
     *  Displays the state of the object-instance.
     * @return  a String that contains the state of the object.
     */
    public String getHolderInfo() {
        return "Id: " + getId() + "\nName: " + getFirstname() +"\nLastname: " + getLastname() + "\nSSN: " + getSsn();
    }
}
