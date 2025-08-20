package fb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public abstract class y<I, O> {

    /* renamed from: fb.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0100y<T> {
        @SuppressLint({"UnknownNullness"})
        public final T y;

        public C0100y(@SuppressLint({"UnknownNullness"}) T t2) {
            this.y = t2;
        }

        @SuppressLint({"UnknownNullness"})
        public T y() {
            return this.y;
        }
    }

    @NonNull
    public abstract Intent createIntent(@NonNull Context context, @SuppressLint({"UnknownNullness"}) I i);

    @Nullable
    public C0100y<O> getSynchronousResult(@NonNull Context context, @SuppressLint({"UnknownNullness"}) I i) {
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract O parseResult(int i, @Nullable Intent intent);
}
