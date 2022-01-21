package org.soffredi.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AESTest {
    final static String PLAIN_STR = "Plain text";
    // "Plain text" encrypted using key "Test" and AES
    final static String ENCRYPTED_STR = "bw8oE6Qu3QNpjJzUQVBNVA==";
    final static String KEY = "Test";

    @Test
    public void encryptsString() throws Exception {
        final String encrypted = AES.encrypt(PLAIN_STR, KEY);
        assertThat(encrypted).isEqualTo(ENCRYPTED_STR);
    }

    @Test
    public void DecryptsString() throws Exception {
        final String decrypted = AES.decrypt(ENCRYPTED_STR, KEY);
        assertThat(decrypted).isEqualTo(PLAIN_STR);
    }
}