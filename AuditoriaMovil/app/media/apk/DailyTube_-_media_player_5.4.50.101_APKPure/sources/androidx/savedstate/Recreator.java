package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.a;
import androidx.lifecycle.v;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import y5.co;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class Recreator implements a {
    public final g.y y;

    /* loaded from: classes.dex */
    public static final class y implements SavedStateRegistry.n3 {
        public final Set<String> y = new HashSet();

        public y(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.gv("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.SavedStateRegistry.n3
        @NonNull
        public Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.y));
            return bundle;
        }

        public void y(String str) {
            this.y.add(str);
        }
    }

    public Recreator(g.y yVar) {
        this.y = yVar;
    }

    @Override // androidx.lifecycle.a
    public void onStateChanged(co coVar, v.n3 n3Var) {
        if (n3Var == v.n3.ON_CREATE) {
            coVar.getLifecycle().zn(this);
            Bundle y2 = this.y.getSavedStateRegistry().y("androidx.savedstate.Restarter");
            if (y2 == null) {
                return;
            }
            ArrayList<String> stringArrayList = y2.getStringArrayList("classes_to_restore");
            if (stringArrayList != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    y(it.next());
                }
                return;
            }
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }

    public final void y(String str) {
        Class cls;
        try {
            try {
                Constructor declaredConstructor = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.y.class).getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.y) declaredConstructor.newInstance(null)).y(this.y);
                } catch (Exception e2) {
                    throw new RuntimeException("Failed to instantiate " + str, e2);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("Class " + str + " wasn't found", e5);
        }
    }
}
