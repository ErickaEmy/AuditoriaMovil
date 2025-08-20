package com.google.android.exoplayer2.ui;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public interface v {

    /* loaded from: classes.dex */
    public interface y {
        void fb(v vVar, long j2);

        void y(v vVar, long j2);

        void zn(v vVar, long j2, boolean z2);
    }

    long getPreferredUpdateDelay();

    void n3(@Nullable long[] jArr, @Nullable boolean[] zArr, int i);

    void setBufferedPosition(long j2);

    void setDuration(long j2);

    void setEnabled(boolean z2);

    void setPosition(long j2);

    void y(y yVar);
}
