package kotlin.reflect.jvm.internal.impl.builtins.functions;

import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: FunctionTypeKindExtractor.kt */
/* loaded from: classes2.dex */
public final class FunctionTypeKindExtractor {
    public static final Companion Companion = new Companion(null);
    private static final FunctionTypeKindExtractor Default;
    private final List kinds;
    private final Map knownKindsByPackageFqName;

    public FunctionTypeKindExtractor(List kinds) {
        Intrinsics.checkNotNullParameter(kinds, "kinds");
        this.kinds = kinds;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : kinds) {
            FqName packageFqName = ((FunctionTypeKind) obj).getPackageFqName();
            Object obj2 = linkedHashMap.get(packageFqName);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(packageFqName, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.knownKindsByPackageFqName = linkedHashMap;
    }

    /* compiled from: FunctionTypeKindExtractor.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FunctionTypeKindExtractor getDefault() {
            return FunctionTypeKindExtractor.Default;
        }
    }

    static {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FunctionTypeKind[]{FunctionTypeKind.Function.INSTANCE, FunctionTypeKind.SuspendFunction.INSTANCE, FunctionTypeKind.KFunction.INSTANCE, FunctionTypeKind.KSuspendFunction.INSTANCE});
        Default = new FunctionTypeKindExtractor(listOf);
    }

    public final FunctionTypeKind getFunctionalClassKind(FqName packageFqName, String className) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(className, "className");
        KindWithArity functionalClassKindWithArity = getFunctionalClassKindWithArity(packageFqName, className);
        if (functionalClassKindWithArity != null) {
            return functionalClassKindWithArity.getKind();
        }
        return null;
    }

    public final KindWithArity getFunctionalClassKindWithArity(FqName packageFqName, String className) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(className, "className");
        List<FunctionTypeKind> list = (List) this.knownKindsByPackageFqName.get(packageFqName);
        if (list == null) {
            return null;
        }
        for (FunctionTypeKind functionTypeKind : list) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(className, functionTypeKind.getClassNamePrefix(), false, 2, null);
            if (startsWith$default) {
                String substring = className.substring(functionTypeKind.getClassNamePrefix().length());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                Integer num = toInt(substring);
                if (num != null) {
                    return new KindWithArity(functionTypeKind, num.intValue());
                }
            }
        }
        return null;
    }

    /* compiled from: FunctionTypeKindExtractor.kt */
    /* loaded from: classes2.dex */
    public static final class KindWithArity {
        private final int arity;
        private final FunctionTypeKind kind;

        public final FunctionTypeKind component1() {
            return this.kind;
        }

        public final int component2() {
            return this.arity;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KindWithArity) {
                KindWithArity kindWithArity = (KindWithArity) obj;
                return Intrinsics.areEqual(this.kind, kindWithArity.kind) && this.arity == kindWithArity.arity;
            }
            return false;
        }

        public final FunctionTypeKind getKind() {
            return this.kind;
        }

        public int hashCode() {
            return (this.kind.hashCode() * 31) + this.arity;
        }

        public String toString() {
            return "KindWithArity(kind=" + this.kind + ", arity=" + this.arity + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public KindWithArity(FunctionTypeKind kind, int i) {
            Intrinsics.checkNotNullParameter(kind, "kind");
            this.kind = kind;
            this.arity = i;
        }
    }

    private final Integer toInt(String str) {
        if (str.length() == 0) {
            return null;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int charAt = str.charAt(i2) - '0';
            if (charAt < 0 || charAt >= 10) {
                return null;
            }
            i = (i * 10) + charAt;
        }
        return Integer.valueOf(i);
    }
}
