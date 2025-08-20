package a;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public abstract class n3<I> {
    @NonNull
    public abstract fb.y<I, ?> getContract();

    public void launch(@SuppressLint({"UnknownNullness"}) I i) {
        launch(i, null);
    }

    public abstract void launch(@SuppressLint({"UnknownNullness"}) I i, @Nullable rz.zn znVar);

    public abstract void unregister();
}
