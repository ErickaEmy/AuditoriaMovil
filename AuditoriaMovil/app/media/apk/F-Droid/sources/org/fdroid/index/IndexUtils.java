package org.fdroid.index;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
/* compiled from: IndexUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0015\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0001¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0002\b\u000eJ\u0011\u0010\u000f\u001a\u00020\b*\u00020\u0004H\u0000¢\u0006\u0002\b\u0010J\u0011\u0010\u0011\u001a\u00020\u0004*\u00020\bH\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lorg/fdroid/index/IndexUtils;", "", "()V", "getFingerprint", "", "certificate", "getPackageSigner", "signerBytes", "", "getsig", "md5", "bytes", "md5$index_release", "sha256", "sha256$index_release", "decodeHex", "decodeHex$index_release", "toHex", "toHex$index_release", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndexUtils {
    public static final IndexUtils INSTANCE = new IndexUtils();

    private IndexUtils() {
    }

    public final String getFingerprint(String certificate) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return toHex$index_release(sha256$index_release(decodeHex$index_release(certificate)));
    }

    public final String getPackageSigner(byte[] signerBytes) {
        Intrinsics.checkNotNullParameter(signerBytes, "signerBytes");
        return toHex$index_release(sha256$index_release(signerBytes));
    }

    public final String getsig(byte[] signerBytes) {
        byte[] encodeToByteArray;
        Intrinsics.checkNotNullParameter(signerBytes, "signerBytes");
        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(toHex$index_release(signerBytes));
        return toHex$index_release(md5$index_release(encodeToByteArray));
    }

    public final byte[] decodeHex$index_release(String str) {
        List<String> chunked;
        int collectionSizeOrDefault;
        byte[] byteArray;
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalStateException("Must have an even length".toString());
        }
        chunked = StringsKt___StringsKt.chunked(str, 2);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(chunked, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str2 : chunked) {
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            arrayList.add(Byte.valueOf((byte) Integer.parseInt(str2, checkRadix)));
        }
        byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList);
        return byteArray;
    }

    public final String toHex$index_release(byte[] bArr) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(bArr, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: org.fdroid.index.IndexUtils$toHex$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).byteValue());
            }

            public final CharSequence invoke(byte b) {
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                return format;
            }
        }, 30, (Object) null);
        return joinToString$default;
    }

    public final byte[] sha256$index_release(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            Intrinsics.checkNotNull(messageDigest);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            return digest;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] md5$index_release(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            Intrinsics.checkNotNull(messageDigest);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            return digest;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
