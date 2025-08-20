package androidx.core.app;

import android.app.Person;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;
/* loaded from: classes.dex */
public class zn {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2317a;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public String f2318gv;
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public IconCompat f2319n3;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2320v;
    @Nullable
    public CharSequence y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public String f2321zn;

    /* loaded from: classes.dex */
    public static class n3 {
        public static Person n3(zn znVar) {
            Icon icon;
            Person.Builder name = new Person.Builder().setName(znVar.v());
            if (znVar.zn() != null) {
                icon = znVar.zn().r();
            } else {
                icon = null;
            }
            return name.setIcon(icon).setUri(znVar.a()).setKey(znVar.gv()).setBot(znVar.fb()).setImportant(znVar.s()).build();
        }

        public static zn y(Person person) {
            IconCompat iconCompat;
            C0019zn a2 = new C0019zn().a(person.getName());
            if (person.getIcon() != null) {
                iconCompat = IconCompat.y(person.getIcon());
            } else {
                iconCompat = null;
            }
            return a2.zn(iconCompat).fb(person.getUri()).v(person.getKey()).n3(person.isBot()).gv(person.isImportant()).y();
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static PersistableBundle n3(zn znVar) {
            String str;
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = znVar.y;
            if (charSequence != null) {
                str = charSequence.toString();
            } else {
                str = null;
            }
            persistableBundle.putString("name", str);
            persistableBundle.putString("uri", znVar.f2321zn);
            persistableBundle.putString("key", znVar.f2318gv);
            persistableBundle.putBoolean("isBot", znVar.f2320v);
            persistableBundle.putBoolean("isImportant", znVar.f2317a);
            return persistableBundle;
        }

        public static zn y(PersistableBundle persistableBundle) {
            return new C0019zn().a(persistableBundle.getString("name")).fb(persistableBundle.getString("uri")).v(persistableBundle.getString("key")).n3(persistableBundle.getBoolean("isBot")).gv(persistableBundle.getBoolean("isImportant")).y();
        }
    }

    /* renamed from: androidx.core.app.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019zn {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2322a;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public String f2323gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public IconCompat f2324n3;

        /* renamed from: v  reason: collision with root package name */
        public boolean f2325v;
        @Nullable
        public CharSequence y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public String f2326zn;

        @NonNull
        public C0019zn a(@Nullable CharSequence charSequence) {
            this.y = charSequence;
            return this;
        }

        @NonNull
        public C0019zn fb(@Nullable String str) {
            this.f2326zn = str;
            return this;
        }

        @NonNull
        public C0019zn gv(boolean z2) {
            this.f2322a = z2;
            return this;
        }

        @NonNull
        public C0019zn n3(boolean z2) {
            this.f2325v = z2;
            return this;
        }

        @NonNull
        public C0019zn v(@Nullable String str) {
            this.f2323gv = str;
            return this;
        }

        @NonNull
        public zn y() {
            return new zn(this);
        }

        @NonNull
        public C0019zn zn(@Nullable IconCompat iconCompat) {
            this.f2324n3 = iconCompat;
            return this;
        }
    }

    public zn(C0019zn c0019zn) {
        this.y = c0019zn.y;
        this.f2319n3 = c0019zn.f2324n3;
        this.f2321zn = c0019zn.f2326zn;
        this.f2318gv = c0019zn.f2323gv;
        this.f2320v = c0019zn.f2325v;
        this.f2317a = c0019zn.f2322a;
    }

    @NonNull
    public static zn n3(@NonNull PersistableBundle persistableBundle) {
        return y.y(persistableBundle);
    }

    @NonNull
    public static zn y(@NonNull Person person) {
        return n3.y(person);
    }

    @Nullable
    public String a() {
        return this.f2321zn;
    }

    @NonNull
    public String c5() {
        String str = this.f2321zn;
        if (str != null) {
            return str;
        }
        if (this.y != null) {
            return "name:" + ((Object) this.y);
        }
        return "";
    }

    @NonNull
    public Bundle f() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence("name", this.y);
        IconCompat iconCompat = this.f2319n3;
        if (iconCompat != null) {
            bundle = iconCompat.z();
        } else {
            bundle = null;
        }
        bundle2.putBundle("icon", bundle);
        bundle2.putString("uri", this.f2321zn);
        bundle2.putString("key", this.f2318gv);
        bundle2.putBoolean("isBot", this.f2320v);
        bundle2.putBoolean("isImportant", this.f2317a);
        return bundle2;
    }

    public boolean fb() {
        return this.f2320v;
    }

    @Nullable
    public String gv() {
        return this.f2318gv;
    }

    @NonNull
    public Person i9() {
        return n3.n3(this);
    }

    public boolean s() {
        return this.f2317a;
    }

    @NonNull
    public PersistableBundle t() {
        return y.n3(this);
    }

    @Nullable
    public CharSequence v() {
        return this.y;
    }

    @Nullable
    public IconCompat zn() {
        return this.f2319n3;
    }
}
