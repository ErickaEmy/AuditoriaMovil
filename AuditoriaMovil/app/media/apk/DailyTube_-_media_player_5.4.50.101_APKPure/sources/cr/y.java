package cr;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class y {
    public static void n3(@NonNull Animator animator) {
        animator.pause();
    }

    public static void y(@NonNull Animator animator, @NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    public static void zn(@NonNull Animator animator) {
        animator.resume();
    }
}
