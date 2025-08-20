package yc;

import android.annotation.SuppressLint;
import android.content.Context;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class a {
    public static final y y = new y(null);

    /* loaded from: classes.dex */
    public static final class y {
        public /* synthetic */ y(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        public final a y(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ra.y yVar = ra.y.y;
            if (yVar.y() >= 5) {
                return new s(context);
            }
            if (yVar.y() == 4) {
                return new fb(context);
            }
            return null;
        }

        public y() {
        }
    }

    public abstract Object y(n3 n3Var, Continuation<? super zn> continuation);
}
