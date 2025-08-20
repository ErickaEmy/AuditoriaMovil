package org.fdroid;

import androidx.core.os.LocaleListCompat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.fdroid.index.IndexConverterKt;
/* compiled from: LocaleChooser.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ-\u0010\n\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u0004*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lorg/fdroid/LocaleChooser;", "", "()V", "getBestLocale", "T", "", "", "localeList", "Landroidx/core/os/LocaleListCompat;", "(Ljava/util/Map;Landroidx/core/os/LocaleListCompat;)Ljava/lang/Object;", "getOrStartsWith", "s", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocaleChooser {
    public static final LocaleChooser INSTANCE = new LocaleChooser();

    private LocaleChooser() {
    }

    public final <T> T getBestLocale(Map<String, ? extends T> map, LocaleListCompat localeList) {
        Locale firstMatch;
        Object first;
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        if (map == null || map.isEmpty() || (firstMatch = localeList.getFirstMatch((String[]) map.keySet().toArray(new String[0]))) == null) {
            return null;
        }
        T t = map.get(firstMatch.toLanguageTag());
        if (t == null) {
            String str = firstMatch.getLanguage() + "-" + firstMatch.getCountry();
            LocaleChooser localeChooser = INSTANCE;
            T t2 = (T) localeChooser.getOrStartsWith(map, str);
            if (t2 == null) {
                String language = firstMatch.getLanguage();
                Intrinsics.checkNotNull(language);
                T t3 = (T) localeChooser.getOrStartsWith(map, language);
                if (t3 == null && (t3 = map.get(IndexConverterKt.DEFAULT_LOCALE)) == null && (t3 = map.get("en")) == null) {
                    first = CollectionsKt___CollectionsKt.first(map.values());
                    t3 = (T) first;
                }
                return t3;
            }
            return t2;
        }
        return t;
    }

    private final <T> T getOrStartsWith(Map<String, ? extends T> map, String str) {
        boolean startsWith$default;
        T t = map.get(str);
        if (t == null) {
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                T t2 = (T) entry.getValue();
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) entry.getKey(), str, false, 2, null);
                if (startsWith$default) {
                    return t2;
                }
            }
            return null;
        }
        return t;
    }
}
