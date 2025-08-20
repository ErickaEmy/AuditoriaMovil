package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.ResultKt;
/* loaded from: classes.dex */
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED;

    static {
        Object m28constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
        }
        ANDROID_DETECTED = Result.m33isSuccessimpl(m28constructorimpl);
    }

    public static final boolean getANDROID_DETECTED() {
        return ANDROID_DETECTED;
    }
}
