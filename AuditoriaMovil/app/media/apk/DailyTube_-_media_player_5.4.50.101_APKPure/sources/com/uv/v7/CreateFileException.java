package com.uv.v7;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class CreateFileException extends MMKVBaseException {
    int mode;

    public CreateFileException(int i) {
        this.mode = i;
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getMessage() {
        String str = "mode = " + this.mode;
        if (this.firstMessage != null) {
            return str + ", firstMessage = " + this.firstMessage;
        }
        return str;
    }
}
