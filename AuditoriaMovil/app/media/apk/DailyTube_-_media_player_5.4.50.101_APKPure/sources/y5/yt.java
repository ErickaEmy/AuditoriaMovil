package y5;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.runtime.R$id;
/* loaded from: classes.dex */
public class yt {
    public static void n3(@NonNull View view, @Nullable co coVar) {
        view.setTag(R$id.y, coVar);
    }

    @Nullable
    public static co y(@NonNull View view) {
        co coVar = (co) view.getTag(R$id.y);
        if (coVar != null) {
            return coVar;
        }
        ViewParent parent = view.getParent();
        while (coVar == null && (parent instanceof View)) {
            View view2 = (View) parent;
            coVar = (co) view2.getTag(R$id.y);
            parent = view2.getParent();
        }
        return coVar;
    }
}
