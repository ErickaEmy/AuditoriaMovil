package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.n3;
import f8.c;
import f8.fh;
import v5.j5;
/* loaded from: classes.dex */
public final class fb {

    /* loaded from: classes.dex */
    public static final class n3 {
        public static int n3(Throwable th) {
            return j5.q9(j5.k(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }

        public static boolean y(@Nullable Throwable th) {
            return th instanceof MediaDrm.MediaDrmStateException;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public static boolean n3(@Nullable Throwable th) {
            return th instanceof NotProvisionedException;
        }

        public static boolean y(@Nullable Throwable th) {
            return th instanceof DeniedByServerException;
        }
    }

    /* loaded from: classes.dex */
    public static final class zn {
        public static boolean y(@Nullable Throwable th) {
            return th instanceof MediaDrmResetException;
        }
    }

    public static int y(Exception exc, int i) {
        int i5 = j5.y;
        if (i5 >= 21 && n3.y(exc)) {
            return n3.n3(exc);
        }
        if (i5 >= 23 && zn.y(exc)) {
            return 6006;
        }
        if (i5 >= 18 && y.n3(exc)) {
            return 6002;
        }
        if (i5 >= 18 && y.y(exc)) {
            return 6007;
        }
        if (exc instanceof fh) {
            return 6001;
        }
        if (exc instanceof n3.v) {
            return 6003;
        }
        if (exc instanceof c) {
            return 6008;
        }
        if (i == 1) {
            return 6006;
        }
        if (i == 2) {
            return 6004;
        }
        if (i == 3) {
            return 6002;
        }
        throw new IllegalArgumentException();
    }
}
