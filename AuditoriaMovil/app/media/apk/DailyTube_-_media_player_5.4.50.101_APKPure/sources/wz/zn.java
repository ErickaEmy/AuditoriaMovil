package wz;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.widget.PopupWindow;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class zn extends rz {

    /* renamed from: ct  reason: collision with root package name */
    public final Context f14881ct;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zn(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f14881ct = context;
        if (Build.VERSION.SDK_INT >= 23) {
            this.f14795u.setEnterTransition(null);
            this.f14795u.setExitTransition(null);
        }
    }

    public final void j5(int i) {
        super.show();
        PopupWindow mPopup = this.f14795u;
        Intrinsics.checkNotNullExpressionValue(mPopup, "mPopup");
        sa1.n3.v(mPopup, i, (Animator.AnimatorListener) null, 2, (Object) null);
    }
}
