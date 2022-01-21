package org.soffredi.resources;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.soffredi.api.EncryptedNumber;
import org.soffredi.api.MyNumber;

public class DecryptResourceTest {
    final static private String KEY = "abc123";
    final static private String ENCRYPTED_NUM = "W7+AeY5oqQgkfMYYPw6/FQ==";
    final static private Double NUM = 4d;
    final private DecryptResource resource = new DecryptResource(KEY);
    
    @Test
    public void executesSuccessfully() {
        final MyNumber number = resource.run(new EncryptedNumber(ENCRYPTED_NUM));
        assertThat(number.getNumber()).isEqualTo(NUM);
    }
}
