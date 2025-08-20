package org.chromium.net;
/* loaded from: classes.dex */
public abstract class UploadDataSink {
    public abstract void onReadError(Exception exc);

    public abstract void onReadSucceeded(boolean z2);

    public abstract void onRewindError(Exception exc);

    public abstract void onRewindSucceeded();
}
