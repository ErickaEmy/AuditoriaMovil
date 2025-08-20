package com.uv.v7;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class LoadDexException extends MMKVBaseException {
    int fileCount;
    int mode;
    Throwable originException;

    public LoadDexException(int i, Throwable th, int i5) {
        this.fileCount = i;
        this.originException = th;
        this.mode = i5;
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getMessage() {
        String str = "fileCount = " + this.fileCount + ", originException = " + this.originException.getClass().getName() + ", msg: " + this.originException.getMessage() + ", mode = " + this.mode;
        if (this.firstMessage != null) {
            return str + ", firstMessage = " + this.firstMessage;
        }
        return str;
    }
}
