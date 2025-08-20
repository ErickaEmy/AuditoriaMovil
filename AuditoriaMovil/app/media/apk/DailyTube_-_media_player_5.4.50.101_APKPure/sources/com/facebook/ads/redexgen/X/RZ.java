package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
/* loaded from: assets/audience_network.dex */
public interface RZ {
    boolean ABU(RX rx);

    HttpURLConnection ADo(String str, Proxy proxy) throws IOException;

    InputStream ADp(HttpURLConnection httpURLConnection) throws IOException;

    OutputStream ADq(HttpURLConnection httpURLConnection) throws IOException;

    void AE6(HttpURLConnection httpURLConnection, RV rv, String str) throws IOException;

    byte[] AEO(InputStream inputStream) throws IOException;

    void AHG(OutputStream outputStream, byte[] bArr) throws IOException;
}
