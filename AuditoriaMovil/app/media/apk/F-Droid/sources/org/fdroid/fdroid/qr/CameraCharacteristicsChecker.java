package org.fdroid.fdroid.qr;

import android.content.Context;
/* loaded from: classes2.dex */
public abstract class CameraCharacteristicsChecker {
    public abstract boolean hasAutofocus();

    public static CameraCharacteristicsChecker getInstance(Context context) {
        return new CameraCharacteristicsMinApiLevel21(context);
    }

    /* loaded from: classes2.dex */
    static class FDroidDeviceException extends Exception {
        /* JADX INFO: Access modifiers changed from: package-private */
        public FDroidDeviceException(String str, Throwable th) {
            super(str, th);
        }
    }
}
