package io.riders.services.security;

/**
 * Created by tommy on 5/5/2017.
 */
public interface EncryptionService {
    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
