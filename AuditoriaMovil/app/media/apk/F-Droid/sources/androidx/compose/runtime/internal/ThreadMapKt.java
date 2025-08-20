package androidx.compose.runtime.internal;
/* compiled from: ThreadMap.kt */
/* loaded from: classes.dex */
public abstract class ThreadMapKt {
    private static final ThreadMap emptyThreadMap = new ThreadMap(0, new long[0], new Object[0]);

    public static final ThreadMap getEmptyThreadMap() {
        return emptyThreadMap;
    }
}
