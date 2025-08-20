package org.chromium.net;
/* loaded from: classes.dex */
public class ApiVersion {
    private ApiVersion() {
    }

    public static int getApiLevel() {
        return 3;
    }

    public static String getCronetVersion() {
        return "72.0.3626.96";
    }

    public static String getCronetVersionWithLastChange() {
        return "72.0.3626.96@84098ee7";
    }

    public static String getLastChange() {
        return "84098ee7ef8622a9defc2ef043cd8930b617b10e-refs/branch-heads/3626@{#836}";
    }

    public static int getMaximumAvailableApiLevel() {
        return 12;
    }
}
