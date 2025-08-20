package de1;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class n3 {
    public static /* synthetic */ xd1.y n3(boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return y(z2, function1);
    }

    public static final xd1.y y(boolean z2, Function1<? super xd1.y, Unit> moduleDeclaration) {
        Intrinsics.checkNotNullParameter(moduleDeclaration, "moduleDeclaration");
        xd1.y yVar = new xd1.y(z2);
        moduleDeclaration.invoke(yVar);
        return yVar;
    }
}
