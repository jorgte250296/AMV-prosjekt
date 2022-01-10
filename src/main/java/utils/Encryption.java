package utils;

import org.apache.commons.codec.digest.DigestUtils;

/* Klasse for kryptering av passord i user-tabell */
public class Encryption {
    /* Tilfeldig nøkkel. */
    private final static String PASSWORD_SECRET = ")2AX9x8q)*jo&QGW";

    public static String encrypt(String password) {
        /* Enveis transformasjon på et passord, gjør passordet til en annen streng, kalt hashed passord. */
        return DigestUtils.md5Hex(password + PASSWORD_SECRET).toUpperCase();
    }
}

