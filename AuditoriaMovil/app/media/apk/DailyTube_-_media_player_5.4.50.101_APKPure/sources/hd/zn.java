package hd;

import m1.m;
/* loaded from: classes.dex */
public interface zn {
    public static final zn y = new y();

    /* loaded from: classes.dex */
    public class y implements zn {
        @Override // hd.zn
        public boolean n3(m mVar) {
            String str = mVar.f10948f3;
            if (!"application/id3".equals(str) && !"application/x-emsg".equals(str) && !"application/x-scte35".equals(str) && !"application/x-icy".equals(str) && !"application/vnd.dvb.ait".equals(str)) {
                return false;
            }
            return true;
        }

        @Override // hd.zn
        public n3 y(m mVar) {
            String str = mVar.f10948f3;
            if (str != null) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1354451219:
                        if (str.equals("application/vnd.dvb.ait")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1348231605:
                        if (str.equals("application/x-icy")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1248341703:
                        if (str.equals("application/id3")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1154383568:
                        if (str.equals("application/x-emsg")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1652648887:
                        if (str.equals("application/x-scte35")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return new tp.y();
                    case 1:
                        return new zl.y();
                    case 2:
                        return new ho.n3();
                    case 3:
                        return new f5.y();
                    case 4:
                        return new n5.y();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean n3(m mVar);

    n3 y(m mVar);
}
