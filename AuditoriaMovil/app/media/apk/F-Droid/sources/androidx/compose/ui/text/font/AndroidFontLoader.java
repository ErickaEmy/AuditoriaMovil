package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidFontLoader.android.kt */
/* loaded from: classes.dex */
public final class AndroidFontLoader implements PlatformFontLoader {
    private final Object cacheKey;
    private final Context context;

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }

    public AndroidFontLoader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context.getApplicationContext();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Typeface loadBlocking(Font font) {
        Object m2081constructorimpl;
        Typeface typeface;
        Typeface load;
        Intrinsics.checkNotNullParameter(font, "font");
        if (font instanceof ResourceFont) {
            int mo1624getLoadingStrategyPKNRLFQ = font.mo1624getLoadingStrategyPKNRLFQ();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.Companion;
            if (FontLoadingStrategy.m1631equalsimpl0(mo1624getLoadingStrategyPKNRLFQ, companion.m1635getBlockingPKNRLFQ())) {
                Context context = this.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                typeface = AndroidFontLoader_androidKt.load((ResourceFont) font, context);
            } else if (FontLoadingStrategy.m1631equalsimpl0(mo1624getLoadingStrategyPKNRLFQ, companion.m1636getOptionalLocalPKNRLFQ())) {
                try {
                    Result.Companion companion2 = Result.Companion;
                    Context context2 = this.context;
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    load = AndroidFontLoader_androidKt.load((ResourceFont) font, context2);
                    m2081constructorimpl = Result.m2081constructorimpl(load);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.Companion;
                    m2081constructorimpl = Result.m2081constructorimpl(ResultKt.createFailure(th));
                }
                typeface = Result.m2086isFailureimpl(m2081constructorimpl) ? null : m2081constructorimpl;
            } else if (FontLoadingStrategy.m1631equalsimpl0(mo1624getLoadingStrategyPKNRLFQ, companion.m1634getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            } else {
                throw new IllegalArgumentException("Unknown loading type " + ((Object) FontLoadingStrategy.m1633toStringimpl(font.mo1624getLoadingStrategyPKNRLFQ())));
            }
            FontVariation$Settings variationSettings = ((ResourceFont) font).getVariationSettings();
            Context context3 = this.context;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            return PlatformTypefacesKt.setFontVariationSettings(typeface, variationSettings, context3);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object awaitLoad(androidx.compose.ui.text.font.Font r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = (androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = new androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "context"
            r4 = 2
            if (r2 == 0) goto L42
            r6 = 1
            if (r2 == r6) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r6 = r0.L$1
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            java.lang.Object r0 = r0.L$0
            androidx.compose.ui.text.font.AndroidFontLoader r0 = (androidx.compose.ui.text.font.AndroidFontLoader) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5f
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            kotlin.ResultKt.throwOnFailure(r7)
            return r7
        L42:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6 instanceof androidx.compose.ui.text.font.ResourceFont
            if (r7 == 0) goto L71
            r7 = r6
            androidx.compose.ui.text.font.ResourceFont r7 = (androidx.compose.ui.text.font.ResourceFont) r7
            android.content.Context r2 = r5.context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = androidx.compose.ui.text.font.AndroidFontLoader_androidKt.access$loadAsync(r7, r2, r0)
            if (r7 != r1) goto L5e
            return r1
        L5e:
            r0 = r5
        L5f:
            android.graphics.Typeface r7 = (android.graphics.Typeface) r7
            androidx.compose.ui.text.font.ResourceFont r6 = (androidx.compose.ui.text.font.ResourceFont) r6
            androidx.compose.ui.text.font.FontVariation$Settings r6 = r6.getVariationSettings()
            android.content.Context r0 = r0.context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            android.graphics.Typeface r6 = androidx.compose.ui.text.font.PlatformTypefacesKt.setFontVariationSettings(r7, r6, r0)
            return r6
        L71:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown font type: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AndroidFontLoader.awaitLoad(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
