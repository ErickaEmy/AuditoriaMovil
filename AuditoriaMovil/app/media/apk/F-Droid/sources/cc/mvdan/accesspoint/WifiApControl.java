package cc.mvdan.accesspoint;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class WifiApControl {
    private static Method getWifiApConfigurationMethod;
    private static Method getWifiApStateMethod;
    private static WifiApControl instance;
    private static Method isWifiApEnabledMethod;
    private static Method setWifiApEnabledMethod;
    private final String deviceName;
    private final WifiManager wm;

    private WifiApControl(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        this.wm = wifiManager;
        this.deviceName = getDeviceName(wifiManager);
    }

    public static WifiApControl getInstance(Context context) {
        Method[] declaredMethods;
        char c;
        if (instance == null) {
            if (!Settings.System.canWrite(context)) {
                Log.e("WifiApControl", "6.0 or later, but haven't been granted WRITE_SETTINGS!");
                return null;
            }
            try {
                for (Method method : WifiManager.class.getDeclaredMethods()) {
                    String name = method.getName();
                    switch (name.hashCode()) {
                        case -144339141:
                            if (name.equals("setWifiApEnabled")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 591399831:
                            if (name.equals("getWifiApState")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 678347635:
                            if (name.equals("isWifiApEnabled")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2135709180:
                            if (name.equals("getWifiApConfiguration")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c == 0) {
                        getWifiApConfigurationMethod = method;
                    } else if (c == 1) {
                        getWifiApStateMethod = method;
                    } else if (c == 2) {
                        isWifiApEnabledMethod = method;
                    } else if (c == 3) {
                        setWifiApEnabledMethod = method;
                    }
                }
                WifiApControl wifiApControl = new WifiApControl(context);
                instance = wifiApControl;
                wifiApControl.isEnabled();
            } catch (Throwable th) {
                Log.e("WifiApControl", "WifiManager failed to init", th);
                return null;
            }
        }
        return instance;
    }

    private static String getDeviceName(WifiManager wifiManager) {
        Log.w("WifiApControl", "6.0 or later, unaccessible MAC - falling back to the default device name: wlan0");
        return "wlan0";
    }

    private static Object invokeQuietly(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Log.e("WifiApControl", "", e);
            return null;
        }
    }

    public boolean isWifiApEnabled() {
        Object invokeQuietly = invokeQuietly(isWifiApEnabledMethod, this.wm, new Object[0]);
        if (invokeQuietly == null) {
            return false;
        }
        return ((Boolean) invokeQuietly).booleanValue();
    }

    public boolean isEnabled() {
        return isWifiApEnabled();
    }

    public WifiConfiguration getWifiApConfiguration() {
        Object invokeQuietly = invokeQuietly(getWifiApConfigurationMethod, this.wm, new Object[0]);
        if (invokeQuietly == null) {
            return null;
        }
        return (WifiConfiguration) invokeQuietly;
    }

    public WifiConfiguration getConfiguration() {
        return getWifiApConfiguration();
    }

    public boolean setWifiApEnabled(WifiConfiguration wifiConfiguration, boolean z) {
        Object invokeQuietly = invokeQuietly(setWifiApEnabledMethod, this.wm, wifiConfiguration, Boolean.valueOf(z));
        if (invokeQuietly == null) {
            return false;
        }
        return ((Boolean) invokeQuietly).booleanValue();
    }

    public boolean setEnabled(WifiConfiguration wifiConfiguration, boolean z) {
        return setWifiApEnabled(wifiConfiguration, z);
    }

    public boolean enable() {
        return setEnabled(getConfiguration(), true);
    }

    public boolean disable() {
        return setEnabled(null, false);
    }
}
