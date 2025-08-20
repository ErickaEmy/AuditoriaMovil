package y5;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class ta {

    /* renamed from: v  reason: collision with root package name */
    public static final Class[] f15303v = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: gv  reason: collision with root package name */
    public final SavedStateRegistry.n3 f15304gv;

    /* renamed from: n3  reason: collision with root package name */
    public final Map<String, SavedStateRegistry.n3> f15305n3;
    public final Map<String, Object> y;

    /* renamed from: zn  reason: collision with root package name */
    public final Map<String, n3<?>> f15306zn;

    /* loaded from: classes.dex */
    public class y implements SavedStateRegistry.n3 {
        public y() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.n3
        @NonNull
        public Bundle saveState() {
            for (Map.Entry entry : new HashMap(ta.this.f15305n3).entrySet()) {
                ta.this.a((String) entry.getKey(), ((SavedStateRegistry.n3) entry.getValue()).saveState());
            }
            Set<String> keySet = ta.this.y.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : keySet) {
                arrayList.add(str);
                arrayList2.add(ta.this.y.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    public ta(@NonNull Map<String, Object> map) {
        this.f15305n3 = new HashMap();
        this.f15306zn = new HashMap();
        this.f15304gv = new y();
        this.y = new HashMap(map);
    }

    public static void fb(Object obj) {
        if (obj == null) {
            return;
        }
        for (Class cls : f15303v) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
    }

    public static ta y(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new ta();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new ta(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                hashMap.put((String) parcelableArrayList.get(i), parcelableArrayList2.get(i));
            }
            return new ta(hashMap);
        }
        throw new IllegalStateException("Invalid bundle passed as restored state");
    }

    public <T> void a(@NonNull String str, @Nullable T t2) {
        fb(t2);
        n3<?> n3Var = this.f15306zn.get(str);
        if (n3Var != null) {
            n3Var.xc(t2);
        } else {
            this.y.put(str, t2);
        }
    }

    @NonNull
    public final <T> d0<T> gv(@NonNull String str, boolean z2, @Nullable T t2) {
        n3<?> n3Var;
        n3<?> n3Var2 = this.f15306zn.get(str);
        if (n3Var2 != null) {
            return n3Var2;
        }
        if (this.y.containsKey(str)) {
            n3Var = new n3<>(this, str, this.y.get(str));
        } else if (z2) {
            n3Var = new n3<>(this, str, t2);
        } else {
            n3Var = new n3<>(this, str);
        }
        this.f15306zn.put(str, n3Var);
        return n3Var;
    }

    @Nullable
    public <T> T n3(@NonNull String str) {
        return (T) this.y.get(str);
    }

    @NonNull
    public SavedStateRegistry.n3 v() {
        return this.f15304gv;
    }

    @NonNull
    public <T> d0<T> zn(@NonNull String str) {
        return gv(str, false, null);
    }

    /* loaded from: classes.dex */
    public static class n3<T> extends d0<T> {

        /* renamed from: t  reason: collision with root package name */
        public String f15307t;

        /* renamed from: tl  reason: collision with root package name */
        public ta f15308tl;

        public n3(ta taVar, String str, T t2) {
            super(t2);
            this.f15307t = str;
            this.f15308tl = taVar;
        }

        @Override // y5.d0, androidx.lifecycle.LiveData
        public void xc(T t2) {
            ta taVar = this.f15308tl;
            if (taVar != null) {
                taVar.y.put(this.f15307t, t2);
            }
            super.xc(t2);
        }

        public n3(ta taVar, String str) {
            this.f15307t = str;
            this.f15308tl = taVar;
        }
    }

    public ta() {
        this.f15305n3 = new HashMap();
        this.f15306zn = new HashMap();
        this.f15304gv = new y();
        this.y = new HashMap();
    }
}
