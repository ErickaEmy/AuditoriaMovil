package wa1;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class fb {
    public static final SpannableString y(String str, int i, boolean z2, String... mates) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mates, "mates");
        SpannableString spannableString = new SpannableString(str);
        int i5 = 0;
        for (String str2 : mates) {
            Integer valueOf = Integer.valueOf(StringsKt.indexOf$default((CharSequence) spannableString, str2, i5, false, 4, (Object) null));
            if (valueOf.intValue() < 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                int length = str2.length() + intValue;
                spannableString.setSpan(new ForegroundColorSpan(i), intValue, length, 17);
                if (z2) {
                    spannableString.setSpan(new StyleSpan(1), intValue, length, 17);
                }
                i5 = length;
            }
        }
        return spannableString;
    }
}
