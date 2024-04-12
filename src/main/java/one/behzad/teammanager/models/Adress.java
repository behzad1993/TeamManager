package one.behzad.teammanager.models;

public record Adress(String Street, String houseNr, String apartmentNr, String zipCode, String City, String State,
                     String country) {
    public Adress {
    }
}
