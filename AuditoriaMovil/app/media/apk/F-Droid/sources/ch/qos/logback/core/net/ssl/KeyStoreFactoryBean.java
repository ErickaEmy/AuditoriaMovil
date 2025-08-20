package ch.qos.logback.core.net.ssl;

import ch.qos.logback.core.util.LocationUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
/* loaded from: classes.dex */
public class KeyStoreFactoryBean {
    private String location;
    private String password;
    private String provider;
    private String type;

    private KeyStore newKeyStore() throws NoSuchAlgorithmException, NoSuchProviderException, KeyStoreException {
        return getProvider() != null ? KeyStore.getInstance(getType(), getProvider()) : KeyStore.getInstance(getType());
    }

    public KeyStore createKeyStore() throws NoSuchProviderException, NoSuchAlgorithmException, KeyStoreException {
        if (getLocation() != null) {
            InputStream inputStream = null;
            try {
                try {
                    try {
                        inputStream = LocationUtil.urlForResource(getLocation()).openStream();
                        KeyStore newKeyStore = newKeyStore();
                        newKeyStore.load(inputStream, getPassword().toCharArray());
                        return newKeyStore;
                    } catch (FileNotFoundException unused) {
                        throw new KeyStoreException(getLocation() + ": file not found");
                    } catch (NoSuchProviderException unused2) {
                        throw new NoSuchProviderException("no such keystore provider: " + getProvider());
                    }
                } catch (NoSuchAlgorithmException unused3) {
                    throw new NoSuchAlgorithmException("no such keystore type: " + getType());
                } catch (Exception e) {
                    throw new KeyStoreException(getLocation() + ": " + e.getMessage(), e);
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace(System.err);
                    }
                }
            }
        }
        throw new IllegalArgumentException("location is required");
    }

    public String getLocation() {
        return this.location;
    }

    public String getPassword() {
        String str = this.password;
        return str == null ? "changeit" : str;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getType() {
        String str = this.type;
        return str == null ? "JKS" : str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
