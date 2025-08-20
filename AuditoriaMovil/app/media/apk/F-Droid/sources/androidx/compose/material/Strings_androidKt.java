package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.material.Strings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.R$string;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Strings.android.kt */
/* loaded from: classes.dex */
public abstract class Strings_androidKt {
    /* renamed from: getString-4foXLRw  reason: not valid java name */
    public static final String m545getString4foXLRw(int i, Composer composer, int i2) {
        String str;
        composer.startReplaceableGroup(-726638443);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-726638443, i2, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
        Strings.Companion companion = Strings.Companion;
        if (Strings.m537equalsimpl0(i, companion.m542getNavigationMenuUdPEhr4())) {
            str = resources.getString(R$string.navigation_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.navigation_menu)");
        } else if (Strings.m537equalsimpl0(i, companion.m538getCloseDrawerUdPEhr4())) {
            str = resources.getString(R$string.close_drawer);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_drawer)");
        } else if (Strings.m537equalsimpl0(i, companion.m539getCloseSheetUdPEhr4())) {
            str = resources.getString(R$string.close_sheet);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_sheet)");
        } else if (Strings.m537equalsimpl0(i, companion.m540getDefaultErrorMessageUdPEhr4())) {
            str = resources.getString(R$string.default_error_message);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.st…ng.default_error_message)");
        } else if (Strings.m537equalsimpl0(i, companion.m541getExposedDropdownMenuUdPEhr4())) {
            str = resources.getString(R$string.dropdown_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.dropdown_menu)");
        } else if (Strings.m537equalsimpl0(i, companion.m544getSliderRangeStartUdPEhr4())) {
            str = resources.getString(R$string.range_start);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_start)");
        } else if (Strings.m537equalsimpl0(i, companion.m543getSliderRangeEndUdPEhr4())) {
            str = resources.getString(R$string.range_end);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_end)");
        } else {
            str = "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return str;
    }
}
