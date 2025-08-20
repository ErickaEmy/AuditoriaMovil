package androidx.core.os;

import java.util.Locale;
/* loaded from: classes.dex */
interface LocaleListInterface {
    Locale get(int i);

    Locale getFirstMatch(String[] strArr);

    Object getLocaleList();

    boolean isEmpty();

    int size();

    String toLanguageTags();
}
