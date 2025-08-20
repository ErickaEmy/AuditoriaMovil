package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class FragmentKt {
    public static final void clearFragmentResult(Fragment clearFragmentResult, String requestKey) {
        Intrinsics.checkNotNullParameter(clearFragmentResult, "$this$clearFragmentResult");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        clearFragmentResult.getParentFragmentManager().clearFragmentResult(requestKey);
    }

    public static final void clearFragmentResultListener(Fragment clearFragmentResultListener, String requestKey) {
        Intrinsics.checkNotNullParameter(clearFragmentResultListener, "$this$clearFragmentResultListener");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        clearFragmentResultListener.getParentFragmentManager().clearFragmentResultListener(requestKey);
    }

    public static final void setFragmentResult(Fragment setFragmentResult, String requestKey, Bundle result) {
        Intrinsics.checkNotNullParameter(setFragmentResult, "$this$setFragmentResult");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        Intrinsics.checkNotNullParameter(result, "result");
        setFragmentResult.getParentFragmentManager().setFragmentResult(requestKey, result);
    }

    public static final void setFragmentResultListener(Fragment setFragmentResultListener, String requestKey, final Function2<? super String, ? super Bundle, Unit> listener) {
        Intrinsics.checkNotNullParameter(setFragmentResultListener, "$this$setFragmentResultListener");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        Intrinsics.checkNotNullParameter(listener, "listener");
        setFragmentResultListener.getParentFragmentManager().setFragmentResultListener(requestKey, setFragmentResultListener, new FragmentResultListener() { // from class: androidx.fragment.app.FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0
            @Override // androidx.fragment.app.FragmentResultListener
            public final /* synthetic */ void onFragmentResult(@NonNull String p02, @NonNull Bundle p1) {
                Intrinsics.checkNotNullParameter(p02, "p0");
                Intrinsics.checkNotNullParameter(p1, "p1");
                Intrinsics.checkNotNullExpressionValue(Function2.this.invoke(p02, p1), "invoke(...)");
            }
        });
    }
}
