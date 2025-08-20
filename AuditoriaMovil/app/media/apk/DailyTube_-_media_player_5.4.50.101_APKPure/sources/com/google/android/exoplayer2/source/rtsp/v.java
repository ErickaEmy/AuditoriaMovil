package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;
import v5.j5;
import z0.d0;
import z0.i4;
import z0.x4;
/* loaded from: classes.dex */
public final class v {

    /* renamed from: n3  reason: collision with root package name */
    public static final v f4653n3 = new n3().v();
    public final i4<String, String> y;

    public static String zn(String str) {
        if (w0.zn.y(str, "Accept")) {
            return "Accept";
        }
        if (w0.zn.y(str, "Allow")) {
            return "Allow";
        }
        if (w0.zn.y(str, "Authorization")) {
            return "Authorization";
        }
        if (w0.zn.y(str, "Bandwidth")) {
            return "Bandwidth";
        }
        if (w0.zn.y(str, "Blocksize")) {
            return "Blocksize";
        }
        if (w0.zn.y(str, "Cache-Control")) {
            return "Cache-Control";
        }
        if (w0.zn.y(str, "Connection")) {
            return "Connection";
        }
        if (w0.zn.y(str, "Content-Base")) {
            return "Content-Base";
        }
        if (w0.zn.y(str, "Content-Encoding")) {
            return "Content-Encoding";
        }
        if (w0.zn.y(str, "Content-Language")) {
            return "Content-Language";
        }
        if (w0.zn.y(str, "Content-Length")) {
            return "Content-Length";
        }
        if (w0.zn.y(str, "Content-Location")) {
            return "Content-Location";
        }
        if (w0.zn.y(str, "Content-Type")) {
            return "Content-Type";
        }
        if (w0.zn.y(str, "CSeq")) {
            return "CSeq";
        }
        if (w0.zn.y(str, "Date")) {
            return "Date";
        }
        if (w0.zn.y(str, "Expires")) {
            return "Expires";
        }
        if (w0.zn.y(str, "Location")) {
            return "Location";
        }
        if (w0.zn.y(str, "Proxy-Authenticate")) {
            return "Proxy-Authenticate";
        }
        if (w0.zn.y(str, "Proxy-Require")) {
            return "Proxy-Require";
        }
        if (w0.zn.y(str, "Public")) {
            return "Public";
        }
        if (w0.zn.y(str, "Range")) {
            return "Range";
        }
        if (w0.zn.y(str, "RTP-Info")) {
            return "RTP-Info";
        }
        if (w0.zn.y(str, "RTCP-Interval")) {
            return "RTCP-Interval";
        }
        if (w0.zn.y(str, "Scale")) {
            return "Scale";
        }
        if (w0.zn.y(str, "Session")) {
            return "Session";
        }
        if (w0.zn.y(str, "Speed")) {
            return "Speed";
        }
        if (w0.zn.y(str, "Supported")) {
            return "Supported";
        }
        if (w0.zn.y(str, "Timestamp")) {
            return "Timestamp";
        }
        if (w0.zn.y(str, "Transport")) {
            return "Transport";
        }
        if (w0.zn.y(str, "User-Agent")) {
            return "User-Agent";
        }
        if (w0.zn.y(str, "Via")) {
            return "Via";
        }
        if (w0.zn.y(str, "WWW-Authenticate")) {
            return "WWW-Authenticate";
        }
        return str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        return this.y.equals(((v) obj).y);
    }

    @Nullable
    public String gv(String str) {
        x4<String> v2 = v(str);
        if (v2.isEmpty()) {
            return null;
        }
        return (String) d0.v(v2);
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    public i4<String, String> n3() {
        return this.y;
    }

    public x4<String> v(String str) {
        return this.y.j(zn(str));
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        public final i4.y<String, String> y;

        public n3() {
            this.y = new i4.y<>();
        }

        public n3 gv(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                n3(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public n3 n3(String str, String str2) {
            this.y.v(v.zn(str.trim()), str2.trim());
            return this;
        }

        public v v() {
            return new v(this);
        }

        public n3 zn(List<String> list) {
            for (int i = 0; i < list.size(); i++) {
                String[] ix2 = j5.ix(list.get(i), ":\\s?");
                if (ix2.length == 2) {
                    n3(ix2[0], ix2[1]);
                }
            }
            return this;
        }

        public n3(String str, @Nullable String str2, int i) {
            this();
            n3("User-Agent", str);
            n3("CSeq", String.valueOf(i));
            if (str2 != null) {
                n3("Session", str2);
            }
        }
    }

    public v(n3 n3Var) {
        this.y = n3Var.y.gv();
    }
}
