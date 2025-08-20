package io.ktor.util;
/* compiled from: PlatformUtils.kt */
/* loaded from: classes.dex */
public final class PlatformUtils {
    public static final PlatformUtils INSTANCE;
    private static final boolean IS_BROWSER;
    private static final boolean IS_DEVELOPMENT_MODE;
    private static final boolean IS_JVM;
    private static final boolean IS_NATIVE;
    private static final boolean IS_NEW_MM_ENABLED;
    private static final boolean IS_NODE;

    private PlatformUtils() {
    }

    public final boolean getIS_BROWSER() {
        return IS_BROWSER;
    }

    public final boolean getIS_DEVELOPMENT_MODE() {
        return IS_DEVELOPMENT_MODE;
    }

    static {
        PlatformUtils platformUtils = new PlatformUtils();
        INSTANCE = platformUtils;
        IS_BROWSER = PlatformUtilsJvmKt.getPlatform(platformUtils) == Platform.Browser;
        IS_NODE = PlatformUtilsJvmKt.getPlatform(platformUtils) == Platform.Node;
        IS_JVM = PlatformUtilsJvmKt.getPlatform(platformUtils) == Platform.Jvm;
        IS_NATIVE = PlatformUtilsJvmKt.getPlatform(platformUtils) == Platform.Native;
        IS_DEVELOPMENT_MODE = PlatformUtilsJvmKt.isDevelopmentMode(platformUtils);
        IS_NEW_MM_ENABLED = PlatformUtilsJvmKt.isNewMemoryModel(platformUtils);
    }
}
