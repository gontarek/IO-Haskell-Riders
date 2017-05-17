package io.riders.services.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tommy on 5/5/2017.
 */

/**
 * Service for encrypting passwords
 */
@Service
public class EncryptionServiceImpl implements EncryptionService {
    private StrongPasswordEncryptor strongEncryptor;

    @Autowired
    public void setStrongEncryptor(StrongPasswordEncryptor strongEncryptor) {
        this.strongEncryptor = strongEncryptor;
    }

    /**
     * Encrypts given String with the use of strong encryption
     * @param input
     * @return
     */
    public String encryptString(String input) {
        return strongEncryptor.encryptPassword(input);
    }

    /**
     * Checks is plainPasswords corresponds to encryptedPassword
     * @param plainPassword
     * @param encryptedPassword
     * @return
     */
    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return strongEncryptor.checkPassword(plainPassword, encryptedPassword);
    }
}
