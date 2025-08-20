package io.ktor.http;

import ch.qos.logback.core.joran.action.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: URLBuilder.kt */
/* loaded from: classes.dex */
public final class URLBuilder {
    public static final Companion Companion;
    private static final Url originUrl;
    private String encodedFragment;
    private ParametersBuilder encodedParameters;
    private String encodedPassword;
    private List encodedPathSegments;
    private String encodedUser;
    private String host;
    private ParametersBuilder parameters;
    private int port;
    private URLProtocol protocol;
    private boolean trailingQuery;

    /* compiled from: URLBuilder.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getEncodedFragment() {
        return this.encodedFragment;
    }

    public final ParametersBuilder getEncodedParameters() {
        return this.encodedParameters;
    }

    public final String getEncodedPassword() {
        return this.encodedPassword;
    }

    public final List getEncodedPathSegments() {
        return this.encodedPathSegments;
    }

    public final String getEncodedUser() {
        return this.encodedUser;
    }

    public final String getHost() {
        return this.host;
    }

    public final ParametersBuilder getParameters() {
        return this.parameters;
    }

    public final int getPort() {
        return this.port;
    }

    public final URLProtocol getProtocol() {
        return this.protocol;
    }

    public final boolean getTrailingQuery() {
        return this.trailingQuery;
    }

    public final void setEncodedFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encodedFragment = str;
    }

    public final void setEncodedPassword(String str) {
        this.encodedPassword = str;
    }

    public final void setEncodedPathSegments(List list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.encodedPathSegments = list;
    }

    public final void setEncodedUser(String str) {
        this.encodedUser = str;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.host = str;
    }

    public final void setPort(int i) {
        this.port = i;
    }

    public final void setProtocol(URLProtocol uRLProtocol) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "<set-?>");
        this.protocol = uRLProtocol;
    }

    public final void setTrailingQuery(boolean z) {
        this.trailingQuery = z;
    }

    public URLBuilder(URLProtocol protocol, String host, int i, String str, String str2, List pathSegments, Parameters parameters, String fragment, boolean z) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.protocol = protocol;
        this.host = host;
        this.port = i;
        this.trailingQuery = z;
        this.encodedUser = str != null ? CodecsKt.encodeURLParameter$default(str, false, 1, null) : null;
        this.encodedPassword = str2 != null ? CodecsKt.encodeURLParameter$default(str2, false, 1, null) : null;
        this.encodedFragment = CodecsKt.encodeURLQueryComponent$default(fragment, false, false, null, 7, null);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(pathSegments, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = pathSegments.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.encodeURLPathPart((String) it.next()));
        }
        this.encodedPathSegments = arrayList;
        ParametersBuilder encodeParameters = UrlDecodedParametersBuilderKt.encodeParameters(parameters);
        this.encodedParameters = encodeParameters;
        this.parameters = new UrlDecodedParametersBuilder(encodeParameters);
    }

    public /* synthetic */ URLBuilder(URLProtocol uRLProtocol, String str, int i, String str2, String str3, List list, Parameters parameters, String str4, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? URLProtocol.Companion.getHTTP() : uRLProtocol, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : str2, (i2 & 16) == 0 ? str3 : null, (i2 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i2 & 64) != 0 ? Parameters.Companion.getEmpty() : parameters, (i2 & 128) == 0 ? str4 : "", (i2 & 256) == 0 ? z : false);
    }

    public final String getUser() {
        String str = this.encodedUser;
        if (str != null) {
            return CodecsKt.decodeURLPart$default(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final void setUser(String str) {
        this.encodedUser = str != null ? CodecsKt.encodeURLParameter$default(str, false, 1, null) : null;
    }

    public final String getPassword() {
        String str = this.encodedPassword;
        if (str != null) {
            return CodecsKt.decodeURLPart$default(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final String getFragment() {
        return CodecsKt.decodeURLQueryComponent$default(this.encodedFragment, 0, 0, false, null, 15, null);
    }

    public final void setEncodedParameters(ParametersBuilder value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.encodedParameters = value;
        this.parameters = new UrlDecodedParametersBuilder(value);
    }

    public final String buildString() {
        Appendable appendTo;
        applyOrigin();
        appendTo = URLBuilderKt.appendTo(this, new StringBuilder(256));
        String sb = ((StringBuilder) appendTo).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "appendTo(StringBuilder(256)).toString()");
        return sb;
    }

    public String toString() {
        Appendable appendTo;
        appendTo = URLBuilderKt.appendTo(this, new StringBuilder(256));
        String sb = ((StringBuilder) appendTo).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "appendTo(StringBuilder(256)).toString()");
        return sb;
    }

    public final Url build() {
        applyOrigin();
        return new Url(this.protocol, this.host, this.port, getPathSegments(), this.parameters.build(), getFragment(), getUser(), getPassword(), this.trailingQuery, buildString());
    }

    private final void applyOrigin() {
        if (this.host.length() <= 0 && !Intrinsics.areEqual(this.protocol.getName(), Action.FILE_ATTRIBUTE)) {
            Url url = originUrl;
            this.host = url.getHost();
            if (Intrinsics.areEqual(this.protocol, URLProtocol.Companion.getHTTP())) {
                this.protocol = url.getProtocol();
            }
            if (this.port == 0) {
                this.port = url.getSpecifiedPort();
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        originUrl = URLUtilsKt.Url(URLBuilderJvmKt.getOrigin(companion));
    }

    public final List getPathSegments() {
        int collectionSizeOrDefault;
        List<String> list = this.encodedPathSegments;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : list) {
            arrayList.add(CodecsKt.decodeURLPart$default(str, 0, 0, null, 7, null));
        }
        return arrayList;
    }
}
