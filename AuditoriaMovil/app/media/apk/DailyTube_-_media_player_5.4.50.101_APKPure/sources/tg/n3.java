package tg;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes.dex */
public interface n3<T> {
    @NonNull
    T create(@NonNull Context context);

    @NonNull
    List<Class<? extends n3<?>>> dependencies();
}
