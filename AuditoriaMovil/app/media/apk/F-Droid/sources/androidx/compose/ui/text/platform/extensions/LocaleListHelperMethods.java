package androidx.compose.ui.text.platform.extensions;

import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LocaleExtensions.android.kt */
/* loaded from: classes.dex */
public final class LocaleListHelperMethods {
    public static final LocaleListHelperMethods INSTANCE = new LocaleListHelperMethods();

    private LocaleListHelperMethods() {
    }

    public final Object localeSpan(LocaleList localeList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<E> it = localeList.iterator();
        while (it.hasNext()) {
            arrayList.add(LocaleExtensions_androidKt.toJavaLocale((Locale) it.next()));
        }
        java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
        return LocaleListHelperMethods$$ExternalSyntheticApiModelOutline2.m(LocaleListHelperMethods$$ExternalSyntheticApiModelOutline1.m((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }

    public final void setTextLocales(AndroidTextPaint textPaint, LocaleList localeList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<E> it = localeList.iterator();
        while (it.hasNext()) {
            arrayList.add(LocaleExtensions_androidKt.toJavaLocale((Locale) it.next()));
        }
        java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
        textPaint.setTextLocales(LocaleListHelperMethods$$ExternalSyntheticApiModelOutline1.m((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }
}
