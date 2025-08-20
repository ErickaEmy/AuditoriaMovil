package kotlin.text;

import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static Integer toIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toIntOrNull(str, 10);
    }

    public static Long toLongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toLongOrNull(str, 10);
    }

    public static final Integer toIntOrNull(String str, int i) {
        boolean z2;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char charAt = str.charAt(0);
        int i10 = -2147483647;
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i5 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i10 = Integer.MIN_VALUE;
                z2 = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
            i5 = 0;
        }
        int i11 = -59652323;
        while (i5 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i5), i);
            if (digitOf < 0) {
                return null;
            }
            if ((i8 < i11 && (i11 != -59652323 || i8 < (i11 = i10 / i))) || (i6 = i8 * i) < i10 + digitOf) {
                return null;
            }
            i8 = i6 - digitOf;
            i5++;
        }
        return z2 ? Integer.valueOf(i8) : Integer.valueOf(-i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Long toLongOrNull(java.lang.String r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            kotlin.text.CharsKt.checkRadix(r19)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L14
            return r3
        L14:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.Intrinsics.compare(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 >= 0) goto L37
            r6 = 1
            if (r2 != r6) goto L2a
            return r3
        L2a:
            r9 = 45
            if (r5 != r9) goto L32
            r7 = -9223372036854775808
            r4 = 1
            goto L3a
        L32:
            r9 = 43
            if (r5 != r9) goto L39
            r4 = 1
        L37:
            r6 = 0
            goto L3a
        L39:
            return r3
        L3a:
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r11 = 0
            r13 = r9
        L42:
            if (r4 >= r2) goto L73
            char r5 = r0.charAt(r4)
            int r5 = kotlin.text.CharsKt__CharJVMKt.digitOf(r5, r1)
            if (r5 >= 0) goto L4f
            return r3
        L4f:
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L5f
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 != 0) goto L5e
            long r13 = (long) r1
            long r13 = r7 / r13
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L5f
        L5e:
            return r3
        L5f:
            long r9 = (long) r1
            long r11 = r11 * r9
            long r9 = (long) r5
            long r16 = r7 + r9
            int r5 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r5 >= 0) goto L6a
            return r3
        L6a:
            long r11 = r11 - r9
            int r4 = r4 + 1
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L42
        L73:
            if (r6 == 0) goto L7a
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
            goto L7f
        L7a:
            long r0 = -r11
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(java.lang.String, int):java.lang.Long");
    }
}
