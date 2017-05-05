package io.riders.services.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tommy on 5/5/2017.
 */
public class EncryptionServiceImpl implements EncryptionService {
    private StrongPasswordEncryptor strongEncryptor;

    @Autowired
    public void setStrongEncryptor(StrongPasswordEncryptor strongEncryptor) {
        this.strongEncryptor = strongEncryptor;
    }

    public String encryptString(String input) {
        return strongEncryptor.encryptPassword(input);
    }

    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return strongEncryptor.checkPassword(plainPassword, encryptedPassword);
    }
}
