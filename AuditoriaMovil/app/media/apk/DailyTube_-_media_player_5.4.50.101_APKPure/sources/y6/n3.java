package y6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes.dex */
public class n3 {
    public static void y(@NonNull AnimatorSet animatorSet, @NonNull List<Animator> list) {
        int size = list.size();
        long j2 = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            j2 = Math.max(j2, animator.getStartDelay() + animator.getDuration());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j2);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }
}
