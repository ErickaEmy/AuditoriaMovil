package com.google.firebase.remoteconfig.internal;
/* loaded from: classes.dex */
public class DefaultsXmlParser {
    /* JADX WARN: Removed duplicated region for block: B:43:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088 A[Catch: IOException -> 0x0013, XmlPullParserException -> 0x0016, TryCatch #2 {IOException -> 0x0013, XmlPullParserException -> 0x0016, blocks: (B:3:0x0007, B:5:0x000d, B:11:0x0019, B:16:0x002b, B:47:0x008c, B:19:0x0033, B:23:0x0043, B:24:0x0047, B:30:0x0055, B:44:0x007d, B:45:0x0083, B:46:0x0088, B:35:0x0064, B:38:0x006e), top: B:51:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> getDefaultsFromXml(android.content.Context r8, int r9) {
        /*
            java.lang.String r0 = "FirebaseRemoteConfig"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.content.res.Resources r8 = r8.getResources()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r8 != 0) goto L19
            java.lang.String r8 = "Could not find the resources of the current context while trying to set defaults from an XML."
            android.util.Log.e(r0, r8)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            return r1
        L13:
            r8 = move-exception
            goto L91
        L16:
            r8 = move-exception
            goto L91
        L19:
            android.content.res.XmlResourceParser r8 = r8.getXml(r9)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            int r9 = r8.getEventType()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
        L25:
            r6 = 1
            if (r9 == r6) goto L96
            r7 = 2
            if (r9 != r7) goto L30
            java.lang.String r3 = r8.getName()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L8c
        L30:
            r7 = 3
            if (r9 != r7) goto L50
            java.lang.String r9 = r8.getName()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            java.lang.String r3 = "entry"
            boolean r9 = r9.equals(r3)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r9 == 0) goto L4e
            if (r4 == 0) goto L47
            if (r5 == 0) goto L47
            r1.put(r4, r5)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L4c
        L47:
            java.lang.String r9 = "An entry in the defaults XML has an invalid key and/or value tag."
            android.util.Log.w(r0, r9)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
        L4c:
            r4 = r2
            r5 = r4
        L4e:
            r3 = r2
            goto L8c
        L50:
            r7 = 4
            if (r9 != r7) goto L8c
            if (r3 == 0) goto L8c
            int r9 = r3.hashCode()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            r7 = 106079(0x19e5f, float:1.48648E-40)
            if (r9 == r7) goto L6e
            r7 = 111972721(0x6ac9171, float:6.4912916E-35)
            if (r9 == r7) goto L64
            goto L78
        L64:
            java.lang.String r9 = "value"
            boolean r9 = r3.equals(r9)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r9 == 0) goto L78
            r9 = 1
            goto L79
        L6e:
            java.lang.String r9 = "key"
            boolean r9 = r3.equals(r9)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            if (r9 == 0) goto L78
            r9 = 0
            goto L79
        L78:
            r9 = -1
        L79:
            if (r9 == 0) goto L88
            if (r9 == r6) goto L83
            java.lang.String r9 = "Encountered an unexpected tag while parsing the defaults XML."
            android.util.Log.w(r0, r9)     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L8c
        L83:
            java.lang.String r5 = r8.getText()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L8c
        L88:
            java.lang.String r4 = r8.getText()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
        L8c:
            int r9 = r8.next()     // Catch: java.io.IOException -> L13 org.xmlpull.v1.XmlPullParserException -> L16
            goto L25
        L91:
            java.lang.String r9 = "Encountered an error while parsing the defaults XML file."
            android.util.Log.e(r0, r9, r8)
        L96:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.DefaultsXmlParser.getDefaultsFromXml(android.content.Context, int):java.util.Map");
    }
}
