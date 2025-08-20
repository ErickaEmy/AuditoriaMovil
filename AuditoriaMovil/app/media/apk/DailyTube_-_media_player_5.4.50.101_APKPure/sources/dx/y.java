package dx;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetProvider;
import v5.j5;
import v5.r;
/* loaded from: classes.dex */
public final class y {

    /* renamed from: dx.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0086y implements Comparator<CronetProvider> {
        public final boolean y;

        public C0086y(boolean z2) {
            this.y = z2;
        }

        public static int n3(@Nullable String str, @Nullable String str2) {
            if (str != null && str2 != null) {
                String[] ro2 = j5.ro(str, "\\.");
                String[] ro3 = j5.ro(str2, "\\.");
                int min = Math.min(ro2.length, ro3.length);
                for (int i = 0; i < min; i++) {
                    if (!ro2[i].equals(ro3[i])) {
                        try {
                            return Integer.parseInt(ro2[i]) - Integer.parseInt(ro3[i]);
                        } catch (NumberFormatException unused) {
                            return 0;
                        }
                    }
                }
            }
            return 0;
        }

        @Override // java.util.Comparator
        /* renamed from: y */
        public int compare(CronetProvider cronetProvider, CronetProvider cronetProvider2) {
            int zn2 = zn(cronetProvider) - zn(cronetProvider2);
            if (zn2 != 0) {
                return zn2;
            }
            return -n3(cronetProvider.getVersion(), cronetProvider2.getVersion());
        }

        public final int zn(CronetProvider cronetProvider) {
            String name = cronetProvider.getName();
            if ("App-Packaged-Cronet-Provider".equals(name)) {
                return 1;
            }
            if ("Google-Play-Services-Cronet-Provider".equals(name)) {
                if (this.y) {
                    return 0;
                }
                return 2;
            }
            return 3;
        }
    }

    @Nullable
    public static CronetEngine y(Context context, @Nullable String str, boolean z2) {
        ArrayList arrayList = new ArrayList(CronetProvider.getAllProviders(context));
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((CronetProvider) arrayList.get(size)).isEnabled() || "Fallback-Cronet-Provider".equals(((CronetProvider) arrayList.get(size)).getName())) {
                arrayList.remove(size);
            }
        }
        Collections.sort(arrayList, new C0086y(z2));
        for (int i = 0; i < arrayList.size(); i++) {
            String name = ((CronetProvider) arrayList.get(i)).getName();
            try {
                CronetEngine.Builder createBuilder = ((CronetProvider) arrayList.get(i)).createBuilder();
                if (str != null) {
                    createBuilder.setUserAgent(str);
                }
                CronetEngine build = createBuilder.build();
                r.n3("CronetUtil", "CronetEngine built using " + name);
                return build;
            } catch (SecurityException unused) {
                r.c5("CronetUtil", "Failed to build CronetEngine. Please check that the process has android.permission.ACCESS_NETWORK_STATE.");
            } catch (UnsatisfiedLinkError unused2) {
                r.c5("CronetUtil", "Failed to link Cronet binaries. Please check that native Cronet binaries arebundled into your app.");
            }
        }
        r.c5("CronetUtil", "CronetEngine could not be built.");
        return null;
    }
}
