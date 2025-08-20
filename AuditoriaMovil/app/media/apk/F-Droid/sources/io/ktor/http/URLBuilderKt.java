package io.ktor.http;

import ch.qos.logback.core.joran.action.Action;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: URLBuilder.kt */
/* loaded from: classes.dex */
public abstract class URLBuilderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Appendable appendTo(URLBuilder uRLBuilder, Appendable appendable) {
        appendable.append(uRLBuilder.getProtocol().getName());
        String name = uRLBuilder.getProtocol().getName();
        if (Intrinsics.areEqual(name, Action.FILE_ATTRIBUTE)) {
            appendFile(appendable, uRLBuilder.getHost(), getEncodedPath(uRLBuilder));
            return appendable;
        } else if (Intrinsics.areEqual(name, "mailto")) {
            appendMailto(appendable, getEncodedUserAndPassword(uRLBuilder), uRLBuilder.getHost());
            return appendable;
        } else {
            appendable.append("://");
            appendable.append(getAuthority(uRLBuilder));
            URLUtilsKt.appendUrlFullPath(appendable, getEncodedPath(uRLBuilder), uRLBuilder.getEncodedParameters(), uRLBuilder.getTrailingQuery());
            if (uRLBuilder.getEncodedFragment().length() > 0) {
                appendable.append('#');
                appendable.append(uRLBuilder.getEncodedFragment());
            }
            return appendable;
        }
    }

    private static final void appendMailto(Appendable appendable, String str, String str2) {
        appendable.append(":");
        appendable.append(str);
        appendable.append(str2);
    }

    private static final void appendFile(Appendable appendable, String str, String str2) {
        boolean startsWith$default;
        appendable.append("://");
        appendable.append(str);
        startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) str2, '/', false, 2, (Object) null);
        if (!startsWith$default) {
            appendable.append('/');
        }
        appendable.append(str2);
    }

    public static final String getEncodedUserAndPassword(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        URLUtilsKt.appendUserAndPassword(sb, uRLBuilder.getEncodedUser(), uRLBuilder.getEncodedPassword());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ URLBuilder appendPathSegments$default(URLBuilder uRLBuilder, String[] strArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return appendPathSegments(uRLBuilder, strArr, z);
    }

    public static final URLBuilder appendPathSegments(URLBuilder uRLBuilder, String[] components, boolean z) {
        List list;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        list = ArraysKt___ArraysKt.toList(components);
        return appendPathSegments(uRLBuilder, list, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final io.ktor.http.URLBuilder appendEncodedPathSegments(io.ktor.http.URLBuilder r4, java.util.List r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "segments"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.List r0 = r4.getEncodedPathSegments()
            int r0 = r0.size()
            r1 = 0
            r2 = 1
            if (r0 <= r2) goto L2f
            java.util.List r0 = r4.getEncodedPathSegments()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.last(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L2f
            boolean r0 = r5.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L2f
            r0 = r2
            goto L30
        L2f:
            r0 = r1
        L30:
            int r3 = r5.size()
            if (r3 <= r2) goto L4e
            java.lang.Object r3 = kotlin.collections.CollectionsKt.first(r5)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L4e
            java.util.List r3 = r4.getEncodedPathSegments()
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r2
            if (r3 == 0) goto L4e
            r1 = r2
        L4e:
            if (r0 == 0) goto L63
            if (r1 == 0) goto L63
            java.util.List r0 = r4.getEncodedPathSegments()
            java.util.List r0 = kotlin.collections.CollectionsKt.dropLast(r0, r2)
            java.util.List r5 = kotlin.collections.CollectionsKt.drop(r5, r2)
            java.util.List r5 = kotlin.collections.CollectionsKt.plus(r0, r5)
            goto L89
        L63:
            if (r0 == 0) goto L72
            java.util.List r0 = r4.getEncodedPathSegments()
            java.util.List r0 = kotlin.collections.CollectionsKt.dropLast(r0, r2)
            java.util.List r5 = kotlin.collections.CollectionsKt.plus(r0, r5)
            goto L89
        L72:
            if (r1 == 0) goto L81
            java.util.List r0 = r4.getEncodedPathSegments()
            java.util.List r5 = kotlin.collections.CollectionsKt.drop(r5, r2)
            java.util.List r5 = kotlin.collections.CollectionsKt.plus(r0, r5)
            goto L89
        L81:
            java.util.List r0 = r4.getEncodedPathSegments()
            java.util.List r5 = kotlin.collections.CollectionsKt.plus(r0, r5)
        L89:
            r4.setEncodedPathSegments(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLBuilderKt.appendEncodedPathSegments(io.ktor.http.URLBuilder, java.util.List):io.ktor.http.URLBuilder");
    }

    public static final String getAuthority(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(getEncodedUserAndPassword(uRLBuilder));
        sb.append(uRLBuilder.getHost());
        if (uRLBuilder.getPort() != 0 && uRLBuilder.getPort() != uRLBuilder.getProtocol().getDefaultPort()) {
            sb.append(":");
            sb.append(String.valueOf(uRLBuilder.getPort()));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String getEncodedPath(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        return joinPath(uRLBuilder.getEncodedPathSegments());
    }

    public static final void setEncodedPath(URLBuilder uRLBuilder, String value) {
        boolean isBlank;
        List split$default;
        List mutableList;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        isBlank = StringsKt__StringsJVMKt.isBlank(value);
        if (isBlank) {
            mutableList = CollectionsKt__CollectionsKt.emptyList();
        } else if (Intrinsics.areEqual(value, "/")) {
            mutableList = URLParserKt.getROOT_PATH();
        } else {
            split$default = StringsKt__StringsKt.split$default((CharSequence) value, new char[]{'/'}, false, 0, 6, (Object) null);
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) split$default);
        }
        uRLBuilder.setEncodedPathSegments(mutableList);
    }

    private static final String joinPath(List list) {
        String joinToString$default;
        Object first;
        Object first2;
        if (list.isEmpty()) {
            return "";
        }
        if (list.size() == 1) {
            first = CollectionsKt___CollectionsKt.first(list);
            if (((CharSequence) first).length() == 0) {
                return "/";
            }
            first2 = CollectionsKt___CollectionsKt.first(list);
            return (String) first2;
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, "/", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    public static final URLBuilder appendPathSegments(URLBuilder uRLBuilder, List segments, boolean z) {
        int collectionSizeOrDefault;
        List split$default;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(segments, "segments");
        if (!z) {
            ArrayList arrayList = new ArrayList();
            Iterator it = segments.iterator();
            while (it.hasNext()) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) ((String) it.next()), new char[]{'/'}, false, 0, 6, (Object) null);
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, split$default);
            }
            segments = arrayList;
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(segments, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (String str : segments) {
            arrayList2.add(CodecsKt.encodeURLPathPart(str));
        }
        appendEncodedPathSegments(uRLBuilder, arrayList2);
        return uRLBuilder;
    }
}
