package io.ktor.http;

import io.ktor.http.HeaderValueWithParameters;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.bouncycastle.i18n.TextBundle;
/* compiled from: ContentTypes.kt */
/* loaded from: classes.dex */
public final class ContentType extends HeaderValueWithParameters {
    private final String contentSubtype;
    private final String contentType;
    public static final Companion Companion = new Companion(null);
    private static final ContentType Any = new ContentType("*", "*", null, 4, null);

    /* compiled from: ContentTypes.kt */
    /* loaded from: classes.dex */
    public static final class Application {
        public static final Application INSTANCE = new Application();
        private static final ContentType Any = new ContentType("application", "*", null, 4, null);
        private static final ContentType Atom = new ContentType("application", "atom+xml", null, 4, null);
        private static final ContentType Cbor = new ContentType("application", "cbor", null, 4, null);
        private static final ContentType Json = new ContentType("application", "json", null, 4, null);
        private static final ContentType HalJson = new ContentType("application", "hal+json", null, 4, null);
        private static final ContentType JavaScript = new ContentType("application", "javascript", null, 4, null);
        private static final ContentType OctetStream = new ContentType("application", "octet-stream", null, 4, null);
        private static final ContentType Rss = new ContentType("application", "rss+xml", null, 4, null);
        private static final ContentType Xml = new ContentType("application", "xml", null, 4, null);
        private static final ContentType Xml_Dtd = new ContentType("application", "xml-dtd", null, 4, null);
        private static final ContentType Zip = new ContentType("application", "zip", null, 4, null);
        private static final ContentType GZip = new ContentType("application", "gzip", null, 4, null);
        private static final ContentType FormUrlEncoded = new ContentType("application", "x-www-form-urlencoded", null, 4, null);
        private static final ContentType Pdf = new ContentType("application", "pdf", null, 4, null);
        private static final ContentType Xlsx = new ContentType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet", null, 4, null);
        private static final ContentType Docx = new ContentType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document", null, 4, null);
        private static final ContentType Pptx = new ContentType("application", "vnd.openxmlformats-officedocument.presentationml.presentation", null, 4, null);
        private static final ContentType ProtoBuf = new ContentType("application", "protobuf", null, 4, null);
        private static final ContentType Wasm = new ContentType("application", "wasm", null, 4, null);
        private static final ContentType ProblemJson = new ContentType("application", "problem+json", null, 4, null);
        private static final ContentType ProblemXml = new ContentType("application", "problem+xml", null, 4, null);

        private Application() {
        }

        public final ContentType getOctetStream() {
            return OctetStream;
        }
    }

    /* compiled from: ContentTypes.kt */
    /* loaded from: classes.dex */
    public static final class Text {
        public static final Text INSTANCE = new Text();
        private static final ContentType Any = new ContentType(TextBundle.TEXT_ENTRY, "*", null, 4, null);
        private static final ContentType Plain = new ContentType(TextBundle.TEXT_ENTRY, "plain", null, 4, null);
        private static final ContentType CSS = new ContentType(TextBundle.TEXT_ENTRY, "css", null, 4, null);
        private static final ContentType CSV = new ContentType(TextBundle.TEXT_ENTRY, "csv", null, 4, null);
        private static final ContentType Html = new ContentType(TextBundle.TEXT_ENTRY, "html", null, 4, null);
        private static final ContentType JavaScript = new ContentType(TextBundle.TEXT_ENTRY, "javascript", null, 4, null);
        private static final ContentType VCard = new ContentType(TextBundle.TEXT_ENTRY, "vcard", null, 4, null);
        private static final ContentType Xml = new ContentType(TextBundle.TEXT_ENTRY, "xml", null, 4, null);
        private static final ContentType EventStream = new ContentType(TextBundle.TEXT_ENTRY, "event-stream", null, 4, null);

        private Text() {
        }

        public final ContentType getPlain() {
            return Plain;
        }
    }

    public final String getContentType() {
        return this.contentType;
    }

    private ContentType(String str, String str2, String str3, List list) {
        super(str3, list);
        this.contentType = str;
        this.contentSubtype = str2;
    }

    public /* synthetic */ ContentType(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentType(String contentType, String contentSubtype, List parameters) {
        this(contentType, contentSubtype, contentType + '/' + contentSubtype, parameters);
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentSubtype, "contentSubtype");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }

    public final ContentType withParameter(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return hasParameter(name, value) ? this : new ContentType(this.contentType, this.contentSubtype, getContent(), CollectionsKt.plus((Collection) getParameters(), (Object) new HeaderValueParam(name, value)));
    }

    private final boolean hasParameter(String str, String str2) {
        boolean equals;
        boolean equals2;
        boolean equals3;
        boolean equals4;
        int size = getParameters().size();
        if (size != 0) {
            if (size == 1) {
                HeaderValueParam headerValueParam = (HeaderValueParam) getParameters().get(0);
                equals = StringsKt__StringsJVMKt.equals(headerValueParam.getName(), str, true);
                if (!equals) {
                    return false;
                }
                equals2 = StringsKt__StringsJVMKt.equals(headerValueParam.getValue(), str2, true);
                if (!equals2) {
                    return false;
                }
            } else {
                List<HeaderValueParam> parameters = getParameters();
                if ((parameters instanceof Collection) && parameters.isEmpty()) {
                    return false;
                }
                for (HeaderValueParam headerValueParam2 : parameters) {
                    equals3 = StringsKt__StringsJVMKt.equals(headerValueParam2.getName(), str, true);
                    if (equals3) {
                        equals4 = StringsKt__StringsJVMKt.equals(headerValueParam2.getValue(), str2, true);
                        if (equals4) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        boolean equals;
        boolean equals2;
        if (obj instanceof ContentType) {
            ContentType contentType = (ContentType) obj;
            equals = StringsKt__StringsJVMKt.equals(this.contentType, contentType.contentType, true);
            if (equals) {
                equals2 = StringsKt__StringsJVMKt.equals(this.contentSubtype, contentType.contentSubtype, true);
                if (equals2 && Intrinsics.areEqual(getParameters(), contentType.getParameters())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.contentType;
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int hashCode = lowerCase.hashCode();
        String lowerCase2 = this.contentSubtype.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return hashCode + (hashCode * 31) + lowerCase2.hashCode() + (getParameters().hashCode() * 31);
    }

    /* compiled from: ContentTypes.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ContentType parse(String value) {
            boolean isBlank;
            int indexOf$default;
            CharSequence trim;
            CharSequence trim2;
            boolean contains$default;
            boolean contains$default2;
            boolean contains$default3;
            CharSequence trim3;
            Intrinsics.checkNotNullParameter(value, "value");
            isBlank = StringsKt__StringsJVMKt.isBlank(value);
            if (isBlank) {
                return getAny();
            }
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.Companion;
            HeaderValue headerValue = (HeaderValue) CollectionsKt.last(HttpHeaderValueParserKt.parseHeaderValue(value));
            String value2 = headerValue.getValue();
            List params = headerValue.getParams();
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) value2, '/', 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                trim3 = StringsKt__StringsKt.trim(value2);
                if (Intrinsics.areEqual(trim3.toString(), "*")) {
                    return ContentType.Companion.getAny();
                }
                throw new BadContentTypeFormatException(value);
            }
            String substring = value2.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            trim = StringsKt__StringsKt.trim(substring);
            String obj = trim.toString();
            if (obj.length() == 0) {
                throw new BadContentTypeFormatException(value);
            }
            String substring2 = value2.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            trim2 = StringsKt__StringsKt.trim(substring2);
            String obj2 = trim2.toString();
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) obj, ' ', false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) obj2, ' ', false, 2, (Object) null);
                if (!contains$default2) {
                    if (obj2.length() != 0) {
                        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) obj2, '/', false, 2, (Object) null);
                        if (!contains$default3) {
                            return new ContentType(obj, obj2, params);
                        }
                    }
                    throw new BadContentTypeFormatException(value);
                }
            }
            throw new BadContentTypeFormatException(value);
        }

        public final ContentType getAny() {
            return ContentType.Any;
        }
    }
}
