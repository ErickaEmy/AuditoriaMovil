package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.c5;
@c5.n3("navigation")
/* loaded from: classes.dex */
public class a extends c5<v> {
    public final i9 y;

    public a(@NonNull i9 i9Var) {
        this.y = i9Var;
    }

    @Override // androidx.navigation.c5
    @NonNull
    /* renamed from: a */
    public v y() {
        return new v(this);
    }

    @Override // androidx.navigation.c5
    @Nullable
    /* renamed from: fb */
    public gv n3(@NonNull v vVar, @Nullable Bundle bundle, @Nullable s sVar, @Nullable c5.y yVar) {
        int n2 = vVar.n();
        if (n2 != 0) {
            gv i42 = vVar.i4(n2, false);
            if (i42 != null) {
                return this.y.v(i42.t()).n3(i42, i42.zn(bundle), sVar, yVar);
            }
            String f32 = vVar.f3();
            throw new IllegalArgumentException("navigation destination " + f32 + " is not a direct child of this NavGraph");
        }
        throw new IllegalStateException("no start destination defined via app:startDestination for " + vVar.c5());
    }

    @Override // androidx.navigation.c5
    public boolean v() {
        return true;
    }
}
