package j5;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class gv {
    @Nullable
    public final Object y;

    /* loaded from: classes.dex */
    public static class n3 extends y {
        public n3(gv gvVar) {
            super(gvVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            j5.zn gv2 = this.y.gv(i);
            if (gv2 == null) {
                return null;
            }
            return gv2.w9();
        }
    }

    /* loaded from: classes.dex */
    public static class y extends AccessibilityNodeProvider {
        public final gv y;

        public y(gv gvVar) {
            this.y = gvVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            j5.zn n32 = this.y.n3(i);
            if (n32 == null) {
                return null;
            }
            return n32.w9();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<j5.zn> zn2 = this.y.zn(str, i);
            if (zn2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = zn2.size();
            for (int i5 = 0; i5 < size; i5++) {
                arrayList.add(zn2.get(i5).w9());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i5, Bundle bundle) {
            return this.y.a(i, i5, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends n3 {
        public zn(gv gvVar) {
            super(gvVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.y.y(i, j5.zn.w2(accessibilityNodeInfo), str, bundle);
        }
    }

    public gv() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.y = new zn(this);
        } else {
            this.y = new n3(this);
        }
    }

    public boolean a(int i, int i5, @Nullable Bundle bundle) {
        return false;
    }

    @Nullable
    public j5.zn gv(int i) {
        return null;
    }

    @Nullable
    public j5.zn n3(int i) {
        return null;
    }

    @Nullable
    public Object v() {
        return this.y;
    }

    @Nullable
    public List<j5.zn> zn(@NonNull String str, int i) {
        return null;
    }

    public gv(@Nullable Object obj) {
        this.y = obj;
    }

    public void y(int i, @NonNull j5.zn znVar, @NonNull String str, @Nullable Bundle bundle) {
    }
}
