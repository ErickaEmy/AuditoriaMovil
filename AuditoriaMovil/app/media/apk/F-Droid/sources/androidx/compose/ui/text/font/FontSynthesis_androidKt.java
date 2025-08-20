package androidx.compose.ui.text.font;
/* compiled from: FontSynthesis.android.kt */
/* loaded from: classes.dex */
public abstract class FontSynthesis_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* renamed from: synthesizeTypeface-FxwP2eA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m1660synthesizeTypefaceFxwP2eA(int r5, java.lang.Object r6, androidx.compose.ui.text.font.Font r7, androidx.compose.ui.text.font.FontWeight r8, int r9) {
        /*
            java.lang.String r0 = "typeface"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "font"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "requestedWeight"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r6 instanceof android.graphics.Typeface
            if (r0 != 0) goto L14
            return r6
        L14:
            boolean r0 = androidx.compose.ui.text.font.FontSynthesis.m1653isWeightOnimpl$ui_text_release(r5)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L42
            androidx.compose.ui.text.font.FontWeight r0 = r7.getWeight()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r8)
            if (r0 != 0) goto L42
            androidx.compose.ui.text.font.FontWeight$Companion r0 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r3 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidBold(r0)
            int r3 = r8.compareTo(r3)
            if (r3 < 0) goto L42
            androidx.compose.ui.text.font.FontWeight r3 = r7.getWeight()
            androidx.compose.ui.text.font.FontWeight r0 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidBold(r0)
            int r0 = r3.compareTo(r0)
            if (r0 >= 0) goto L42
            r0 = r2
            goto L43
        L42:
            r0 = r1
        L43:
            boolean r5 = androidx.compose.ui.text.font.FontSynthesis.m1652isStyleOnimpl$ui_text_release(r5)
            if (r5 == 0) goto L55
            int r5 = r7.mo1625getStyle_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m1641equalsimpl0(r9, r5)
            if (r5 != 0) goto L55
            r5 = r2
            goto L56
        L55:
            r5 = r1
        L56:
            if (r5 != 0) goto L5b
            if (r0 != 0) goto L5b
            return r6
        L5b:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r3 >= r4) goto L7b
            if (r5 == 0) goto L70
            androidx.compose.ui.text.font.FontStyle$Companion r5 = androidx.compose.ui.text.font.FontStyle.Companion
            int r5 = r5.m1645getItalic_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m1641equalsimpl0(r9, r5)
            if (r5 == 0) goto L70
            r1 = r2
        L70:
            int r5 = androidx.compose.ui.text.font.AndroidFontUtils_androidKt.getAndroidTypefaceStyle(r0, r1)
            android.graphics.Typeface r6 = (android.graphics.Typeface) r6
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r6, r5)
            goto Lad
        L7b:
            if (r0 == 0) goto L82
            int r8 = r8.getWeight()
            goto L8a
        L82:
            androidx.compose.ui.text.font.FontWeight r8 = r7.getWeight()
            int r8 = r8.getWeight()
        L8a:
            if (r5 == 0) goto L97
            androidx.compose.ui.text.font.FontStyle$Companion r5 = androidx.compose.ui.text.font.FontStyle.Companion
            int r5 = r5.m1645getItalic_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m1641equalsimpl0(r9, r5)
            goto La5
        L97:
            int r5 = r7.mo1625getStyle_LCdwA()
            androidx.compose.ui.text.font.FontStyle$Companion r7 = androidx.compose.ui.text.font.FontStyle.Companion
            int r7 = r7.m1645getItalic_LCdwA()
            boolean r5 = androidx.compose.ui.text.font.FontStyle.m1641equalsimpl0(r5, r7)
        La5:
            androidx.compose.ui.text.font.TypefaceHelperMethodsApi28 r7 = androidx.compose.ui.text.font.TypefaceHelperMethodsApi28.INSTANCE
            android.graphics.Typeface r6 = (android.graphics.Typeface) r6
            android.graphics.Typeface r5 = r7.create(r6, r8, r5)
        Lad:
            java.lang.String r6 = "if (Build.VERSION.SDK_IN…ht, finalFontStyle)\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontSynthesis_androidKt.m1660synthesizeTypefaceFxwP2eA(int, java.lang.Object, androidx.compose.ui.text.font.Font, androidx.compose.ui.text.font.FontWeight, int):java.lang.Object");
    }
}
