package androidx.compose.ui.text;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MultiParagraph.kt */
/* loaded from: classes.dex */
public abstract class MultiParagraphKt {
    public static final int findParagraphByIndex(List paragraphInfoList, int i) {
        char c;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) paragraphInfoList.get(i3);
            if (paragraphInfo.getStartIndex() > i) {
                c = 1;
            } else {
                c = paragraphInfo.getEndIndex() <= i ? (char) 65535 : (char) 0;
            }
            if (c < 0) {
                i2 = i3 + 1;
            } else if (c <= 0) {
                return i3;
            } else {
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int findParagraphByLineIndex(List paragraphInfoList, int i) {
        char c;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) paragraphInfoList.get(i3);
            if (paragraphInfo.getStartLineIndex() > i) {
                c = 1;
            } else {
                c = paragraphInfo.getEndLineIndex() <= i ? (char) 65535 : (char) 0;
            }
            if (c < 0) {
                i2 = i3 + 1;
            } else if (c <= 0) {
                return i3;
            } else {
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final int findParagraphByY(List paragraphInfoList, float f) {
        char c;
        Intrinsics.checkNotNullParameter(paragraphInfoList, "paragraphInfoList");
        int size = paragraphInfoList.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            ParagraphInfo paragraphInfo = (ParagraphInfo) paragraphInfoList.get(i2);
            if (paragraphInfo.getTop() > f) {
                c = 1;
            } else {
                c = paragraphInfo.getBottom() <= f ? (char) 65535 : (char) 0;
            }
            if (c < 0) {
                i = i2 + 1;
            } else if (c <= 0) {
                return i2;
            } else {
                size = i2 - 1;
            }
        }
        return -(i + 1);
    }
}
