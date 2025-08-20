package wa1;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes.dex */
public final class a {
    public static final String gv(Pair<?, ?> pair, String separator) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        return pair.getFirst() + separator + pair.getSecond();
    }

    public static final String n3(List<String> list, String listSeparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(listSeparator, "listSeparator");
        if (list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append(str);
            stringBuffer.append(listSeparator);
        }
        String substring = stringBuffer.substring(0, stringBuffer.length() - listSeparator.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final List<Pair<String, String>> y(String str, String pairSeparator, String listSeparator) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(pairSeparator, "pairSeparator");
        Intrinsics.checkNotNullParameter(listSeparator, "listSeparator");
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : StringsKt.split$default((CharSequence) str, new String[]{listSeparator}, false, 0, 6, (Object) null)) {
            if (!TextUtils.isEmpty((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (String str2 : arrayList) {
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str2, pairSeparator, 0, false, 6, (Object) null);
            String substring = str2.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring2 = str2.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            arrayList2.add(new Pair(substring, substring2));
        }
        return CollectionsKt.toMutableList((Collection) arrayList2);
    }

    public static final String zn(List<? extends Pair<?, ?>> list, String pairSeparator, String listSeparator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(pairSeparator, "pairSeparator");
        Intrinsics.checkNotNullParameter(listSeparator, "listSeparator");
        if (list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(gv((Pair) it.next(), pairSeparator));
            stringBuffer.append(listSeparator);
        }
        String substring = stringBuffer.substring(0, stringBuffer.length() - listSeparator.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}
