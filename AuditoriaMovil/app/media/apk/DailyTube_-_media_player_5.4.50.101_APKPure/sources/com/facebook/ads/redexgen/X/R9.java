package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public interface R9 {
    void A8Q();

    boolean A8b();

    boolean A8c();

    boolean A9B();

    void ADu(boolean z2, int i);

    void AGN(int i);

    void AGS(QM qm, int i);

    void AGZ(int i);

    void destroy();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    QM getStartReason();

    RB getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void seekTo(int i);

    void setBackgroundPlaybackEnabled(boolean z2);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z2);

    void setRequestedVolume(float f4);

    void setVideoMPD(String str);

    void setVideoStateChangeListener(RC rc);

    void setup(Uri uri);
}
