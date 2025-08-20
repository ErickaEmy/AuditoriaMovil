package ta;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class n3 {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f13921a;

    /* renamed from: c  reason: collision with root package name */
    public int f13922c;

    /* renamed from: c5  reason: collision with root package name */
    public IconCompat f13923c5;

    /* renamed from: co  reason: collision with root package name */
    public boolean f13924co;

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f13925f;

    /* renamed from: f3  reason: collision with root package name */
    public boolean f13926f3;

    /* renamed from: fb  reason: collision with root package name */
    public CharSequence f13927fb;

    /* renamed from: gv  reason: collision with root package name */
    public Intent[] f13928gv;

    /* renamed from: i4  reason: collision with root package name */
    public boolean f13929i4 = true;

    /* renamed from: i9  reason: collision with root package name */
    public androidx.core.app.zn[] f13930i9;

    /* renamed from: mt  reason: collision with root package name */
    public boolean f13931mt;

    /* renamed from: n  reason: collision with root package name */
    public int f13932n;

    /* renamed from: n3  reason: collision with root package name */
    public String f13933n3;

    /* renamed from: p  reason: collision with root package name */
    public UserHandle f13934p;

    /* renamed from: r  reason: collision with root package name */
    public boolean f13935r;

    /* renamed from: s  reason: collision with root package name */
    public CharSequence f13936s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public mg.n3 f13937t;

    /* renamed from: tl  reason: collision with root package name */
    public boolean f13938tl;

    /* renamed from: v  reason: collision with root package name */
    public ComponentName f13939v;

    /* renamed from: w  reason: collision with root package name */
    public long f13940w;

    /* renamed from: wz  reason: collision with root package name */
    public int f13941wz;

    /* renamed from: x4  reason: collision with root package name */
    public boolean f13942x4;

    /* renamed from: xc  reason: collision with root package name */
    public PersistableBundle f13943xc;
    public Context y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f13944z;

    /* renamed from: zn  reason: collision with root package name */
    public String f13945zn;

    /* loaded from: classes.dex */
    public static class y {
        public static void y(@NonNull ShortcutInfo.Builder builder, int i) {
            builder.setExcludedFromSurfaces(i);
        }
    }

    @Nullable
    public static androidx.core.app.zn[] a(@NonNull PersistableBundle persistableBundle) {
        if (persistableBundle != null && persistableBundle.containsKey("extraPersonCount")) {
            int i = persistableBundle.getInt("extraPersonCount");
            androidx.core.app.zn[] znVarArr = new androidx.core.app.zn[i];
            int i5 = 0;
            while (i5 < i) {
                StringBuilder sb = new StringBuilder();
                sb.append("extraPerson_");
                int i6 = i5 + 1;
                sb.append(i6);
                znVarArr[i5] = androidx.core.app.zn.n3(persistableBundle.getPersistableBundle(sb.toString()));
                i5 = i6;
            }
            return znVarArr;
        }
        return null;
    }

    @Nullable
    public static mg.n3 gv(@NonNull ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (shortcutInfo.getLocusId() == null) {
                return null;
            }
            return mg.n3.gv(shortcutInfo.getLocusId());
        }
        return v(shortcutInfo.getExtras());
    }

    public static List<n3> n3(@NonNull Context context, @NonNull List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (ShortcutInfo shortcutInfo : list) {
            arrayList.add(new C0217n3(context, shortcutInfo).y());
        }
        return arrayList;
    }

    @Nullable
    public static mg.n3 v(@Nullable PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString("extraLocusId")) == null) {
            return null;
        }
        return new mg.n3(string);
    }

    public boolean fb(int i) {
        if ((i & this.f13922c) != 0) {
            return true;
        }
        return false;
    }

    public ShortcutInfo s() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.y, this.f13933n3).setShortLabel(this.f13921a).setIntents(this.f13928gv);
        IconCompat iconCompat = this.f13923c5;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.x4(this.y));
        }
        if (!TextUtils.isEmpty(this.f13927fb)) {
            intents.setLongLabel(this.f13927fb);
        }
        if (!TextUtils.isEmpty(this.f13936s)) {
            intents.setDisabledMessage(this.f13936s);
        }
        ComponentName componentName = this.f13939v;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.f13925f;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.f13941wz);
        PersistableBundle persistableBundle = this.f13943xc;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            androidx.core.app.zn[] znVarArr = this.f13930i9;
            if (znVarArr != null && znVarArr.length > 0) {
                int length = znVarArr.length;
                Person[] personArr = new Person[length];
                for (int i = 0; i < length; i++) {
                    personArr[i] = this.f13930i9[i].i9();
                }
                intents.setPersons(personArr);
            }
            mg.n3 n3Var = this.f13937t;
            if (n3Var != null) {
                intents.setLocusId(n3Var.zn());
            }
            intents.setLongLived(this.f13938tl);
        } else {
            intents.setExtras(y());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            y.y(intents, this.f13922c);
        }
        return intents.build();
    }

    public final PersistableBundle y() {
        if (this.f13943xc == null) {
            this.f13943xc = new PersistableBundle();
        }
        androidx.core.app.zn[] znVarArr = this.f13930i9;
        if (znVarArr != null && znVarArr.length > 0) {
            this.f13943xc.putInt("extraPersonCount", znVarArr.length);
            int i = 0;
            while (i < this.f13930i9.length) {
                PersistableBundle persistableBundle = this.f13943xc;
                StringBuilder sb = new StringBuilder();
                sb.append("extraPerson_");
                int i5 = i + 1;
                sb.append(i5);
                persistableBundle.putPersistableBundle(sb.toString(), this.f13930i9[i].t());
                i = i5;
            }
        }
        mg.n3 n3Var = this.f13937t;
        if (n3Var != null) {
            this.f13943xc.putString("extraLocusId", n3Var.y());
        }
        this.f13943xc.putBoolean("extraLongLived", this.f13938tl);
        return this.f13943xc;
    }

    @NonNull
    public String zn() {
        return this.f13933n3;
    }

    /* renamed from: ta.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0217n3 {

        /* renamed from: gv  reason: collision with root package name */
        public Map<String, Map<String, List<String>>> f13946gv;

        /* renamed from: n3  reason: collision with root package name */
        public boolean f13947n3;

        /* renamed from: v  reason: collision with root package name */
        public Uri f13948v;
        public final n3 y;

        /* renamed from: zn  reason: collision with root package name */
        public Set<String> f13949zn;

        public C0217n3(@NonNull Context context, @NonNull String str) {
            n3 n3Var = new n3();
            this.y = n3Var;
            n3Var.y = context;
            n3Var.f13933n3 = str;
        }

        @NonNull
        public C0217n3 a(@NonNull CharSequence charSequence) {
            this.y.f13921a = charSequence;
            return this;
        }

        @NonNull
        public C0217n3 gv(@NonNull Intent[] intentArr) {
            this.y.f13928gv = intentArr;
            return this;
        }

        @NonNull
        public C0217n3 n3(IconCompat iconCompat) {
            this.y.f13923c5 = iconCompat;
            return this;
        }

        @NonNull
        public C0217n3 v(@NonNull CharSequence charSequence) {
            this.y.f13927fb = charSequence;
            return this;
        }

        @NonNull
        public n3 y() {
            String[] strArr;
            if (!TextUtils.isEmpty(this.y.f13921a)) {
                n3 n3Var = this.y;
                Intent[] intentArr = n3Var.f13928gv;
                if (intentArr != null && intentArr.length != 0) {
                    if (this.f13947n3) {
                        if (n3Var.f13937t == null) {
                            n3Var.f13937t = new mg.n3(n3Var.f13933n3);
                        }
                        this.y.f13938tl = true;
                    }
                    if (this.f13949zn != null) {
                        n3 n3Var2 = this.y;
                        if (n3Var2.f13925f == null) {
                            n3Var2.f13925f = new HashSet();
                        }
                        this.y.f13925f.addAll(this.f13949zn);
                    }
                    if (this.f13946gv != null) {
                        n3 n3Var3 = this.y;
                        if (n3Var3.f13943xc == null) {
                            n3Var3.f13943xc = new PersistableBundle();
                        }
                        for (String str : this.f13946gv.keySet()) {
                            Map<String, List<String>> map = this.f13946gv.get(str);
                            this.y.f13943xc.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                            for (String str2 : map.keySet()) {
                                List<String> list = map.get(str2);
                                PersistableBundle persistableBundle = this.y.f13943xc;
                                String str3 = str + "/" + str2;
                                if (list == null) {
                                    strArr = new String[0];
                                } else {
                                    strArr = (String[]) list.toArray(new String[0]);
                                }
                                persistableBundle.putStringArray(str3, strArr);
                            }
                        }
                    }
                    if (this.f13948v != null) {
                        n3 n3Var4 = this.y;
                        if (n3Var4.f13943xc == null) {
                            n3Var4.f13943xc = new PersistableBundle();
                        }
                        this.y.f13943xc.putString("extraSliceUri", x.n3.y(this.f13948v));
                    }
                    return this.y;
                }
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            throw new IllegalArgumentException("Shortcut must have a non-empty label");
        }

        @NonNull
        public C0217n3 zn(@NonNull Intent intent) {
            return gv(new Intent[]{intent});
        }

        public C0217n3(@NonNull Context context, @NonNull ShortcutInfo shortcutInfo) {
            n3 n3Var = new n3();
            this.y = n3Var;
            n3Var.y = context;
            n3Var.f13933n3 = shortcutInfo.getId();
            n3Var.f13945zn = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            n3Var.f13928gv = (Intent[]) Arrays.copyOf(intents, intents.length);
            n3Var.f13939v = shortcutInfo.getActivity();
            n3Var.f13921a = shortcutInfo.getShortLabel();
            n3Var.f13927fb = shortcutInfo.getLongLabel();
            n3Var.f13936s = shortcutInfo.getDisabledMessage();
            int i = Build.VERSION.SDK_INT;
            if (i >= 28) {
                n3Var.f13932n = shortcutInfo.getDisabledReason();
            } else {
                n3Var.f13932n = shortcutInfo.isEnabled() ? 0 : 3;
            }
            n3Var.f13925f = shortcutInfo.getCategories();
            n3Var.f13930i9 = n3.a(shortcutInfo.getExtras());
            n3Var.f13934p = shortcutInfo.getUserHandle();
            n3Var.f13940w = shortcutInfo.getLastChangedTimestamp();
            if (i >= 30) {
                n3Var.f13931mt = shortcutInfo.isCached();
            }
            n3Var.f13924co = shortcutInfo.isDynamic();
            n3Var.f13944z = shortcutInfo.isPinned();
            n3Var.f13935r = shortcutInfo.isDeclaredInManifest();
            n3Var.f13942x4 = shortcutInfo.isImmutable();
            n3Var.f13929i4 = shortcutInfo.isEnabled();
            n3Var.f13926f3 = shortcutInfo.hasKeyFieldsOnly();
            n3Var.f13937t = n3.gv(shortcutInfo);
            n3Var.f13941wz = shortcutInfo.getRank();
            n3Var.f13943xc = shortcutInfo.getExtras();
        }
    }
}
