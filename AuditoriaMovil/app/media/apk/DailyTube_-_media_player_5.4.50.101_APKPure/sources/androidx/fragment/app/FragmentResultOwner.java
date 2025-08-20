package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import y5.co;
/* loaded from: classes.dex */
public interface FragmentResultOwner {
    void clearFragmentResult(@NonNull String str);

    void clearFragmentResultListener(@NonNull String str);

    void setFragmentResult(@NonNull String str, @NonNull Bundle bundle);

    void setFragmentResultListener(@NonNull String str, @NonNull co coVar, @NonNull FragmentResultListener fragmentResultListener);
}
