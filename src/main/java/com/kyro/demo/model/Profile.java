package com.kyro.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "displayname")
    private String displayName;

    @Column(name = "email")
    private String email;

    @Column(name = "worknumber")
    private String phoneNumberWork;

    @Column(name = "homenumber")
    private String phoneNumberHome;

    @Column(name = "location")
    private String location;


    public Profile() {

    }

    public Profile(String firstName, String lastName, String displayName, String email, String workNumber, String homeNumber, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.email = email;
        this.phoneNumberWork = workNumber;
        this.phoneNumberHome = homeNumber;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumberWork() {
        return phoneNumberWork;
    }

    public void setPhoneNumberWork(String workNumber) {
        this.phoneNumberWork = workNumber;
    }


    public String getPhoneNumberHome() {
        return phoneNumberHome;
    }

    public void setPhoneNumberHome(String homeNumber) {
        this.phoneNumberHome = homeNumber;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Profile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", displayName=" + displayName
                + ", email=" + email + ", workNumber=" + phoneNumberWork + ", homeNumber=" + phoneNumberHome + ", location=" + location + "]";
    }
}
