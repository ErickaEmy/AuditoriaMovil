package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.wz;
import androidx.savedstate.SavedStateRegistry;
import y5.ta;
import y5.ud;
/* loaded from: classes.dex */
public abstract class y extends wz.zn {

    /* renamed from: n3  reason: collision with root package name */
    public final v f2662n3;
    public final SavedStateRegistry y;

    /* renamed from: zn  reason: collision with root package name */
    public final Bundle f2663zn;

    public y(@NonNull g.y yVar, @Nullable Bundle bundle) {
        this.y = yVar.getSavedStateRegistry();
        this.f2662n3 = yVar.getLifecycle();
        this.f2663zn = bundle;
    }

    @Override // androidx.lifecycle.wz.zn, androidx.lifecycle.wz.n3
    @NonNull
    public final <T extends ud> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) n3(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.wz.zn
    @NonNull
    public final <T extends ud> T n3(@NonNull String str, @NonNull Class<T> cls) {
        SavedStateHandleController zn2 = SavedStateHandleController.zn(this.y, this.f2662n3, str, this.f2663zn);
        T t2 = (T) zn(str, cls, zn2.gv());
        t2.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", zn2);
        return t2;
    }

    @Override // androidx.lifecycle.wz.v
    public void y(@NonNull ud udVar) {
        SavedStateHandleController.y(udVar, this.y, this.f2662n3);
    }

    @NonNull
    public abstract <T extends ud> T zn(@NonNull String str, @NonNull Class<T> cls, @NonNull ta taVar);
}
