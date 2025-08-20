package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: propertiesConventionUtil.kt */
/* loaded from: classes2.dex */
public abstract class PropertiesConventionUtilKt {
    public static final Name propertyNameByGetMethodName(Name methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Name propertyNameFromAccessorMethodName$default = propertyNameFromAccessorMethodName$default(methodName, "get", false, null, 12, null);
        return propertyNameFromAccessorMethodName$default == null ? propertyNameFromAccessorMethodName$default(methodName, "is", false, null, 8, null) : propertyNameFromAccessorMethodName$default;
    }

    public static final Name propertyNameBySetMethodName(Name methodName, boolean z) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return propertyNameFromAccessorMethodName$default(methodName, "set", false, z ? "is" : null, 4, null);
    }

    public static final List propertyNamesBySetMethodName(Name methodName) {
        List listOfNotNull;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new Name[]{propertyNameBySetMethodName(methodName, false), propertyNameBySetMethodName(methodName, true)});
        return listOfNotNull;
    }

    static /* synthetic */ Name propertyNameFromAccessorMethodName$default(Name name, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        return propertyNameFromAccessorMethodName(name, str, z, str2);
    }

    private static final Name propertyNameFromAccessorMethodName(Name name, String str, boolean z, String str2) {
        boolean startsWith$default;
        String removePrefix;
        String removePrefix2;
        if (name.isSpecial()) {
            return null;
        }
        String identifier = name.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(identifier, str, false, 2, null);
        if (startsWith$default && identifier.length() != str.length()) {
            char charAt = identifier.charAt(str.length());
            if ('a' > charAt || charAt >= '{') {
                if (str2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    removePrefix2 = StringsKt__StringsKt.removePrefix(identifier, str);
                    sb.append(removePrefix2);
                    return Name.identifier(sb.toString());
                } else if (z) {
                    removePrefix = StringsKt__StringsKt.removePrefix(identifier, str);
                    String decapitalizeSmartForCompiler = CapitalizeDecapitalizeKt.decapitalizeSmartForCompiler(removePrefix, true);
                    if (Name.isValidIdentifier(decapitalizeSmartForCompiler)) {
                        return Name.identifier(decapitalizeSmartForCompiler);
                    }
                    return null;
                } else {
                    return name;
                }
            }
            return null;
        }
        return null;
    }

    public static final List getPropertyNamesCandidatesByAccessorName(Name name) {
        List listOfNotNull;
        Intrinsics.checkNotNullParameter(name, "name");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        if (JvmAbi.isGetterName(asString)) {
            listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(propertyNameByGetMethodName(name));
            return listOfNotNull;
        } else if (JvmAbi.isSetterName(asString)) {
            return propertyNamesBySetMethodName(name);
        } else {
            return BuiltinSpecialProperties.INSTANCE.getPropertyNameCandidatesBySpecialGetterName(name);
        }
    }
}
