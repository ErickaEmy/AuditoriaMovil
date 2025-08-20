package q9;

import androidx.annotation.Nullable;
import java.io.Serializable;
/* loaded from: classes.dex */
public class a<T> extends androidx.databinding.n3 implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public void ct(T t2) {
        if (t2 != this.mValue) {
            this.mValue = t2;
            o();
        }
    }

    @Nullable
    public T u() {
        return this.mValue;
    }
}
