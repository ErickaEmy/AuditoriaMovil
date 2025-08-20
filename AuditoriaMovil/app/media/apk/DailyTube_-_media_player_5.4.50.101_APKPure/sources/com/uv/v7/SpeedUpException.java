package com.uv.v7;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class SpeedUpException extends MMKVBaseException {
    int mode;
    int speedUpResult;

    public SpeedUpException(int i, int i5) {
        this.mode = i;
        this.speedUpResult = i5;
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getMessage() {
        String str = "mode = " + this.mode + ", speedUpResult = " + this.speedUpResult;
        if (this.firstMessage != null) {
            return str + ", firstMessage = " + this.firstMessage;
        }
        return str;
    }
}
