package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: BuiltInSerializerProtocol.kt */
/* loaded from: classes2.dex */
public final class BuiltInSerializerProtocol extends SerializerExtensionProtocol {
    public static final BuiltInSerializerProtocol INSTANCE = new BuiltInSerializerProtocol();

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private BuiltInSerializerProtocol() {
        /*
            r18 = this;
            r0 = r18
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2 = kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite.newInstance()
            r1 = r2
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.registerAllExtensions(r2)
            java.lang.String r3 = "apply(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r3 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.packageFqName
            r2 = r3
            java.lang.String r4 = "packageFqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r4 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.constructorAnnotation
            r3 = r4
            java.lang.String r5 = "constructorAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r5 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.classAnnotation
            r4 = r5
            java.lang.String r6 = "classAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r6 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.functionAnnotation
            r5 = r6
            java.lang.String r7 = "functionAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r6 = 0
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r8 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.propertyAnnotation
            r7 = r8
            java.lang.String r9 = "propertyAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r9 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.propertyGetterAnnotation
            r8 = r9
            java.lang.String r10 = "propertyGetterAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r10 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.propertySetterAnnotation
            r9 = r10
            java.lang.String r11 = "propertySetterAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r10 = 0
            r11 = 0
            r12 = 0
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r14 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.enumEntryAnnotation
            r13 = r14
            java.lang.String r15 = "enumEntryAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r15 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.compileTimeValue
            r14 = r15
            java.lang.String r6 = "compileTimeValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r6)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r6 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.parameterAnnotation
            r15 = r6
            java.lang.String r10 = "parameterAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r10)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r6 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.typeAnnotation
            r16 = r6
            java.lang.String r10 = "typeAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r10)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension r6 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.typeParameterAnnotation
            r17 = r6
            java.lang.String r10 = "typeParameterAnnotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r10)
            r6 = 0
            r10 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.<init>():void");
    }

    public final String getBuiltInsFilePath(FqName fqName) {
        String replace$default;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        StringBuilder sb = new StringBuilder();
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        replace$default = StringsKt__StringsJVMKt.replace$default(asString, (char) CoreConstants.DOT, '/', false, 4, (Object) null);
        sb.append(replace$default);
        sb.append('/');
        sb.append(getBuiltInsFileName(fqName));
        return sb.toString();
    }

    public final String getBuiltInsFileName(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return shortName(fqName) + ".kotlin_builtins";
    }

    private final String shortName(FqName fqName) {
        if (fqName.isRoot()) {
            return "default-package";
        }
        String asString = fqName.shortName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }
}
