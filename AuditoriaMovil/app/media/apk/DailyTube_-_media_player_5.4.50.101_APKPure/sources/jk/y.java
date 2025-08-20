package jk;

import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class y {
    @Nullable
    public f y(r4.s sVar) {
        String str = (String) v5.y.v(sVar.f13101zn.f10948f3);
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1606874997:
                if (str.equals("audio/amr-wb")) {
                    c2 = 2;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c2 = 3;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 4;
                    break;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1503095341:
                if (str.equals("audio/3gpp")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1903231877:
                if (str.equals("audio/g711-alaw")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1903589369:
                if (str.equals("audio/g711-mlaw")) {
                    c2 = '\r';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new v(sVar);
            case 1:
                return new fb(sVar);
            case 2:
            case '\b':
                return new gv(sVar);
            case 3:
                if (sVar.f13100v.equals("MP4A-LATM")) {
                    return new s(sVar);
                }
                return new n3(sVar);
            case 4:
                return new zn(sVar);
            case 5:
            case '\f':
            case '\r':
                return new t(sVar);
            case 6:
                return new c5(sVar);
            case 7:
                return new a(sVar);
            case '\t':
                return new i9(sVar);
            case '\n':
                return new wz(sVar);
            case 11:
                return new xc(sVar);
            default:
                return null;
        }
    }
}
