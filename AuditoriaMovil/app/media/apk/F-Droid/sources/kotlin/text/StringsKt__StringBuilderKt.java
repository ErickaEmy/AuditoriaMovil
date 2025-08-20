package kotlin.text;

import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringBuilder.kt */
/* loaded from: classes2.dex */
public abstract class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    public static StringBuilder append(StringBuilder sb, String... value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (String str : value) {
            sb.append(str);
        }
        return sb;
    }
}
