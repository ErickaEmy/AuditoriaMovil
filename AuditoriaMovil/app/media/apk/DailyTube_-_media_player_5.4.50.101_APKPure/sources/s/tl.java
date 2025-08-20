package s;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import com.hjq.permissions.Permission;
import java.util.Calendar;
/* loaded from: classes.dex */
public class tl {

    /* renamed from: gv  reason: collision with root package name */
    public static tl f13399gv;

    /* renamed from: n3  reason: collision with root package name */
    public final LocationManager f13400n3;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final y f13401zn = new y();

    /* loaded from: classes.dex */
    public static class y {

        /* renamed from: a  reason: collision with root package name */
        public long f13402a;

        /* renamed from: gv  reason: collision with root package name */
        public long f13403gv;

        /* renamed from: n3  reason: collision with root package name */
        public long f13404n3;

        /* renamed from: v  reason: collision with root package name */
        public long f13405v;
        public boolean y;

        /* renamed from: zn  reason: collision with root package name */
        public long f13406zn;
    }

    public tl(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.y = context;
        this.f13400n3 = locationManager;
    }

    public static tl y(@NonNull Context context) {
        if (f13399gv == null) {
            Context applicationContext = context.getApplicationContext();
            f13399gv = new tl(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f13399gv;
    }

    public final void a(@NonNull Location location) {
        boolean z2;
        long j2;
        long j4;
        y yVar = this.f13401zn;
        long currentTimeMillis = System.currentTimeMillis();
        t n32 = t.n3();
        n32.y(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j6 = n32.y;
        n32.y(currentTimeMillis, location.getLatitude(), location.getLongitude());
        if (n32.f13398zn == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j7 = n32.f13397n3;
        long j8 = n32.y;
        boolean z3 = z2;
        n32.y(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j9 = n32.f13397n3;
        if (j7 != -1 && j8 != -1) {
            if (currentTimeMillis > j8) {
                j4 = j9;
            } else if (currentTimeMillis > j7) {
                j4 = j8;
            } else {
                j4 = j7;
            }
            j2 = j4 + 60000;
        } else {
            j2 = 43200000 + currentTimeMillis;
        }
        yVar.y = z3;
        yVar.f13404n3 = j6;
        yVar.f13406zn = j7;
        yVar.f13403gv = j8;
        yVar.f13405v = j9;
        yVar.f13402a = j2;
    }

    public boolean gv() {
        y yVar = this.f13401zn;
        if (v()) {
            return yVar.y;
        }
        Location n32 = n3();
        if (n32 != null) {
            a(n32);
            return yVar.y;
        }
        int i = Calendar.getInstance().get(11);
        if (i >= 6 && i < 22) {
            return false;
        }
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public final Location n3() {
        Location location;
        Location location2 = null;
        if (mg.zn.zn(this.y, Permission.ACCESS_COARSE_LOCATION) == 0) {
            location = zn("network");
        } else {
            location = null;
        }
        if (mg.zn.zn(this.y, Permission.ACCESS_FINE_LOCATION) == 0) {
            location2 = zn("gps");
        }
        if (location2 != null && location != null) {
            if (location2.getTime() > location.getTime()) {
                return location2;
            }
            return location;
        } else if (location2 != null) {
            return location2;
        } else {
            return location;
        }
    }

    public final boolean v() {
        if (this.f13401zn.f13402a > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public final Location zn(String str) {
        try {
            if (this.f13400n3.isProviderEnabled(str)) {
                return this.f13400n3.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
