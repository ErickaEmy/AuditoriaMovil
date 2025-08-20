package qh;

import m1.m;
/* loaded from: classes.dex */
public interface t {
    public static final t y = new y();

    /* loaded from: classes.dex */
    public class y implements t {
        @Override // qh.t
        public boolean n3(m mVar) {
            String str = mVar.f10948f3;
            if (!"text/vtt".equals(str) && !"text/x-ssa".equals(str) && !"application/ttml+xml".equals(str) && !"application/x-mp4-vtt".equals(str) && !"application/x-subrip".equals(str) && !"application/x-quicktime-tx3g".equals(str) && !"application/cea-608".equals(str) && !"application/x-mp4-cea-608".equals(str) && !"application/cea-708".equals(str) && !"application/dvbsubs".equals(str) && !"application/pgs".equals(str) && !"text/x-exoplayer-cues".equals(str)) {
                return false;
            }
            return true;
        }

        @Override // qh.t
        public i9 y(m mVar) {
            String str = mVar.f10948f3;
            if (str != null) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals("application/dvbsubs")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1248334819:
                        if (str.equals("application/pgs")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1026075066:
                        if (str.equals("application/x-mp4-vtt")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 822864842:
                        if (str.equals("text/x-ssa")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1201784583:
                        if (str.equals("text/x-exoplayer-cues")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            c2 = 11;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return new p5.y(mVar.f10941c);
                    case 1:
                        return new c3.y();
                    case 2:
                        return new ft.y();
                    case 3:
                        return new ft.s();
                    case 4:
                        return new l9.y(mVar.f10941c);
                    case 5:
                        return new ps.y(mVar.f10941c);
                    case 6:
                    case '\b':
                        return new us.y(str, mVar.f10946en, 16000L);
                    case 7:
                        return new fb();
                    case '\t':
                        return new us.zn(mVar.f10946en, mVar.f10941c);
                    case '\n':
                        return new hu.y();
                    case 11:
                        return new oh.zn();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean n3(m mVar);

    i9 y(m mVar);
}
