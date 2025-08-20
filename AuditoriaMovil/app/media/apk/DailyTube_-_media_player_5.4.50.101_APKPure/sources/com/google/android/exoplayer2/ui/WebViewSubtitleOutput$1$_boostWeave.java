package com.google.android.exoplayer2.ui;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ui.a;
import timber.log.Timber;
/* loaded from: classes.dex */
class WebViewSubtitleOutput$1$_boostWeave {
    @Keep
    public static void HookProxy_setMyWebViewClient(@Nullable a.y yVar, WebViewClient webViewClient) {
        String str;
        yVar.n3(webViewClient);
        if (webViewClient != null) {
            str = webViewClient.getClass().getName();
        } else {
            if (yVar instanceof WebView) {
                yVar.setWebViewClient(new free.daily.tube.background.dtoapp.hook.y());
            }
            str = "null";
        }
        String[] split = Log.getStackTraceString(new Throwable()).split("\n");
        String str2 = (split == null || split.length < 2) ? "" : split[1];
        Timber.Tree tag = Timber.tag("HookProxy");
        tag.e("WebView Client Name:" + str + " from:" + str2, new Object[0]);
    }
}
