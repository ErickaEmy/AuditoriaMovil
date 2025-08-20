package i4;

import android.view.View;
/* loaded from: classes.dex */
public class y {
    public static String y(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }
}
