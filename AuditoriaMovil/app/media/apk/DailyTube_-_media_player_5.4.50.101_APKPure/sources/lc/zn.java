package lc;

import android.os.Bundle;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: n3  reason: collision with root package name */
    public androidx.navigation.s f10299n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public Bundle f10300zn;

    public zn(int i) {
        this(i, null);
    }

    public void gv(@Nullable Bundle bundle) {
        this.f10300zn = bundle;
    }

    public int n3() {
        return this.y;
    }

    public void v(@Nullable androidx.navigation.s sVar) {
        this.f10299n3 = sVar;
    }

    @Nullable
    public Bundle y() {
        return this.f10300zn;
    }

    @Nullable
    public androidx.navigation.s zn() {
        return this.f10299n3;
    }

    public zn(int i, @Nullable androidx.navigation.s sVar) {
        this(i, sVar, null);
    }

    public zn(int i, @Nullable androidx.navigation.s sVar, @Nullable Bundle bundle) {
        this.y = i;
        this.f10299n3 = sVar;
        this.f10300zn = bundle;
    }
}
