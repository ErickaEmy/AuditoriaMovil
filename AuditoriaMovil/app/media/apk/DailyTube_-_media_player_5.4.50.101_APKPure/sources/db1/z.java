package db1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class z {
    public static final z y = new z();

    public final String n3(byte[] bArr) {
        byte[] digest;
        if (bArr != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
        return y(digest);
    }

    public final String y(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
