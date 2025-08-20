package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.a;
import androidx.lifecycle.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import y5.co;
/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    public Random y = new Random();

    /* renamed from: n3  reason: collision with root package name */
    public final Map<Integer, String> f604n3 = new HashMap();

    /* renamed from: zn  reason: collision with root package name */
    public final Map<String, Integer> f607zn = new HashMap();

    /* renamed from: gv  reason: collision with root package name */
    public final Map<String, gv> f603gv = new HashMap();

    /* renamed from: v  reason: collision with root package name */
    public ArrayList<String> f606v = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public final transient Map<String, zn<?>> f601a = new HashMap();

    /* renamed from: fb  reason: collision with root package name */
    public final Map<String, Object> f602fb = new HashMap();

    /* renamed from: s  reason: collision with root package name */
    public final Bundle f605s = new Bundle();

    /* loaded from: classes.dex */
    public static class gv {

        /* renamed from: n3  reason: collision with root package name */
        public final ArrayList<a> f611n3 = new ArrayList<>();
        public final v y;

        public gv(@NonNull v vVar) {
            this.y = vVar;
        }

        public void n3() {
            Iterator<a> it = this.f611n3.iterator();
            while (it.hasNext()) {
                this.y.zn(it.next());
            }
            this.f611n3.clear();
        }

        public void y(@NonNull a aVar) {
            this.y.y(aVar);
            this.f611n3.add(aVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* loaded from: classes.dex */
    public class n3<I> extends a.n3<I> {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ int f613n3;
        public final /* synthetic */ String y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ fb.y f614zn;

        public n3(String str, int i, fb.y yVar) {
            this.y = str;
            this.f613n3 = i;
            this.f614zn = yVar;
        }

        @Override // a.n3
        @NonNull
        public fb.y<I, ?> getContract() {
            return this.f614zn;
        }

        @Override // a.n3
        public void launch(I i, @Nullable rz.zn znVar) {
            int i5;
            ActivityResultRegistry.this.f606v.add(this.y);
            Integer num = ActivityResultRegistry.this.f607zn.get(this.y);
            ActivityResultRegistry activityResultRegistry = ActivityResultRegistry.this;
            if (num != null) {
                i5 = num.intValue();
            } else {
                i5 = this.f613n3;
            }
            activityResultRegistry.a(i5, this.f614zn, i, znVar);
        }

        @Override // a.n3
        public void unregister() {
            ActivityResultRegistry.this.t(this.y);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* loaded from: classes.dex */
    public class y<I> extends a.n3<I> {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ int f616n3;
        public final /* synthetic */ String y;

        /* renamed from: zn  reason: collision with root package name */
        public final /* synthetic */ fb.y f617zn;

        public y(String str, int i, fb.y yVar) {
            this.y = str;
            this.f616n3 = i;
            this.f617zn = yVar;
        }

        @Override // a.n3
        @NonNull
        public fb.y<I, ?> getContract() {
            return this.f617zn;
        }

        @Override // a.n3
        public void launch(I i, @Nullable rz.zn znVar) {
            int i5;
            ActivityResultRegistry.this.f606v.add(this.y);
            Integer num = ActivityResultRegistry.this.f607zn.get(this.y);
            ActivityResultRegistry activityResultRegistry = ActivityResultRegistry.this;
            if (num != null) {
                i5 = num.intValue();
            } else {
                i5 = this.f616n3;
            }
            activityResultRegistry.a(i5, this.f617zn, i, znVar);
        }

        @Override // a.n3
        public void unregister() {
            ActivityResultRegistry.this.t(this.y);
        }
    }

    /* loaded from: classes.dex */
    public static class zn<O> {

        /* renamed from: n3  reason: collision with root package name */
        public final fb.y<?, O> f618n3;
        public final a.y<O> y;

        public zn(a.y<O> yVar, fb.y<?, O> yVar2) {
            this.y = yVar;
            this.f618n3 = yVar2;
        }
    }

    public abstract <I, O> void a(int i, @NonNull fb.y<I, O> yVar, @SuppressLint({"UnknownNullness"}) I i5, @Nullable rz.zn znVar);

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final <I, O> a.n3<I> c5(@NonNull String str, @NonNull fb.y<I, O> yVar, @NonNull a.y<O> yVar2) {
        int f4 = f(str);
        this.f601a.put(str, new zn<>(yVar2, yVar));
        if (this.f602fb.containsKey(str)) {
            Object obj = this.f602fb.get(str);
            this.f602fb.remove(str);
            yVar2.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f605s.getParcelable(str);
        if (activityResult != null) {
            this.f605s.remove(str);
            yVar2.onActivityResult(yVar.parseResult(activityResult.n3(), activityResult.y()));
        }
        return new n3(str, f4, yVar);
    }

    public final int f(String str) {
        Integer num = this.f607zn.get(str);
        if (num != null) {
            return num.intValue();
        }
        int v2 = v();
        y(v2, str);
        return v2;
    }

    public final void fb(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList != null && integerArrayList != null) {
            this.f606v = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            this.y = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
            this.f605s.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            for (int i = 0; i < stringArrayList.size(); i++) {
                String str = stringArrayList.get(i);
                if (this.f607zn.containsKey(str)) {
                    Integer remove = this.f607zn.remove(str);
                    if (!this.f605s.containsKey(str)) {
                        this.f604n3.remove(remove);
                    }
                }
                y(integerArrayList.get(i).intValue(), stringArrayList.get(i));
            }
        }
    }

    public final <O> void gv(String str, int i, @Nullable Intent intent, @Nullable zn<O> znVar) {
        a.y<O> yVar;
        if (znVar != null && (yVar = znVar.y) != null) {
            yVar.onActivityResult(znVar.f618n3.parseResult(i, intent));
            return;
        }
        this.f602fb.remove(str);
        this.f605s.putParcelable(str, new ActivityResult(i, intent));
    }

    @NonNull
    public final <I, O> a.n3<I> i9(@NonNull final String str, @NonNull co coVar, @NonNull final fb.y<I, O> yVar, @NonNull final a.y<O> yVar2) {
        v lifecycle = coVar.getLifecycle();
        if (!lifecycle.n3().y(v.zn.STARTED)) {
            int f4 = f(str);
            gv gvVar = this.f603gv.get(str);
            if (gvVar == null) {
                gvVar = new gv(lifecycle);
            }
            gvVar.y(new a() { // from class: androidx.activity.result.ActivityResultRegistry.1
                @Override // androidx.lifecycle.a
                public void onStateChanged(@NonNull co coVar2, @NonNull v.n3 n3Var) {
                    if (v.n3.ON_START.equals(n3Var)) {
                        ActivityResultRegistry.this.f601a.put(str, new zn<>(yVar2, yVar));
                        if (ActivityResultRegistry.this.f602fb.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f602fb.get(str);
                            ActivityResultRegistry.this.f602fb.remove(str);
                            yVar2.onActivityResult(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f605s.getParcelable(str);
                        if (activityResult != null) {
                            ActivityResultRegistry.this.f605s.remove(str);
                            yVar2.onActivityResult(yVar.parseResult(activityResult.n3(), activityResult.y()));
                        }
                    } else if (v.n3.ON_STOP.equals(n3Var)) {
                        ActivityResultRegistry.this.f601a.remove(str);
                    } else if (v.n3.ON_DESTROY.equals(n3Var)) {
                        ActivityResultRegistry.this.t(str);
                    }
                }
            });
            this.f603gv.put(str, gvVar);
            return new y(str, f4, yVar);
        }
        throw new IllegalStateException("LifecycleOwner " + coVar + " is attempting to register while current state is " + lifecycle.n3() + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final boolean n3(int i, int i5, @Nullable Intent intent) {
        String str = this.f604n3.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.f606v.remove(str);
        gv(str, i5, intent, this.f601a.get(str));
        return true;
    }

    public final void s(@NonNull Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f607zn.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f607zn.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f606v));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f605s.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.y);
    }

    public final void t(@NonNull String str) {
        Integer remove;
        if (!this.f606v.contains(str) && (remove = this.f607zn.remove(str)) != null) {
            this.f604n3.remove(remove);
        }
        this.f601a.remove(str);
        if (this.f602fb.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f602fb.get(str));
            this.f602fb.remove(str);
        }
        if (this.f605s.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f605s.getParcelable(str));
            this.f605s.remove(str);
        }
        gv gvVar = this.f603gv.get(str);
        if (gvVar != null) {
            gvVar.n3();
            this.f603gv.remove(str);
        }
    }

    public final int v() {
        int nextInt = this.y.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (this.f604n3.containsKey(Integer.valueOf(i))) {
                nextInt = this.y.nextInt(2147418112);
            } else {
                return i;
            }
        }
    }

    public final void y(int i, String str) {
        this.f604n3.put(Integer.valueOf(i), str);
        this.f607zn.put(str, Integer.valueOf(i));
    }

    public final <O> boolean zn(int i, @SuppressLint({"UnknownNullness"}) O o2) {
        a.y<?> yVar;
        String str = this.f604n3.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.f606v.remove(str);
        zn<?> znVar = this.f601a.get(str);
        if (znVar != null && (yVar = znVar.y) != null) {
            yVar.onActivityResult(o2);
            return true;
        }
        this.f605s.remove(str);
        this.f602fb.put(str, o2);
        return true;
    }
}
