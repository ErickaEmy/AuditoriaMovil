package org.fdroid.fdroid;

import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: HashUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"isMatching", "", "Ljava/security/MessageDigest;", "sha256", "", "toHex", "", "download_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HashUtilsKt {
    public static final boolean isMatching(MessageDigest messageDigest, String sha256) {
        boolean equals;
        Intrinsics.checkNotNullParameter(sha256, "sha256");
        if (messageDigest == null) {
            return false;
        }
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        equals = StringsKt__StringsJVMKt.equals(toHex(digest), sha256, true);
        return equals;
    }

    public static final String toHex(byte[] bArr) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(bArr, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: org.fdroid.fdroid.HashUtilsKt$toHex$1
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
}
