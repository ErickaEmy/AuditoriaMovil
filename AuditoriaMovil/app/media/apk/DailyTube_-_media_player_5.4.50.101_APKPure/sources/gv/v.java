package gv;

import androidx.activity.OnBackPressedDispatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import y5.co;
/* loaded from: classes.dex */
public final class v {

    /* loaded from: classes.dex */
    public static final class y extends gv {

        /* renamed from: n3  reason: collision with root package name */
        public final /* synthetic */ boolean f8413n3;
        public final /* synthetic */ Function1<gv, Unit> y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public y(Function1<? super gv, Unit> function1, boolean z2) {
            super(z2);
            this.y = function1;
            this.f8413n3 = z2;
        }

        @Override // gv.gv
        public void handleOnBackPressed() {
            this.y.invoke(this);
        }
    }

    public static /* synthetic */ gv n3(OnBackPressedDispatcher onBackPressedDispatcher, co coVar, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coVar = null;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return y(onBackPressedDispatcher, coVar, z2, function1);
    }

    public static final gv y(OnBackPressedDispatcher onBackPressedDispatcher, co coVar, boolean z2, Function1<? super gv, Unit> onBackPressed) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcher, "<this>");
        Intrinsics.checkNotNullParameter(onBackPressed, "onBackPressed");
        y yVar = new y(onBackPressed, z2);
        if (coVar != null) {
            onBackPressedDispatcher.n3(coVar, yVar);
        } else {
            onBackPressedDispatcher.y(yVar);
        }
        return yVar;
    }
}
