package org.fdroid.fdroid;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
/* loaded from: classes2.dex */
public class Hasher {
    private final byte[] array;
    private MessageDigest digest;
    private String hashCache;

    public Hasher(String str, byte[] bArr) throws NoSuchAlgorithmException {
        init(str);
        this.array = bArr;
    }

    private void init(String str) throws NoSuchAlgorithmException {
        try {
            this.digest = MessageDigest.getInstance(str);
        } catch (Exception e) {
            throw new NoSuchAlgorithmException(e);
        }
    }

    public String getHash() {
        String str = this.hashCache;
        if (str != null) {
            return str;
        }
        this.digest.update(this.array);
        String hex = hex(this.digest.digest());
        this.hashCache = hex;
        return hex;
    }

    public static String hex(Certificate certificate) {
        byte[] bArr;
        try {
            bArr = certificate.getEncoded();
        } catch (CertificateEncodingException unused) {
            bArr = new byte[0];
        }
        return hex(bArr);
    }

    private static String hex(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            int i3 = i * 2;
            bArr2[i3] = (byte) (i2 >= 10 ? i2 + 87 : i2 + 48);
            int i4 = b & 15;
            bArr2[i3 + 1] = (byte) (i4 >= 10 ? i4 + 87 : i4 + 48);
        }
        return new String(bArr2);
    }

    static byte[] unhex(String str) {
        int i;
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ('0' <= charAt && charAt <= '9') {
                i = charAt - '0';
            } else if ('a' <= charAt && charAt <= 'f') {
                i = charAt - 'W';
            } else if ('A' > charAt || charAt > 'F') {
                throw new IllegalArgumentException("Bad hex digit");
            } else {
                i = charAt - '7';
            }
            int i3 = i2 / 2;
            byte b = bArr[i3];
            if (i2 % 2 == 0) {
                i <<= 4;
            }
            bArr[i3] = (byte) (b + ((byte) i));
        }
        return bArr;
    }
}
