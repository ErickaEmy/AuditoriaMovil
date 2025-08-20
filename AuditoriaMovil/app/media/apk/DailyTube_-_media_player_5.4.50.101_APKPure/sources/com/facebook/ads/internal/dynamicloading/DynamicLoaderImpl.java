package com.facebook.ads.internal.dynamicloading;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;
import com.facebook.ads.RewardedInterstitialAd;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import com.facebook.ads.internal.api.AdSettingsApi;
import com.facebook.ads.internal.api.AdSizeApi;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.api.AudienceNetworkAdsApi;
import com.facebook.ads.internal.api.AudienceNetworkExportedActivityApi;
import com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi;
import com.facebook.ads.internal.api.BidderTokenProviderApi;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.api.InitApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import com.facebook.ads.internal.api.NativeAdViewApi;
import com.facebook.ads.internal.api.NativeAdViewAttributesApi;
import com.facebook.ads.internal.api.NativeAdViewTypeApi;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import com.facebook.ads.internal.api.NativeBannerAdApi;
import com.facebook.ads.internal.api.NativeBannerAdViewApi;
import com.facebook.ads.internal.api.NativeComponentTagApi;
import com.facebook.ads.internal.api.RewardedInterstitialAdApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.redexgen.X.C03945b;
import com.facebook.ads.redexgen.X.C03955c;
import com.facebook.ads.redexgen.X.C03975e;
import com.facebook.ads.redexgen.X.C04005h;
import com.facebook.ads.redexgen.X.C04015i;
import com.facebook.ads.redexgen.X.C04025j;
import com.facebook.ads.redexgen.X.C04055m;
import com.facebook.ads.redexgen.X.C04125t;
import com.facebook.ads.redexgen.X.C04165x;
import com.facebook.ads.redexgen.X.C0717Iv;
import com.facebook.ads.redexgen.X.C0718Iw;
import com.facebook.ads.redexgen.X.C0723Jc;
import com.facebook.ads.redexgen.X.C5M;
import com.facebook.ads.redexgen.X.C5P;
import com.facebook.ads.redexgen.X.C5V;
import com.facebook.ads.redexgen.X.C8Y;
import com.facebook.ads.redexgen.X.EnumC0724Je;
import com.facebook.ads.redexgen.X.JO;
import com.facebook.ads.redexgen.X.JP;
import com.facebook.ads.redexgen.X.JQ;
import com.facebook.ads.redexgen.X.JR;
import com.facebook.ads.redexgen.X.L3;
import com.facebook.ads.redexgen.X.V2;
import com.facebook.ads.redexgen.X.VE;
import com.facebook.ads.redexgen.X.ZG;
import com.facebook.ads.redexgen.X.ZH;
import com.facebook.ads.redexgen.X.ZX;
import com.uv.v7.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public class DynamicLoaderImpl implements DynamicLoader, RemoteRenderingApi {
    public static AdSettingsApi A00;
    public static AudienceNetworkAdsApi A01;
    public static NativeAdViewApi A02;
    public static NativeBannerAdViewApi A03;
    public static C03945b A04;
    public static String[] A05 = {"", "hl0DpOFqxM1jfK98LJTADvCdgffrETQN", "QW5nZBv4w8ebawOaJAju5UC6DpXIEYNP", "lDXIr49IIqC5d9soZ9ZlhOdK7Sq4PNcS", "1TLrXBQAGAxZIydv1bacR9cCDSxOiDhT", "HKpyy44hPf1TiYKwXHdFJYATCyhvdc4i", "5Vop4gtsdytJgHep4xjnsMChzM034SFi", "0HGMkPnlBdCz3NKZQL2lJn"};
    public static final InitApi A06 = new InitApi() { // from class: com.facebook.ads.redexgen.X.5d
        public final void initialize(Context context, MultithreadedBundleWrapper multithreadedBundleWrapper, AudienceNetworkAds.InitListener initListener, int i) {
            C8Y.A0G(C03955c.A09(context), multithreadedBundleWrapper, initListener, i);
        }

        public final boolean isInitialized() {
            return C8Y.A0H();
        }

        public final void onAdLoadInvoked(Context context) {
            C8Y.A08(C03955c.A09(context));
        }

        public final void onContentProviderCreated(Context context) {
            C8Y.A09(C03955c.A09(context));
        }
    };

    public AdOptionsViewApi createAdOptionsView(Context context, NativeAdBase nativeAdBase, NativeAdLayout nativeAdLayout, AdOptionsView.Orientation orientation, int i, AdOptionsView adOptionsView) {
        return new ZX(context, nativeAdBase, nativeAdLayout, orientation, i, adOptionsView);
    }

    public AdOptionsViewApi createAdOptionsView(Context context, NativeAdBase nativeAdBase, NativeAdLayout nativeAdLayout, AdOptionsView adOptionsView) {
        return new ZX(context, nativeAdBase, nativeAdLayout, adOptionsView);
    }

    public AdSettingsApi createAdSettingsApi() {
        if (A00 == null) {
            A00 = new AdSettingsApi() { // from class: com.facebook.ads.redexgen.X.5O
                public static byte[] A00;
                public static String[] A01 = {"TFkOB7WAPr6F4oSDAD2lBM3orjMmpCql", "qm70b4Ur0FRBuwfAT3tN36vqG0Nf4UFd", "zPpQ1cnfbXvczPvVr", "8IvLkkrNdMNEKNCoxjkf6IUs19Br2Jri", "GW45NL8mXfcvSmeq7", "yk6fztNbTNbTdYOeWP4a4qU6KiJuVBGT", "Yi7aT5eKgI7tScmdPed7vydq7f2NoqCT", "ldtlhzHQs0POAzCz5K2SoOIZIeNjlq2l"};
                public static final String A02;
                public static final Collection<String> A03;
                public static volatile boolean A04;

                public static String A00(int i, int i5, int i6) {
                    byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
                    for (int i8 = 0; i8 < copyOfRange.length; i8++) {
                        copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 48);
                    }
                    return new String(copyOfRange);
                }

                public static void A01() {
                    A00 = new byte[]{124, 119, 101, 8, 15, 9, 4, 31, 30, 13, 18, 24, 30, 4, 18, 31, 4, 19, 26, 8, 19, 4, 16, 30, 2, 107, 90, 76, 75, 31, 82, 80, 91, 90, 31, 91, 90, 73, 86, 92, 90, 31, 87, 94, 76, 87, 5, 31, 45, 18, 31, 20, 90, 14, 31, 9, 14, 19, 20, 29, 90, 3, 21, 15, 8, 90, 27, 10, 10, 90, 13, 19, 14, 18, 90, 60, 27, 25, 31, 24, 21, 21, 17, 93, 9, 90, 27, 30, 90, 15, 20, 19, 14, 9, 90, 3, 21, 15, 90, 23, 15, 9, 14, 90, 9, 10, 31, 25, 19, 28, 3, 90, 14, 18, 31, 90, 30, 31, 12, 19, 25, 31, 90, 18, 27, 9, 18, 31, 30, 90, 51, 62, 90, 14, 21, 90, 31, 20, 9, 15, 8, 31, 90, 14, 18, 31, 90, 30, 31, 22, 19, 12, 31, 8, 3, 90, 21, 28, 90, 14, 31, 9, 14, 90, 27, 30, 9, 86, 90, 27, 30, 30, 90, 14, 18, 31, 90, 28, 21, 22, 22, 21, 13, 19, 20, 29, 90, 25, 21, 30, 31, 90, 24, 31, 28, 21, 8, 31, 90, 22, 21, 27, 30, 19, 20, 29, 90, 27, 20, 90, 27, 30, 64, 90, 59, 30, 41, 31, 14, 14, 19, 20, 29, 9, 84, 27, 30, 30, 46, 31, 9, 14, 62, 31, 12, 19, 25, 31, 82, 88, 26, 27, 8, 23, 29, 27, 55, 26, 54, 31, 13, 22, 60, 52, 52, 60, 55, 62, 4, 40, 63, 48, 114, 101, 106, 102, 114, Byte.MAX_VALUE, 104, 40, 38, 96, 41, 61, 48, 39, 103, 105, 43, 47};
                }

                static {
                    A01();
                    A02 = AdInternalSettings.class.getSimpleName();
                    HashSet hashSet = new HashSet();
                    A03 = hashSet;
                    hashSet.add(A00(262, 3, 49));
                    hashSet.add(A00(252, 10, 107));
                    hashSet.add(A00(265, 7, 32));
                    hashSet.add(A00(272, 8, R.styleable.AppCompatTheme_textColorSearchUrl));
                    A04 = false;
                }

                public static void A02(String str) {
                    if (A04) {
                        return;
                    }
                    A04 = true;
                    String str2 = A02;
                    Log.i(str2, A00(25, 23, 15) + str);
                    Log.i(str2, A00(48, 192, 74) + str + A00(0, 3, R.styleable.AppCompatTheme_textColorAlertDialogListItem));
                }

                public final boolean isTestMode(Context context) {
                    if (AdInternalSettings.isDebugBuild() || AdInternalSettings.isExplicitTestMode() || A03.contains(Build.PRODUCT)) {
                        return true;
                    }
                    MultithreadedBundleWrapper multithreadedBundleWrapper = AdInternalSettings.sSettingsBundle;
                    String A002 = A00(3, 22, 107);
                    String string = multithreadedBundleWrapper.getString(A002, (String) null);
                    if (string == null) {
                        SharedPreferences A003 = KE.A00(context);
                        String A004 = A00(240, 12, 78);
                        string = A003.getString(A004, null);
                        if (TextUtils.isEmpty(string)) {
                            UUID randomUUID = UUID.randomUUID();
                            if (A01[6].charAt(4) == 'r') {
                                throw new RuntimeException();
                            }
                            String[] strArr = A01;
                            strArr[4] = "ACuTT9OHS44wxpENU";
                            strArr[2] = "rDA9ItLQjR7JTNF9w";
                            string = randomUUID.toString();
                            A003.edit().putString(A004, string).apply();
                        }
                        AdInternalSettings.sSettingsBundle.putString(A002, string);
                    }
                    if (AdInternalSettings.getTestDevicesList().contains(string)) {
                        return true;
                    }
                    A02(string);
                    return false;
                }

                public final void turnOnDebugger() {
                    AbstractC0735Jp.A02();
                }
            };
        }
        AdSettingsApi adSettingsApi = A00;
        String[] strArr = A05;
        if (strArr[5].charAt(22) != strArr[3].charAt(22)) {
            A05[7] = "zPBUQH";
            return adSettingsApi;
        }
        throw new RuntimeException();
    }

    public AdSizeApi createAdSizeApi(int i) {
        final EnumC0724Je A022 = L3.A02(i);
        return new AdSizeApi() { // from class: com.facebook.ads.redexgen.X.8V
            public final int getHeight() {
                return A022.A02();
            }

            public final int getWidth() {
                return A022.A03();
            }
        };
    }

    public AdViewApi createAdViewApi(Context context, String str, AdSize adSize, AdViewParentApi adViewParentApi, AdView adView) {
        return (AdViewApi) C5M.A00(new C5P(context, str, adSize, adViewParentApi, adView), AdViewApi.class);
    }

    public AdViewApi createAdViewApi(Context context, String str, String str2, AdViewParentApi adViewParentApi, AdView adView) throws Exception {
        try {
            return (AdViewApi) C5M.A00(new C5P(context, str, str2, adViewParentApi, adView), AdViewApi.class);
        } catch (C0723Jc e2) {
            throw new Exception(e2.A01());
        }
    }

    public AudienceNetworkActivityApi createAudienceNetworkActivity(final AudienceNetworkActivity audienceNetworkActivity, final AudienceNetworkActivityApi audienceNetworkActivityApi) {
        final C5V c5v = new C5V(audienceNetworkActivity, audienceNetworkActivityApi);
        return new AudienceNetworkActivityApi(audienceNetworkActivity, audienceNetworkActivityApi, c5v) { // from class: com.facebook.ads.redexgen.X.5W
            public static byte[] A03;
            public static String[] A04 = {"kVVxbIvKBpFLpNMn249evg7U1t5DMrkR", "HNBIISUKPJt5lzvo", "tha", "s0U2IqORDUirQkjYFZUhzDbmHPDS66DK", "4XQ6Ra6x1CsG5mP0jlsGo4Oc8x5GsOh7", "mYQ1yQiLRLlGaSwEYEmmcgt3b9ncmm6M", "URRMMekVjcz4ECsO2XmiMnA4WEVCe5QQ", "lW2qNIOuJVr9bvm7hZsN45J1F7Bnv3JY"};
            public boolean A00;
            public final AudienceNetworkActivityApi A01;
            public final C5V A02;

            public static String A00(int i, int i5, int i6) {
                byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i5);
                for (int i8 = 0; i8 < copyOfRange.length; i8++) {
                    copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 71);
                }
                return new String(copyOfRange);
            }

            public static void A01() {
                A03 = new byte[]{12, 8, 7, 59, 42, 47, 43, 52, 41, 43, 20, 43, 58, 61, 53, 56, 49, 19, 44, 35, 54, 46, 35, 33, 50, 35, 34, -34, 35, 54, 33, 35, 46, 50, 39, 45, 44, -20, -70, -57, -72, -70, -68, -51, -62, -49, -62, -51, -46};
            }

            static {
                A01();
            }

            {
                this.A01 = audienceNetworkActivityApi;
                this.A02 = c5v;
            }

            private void A02(Throwable th) {
                this.A00 = true;
                this.A02.A0L();
                finish(8);
                C04447f logContext = this.A02.A0K();
                if (logContext != null) {
                    logContext.A07().A9a(A00(38, 11, 18), C8A.A0C, new C8B(th));
                    return;
                }
                String A002 = A00(0, 17, 127);
                if (A04[3].charAt(1) != '0') {
                    throw new RuntimeException();
                }
                A04[6] = "roakWe6n8CepWvGQKms2st32sM0MtJhe";
                Log.e(A002, A00(17, 21, 119), th);
            }

            public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
                try {
                    if (this.A00) {
                        this.A01.dump(str, fileDescriptor, printWriter, strArr);
                    } else {
                        this.A02.dump(str, fileDescriptor, printWriter, strArr);
                    }
                } catch (Throwable t2) {
                    A02(t2);
                }
            }

            public final void finish(int i) {
                this.A02.finish(i);
            }

            public final void onActivityResult(int i, int i5, Intent intent) {
                try {
                } catch (Throwable t2) {
                    A02(t2);
                }
                if (this.A00) {
                    this.A01.onActivityResult(i, i5, intent);
                    return;
                }
                this.A02.onActivityResult(i, i5, intent);
                this.A01.onActivityResult(i, i5, intent);
            }

            public final void onBackPressed() {
                try {
                    if (this.A00) {
                        return;
                    }
                    this.A02.onBackPressed();
                } catch (Throwable th) {
                    String[] strArr = A04;
                    if (strArr[4].charAt(24) == strArr[5].charAt(24)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A04;
                    strArr2[7] = "o2QAVIvbVP3X0FiUaWNt1f6t7dHcTRBl";
                    strArr2[0] = "vmYtMIbIQwew4451MpW2UPrO9wIbxS87";
                    A02(th);
                }
            }

            public final void onConfigurationChanged(Configuration configuration) {
                try {
                } catch (Throwable t2) {
                    A02(t2);
                }
                if (this.A00) {
                    this.A01.onConfigurationChanged(configuration);
                    return;
                }
                this.A02.onConfigurationChanged(configuration);
                this.A01.onConfigurationChanged(configuration);
            }

            public final void onCreate(Bundle bundle) {
                this.A01.onCreate(bundle);
                try {
                    this.A02.onCreate(bundle);
                } catch (Throwable t2) {
                    A02(t2);
                }
            }

            public final void onDestroy() {
                try {
                } catch (Throwable t2) {
                    A02(t2);
                }
                if (this.A00) {
                    this.A01.onDestroy();
                    return;
                }
                this.A02.onDestroy();
                this.A01.onDestroy();
            }

            public final void onPause() {
                try {
                } catch (Throwable t2) {
                    A02(t2);
                }
                if (this.A00) {
                    this.A01.onPause();
                    return;
                }
                this.A02.onPause();
                this.A01.onPause();
            }

            public final void onResume() {
                this.A01.onResume();
                try {
                    if (this.A00) {
                        return;
                    }
                    this.A02.onResume();
                } catch (Throwable t2) {
                    A02(t2);
                }
            }

            public final void onSaveInstanceState(Bundle bundle) {
                this.A01.onSaveInstanceState(bundle);
                try {
                    if (this.A00) {
                        return;
                    }
                    this.A02.onSaveInstanceState(bundle);
                } catch (Throwable th) {
                    String[] strArr = A04;
                    if (strArr[4].charAt(24) == strArr[5].charAt(24)) {
                        throw new RuntimeException();
                    }
                    A04[6] = "46sQaeWUXFUhhsRkoBzMlxezgaVtku4l";
                    A02(th);
                }
            }

            public final void onStart() {
                this.A01.onStart();
                try {
                    if (this.A00) {
                        return;
                    }
                    this.A02.onStart();
                } catch (Throwable t2) {
                    A02(t2);
                }
            }

            public final void onStop() {
                this.A01.onStop();
                try {
                    if (this.A00) {
                        return;
                    }
                    this.A02.onStop();
                } catch (Throwable t2) {
                    A02(t2);
                }
            }

            public final boolean onTouchEvent(MotionEvent motionEvent) {
                try {
                } catch (Throwable t2) {
                    A02(t2);
                }
                if (this.A00) {
                    return this.A01.onTouchEvent(motionEvent);
                }
                this.A02.onTouchEvent(motionEvent);
                return this.A01.onTouchEvent(motionEvent);
            }
        };
    }

    public AudienceNetworkAdsApi createAudienceNetworkAdsApi() {
        if (A01 == null) {
            A01 = new AudienceNetworkAdsApi() { // from class: com.facebook.ads.redexgen.X.5Y
                public final int getAdFormatForPlacement(String str) {
                    KL.A02(this);
                    return 0;
                }

                public final void initialize(Context context, MultithreadedBundleWrapper initSettings, AudienceNetworkAds.InitListener initListener) {
                    if (KL.A02(this)) {
                        return;
                    }
                    if (initListener == null) {
                        try {
                            initListener = new AudienceNetworkAds.InitListener() { // from class: com.facebook.ads.redexgen.X.5X
                                public final void onInitialized(AudienceNetworkAds.InitResult initResult) {
                                }
                            };
                        } catch (Throwable th) {
                            KL.A00(th, this);
                            return;
                        }
                    }
                    DynamicLoaderFactory.makeLoader(context).getInitApi().initialize(context, initSettings, initListener, 1);
                }

                public final boolean isInitialized() {
                    if (KL.A02(this)) {
                        return false;
                    }
                    try {
                        DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
                        if (dynamicLoader == null) {
                            return false;
                        }
                        return dynamicLoader.getInitApi().isInitialized();
                    } catch (Throwable th) {
                        KL.A00(th, this);
                        return false;
                    }
                }

                public final void onContentProviderCreated(Context context) {
                    if (KL.A02(this)) {
                        return;
                    }
                    try {
                        DynamicLoaderFactory.makeLoader(context).getInitApi().onContentProviderCreated(context);
                    } catch (Throwable th) {
                        KL.A00(th, this);
                    }
                }
            };
        }
        return A01;
    }

    public AudienceNetworkExportedActivityApi createAudienceNetworkExportedActivityApi(Activity activity) {
        return new C0717Iv(activity);
    }

    public AudienceNetworkRemoteServiceApi createAudienceNetworkRemoteService(Service service) {
        return new C0718Iw(service);
    }

    public BidderTokenProviderApi createBidderTokenProviderApi() {
        return getBidderTokenProviderApi();
    }

    public DefaultMediaViewVideoRendererApi createDefaultMediaViewVideoRendererApi() {
        return new VE();
    }

    public InterstitialAdApi createInterstitialAd(Context context, String str, InterstitialAd interstitialAd) {
        return (InterstitialAdApi) C5M.A00(new C03975e(context, str, interstitialAd), InterstitialAdApi.class);
    }

    public MediaViewApi createMediaViewApi() {
        return new ZH();
    }

    public MediaViewVideoRendererApi createMediaViewVideoRendererApi() {
        return new C04005h();
    }

    public C04015i createNativeAdApi(NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        return new C04015i(nativeAd, nativeAdBaseApi);
    }

    public C04015i createNativeAdApi(NativeAdBase nativeAdBase, NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        return new C04015i(nativeAdBase, nativeAd, nativeAdBaseApi);
    }

    public NativeAdBaseApi createNativeAdBaseApi(Context context, String str) {
        return new V2(context, str, (JO) V2.A0K(), false);
    }

    public NativeAdBaseApi createNativeAdBaseApi(NativeAdBaseApi nativeAdBaseApi) {
        return new V2((V2) nativeAdBaseApi);
    }

    public NativeAdBase createNativeAdBaseFromBidPayload(Context context, String str, String str2) throws Exception {
        try {
            return V2.A0A(context, str, str2);
        } catch (C0723Jc e2) {
            throw new Exception(e2.A01());
        }
    }

    public NativeAdImageApi createNativeAdImageApi(JSONObject jSONObject) {
        return JP.A00(jSONObject);
    }

    public NativeAdLayoutApi createNativeAdLayoutApi() {
        return new ZG();
    }

    public JQ createNativeAdRatingApi(JSONObject jSONObject) {
        return JQ.A00(jSONObject);
    }

    public NativeAdScrollViewApi createNativeAdScrollViewApi(NativeAdScrollView nativeAdScrollView, Context context, NativeAdsManager nativeAdsManager, NativeAdScrollView.AdViewProvider adViewProvider, int i, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i5) {
        return new C04025j(nativeAdScrollView, context, nativeAdsManager, adViewProvider, i, type, nativeAdViewAttributes, i5);
    }

    public NativeAdViewApi createNativeAdViewApi() {
        if (A02 == null) {
            A02 = new NativeAdViewApi() { // from class: com.facebook.ads.redexgen.X.5k
                public static String[] A00 = {"4lhDSJeQx8ImoxNIMYyIsOpW4XJuQDgf", "lqCKp7vrLkXGNxXrvc6I3m7c", "zCZ5ygsfQGVhB3Y237HbJ1q9o76yX", "bq9vw23WcXUY1kk1BWsR1Wz1yPOY5uBm", "", "Hv6Nwq3QZSzEF0Nb8JqXMZqCHWYzLqUn", "tYYpfGiIizklMQ8", "46C5bVFnHWUcfGRcMiONp8ja9wt0MV54"};

                public static View A00(C1116Yn c1116Yn, NativeAd nativeAd, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
                    if (nativeAdViewAttributes == null) {
                        nativeAdViewAttributes = new NativeAdViewAttributes();
                    }
                    JR jr = (JR) nativeAdViewAttributes.getInternalAttributes();
                    V2 internalNativeAd = V2.A0L(nativeAd.getInternalNativeAd());
                    internalNativeAd.A1X(JS.A00(type.getEnumCode()));
                    internalNativeAd.A1W(jr);
                    ER er = new ER();
                    NativeAdLayout mediumRectTemplateLayout = new NativeAdLayout(c1116Yn, er);
                    er.A04(mediumRectTemplateLayout, c1116Yn, nativeAd, jr);
                    mediumRectTemplateLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (LD.A02 * type.getHeight())));
                    return mediumRectTemplateLayout;
                }

                public static View A01(C1116Yn c1116Yn, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
                    if (nativeAdViewAttributes == null) {
                        nativeAdViewAttributes = new NativeAdViewAttributes();
                    }
                    V2 A0L = V2.A0L(nativeAd.getInternalNativeAd());
                    JR jr = (JR) nativeAdViewAttributes.getInternalAttributes();
                    A0L.A1X(JS.A0B);
                    A0L.A1W(jr);
                    ER er = new ER();
                    NativeAdLayout nativeAdLayout = new NativeAdLayout(c1116Yn, er);
                    er.A04(nativeAdLayout, c1116Yn, nativeAd, jr);
                    return nativeAdLayout;
                }

                public final View render(Context context, NativeAd nativeAd) {
                    return render(context, nativeAd, (NativeAdViewAttributes) null);
                }

                public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type) {
                    return render(context, nativeAd, type, null);
                }

                public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
                    try {
                        return A00(C03955c.A03(context), nativeAd, type, nativeAdViewAttributes);
                    } catch (Throwable th) {
                        C1116Yn A032 = C03955c.A03(context);
                        if (A00[1].length() == 17) {
                            Throwable t2 = new RuntimeException();
                            throw t2;
                        }
                        String[] strArr = A00;
                        strArr[0] = "2CJ6YuIajjVObDWBrmgwGQhi0qiA6kO3";
                        strArr[3] = "BzZMljeHsN6l5z4UR6G3olqVRWzg5ScF";
                        return MR.A00(A032, th);
                    }
                }

                public final View render(Context context, NativeAd nativeAd, NativeAdViewAttributes nativeAdViewAttributes) {
                    C1116Yn contextWrapper;
                    try {
                        if (context instanceof C1116Yn) {
                            contextWrapper = (C1116Yn) context;
                        } else {
                            contextWrapper = C03955c.A03(context);
                        }
                        return A01(contextWrapper, nativeAd, nativeAdViewAttributes);
                    } catch (Throwable th) {
                        return MR.A00(C03955c.A03(context), th);
                    }
                }
            };
        }
        return A02;
    }

    public NativeAdViewAttributesApi createNativeAdViewAttributesApi() {
        return new JR();
    }

    public NativeAdViewTypeApi createNativeAdViewTypeApi(final int i) {
        return new NativeAdViewTypeApi(i) { // from class: com.facebook.ads.redexgen.X.5l
            public final JS A00;

            {
                this.A00 = JS.A00(i);
            }

            public final int getHeight() {
                return this.A00.A03();
            }

            public final int getValue() {
                return this.A00.A04();
            }

            public final int getWidth() {
                return this.A00.A05();
            }
        };
    }

    public NativeAdsManagerApi createNativeAdsManagerApi(Context context, String str, int i) {
        return (NativeAdsManagerApi) C5M.A00(new C04055m(context, str, i), NativeAdsManagerApi.class);
    }

    public NativeBannerAdApi createNativeBannerAdApi(NativeBannerAd nativeBannerAd, NativeAdBaseApi nativeAdBaseApi) {
        return new NativeBannerAdApi(nativeAdBaseApi) { // from class: com.facebook.ads.redexgen.X.5q
            public static byte[] A01;
            public static String[] A02 = {"GHtEJsCBxF6ZG8G1CCL5RBmKmDCxDlHG", "8TFtHG5", "ovYsObbmHQ4MgJZYSDt7UbSE4I8Jd3xL", "OStrwIklzSQSoVp6y3SnTe0L", "CizBuXx6tKQSK5P8xVf5ORSYZ1", "CxGaKpsxgS6bhWDX5B71lG4aeRzyf4w9", "ZUquOnXGk9BCY4cqa0yz5KxW6oH5Pvvn", "wvrH4lpYI8UyLhNBrrW8XGK9bs66R2Pk"};
            public final V2 A00;

            public static String A00(int i, int i5, int i6) {
                byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i5);
                for (int i8 = 0; i8 < copyOfRange.length; i8++) {
                    copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ 40);
                }
                return new String(copyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{43, 47, 44, 24, 9, 4, 8, 3, 14, 8, 35, 8, 25, 26, 2, 31, 6};
                String[] strArr = A02;
                if (strArr[3].length() == strArr[4].length()) {
                    throw new RuntimeException();
                }
                A02[1] = "g9VMJ7KVDiHxjzY4mov6XPU8OVFxG";
            }

            static {
                A01();
            }

            {
                V2 A0L = V2.A0L(nativeAdBaseApi);
                this.A00 = A0L;
                A0L.A1Y(EnumC0726Jg.A04);
            }

            private void A02(ImageView imageView, NativeAdBaseApi nativeAdBaseApi2) {
                V2 A0L = V2.A0L(nativeAdBaseApi2);
                Z9 z9 = new Z9(this, imageView, A0L);
                JP adIcon = A0L.getAdIcon();
                if (adIcon != null) {
                    Bitmap preloadedBitmap = A0L.A10().A0M(adIcon.getUrl());
                    C1116Yn A032 = C03955c.A03(imageView.getContext());
                    if (preloadedBitmap != null) {
                        Drawable A052 = V2.A05(A032, preloadedBitmap, A0L.A1d(), A0L.A1C());
                        V2.A0e(A052, imageView);
                        imageView.post(new Z8(this, A0L, A052));
                        return;
                    }
                    new AsyncTaskC04065n(A032, z9, A0L.A1d(), null).execute(new C04085p(adIcon.getUrl(), A0L.A1C(), null));
                    return;
                }
                V1 A15 = A0L.A15();
                AdErrorType adErrorType = AdErrorType.NATIVE_AD_IS_NOT_LOADED;
                A0L.A11().A0E().A2m(-1L, adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
                if (A15 != null) {
                    A15.ABR(C0722Jb.A00(adErrorType));
                }
                Log.e(A00(0, 17, 69), adErrorType.getDefaultErrorMessage());
            }

            public final void registerViewForInteraction(View view, ImageView imageView) {
                registerViewForInteraction(view, imageView, (List<View>) null);
            }

            public final void registerViewForInteraction(View view, ImageView imageView, List<View> clickableViews) {
                if (imageView != null) {
                    A02(imageView, this.A00);
                }
                if (clickableViews != null) {
                    this.A00.A1M(view, imageView, clickableViews);
                } else {
                    this.A00.A1L(view, imageView);
                }
            }

            public final void registerViewForInteraction(View view, MediaView mediaView) {
                registerViewForInteraction(view, mediaView, (List<View>) null);
            }

            public final void registerViewForInteraction(View view, MediaView mediaView, List<View> list) {
                if (mediaView != null) {
                    ZH zh = (ZH) mediaView.getMediaViewApi();
                    V2 v2 = this.A00;
                    String[] strArr = A02;
                    if (strArr[3].length() == strArr[4].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[2] = "js1TYeoyNOBe6miaJaLofzAsC6CsUfwk";
                    strArr2[0] = "W1hafLFlhK2580scubVHArACmFSZlS1F";
                    zh.A0M(v2, true);
                }
                if (list != null) {
                    this.A00.A1O(view, mediaView, list);
                } else {
                    this.A00.A1N(view, mediaView);
                }
            }
        };
    }

    public NativeBannerAdViewApi createNativeBannerAdViewApi() {
        if (A03 == null) {
            A03 = new NativeBannerAdViewApi() { // from class: com.facebook.ads.redexgen.X.5r
                public static View A00(C1116Yn c1116Yn, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
                    if (nativeAdViewAttributes == null) {
                        nativeAdViewAttributes = new NativeAdViewAttributes();
                    }
                    V2.A0L(nativeBannerAd.getInternalNativeAd()).A1X(JS.A00(type.getEnumCode()));
                    EZ bannerTemplateLayoutApi = new EZ();
                    NativeAdLayout nativeAdLayout = new NativeAdLayout(c1116Yn, bannerTemplateLayoutApi);
                    bannerTemplateLayoutApi.A04(c1116Yn, nativeBannerAd, (JR) nativeAdViewAttributes.getInternalAttributes(), nativeAdLayout);
                    nativeAdLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (LD.A02 * type.getHeight())));
                    return nativeAdLayout;
                }

                public final View render(Context context, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type) {
                    return render(context, nativeBannerAd, type, null);
                }

                public final View render(Context context, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
                    try {
                        return A00(C03955c.A03(context), nativeBannerAd, type, nativeAdViewAttributes);
                    } catch (Throwable th) {
                        return MR.A00(C03955c.A03(context), th);
                    }
                }
            };
        }
        return A03;
    }

    public NativeComponentTagApi createNativeComponentTagApi() {
        return new NativeComponentTagApi() { // from class: com.facebook.ads.redexgen.X.5s
            public final void tagView(View view, NativeAdBase.NativeComponentTag nativeComponentTag) {
                if (view != null && nativeComponentTag != null) {
                    LI.A03(view, nativeComponentTag);
                }
            }
        };
    }

    public RewardedInterstitialAdApi createRewardedInterstitialAd(Context context, String str, RewardedInterstitialAd rewardedInterstitialAd) {
        return (RewardedInterstitialAdApi) C5M.A00(new C04125t(context, str, rewardedInterstitialAd), RewardedInterstitialAdApi.class);
    }

    public RewardedVideoAdApi createRewardedVideoAd(Context context, String str, RewardedVideoAd rewardedVideoAd) {
        return (RewardedVideoAdApi) C5M.A00(new C04165x(context, str, rewardedVideoAd), RewardedVideoAdApi.class);
    }

    public static C03945b getBidderTokenProviderApi() {
        if (A04 == null) {
            A04 = new C03945b();
        }
        C03945b c03945b = A04;
        if (A05[0].length() != 2) {
            A05[6] = "wbYWwuhs42I1eIPNPpozWjfLzFT5vnXv";
            return c03945b;
        }
        throw new RuntimeException();
    }

    public InitApi getInitApi() {
        return A06;
    }

    public void maybeInitInternally(Context context) {
        C8Y.A0A(C03955c.A09(context));
    }
}
