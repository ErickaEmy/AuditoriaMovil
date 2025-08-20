package qj;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import qj.f;
import qj.y;
/* loaded from: classes.dex */
public class t {
    public static final y.n3 y = new y.n3("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");

    /* renamed from: n3  reason: collision with root package name */
    public static final y.n3 f12959n3 = new y.n3("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");

    /* renamed from: zn  reason: collision with root package name */
    public static final y.v f12986zn = new y.v("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");

    /* renamed from: gv  reason: collision with root package name */
    public static final y.zn f12947gv = new y.zn("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");

    /* renamed from: v  reason: collision with root package name */
    public static final y.a f12974v = new y.a("START_SAFE_BROWSING", "START_SAFE_BROWSING");
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final y.a f12932a = new y.a("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");
    @Deprecated

    /* renamed from: fb  reason: collision with root package name */
    public static final y.a f12945fb = new y.a("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");

    /* renamed from: s  reason: collision with root package name */
    public static final y.a f12967s = new y.a("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");

    /* renamed from: c5  reason: collision with root package name */
    public static final y.a f12936c5 = new y.a("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");

    /* renamed from: i9  reason: collision with root package name */
    public static final y.a f12950i9 = new y.a("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");

    /* renamed from: f  reason: collision with root package name */
    public static final y.zn f12942f = new y.zn("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");

    /* renamed from: t  reason: collision with root package name */
    public static final y.zn f12968t = new y.zn("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");

    /* renamed from: tl  reason: collision with root package name */
    public static final y.zn f12970tl = new y.zn("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");

    /* renamed from: wz  reason: collision with root package name */
    public static final y.zn f12977wz = new y.zn("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");

    /* renamed from: xc  reason: collision with root package name */
    public static final y.zn f12980xc = new y.zn("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");

    /* renamed from: w  reason: collision with root package name */
    public static final y.zn f12976w = new y.zn("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");

    /* renamed from: p  reason: collision with root package name */
    public static final y.n3 f12962p = new y.n3("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");

    /* renamed from: mt  reason: collision with root package name */
    public static final y.n3 f12957mt = new y.n3("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");

    /* renamed from: co  reason: collision with root package name */
    public static final y.zn f12937co = new y.zn("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");

    /* renamed from: z  reason: collision with root package name */
    public static final y.a f12984z = new y.a("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");

    /* renamed from: r  reason: collision with root package name */
    public static final y.zn f12965r = new y.zn("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");

    /* renamed from: x4  reason: collision with root package name */
    public static final y.n3 f12979x4 = new y.n3("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");

    /* renamed from: i4  reason: collision with root package name */
    public static final y.n3 f12949i4 = new y.n3("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");

    /* renamed from: f3  reason: collision with root package name */
    public static final y.a f12943f3 = new y.a("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");

    /* renamed from: n  reason: collision with root package name */
    public static final y.a f12958n = new y.a("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");

    /* renamed from: c  reason: collision with root package name */
    public static final y.a f12935c = new y.a("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");

    /* renamed from: d0  reason: collision with root package name */
    public static final y.n3 f12939d0 = new y.n3("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");

    /* renamed from: fh  reason: collision with root package name */
    public static final y.n3 f12946fh = new y.n3("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");

    /* renamed from: rz  reason: collision with root package name */
    public static final y.gv f12966rz = new y.gv("WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");

    /* renamed from: mg  reason: collision with root package name */
    public static final y.n3 f12956mg = new y.n3("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");

    /* renamed from: ta  reason: collision with root package name */
    public static final y.n3 f12969ta = new y.n3("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");

    /* renamed from: d  reason: collision with root package name */
    public static final y.n3 f12938d = new y.n3("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");

    /* renamed from: z6  reason: collision with root package name */
    public static final y.n3 f12985z6 = new y.n3("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");

    /* renamed from: ej  reason: collision with root package name */
    public static final y.v f12940ej = new y.v("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");

    /* renamed from: ud  reason: collision with root package name */
    public static final y.v f12972ud = new y.v("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");

    /* renamed from: a8  reason: collision with root package name */
    public static final y.s f12933a8 = new y.s("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");

    /* renamed from: x  reason: collision with root package name */
    public static final y.s f12978x = new y.s("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");

    /* renamed from: b  reason: collision with root package name */
    public static final y.fb f12934b = new y.fb("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");

    /* renamed from: k5  reason: collision with root package name */
    public static final f.n3 f12955k5 = new f.n3("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");

    /* renamed from: yt  reason: collision with root package name */
    public static final f.y f12983yt = new f.y("STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS", "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH");

    /* renamed from: vl  reason: collision with root package name */
    public static final y.s f12975vl = new y.s("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");

    /* renamed from: hw  reason: collision with root package name */
    public static final y.c5 f12948hw = new y("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");

    /* renamed from: j5  reason: collision with root package name */
    public static final y.gv f12952j5 = new y.gv("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");

    /* renamed from: qn  reason: collision with root package name */
    public static final y.gv f12964qn = new y.gv("MULTI_PROCESS", "MULTI_PROCESS_QUERY");

    /* renamed from: o  reason: collision with root package name */
    public static final y.s f12960o = new y.s("FORCE_DARK", "FORCE_DARK");

    /* renamed from: j  reason: collision with root package name */
    public static final y.gv f12951j = new y.gv("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");

    /* renamed from: oz  reason: collision with root package name */
    public static final y.gv f12961oz = new y.gv("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");

    /* renamed from: ut  reason: collision with root package name */
    public static final y.gv f12973ut = new y.gv("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");

    /* renamed from: q9  reason: collision with root package name */
    public static final y.gv f12963q9 = new y.gv("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");

    /* renamed from: k  reason: collision with root package name */
    public static final y.gv f12954k = new y.gv("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");

    /* renamed from: f7  reason: collision with root package name */
    public static final y.gv f12944f7 = new y.gv("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");

    /* renamed from: en  reason: collision with root package name */
    public static final y.gv f12941en = new y.gv("GET_COOKIE_INFO", "GET_COOKIE_INFO");

    /* renamed from: jz  reason: collision with root package name */
    public static final y.gv f12953jz = new y.gv("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");

    /* renamed from: u  reason: collision with root package name */
    public static final y.gv f12971u = new y.gv("USER_AGENT_METADATA", "USER_AGENT_METADATA");

    /* renamed from: y5  reason: collision with root package name */
    public static final y.gv f12982y5 = new n3("MULTI_PROFILE", "MULTI_PROFILE");

    /* renamed from: xg  reason: collision with root package name */
    public static final y.gv f12981xg = new y.gv("ATTRIBUTION_REGISTRATION_BEHAVIOR", "ATTRIBUTION_BEHAVIOR");

    /* loaded from: classes.dex */
    public class n3 extends y.gv {
        public n3(String str, String str2) {
            super(str, str2);
        }

        @Override // qj.y
        public boolean gv() {
            if (!super.gv() || !qk.a.y("MULTI_PROCESS")) {
                return false;
            }
            return qk.v.fb();
        }
    }

    /* loaded from: classes.dex */
    public class y extends y.c5 {

        /* renamed from: gv  reason: collision with root package name */
        public final Pattern f12987gv;

        public y(String str, String str2) {
            super(str, str2);
            this.f12987gv = Pattern.compile("\\A\\d+");
        }

        @Override // qj.y
        public boolean gv() {
            boolean gv2 = super.gv();
            if (gv2 && Build.VERSION.SDK_INT < 29) {
                PackageInfo n32 = qk.v.n3();
                if (n32 == null) {
                    return false;
                }
                Matcher matcher = this.f12987gv.matcher(n32.versionName);
                if (!matcher.find() || Integer.parseInt(n32.versionName.substring(matcher.start(), matcher.end())) < 105) {
                    return false;
                }
                return true;
            }
            return gv2;
        }
    }

    public static boolean n3(@NonNull String str) {
        return zn(str, qj.y.v());
    }

    @NonNull
    public static UnsupportedOperationException y() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public static <T extends v> boolean zn(@NonNull String str, @NonNull Collection<T> collection) {
        HashSet<v> hashSet = new HashSet();
        for (T t2 : collection) {
            if (t2.y().equals(str)) {
                hashSet.add(t2);
            }
        }
        if (!hashSet.isEmpty()) {
            for (v vVar : hashSet) {
                if (vVar.zn()) {
                    return true;
                }
            }
            return false;
        }
        throw new RuntimeException("Unknown feature " + str);
    }
}
