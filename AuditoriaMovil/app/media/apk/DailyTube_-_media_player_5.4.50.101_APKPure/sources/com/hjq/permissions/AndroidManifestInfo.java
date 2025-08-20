package com.hjq.permissions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
final class AndroidManifestInfo {
    ApplicationInfo applicationInfo;
    String packageName;
    @Nullable
    UsesSdkInfo usesSdkInfo;
    @NonNull
    final List<PermissionInfo> permissionInfoList = new ArrayList();
    @NonNull
    final List<ActivityInfo> activityInfoList = new ArrayList();
    @NonNull
    final List<ServiceInfo> serviceInfoList = new ArrayList();

    /* loaded from: classes.dex */
    public static final class ActivityInfo {
        public String name;
        public boolean supportsPictureInPicture;
    }

    /* loaded from: classes.dex */
    public static final class ApplicationInfo {
        public String name;
        public boolean requestLegacyExternalStorage;
    }

    /* loaded from: classes.dex */
    public static final class PermissionInfo {
        public int maxSdkVersion;
        public String name;
        public int usesPermissionFlags;

        public boolean neverForLocation() {
            if ((this.usesPermissionFlags & 65536) != 0) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static final class ServiceInfo {
        public String name;
        public String permission;
    }

    /* loaded from: classes.dex */
    public static final class UsesSdkInfo {
        public int minSdkVersion;
    }
}
