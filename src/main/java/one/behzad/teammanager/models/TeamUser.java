package one.behzad.teammanager.models;

import java.io.File;

public record TeamUser(String surName, String lastName, String email, Adress adress, String phoneNr,
                       File profilePicture) {
}
