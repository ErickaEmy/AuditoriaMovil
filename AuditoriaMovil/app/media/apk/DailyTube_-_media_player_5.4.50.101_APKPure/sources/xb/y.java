package xb;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.versionedparcelable.ParcelImpl;
/* loaded from: classes.dex */
public class y {
    public static Parcelable gv(gv gvVar) {
        return new ParcelImpl(gvVar);
    }

    @Nullable
    public static <T extends gv> T n3(@NonNull Bundle bundle, @NonNull String str) {
        try {
            Bundle bundle2 = (Bundle) bundle.getParcelable(str);
            if (bundle2 == null) {
                return null;
            }
            bundle2.setClassLoader(y.class.getClassLoader());
            return (T) y(bundle2.getParcelable("a"));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static <T extends gv> T y(Parcelable parcelable) {
        if (parcelable instanceof ParcelImpl) {
            return (T) ((ParcelImpl) parcelable).y();
        }
        throw new IllegalArgumentException("Invalid parcel");
    }

    public static void zn(@NonNull Bundle bundle, @NonNull String str, @Nullable gv gvVar) {
        if (gvVar == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("a", gv(gvVar));
        bundle.putParcelable(str, bundle2);
    }
}
