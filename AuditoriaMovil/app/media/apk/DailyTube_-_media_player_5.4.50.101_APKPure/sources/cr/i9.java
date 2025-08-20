package cr;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.R$id;
/* loaded from: classes.dex */
public class i9 {

    /* renamed from: n3  reason: collision with root package name */
    public Runnable f6770n3;
    public ViewGroup y;

    @Nullable
    public static i9 n3(@NonNull ViewGroup viewGroup) {
        return (i9) viewGroup.getTag(R$id.transition_current_scene);
    }

    public static void zn(@NonNull ViewGroup viewGroup, @Nullable i9 i9Var) {
        viewGroup.setTag(R$id.transition_current_scene, i9Var);
    }

    public void y() {
        Runnable runnable;
        if (n3(this.y) == this && (runnable = this.f6770n3) != null) {
            runnable.run();
        }
    }
}
