package model;

public class Subscription implements Identifiable<Integer> {

    private int id;
    private String participant;
    private String phoneNr;
    private String address;
    private String cookingClass;

    public Subscription(String participant, String phoneNr, String address, String cookingClass) {
        this.participant = participant;
        this.phoneNr = phoneNr;
        this.address = address;
        this.cookingClass = cookingClass;
    }

    public Subscription(int id, String participant, String phoneNr, String address, String cookingClass) {
        this.id = id;
        this.participant = participant;
        this.phoneNr = phoneNr;
        this.address = address;
        this.cookingClass = cookingClass;
    }

    public Subscription() {

        this.id = 0;
        this.participant = "";
        this.phoneNr = "";
        this.address = "";
        this.cookingClass = "";

    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCookingClass() {
        return cookingClass;
    }

    public void setCookingClass(String cookingClass) {
        this.cookingClass = cookingClass;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob instanceof Subscription) {
            Subscription c = (Subscription) ob;
            if (c.participant.equals(participant) && c.phoneNr.equals(phoneNr) && c.address.equals(address) && c.cookingClass.equals(cookingClass))
                return true;
        }
        return false;
    }

    public String toString() {
        return id + " | "  + participant + " | " + phoneNr + " | " + address + " | " + cookingClass;
    }

}
