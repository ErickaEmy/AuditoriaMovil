package m1;

import android.os.Bundle;
/* loaded from: classes.dex */
public interface s {

    /* loaded from: classes.dex */
    public interface y<T extends s> {
        T fromBundle(Bundle bundle);
    }

    Bundle toBundle();
}
