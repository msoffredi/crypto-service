package org.soffredi;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class CryptoServiceConfiguration extends Configuration {
    @NotEmpty
    private String encryptionKey;

    @JsonProperty
    public String getEncryptionKey() {
        return encryptionKey;
    }

    @JsonProperty
    public void setEncryptionKey(String key) {
        encryptionKey = key;
    }
}
