package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class zn {

    /* renamed from: i9  reason: collision with root package name */
    public static final Pattern f3014i9 = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: a  reason: collision with root package name */
    public final String f3015a;

    /* renamed from: c5  reason: collision with root package name */
    public final String f3016c5;

    /* renamed from: fb  reason: collision with root package name */
    public final String f3017fb;

    /* renamed from: gv  reason: collision with root package name */
    public boolean f3018gv;

    /* renamed from: s  reason: collision with root package name */
    public Pattern f3020s;

    /* renamed from: v  reason: collision with root package name */
    public boolean f3021v;

    /* renamed from: zn  reason: collision with root package name */
    public Pattern f3022zn;
    public final ArrayList<String> y = new ArrayList<>();

    /* renamed from: n3  reason: collision with root package name */
    public final Map<String, C0023zn> f3019n3 = new HashMap();

    /* loaded from: classes.dex */
    public static class n3 implements Comparable<n3> {

        /* renamed from: v  reason: collision with root package name */
        public String f3023v;
        public String y;

        public n3(@NonNull String str) {
            String[] split = str.split("/", -1);
            this.y = split[0];
            this.f3023v = split[1];
        }

        @Override // java.lang.Comparable
        /* renamed from: y */
        public int compareTo(@NonNull n3 n3Var) {
            int i;
            if (this.y.equals(n3Var.y)) {
                i = 2;
            } else {
                i = 0;
            }
            if (this.f3023v.equals(n3Var.f3023v)) {
                return i + 1;
            }
            return i;
        }
    }

    /* loaded from: classes.dex */
    public static final class y {

        /* renamed from: n3  reason: collision with root package name */
        public String f3024n3;
        public String y;

        /* renamed from: zn  reason: collision with root package name */
        public String f3025zn;

        @NonNull
        public y gv(@NonNull String str) {
            this.y = str;
            return this;
        }

        @NonNull
        public y n3(@NonNull String str) {
            if (!str.isEmpty()) {
                this.f3024n3 = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        @NonNull
        public zn y() {
            return new zn(this.y, this.f3024n3, this.f3025zn);
        }

        @NonNull
        public y zn(@NonNull String str) {
            this.f3025zn = str;
            return this;
        }
    }

    /* renamed from: androidx.navigation.zn$zn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0023zn {

        /* renamed from: n3  reason: collision with root package name */
        public ArrayList<String> f3026n3 = new ArrayList<>();
        public String y;

        public void gv(String str) {
            this.y = str;
        }

        public String n3(int i) {
            return this.f3026n3.get(i);
        }

        public int v() {
            return this.f3026n3.size();
        }

        public void y(String str) {
            this.f3026n3.add(str);
        }

        public String zn() {
            return this.y;
        }
    }

    public zn(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        boolean z2;
        this.f3022zn = null;
        this.f3018gv = false;
        this.f3021v = false;
        this.f3020s = null;
        this.f3015a = str;
        this.f3017fb = str2;
        this.f3016c5 = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            if (parse.getQuery() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f3021v = z2;
            StringBuilder sb = new StringBuilder("^");
            if (!f3014i9.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.f3021v) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    y(str.substring(0, matcher.start()), sb, compile);
                }
                this.f3018gv = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    C0023zn c0023zn = new C0023zn();
                    int i = 0;
                    while (matcher2.find()) {
                        c0023zn.y(matcher2.group(1));
                        sb2.append(Pattern.quote(queryParameter.substring(i, matcher2.start())));
                        sb2.append("(.+?)?");
                        i = matcher2.end();
                    }
                    if (i < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(i)));
                    }
                    c0023zn.gv(sb2.toString().replace(".*", "\\E.*\\Q"));
                    this.f3019n3.put(str4, c0023zn);
                }
            } else {
                this.f3018gv = y(str, sb, compile);
            }
            this.f3022zn = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"), 2);
        }
        if (str3 != null) {
            if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                n3 n3Var = new n3(str3);
                this.f3020s = Pattern.compile(("^(" + n3Var.y + "|[*]+)/(" + n3Var.f3023v + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
                return;
            }
            throw new IllegalArgumentException("The given mimeType " + str3 + " does not match to required \"type/subtype\" format");
        }
    }

    public final boolean a(Bundle bundle, String str, String str2, androidx.navigation.n3 n3Var) {
        if (n3Var != null) {
            try {
                n3Var.y().fb(bundle, str, str2);
                return false;
            } catch (IllegalArgumentException unused) {
                return true;
            }
        }
        bundle.putString(str, str2);
        return false;
    }

    public int gv(@NonNull String str) {
        if (this.f3016c5 != null && this.f3020s.matcher(str).matches()) {
            return new n3(this.f3016c5).compareTo(new n3(str));
        }
        return -1;
    }

    @Nullable
    public String n3() {
        return this.f3017fb;
    }

    public boolean v() {
        return this.f3018gv;
    }

    public final boolean y(@NonNull String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z2 = !str.contains(".*");
        int i = 0;
        while (matcher.find()) {
            this.y.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i, matcher.start())));
            sb.append("(.+?)");
            i = matcher.end();
            z2 = false;
        }
        if (i < str.length()) {
            sb.append(Pattern.quote(str.substring(i)));
        }
        sb.append("($|(\\?(.)*))");
        return z2;
    }

    @Nullable
    public Bundle zn(@NonNull Uri uri, @NonNull Map<String, androidx.navigation.n3> map) {
        Matcher matcher;
        String str;
        Matcher matcher2 = this.f3022zn.matcher(uri.toString());
        if (!matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.y.size();
        int i = 0;
        while (i < size) {
            String str2 = this.y.get(i);
            i++;
            if (a(bundle, str2, Uri.decode(matcher2.group(i)), map.get(str2))) {
                return null;
            }
        }
        if (this.f3021v) {
            for (String str3 : this.f3019n3.keySet()) {
                C0023zn c0023zn = this.f3019n3.get(str3);
                String queryParameter = uri.getQueryParameter(str3);
                if (queryParameter != null) {
                    matcher = Pattern.compile(c0023zn.zn()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                for (int i5 = 0; i5 < c0023zn.v(); i5++) {
                    if (matcher != null) {
                        str = Uri.decode(matcher.group(i5 + 1));
                    } else {
                        str = null;
                    }
                    String n32 = c0023zn.n3(i5);
                    androidx.navigation.n3 n3Var = map.get(n32);
                    if (str != null && !str.replaceAll("[{}]", "").equals(n32) && a(bundle, n32, str, n3Var)) {
                        return null;
                    }
                }
            }
        }
        return bundle;
    }
}
