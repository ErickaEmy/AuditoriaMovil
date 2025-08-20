package com.hjq.permissions;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.hjq.permissions.AndroidManifestInfo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
final class AndroidManifestParser {
    private static AndroidManifestInfo.ActivityInfo parseActivityFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.ActivityInfo activityInfo = new AndroidManifestInfo.ActivityInfo();
        activityInfo.name = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        activityInfo.supportsPictureInPicture = xmlResourceParser.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "supportsPictureInPicture", false);
        return activityInfo;
    }

    @NonNull
    public static AndroidManifestInfo parseAndroidManifest(@NonNull Context context, int i) throws IOException, XmlPullParserException {
        AndroidManifestInfo androidManifestInfo = new AndroidManifestInfo();
        XmlResourceParser openXmlResourceParser = context.getAssets().openXmlResourceParser(i, "AndroidManifest.xml");
        do {
            if (openXmlResourceParser.getEventType() == 2) {
                String name = openXmlResourceParser.getName();
                if (TextUtils.equals("manifest", name)) {
                    androidManifestInfo.packageName = openXmlResourceParser.getAttributeValue(null, "package");
                }
                if (TextUtils.equals("uses-sdk", name)) {
                    androidManifestInfo.usesSdkInfo = parseUsesSdkFromXml(openXmlResourceParser);
                }
                if (TextUtils.equals("uses-permission", name) || TextUtils.equals("uses-permission-sdk-23", name) || TextUtils.equals("uses-permission-sdk-m", name)) {
                    androidManifestInfo.permissionInfoList.add(parsePermissionFromXml(openXmlResourceParser));
                }
                if (TextUtils.equals("application", name)) {
                    androidManifestInfo.applicationInfo = parseApplicationFromXml(openXmlResourceParser);
                }
                if (TextUtils.equals("activity", name) || TextUtils.equals("activity-alias", name)) {
                    androidManifestInfo.activityInfoList.add(parseActivityFromXml(openXmlResourceParser));
                }
                if (TextUtils.equals("service", name)) {
                    androidManifestInfo.serviceInfoList.add(parseServerFromXml(openXmlResourceParser));
                }
            }
        } while (openXmlResourceParser.next() != 1);
        openXmlResourceParser.close();
        return androidManifestInfo;
    }

    private static AndroidManifestInfo.ApplicationInfo parseApplicationFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.ApplicationInfo applicationInfo = new AndroidManifestInfo.ApplicationInfo();
        applicationInfo.name = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        applicationInfo.requestLegacyExternalStorage = xmlResourceParser.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "requestLegacyExternalStorage", false);
        return applicationInfo;
    }

    private static AndroidManifestInfo.PermissionInfo parsePermissionFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.PermissionInfo permissionInfo = new AndroidManifestInfo.PermissionInfo();
        permissionInfo.name = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        permissionInfo.maxSdkVersion = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxSdkVersion", Integer.MAX_VALUE);
        permissionInfo.usesPermissionFlags = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "usesPermissionFlags", 0);
        return permissionInfo;
    }

    private static AndroidManifestInfo.ServiceInfo parseServerFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.ServiceInfo serviceInfo = new AndroidManifestInfo.ServiceInfo();
        serviceInfo.name = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        serviceInfo.permission = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "permission");
        return serviceInfo;
    }

    private static AndroidManifestInfo.UsesSdkInfo parseUsesSdkFromXml(@NonNull XmlResourceParser xmlResourceParser) {
        AndroidManifestInfo.UsesSdkInfo usesSdkInfo = new AndroidManifestInfo.UsesSdkInfo();
        usesSdkInfo.minSdkVersion = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minSdkVersion", 0);
        return usesSdkInfo;
    }
}
