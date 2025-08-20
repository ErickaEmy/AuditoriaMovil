package io.ktor.client.engine;

import java.net.Proxy;
import java.net.SocketAddress;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ProxyConfigJvm.kt */
/* loaded from: classes.dex */
public abstract class ProxyConfigJvmKt {

    /* compiled from: ProxyConfigJvm.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.SOCKS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final SocketAddress resolveAddress(Proxy proxy) {
        Intrinsics.checkNotNullParameter(proxy, "<this>");
        SocketAddress address = proxy.address();
        Intrinsics.checkNotNullExpressionValue(address, "address()");
        return address;
    }

    public static final ProxyType getType(Proxy proxy) {
        Intrinsics.checkNotNullParameter(proxy, "<this>");
        Proxy.Type type = proxy.type();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return ProxyType.HTTP;
            }
            return ProxyType.UNKNOWN;
        }
        return ProxyType.SOCKS;
    }
}
