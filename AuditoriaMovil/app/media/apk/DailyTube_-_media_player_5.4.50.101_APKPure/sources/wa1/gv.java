package wa1;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class gv {
    public static final FragmentManager y(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        AppCompatActivity n32 = n3.n3(context);
        if (n32 != null) {
            return n32.getSupportFragmentManager();
        }
        return null;
    }
}
