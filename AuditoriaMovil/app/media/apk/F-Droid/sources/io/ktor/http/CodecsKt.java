package io.ktor.http;

import ch.qos.logback.core.CoreConstants;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
/* compiled from: Codecs.kt */
/* loaded from: classes.dex */
public abstract class CodecsKt {
    private static final Set ATTRIBUTE_CHARACTERS;
    private static final Set HEX_ALPHABET;
    private static final List SPECIAL_SYMBOLS;
    private static final Set URL_ALPHABET;
    private static final Set URL_ALPHABET_CHARS;
    private static final List URL_PROTOCOL_PART;
    private static final Set VALID_PATH_PART;

    private static final int charToHexDigit(char c) {
        if ('0' > c || c >= ':') {
            if ('A' > c || c >= 'G') {
                if ('a' > c || c >= 'g') {
                    return -1;
                }
                return c - 'W';
            }
            return c - '7';
        }
        return c - '0';
    }

    private static final char hexDigitToChar(int i) {
        return (char) ((i < 0 || i >= 10) ? ((char) (i + 65)) - '\n' : i + 48);
    }

    static {
        List plus;
        List<Character> plus2;
        int collectionSizeOrDefault;
        Set set;
        List plus3;
        List plus4;
        Set set2;
        List plus5;
        List plus6;
        Set set3;
        Set of;
        int collectionSizeOrDefault2;
        Set of2;
        Set of3;
        Set plus7;
        List<Character> listOf;
        int collectionSizeOrDefault3;
        plus = CollectionsKt___CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', Matrix.MATRIX_TYPE_ZERO));
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) plus, (Iterable) new CharRange('0', '9'));
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(plus2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Character ch2 : plus2) {
            arrayList.add(Byte.valueOf((byte) ch2.charValue()));
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        URL_ALPHABET = set;
        plus3 = CollectionsKt___CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', Matrix.MATRIX_TYPE_ZERO));
        plus4 = CollectionsKt___CollectionsKt.plus((Collection) plus3, (Iterable) new CharRange('0', '9'));
        set2 = CollectionsKt___CollectionsKt.toSet(plus4);
        URL_ALPHABET_CHARS = set2;
        plus5 = CollectionsKt___CollectionsKt.plus((Iterable) new CharRange('a', 'f'), (Iterable) new CharRange('A', 'F'));
        plus6 = CollectionsKt___CollectionsKt.plus((Collection) plus5, (Iterable) new CharRange('0', '9'));
        set3 = CollectionsKt___CollectionsKt.toSet(plus6);
        HEX_ALPHABET = set3;
        of = SetsKt__SetsKt.setOf((Object[]) new Character[]{Character.valueOf(CoreConstants.COLON_CHAR), '/', '?', '#', '[', ']', '@', '!', Character.valueOf(CoreConstants.DOLLAR), '&', Character.valueOf(CoreConstants.SINGLE_QUOTE_CHAR), Character.valueOf(CoreConstants.LEFT_PARENTHESIS_CHAR), Character.valueOf(CoreConstants.RIGHT_PARENTHESIS_CHAR), '*', Character.valueOf(CoreConstants.COMMA_CHAR), ';', '=', Character.valueOf(CoreConstants.DASH_CHAR), Character.valueOf(CoreConstants.DOT), '_', '~', '+'});
        Set<Character> set4 = of;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(set4, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (Character ch3 : set4) {
            arrayList2.add(Byte.valueOf((byte) ch3.charValue()));
        }
        URL_PROTOCOL_PART = arrayList2;
        of2 = SetsKt__SetsKt.setOf((Object[]) new Character[]{Character.valueOf(CoreConstants.COLON_CHAR), '@', '!', Character.valueOf(CoreConstants.DOLLAR), '&', Character.valueOf(CoreConstants.SINGLE_QUOTE_CHAR), Character.valueOf(CoreConstants.LEFT_PARENTHESIS_CHAR), Character.valueOf(CoreConstants.RIGHT_PARENTHESIS_CHAR), '*', '+', Character.valueOf(CoreConstants.COMMA_CHAR), ';', '=', Character.valueOf(CoreConstants.DASH_CHAR), Character.valueOf(CoreConstants.DOT), '_', '~'});
        VALID_PATH_PART = of2;
        Set set5 = URL_ALPHABET_CHARS;
        of3 = SetsKt__SetsKt.setOf((Object[]) new Character[]{'!', '#', Character.valueOf(CoreConstants.DOLLAR), '&', '+', Character.valueOf(CoreConstants.DASH_CHAR), Character.valueOf(CoreConstants.DOT), '^', '_', '`', '|', '~'});
        plus7 = SetsKt___SetsKt.plus(set5, (Iterable) of3);
        ATTRIBUTE_CHARACTERS = plus7;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{Character.valueOf(CoreConstants.DASH_CHAR), Character.valueOf(CoreConstants.DOT), '_', '~'});
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(listOf, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
        for (Character ch4 : listOf) {
            arrayList3.add(Byte.valueOf((byte) ch4.charValue()));
        }
        SPECIAL_SYMBOLS = arrayList3;
    }

    public static /* synthetic */ String encodeURLQueryComponent$default(String str, boolean z, boolean z2, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return encodeURLQueryComponent(str, z, z2, charset);
    }

    public static final String encodeURLQueryComponent(String str, final boolean z, final boolean z2, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final StringBuilder sb = new StringBuilder();
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        forEach(EncodingKt.encode$default(newEncoder, str, 0, 0, 6, null), new Function1() { // from class: io.ktor.http.CodecsKt$encodeURLQueryComponent$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).byteValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
                if (r0.contains(java.lang.Byte.valueOf(r3)) != false) goto L18;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(byte r3) {
                /*
                    r2 = this;
                    r0 = 32
                    if (r3 != r0) goto L18
                    boolean r3 = r1
                    if (r3 == 0) goto L10
                    java.lang.StringBuilder r3 = r2
                    r0 = 43
                    r3.append(r0)
                    goto L49
                L10:
                    java.lang.StringBuilder r3 = r2
                    java.lang.String r0 = "%20"
                    r3.append(r0)
                    goto L49
                L18:
                    java.util.Set r0 = io.ktor.http.CodecsKt.access$getURL_ALPHABET$p()
                    java.lang.Byte r1 = java.lang.Byte.valueOf(r3)
                    boolean r0 = r0.contains(r1)
                    if (r0 != 0) goto L43
                    boolean r0 = r3
                    if (r0 != 0) goto L39
                    java.util.List r0 = io.ktor.http.CodecsKt.access$getURL_PROTOCOL_PART$p()
                    java.lang.Byte r1 = java.lang.Byte.valueOf(r3)
                    boolean r0 = r0.contains(r1)
                    if (r0 == 0) goto L39
                    goto L43
                L39:
                    java.lang.StringBuilder r0 = r2
                    java.lang.String r3 = io.ktor.http.CodecsKt.access$percentEncode(r3)
                    r0.append(r3)
                    goto L49
                L43:
                    java.lang.StringBuilder r0 = r2
                    char r3 = (char) r3
                    r0.append(r3)
                L49:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CodecsKt$encodeURLQueryComponent$1$1.invoke(byte):void");
            }
        });
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String encodeURLPathPart(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return encodeURLPath(str, true);
    }

    public static final String encodeURLPath(String str, boolean z) {
        boolean isSurrogate;
        int i;
        Intrinsics.checkNotNullParameter(str, "<this>");
        final StringBuilder sb = new StringBuilder();
        Charset charset = Charsets.UTF_8;
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if ((!z && charAt == '/') || URL_ALPHABET_CHARS.contains(Character.valueOf(charAt)) || VALID_PATH_PART.contains(Character.valueOf(charAt))) {
                sb.append(charAt);
                i2++;
            } else {
                if (charAt == '%' && (i = i2 + 2) < str.length()) {
                    Set set = HEX_ALPHABET;
                    int i3 = i2 + 1;
                    if (set.contains(Character.valueOf(str.charAt(i3))) && set.contains(Character.valueOf(str.charAt(i)))) {
                        sb.append(charAt);
                        sb.append(str.charAt(i3));
                        sb.append(str.charAt(i));
                        i2 += 3;
                    }
                }
                isSurrogate = CharsKt__CharKt.isSurrogate(charAt);
                int i4 = isSurrogate ? 2 : 1;
                CharsetEncoder newEncoder = charset.newEncoder();
                Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
                int i5 = i4 + i2;
                forEach(EncodingKt.encode(newEncoder, str, i2, i5), new Function1() { // from class: io.ktor.http.CodecsKt$encodeURLPath$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).byteValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(byte b) {
                        String percentEncode;
                        StringBuilder sb2 = sb;
                        percentEncode = CodecsKt.percentEncode(b);
                        sb2.append(percentEncode);
                    }
                });
                i2 = i5;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String encodeURLParameter$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return encodeURLParameter(str, z);
    }

    public static final String encodeURLParameter(String str, final boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        final StringBuilder sb = new StringBuilder();
        CharsetEncoder newEncoder = Charsets.UTF_8.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "UTF_8.newEncoder()");
        forEach(EncodingKt.encode$default(newEncoder, str, 0, 0, 6, null), new Function1() { // from class: io.ktor.http.CodecsKt$encodeURLParameter$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).byteValue());
                return Unit.INSTANCE;
            }

            public final void invoke(byte b) {
                Set set;
                List list;
                String percentEncode;
                set = CodecsKt.URL_ALPHABET;
                if (!set.contains(Byte.valueOf(b))) {
                    list = CodecsKt.SPECIAL_SYMBOLS;
                    if (!list.contains(Byte.valueOf(b))) {
                        if (!z || b != 32) {
                            StringBuilder sb2 = sb;
                            percentEncode = CodecsKt.percentEncode(b);
                            sb2.append(percentEncode);
                            return;
                        }
                        sb.append('+');
                        return;
                    }
                }
                sb.append((char) b);
            }
        });
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String encodeURLParameterValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return encodeURLParameter(str, true);
    }

    public static /* synthetic */ String decodeURLQueryComponent$default(String str, int i, int i2, boolean z, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeURLQueryComponent(str, i, i2, z, charset);
    }

    public static final String decodeURLQueryComponent(String str, int i, int i2, boolean z, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return decodeScan(str, i, i2, z, charset);
    }

    public static /* synthetic */ String decodeURLPart$default(String str, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return decodeURLPart(str, i, i2, charset);
    }

    public static final String decodeURLPart(String str, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return decodeScan(str, i, i2, false, charset);
    }

    private static final String decodeScan(String str, int i, int i2, boolean z, Charset charset) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (z && charAt == '+')) {
                return decodeImpl(str, i, i2, i3, z, charset);
            }
        }
        if (i == 0 && i2 == str.length()) {
            return str;
        }
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    private static final String decodeImpl(CharSequence charSequence, int i, int i2, int i3, boolean z, Charset charset) {
        int i4;
        int i5 = i2 - i;
        if (i5 > 255) {
            i5 /= 3;
        }
        StringBuilder sb = new StringBuilder(i5);
        if (i3 > i) {
            sb.append(charSequence, i, i3);
        }
        byte[] bArr = null;
        while (i3 < i2) {
            char charAt = charSequence.charAt(i3);
            if (z && charAt == '+') {
                sb.append(' ');
            } else if (charAt == '%') {
                if (bArr == null) {
                    bArr = new byte[(i2 - i3) / 3];
                }
                int i6 = 0;
                while (i3 < i2 && charSequence.charAt(i3) == '%') {
                    int i7 = i3 + 2;
                    if (i7 >= i2) {
                        throw new URLDecodeException("Incomplete trailing HEX escape: " + charSequence.subSequence(i3, charSequence.length()).toString() + ", in " + ((Object) charSequence) + " at " + i3);
                    }
                    int charToHexDigit = charToHexDigit(charSequence.charAt(i3 + 1));
                    int charToHexDigit2 = charToHexDigit(charSequence.charAt(i7));
                    if (charToHexDigit == -1 || charToHexDigit2 == -1) {
                        throw new URLDecodeException("Wrong HEX escape: %" + charSequence.charAt(i4) + charSequence.charAt(i7) + ", in " + ((Object) charSequence) + ", at " + i3);
                    }
                    bArr[i6] = (byte) ((charToHexDigit * 16) + charToHexDigit2);
                    i3 += 3;
                    i6++;
                }
                sb.append(new String(bArr, 0, i6, charset));
            } else {
                sb.append(charAt);
            }
            i3++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String percentEncode(byte b) {
        String concatToString;
        concatToString = StringsKt__StringsJVMKt.concatToString(new char[]{CoreConstants.PERCENT_CHAR, hexDigitToChar((b & 255) >> 4), hexDigitToChar(b & 15)});
        return concatToString;
    }

    private static final void forEach(ByteReadPacket byteReadPacket, Function1 function1) {
        boolean z = true;
        ChunkBuffer prepareReadFirstHead = UnsafeKt.prepareReadFirstHead(byteReadPacket, 1);
        if (prepareReadFirstHead == null) {
            return;
        }
        while (true) {
            try {
                if (prepareReadFirstHead.getWritePosition() > prepareReadFirstHead.getReadPosition()) {
                    function1.invoke(Byte.valueOf(prepareReadFirstHead.readByte()));
                } else {
                    try {
                        prepareReadFirstHead = UnsafeKt.prepareReadNextHead(byteReadPacket, prepareReadFirstHead);
                        if (prepareReadFirstHead == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (z) {
                            UnsafeKt.completeReadHead(byteReadPacket, prepareReadFirstHead);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
