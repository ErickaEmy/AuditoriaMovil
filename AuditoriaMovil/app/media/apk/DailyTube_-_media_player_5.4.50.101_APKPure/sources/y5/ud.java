package y5;

import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class ud {
    @Nullable
    private final Map<String, Object> mBagOfTags = new HashMap();
    private volatile boolean mCleared = false;

    private static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                try {
                    for (Object obj : this.mBagOfTags.values()) {
                        closeWithRuntimeException(obj);
                    }
                } finally {
                }
            }
        }
        onCleared();
    }

    public <T> T getTag(String str) {
        T t2;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t2 = (T) this.mBagOfTags.get(str);
        }
        return t2;
    }

    public <T> T setTagIfAbsent(String str, T t2) {
        Object obj;
        synchronized (this.mBagOfTags) {
            try {
                obj = this.mBagOfTags.get(str);
                if (obj == null) {
                    this.mBagOfTags.put(str, t2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            t2 = obj;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t2);
        }
        return t2;
    }

    public void onCleared() {
    }
}
