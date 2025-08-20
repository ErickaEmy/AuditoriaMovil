package kotlinx.serialization.json.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: ByteArrayPool.kt */
/* loaded from: classes2.dex */
public final class ByteArrayPool {
    private static final int MAX_CHARS_IN_POOL;
    private static int charsTotal;
    public static final ByteArrayPool INSTANCE = new ByteArrayPool();
    private static final ArrayDeque arrays = new ArrayDeque();

    private ByteArrayPool() {
    }

    static {
        Object m2081constructorimpl;
        Integer intOrNull;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            Intrinsics.checkNotNullExpressionValue(property, "getProperty(\"kotlinx.ser…lization.json.pool.size\")");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(property);
            m2081constructorimpl = Result.m2081constructorimpl(intOrNull);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2081constructorimpl = Result.m2081constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2086isFailureimpl(m2081constructorimpl)) {
            m2081constructorimpl = null;
        }
        Integer num = (Integer) m2081constructorimpl;
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : PKIFailureInfo.badSenderNonce;
    }

    public final byte[] take() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) arrays.removeLastOrNull();
            if (bArr != null) {
                charsTotal -= bArr.length;
            } else {
                bArr = null;
            }
        }
        return bArr == null ? new byte[512] : bArr;
    }

    public final void release(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        synchronized (this) {
            try {
                int i = charsTotal;
                if (array.length + i < MAX_CHARS_IN_POOL) {
                    charsTotal = i + array.length;
                    arrays.addLast(array);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
