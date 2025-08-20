package jq;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* loaded from: classes.dex */
public final class y implements sq.n3 {
    public final Pair<IntRange, Integer>[] y = {TuplesKt.to(new IntRange(48, 57), 5), TuplesKt.to(new IntRange(65, 90), 23), TuplesKt.to(new IntRange(97, 122), 1)};

    public final char gv(char c2) {
        Pair<IntRange, Integer>[] pairArr;
        for (Pair<IntRange, Integer> pair : this.y) {
            IntRange first = pair.getFirst();
            int last = (first.getLast() - first.getFirst()) + 1;
            int intValue = pair.getSecond().intValue();
            int first2 = first.getFirst();
            if (c2 <= first.getLast() && first2 <= c2) {
                return (char) ((((c2 - first.getFirst()) + intValue) % last) + first.getFirst());
            }
        }
        return c2;
    }

    @Override // sq.n3
    public String n3(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        StringBuilder sb = new StringBuilder(data.length());
        for (int i = 0; i < data.length(); i++) {
            sb.append(zn(data.charAt(i)));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @Override // sq.n3
    public String y(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        StringBuilder sb = new StringBuilder(data.length());
        for (int i = 0; i < data.length(); i++) {
            sb.append(gv(data.charAt(i)));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public final char zn(char c2) {
        Pair<IntRange, Integer>[] pairArr;
        for (Pair<IntRange, Integer> pair : this.y) {
            IntRange first = pair.getFirst();
            int last = (first.getLast() - first.getFirst()) + 1;
            int intValue = pair.getSecond().intValue();
            int first2 = first.getFirst();
            if (c2 <= first.getLast() && first2 <= c2) {
                return (char) (((((c2 - first.getFirst()) - (intValue % last)) + last) % last) + first.getFirst());
            }
        }
        return c2;
    }
}
