package y6;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    public final z.s<String, c5> y = new z.s<>();

    /* renamed from: n3  reason: collision with root package name */
    public final z.s<String, PropertyValuesHolder[]> f15322n3 = new z.s<>();

    @NonNull
    public static s gv(@NonNull List<Animator> list) {
        s sVar = new s();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            y(sVar, list.get(i));
        }
        return sVar;
    }

    @Nullable
    public static s n3(@NonNull Context context, @NonNull TypedArray typedArray, int i) {
        int resourceId;
        if (typedArray.hasValue(i) && (resourceId = typedArray.getResourceId(i, 0)) != 0) {
            return zn(context, resourceId);
        }
        return null;
    }

    public static void y(@NonNull s sVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            sVar.s(objectAnimator.getPropertyName(), objectAnimator.getValues());
            sVar.c5(objectAnimator.getPropertyName(), c5.n3(objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    @Nullable
    public static s zn(@NonNull Context context, int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return gv(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return gv(arrayList);
        } catch (Exception e2) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i), e2);
            return null;
        }
    }

    public long a() {
        int size = this.y.size();
        long j2 = 0;
        for (int i = 0; i < size; i++) {
            c5 xc2 = this.y.xc(i);
            j2 = Math.max(j2, xc2.zn() + xc2.gv());
        }
        return j2;
    }

    public void c5(String str, @Nullable c5 c5Var) {
        this.y.put(str, c5Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        return this.y.equals(((s) obj).y);
    }

    public boolean fb(String str) {
        if (this.y.get(str) != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    public void s(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f15322n3.put(str, propertyValuesHolderArr);
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.y + "}\n";
    }

    public c5 v(String str) {
        if (fb(str)) {
            return this.y.get(str);
        }
        throw new IllegalArgumentException();
    }
}
