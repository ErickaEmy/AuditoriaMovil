package io.ktor.http;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: HttpHeaderValueParser.kt */
/* loaded from: classes.dex */
public abstract class HttpHeaderValueParserKt {
    public static final List parseHeaderValue(String str) {
        return parseHeaderValue(str, false);
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0014 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List parseHeaderValue(java.lang.String r3, boolean r4) {
        /*
            if (r3 != 0) goto L7
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            return r3
        L7:
            kotlin.LazyThreadSafetyMode r0 = kotlin.LazyThreadSafetyMode.NONE
            io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1 r1 = new kotlin.jvm.functions.Function0() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1
                static {
                    /*
                        io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1 r0 = new io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1) io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1.INSTANCE io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r1 = this;
                        java.util.ArrayList r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.util.ArrayList invoke() {
                    /*
                        r1 = this;
                        java.util.ArrayList r0 = new java.util.ArrayList
                        r0.<init>()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValue$items$1.invoke():java.util.ArrayList");
                }
            }
            kotlin.Lazy r0 = kotlin.LazyKt.lazy(r0, r1)
            r1 = 0
        L10:
            int r2 = kotlin.text.StringsKt.getLastIndex(r3)
            if (r1 > r2) goto L1b
            int r1 = parseHeaderValueItem(r3, r1, r0, r4)
            goto L10
        L1b:
            java.util.List r3 = valueOrEmpty(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt.parseHeaderValue(java.lang.String, boolean):java.util.List");
    }

    private static final List valueOrEmpty(Lazy lazy) {
        List emptyList;
        if (lazy.isInitialized()) {
            return (List) lazy.getValue();
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    private static final String subtrim(String str, int i, int i2) {
        CharSequence trim;
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        trim = StringsKt__StringsKt.trim(substring);
        return trim.toString();
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x0015 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int parseHeaderValueItem(java.lang.String r5, int r6, kotlin.Lazy r7, boolean r8) {
        /*
            kotlin.LazyThreadSafetyMode r0 = kotlin.LazyThreadSafetyMode.NONE
            io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1 r1 = new kotlin.jvm.functions.Function0() { // from class: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1
                static {
                    /*
                        io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1 r0 = new io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1) io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.INSTANCE io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r1 = this;
                        java.util.ArrayList r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.util.ArrayList invoke() {
                    /*
                        r1 = this;
                        java.util.ArrayList r0 = new java.util.ArrayList
                        r0.<init>()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.invoke():java.util.ArrayList");
                }
            }
            kotlin.Lazy r0 = kotlin.LazyKt.lazy(r0, r1)
            if (r8 == 0) goto Lf
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            goto L10
        Lf:
            r1 = 0
        L10:
            r2 = r6
        L11:
            int r3 = kotlin.text.StringsKt.getLastIndex(r5)
            if (r2 > r3) goto L5b
            char r3 = r5.charAt(r2)
            r4 = 44
            if (r3 != r4) goto L40
            java.lang.Object r7 = r7.getValue()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            io.ktor.http.HeaderValue r8 = new io.ktor.http.HeaderValue
            if (r1 == 0) goto L2e
            int r1 = r1.intValue()
            goto L2f
        L2e:
            r1 = r2
        L2f:
            java.lang.String r5 = subtrim(r5, r6, r1)
            java.util.List r6 = valueOrEmpty(r0)
            r8.<init>(r5, r6)
            r7.add(r8)
            int r2 = r2 + 1
            return r2
        L40:
            r4 = 59
            if (r3 != r4) goto L51
            if (r1 != 0) goto L4a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
        L4a:
            int r2 = r2 + 1
            int r2 = parseHeaderValueParameter(r5, r2, r0)
            goto L11
        L51:
            if (r8 == 0) goto L58
            int r2 = parseHeaderValueParameter(r5, r2, r0)
            goto L11
        L58:
            int r2 = r2 + 1
            goto L11
        L5b:
            java.lang.Object r7 = r7.getValue()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            io.ktor.http.HeaderValue r8 = new io.ktor.http.HeaderValue
            if (r1 == 0) goto L6a
            int r1 = r1.intValue()
            goto L6b
        L6a:
            r1 = r2
        L6b:
            java.lang.String r5 = subtrim(r5, r6, r1)
            java.util.List r6 = valueOrEmpty(r0)
            r8.<init>(r5, r6)
            r7.add(r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt.parseHeaderValueItem(java.lang.String, int, kotlin.Lazy, boolean):int");
    }

    private static final void parseHeaderValueParameter$addParam(Lazy lazy, String str, int i, int i2, String str2) {
        String subtrim = subtrim(str, i, i2);
        if (subtrim.length() == 0) {
            return;
        }
        ((ArrayList) lazy.getValue()).add(new HeaderValueParam(subtrim, str2));
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int parseHeaderValueParameter(java.lang.String r4, int r5, kotlin.Lazy r6) {
        /*
            r0 = r5
        L1:
            int r1 = kotlin.text.StringsKt.getLastIndex(r4)
            java.lang.String r2 = ""
            if (r0 > r1) goto L3b
            char r1 = r4.charAt(r0)
            r3 = 61
            if (r1 != r3) goto L2b
            int r1 = r0 + 1
            kotlin.Pair r1 = parseHeaderValueParameterValue(r4, r1)
            java.lang.Object r2 = r1.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.component2()
            java.lang.String r1 = (java.lang.String) r1
            parseHeaderValueParameter$addParam(r6, r4, r5, r0, r1)
            return r2
        L2b:
            r3 = 59
            if (r1 != r3) goto L30
            goto L34
        L30:
            r3 = 44
            if (r1 != r3) goto L38
        L34:
            parseHeaderValueParameter$addParam(r6, r4, r5, r0, r2)
            return r0
        L38:
            int r0 = r0 + 1
            goto L1
        L3b:
            parseHeaderValueParameter$addParam(r6, r4, r5, r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt.parseHeaderValueParameter(java.lang.String, int, kotlin.Lazy):int");
    }

    /* JADX WARN: Incorrect condition in loop: B:12:0x0025 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Pair parseHeaderValueParameterValue(java.lang.String r3, int r4) {
        /*
            int r0 = r3.length()
            if (r0 != r4) goto L11
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            java.lang.String r4 = ""
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            return r3
        L11:
            char r0 = r3.charAt(r4)
            r1 = 34
            if (r0 != r1) goto L20
            int r4 = r4 + 1
            kotlin.Pair r3 = parseHeaderValueParameterValueQuoted(r3, r4)
            return r3
        L20:
            r0 = r4
        L21:
            int r1 = kotlin.text.StringsKt.getLastIndex(r3)
            if (r0 > r1) goto L44
            char r1 = r3.charAt(r0)
            r2 = 59
            if (r1 != r2) goto L30
            goto L34
        L30:
            r2 = 44
            if (r1 != r2) goto L41
        L34:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = subtrim(r3, r4, r0)
            kotlin.Pair r3 = kotlin.TuplesKt.to(r1, r3)
            return r3
        L41:
            int r0 = r0 + 1
            goto L21
        L44:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = subtrim(r3, r4, r0)
            kotlin.Pair r3 = kotlin.TuplesKt.to(r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt.parseHeaderValueParameterValue(java.lang.String, int):kotlin.Pair");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.Pair parseHeaderValueParameterValueQuoted(java.lang.String r4, int r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L5:
            int r1 = kotlin.text.StringsKt.getLastIndex(r4)
            java.lang.String r2 = "builder.toString()"
            r3 = 34
            if (r5 > r1) goto L4b
            char r1 = r4.charAt(r5)
            if (r1 != r3) goto L2d
            boolean r3 = nextIsSemicolonOrEnd(r4, r5)
            if (r3 == 0) goto L2d
            int r5 = r5 + 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            java.lang.String r5 = r0.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            return r4
        L2d:
            r2 = 92
            if (r1 != r2) goto L45
            int r2 = kotlin.text.StringsKt.getLastIndex(r4)
            int r2 = r2 + (-2)
            if (r5 >= r2) goto L45
            int r1 = r5 + 1
            char r1 = r4.charAt(r1)
            r0.append(r1)
            int r5 = r5 + 2
            goto L5
        L45:
            r0.append(r1)
            int r5 = r5 + 1
            goto L5
        L4b:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            java.lang.String r5 = r0.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpHeaderValueParserKt.parseHeaderValueParameterValueQuoted(java.lang.String, int):kotlin.Pair");
    }

    private static final boolean nextIsSemicolonOrEnd(String str, int i) {
        int i2 = i + 1;
        while (i2 < str.length() && str.charAt(i2) == ' ') {
            i2++;
        }
        return i2 == str.length() || str.charAt(i2) == ';';
    }
}
