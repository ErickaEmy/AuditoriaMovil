package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.v;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes.dex */
public interface gv {

    /* loaded from: classes.dex */
    public static class y extends IOException {
        public final int errorCode;

        public y(Throwable th, int i) {
            super(th);
            this.errorCode = i;
        }
    }

    @Nullable
    Map<String, String> a();

    boolean fb(String str);

    @Nullable
    y getError();

    int getState();

    boolean gv();

    void n3(@Nullable v.y yVar);

    @Nullable
    a9.n3 v();

    void y(@Nullable v.y yVar);

    UUID zn();
}
