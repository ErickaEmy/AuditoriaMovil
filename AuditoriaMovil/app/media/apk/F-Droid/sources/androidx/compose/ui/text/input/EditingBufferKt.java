package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
/* compiled from: EditingBuffer.kt */
/* loaded from: classes.dex */
public abstract class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M  reason: not valid java name */
    public static final long m1674updateRangeAfterDeletepWDy79M(long j, long j2) {
        int m1581getLengthimpl;
        int m1583getMinimpl = TextRange.m1583getMinimpl(j);
        int m1582getMaximpl = TextRange.m1582getMaximpl(j);
        if (TextRange.m1587intersects5zctL8(j2, j)) {
            if (TextRange.m1575contains5zctL8(j2, j)) {
                m1583getMinimpl = TextRange.m1583getMinimpl(j2);
                m1582getMaximpl = m1583getMinimpl;
            } else {
                if (TextRange.m1575contains5zctL8(j, j2)) {
                    m1581getLengthimpl = TextRange.m1581getLengthimpl(j2);
                } else if (TextRange.m1576containsimpl(j2, m1583getMinimpl)) {
                    m1583getMinimpl = TextRange.m1583getMinimpl(j2);
                    m1581getLengthimpl = TextRange.m1581getLengthimpl(j2);
                } else {
                    m1582getMaximpl = TextRange.m1583getMinimpl(j2);
                }
                m1582getMaximpl -= m1581getLengthimpl;
            }
        } else if (m1582getMaximpl > TextRange.m1583getMinimpl(j2)) {
            m1583getMinimpl -= TextRange.m1581getLengthimpl(j2);
            m1581getLengthimpl = TextRange.m1581getLengthimpl(j2);
            m1582getMaximpl -= m1581getLengthimpl;
        }
        return TextRangeKt.TextRange(m1583getMinimpl, m1582getMaximpl);
    }
}
