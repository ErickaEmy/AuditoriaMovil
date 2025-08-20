package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* compiled from: JvmAnnotationNames.kt */
/* loaded from: classes2.dex */
public abstract class JvmAnnotationNamesKt {
    private static final FqName ANDROIDX_RECENTLY_NON_NULL_ANNOTATION;
    private static final FqName ANDROIDX_RECENTLY_NULLABLE_ANNOTATION;
    private static final FqName COMPATQUAL_NONNULL_ANNOTATION;
    private static final FqName COMPATQUAL_NULLABLE_ANNOTATION;
    private static final FqName JAVAX_CHECKFORNULL_ANNOTATION;
    private static final FqName JAVAX_NONNULL_ANNOTATION;
    private static final FqName JSPECIFY_NULLABLE;
    private static final FqName JSPECIFY_NULLNESS_UNKNOWN;
    private static final FqName JSPECIFY_NULL_MARKED;
    private static final FqName JSPECIFY_OLD_NULLABLE;
    private static final FqName JSPECIFY_OLD_NULLNESS_UNKNOWN;
    private static final FqName JSPECIFY_OLD_NULL_MARKED;
    private static final Set MUTABLE_ANNOTATIONS;
    private static final List NOT_NULL_ANNOTATIONS;
    private static final Set NULLABILITY_ANNOTATIONS;
    private static final List NULLABLE_ANNOTATIONS;
    private static final Set READ_ONLY_ANNOTATIONS;
    private static final Map javaToKotlinNameMap;

    public static final FqName getANDROIDX_RECENTLY_NON_NULL_ANNOTATION() {
        return ANDROIDX_RECENTLY_NON_NULL_ANNOTATION;
    }

    public static final FqName getANDROIDX_RECENTLY_NULLABLE_ANNOTATION() {
        return ANDROIDX_RECENTLY_NULLABLE_ANNOTATION;
    }

    public static final FqName getCOMPATQUAL_NONNULL_ANNOTATION() {
        return COMPATQUAL_NONNULL_ANNOTATION;
    }

    public static final FqName getCOMPATQUAL_NULLABLE_ANNOTATION() {
        return COMPATQUAL_NULLABLE_ANNOTATION;
    }

    public static final FqName getJAVAX_CHECKFORNULL_ANNOTATION() {
        return JAVAX_CHECKFORNULL_ANNOTATION;
    }

    public static final FqName getJAVAX_NONNULL_ANNOTATION() {
        return JAVAX_NONNULL_ANNOTATION;
    }

    public static final FqName getJSPECIFY_NULLABLE() {
        return JSPECIFY_NULLABLE;
    }

    public static final FqName getJSPECIFY_NULLNESS_UNKNOWN() {
        return JSPECIFY_NULLNESS_UNKNOWN;
    }

    public static final FqName getJSPECIFY_NULL_MARKED() {
        return JSPECIFY_NULL_MARKED;
    }

    public static final FqName getJSPECIFY_OLD_NULLABLE() {
        return JSPECIFY_OLD_NULLABLE;
    }

    public static final FqName getJSPECIFY_OLD_NULLNESS_UNKNOWN() {
        return JSPECIFY_OLD_NULLNESS_UNKNOWN;
    }

    public static final FqName getJSPECIFY_OLD_NULL_MARKED() {
        return JSPECIFY_OLD_NULL_MARKED;
    }

    public static final Set getMUTABLE_ANNOTATIONS() {
        return MUTABLE_ANNOTATIONS;
    }

    public static final List getNOT_NULL_ANNOTATIONS() {
        return NOT_NULL_ANNOTATIONS;
    }

    public static final List getNULLABLE_ANNOTATIONS() {
        return NULLABLE_ANNOTATIONS;
    }

    public static final Set getREAD_ONLY_ANNOTATIONS() {
        return READ_ONLY_ANNOTATIONS;
    }

    static {
        List listOf;
        List listOf2;
        Set plus;
        Set plus2;
        Set plus3;
        Set plus4;
        Set plus5;
        Set plus6;
        Set plus7;
        Set plus8;
        Set plus9;
        Set plus10;
        Set plus11;
        Set of;
        Set of2;
        Map mapOf;
        FqName fqName = new FqName("org.jspecify.nullness.Nullable");
        JSPECIFY_OLD_NULLABLE = fqName;
        JSPECIFY_OLD_NULLNESS_UNKNOWN = new FqName("org.jspecify.nullness.NullnessUnspecified");
        FqName fqName2 = new FqName("org.jspecify.nullness.NullMarked");
        JSPECIFY_OLD_NULL_MARKED = fqName2;
        FqName fqName3 = new FqName("org.jspecify.annotations.Nullable");
        JSPECIFY_NULLABLE = fqName3;
        JSPECIFY_NULLNESS_UNKNOWN = new FqName("org.jspecify.annotations.NullnessUnspecified");
        FqName fqName4 = new FqName("org.jspecify.annotations.NullMarked");
        JSPECIFY_NULL_MARKED = fqName4;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("androidx.annotation.Nullable"), new FqName("android.support.annotation.Nullable"), new FqName("android.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("io.reactivex.annotations.Nullable"), new FqName("io.reactivex.rxjava3.annotations.Nullable")});
        NULLABLE_ANNOTATIONS = listOf;
        FqName fqName5 = new FqName("javax.annotation.Nonnull");
        JAVAX_NONNULL_ANNOTATION = fqName5;
        JAVAX_CHECKFORNULL_ANNOTATION = new FqName("javax.annotation.CheckForNull");
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("android.support.annotation.NonNull"), new FqName("android.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull"), new FqName("io.reactivex.annotations.NonNull"), new FqName("io.reactivex.rxjava3.annotations.NonNull")});
        NOT_NULL_ANNOTATIONS = listOf2;
        FqName fqName6 = new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        COMPATQUAL_NULLABLE_ANNOTATION = fqName6;
        FqName fqName7 = new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        COMPATQUAL_NONNULL_ANNOTATION = fqName7;
        FqName fqName8 = new FqName("androidx.annotation.RecentlyNullable");
        ANDROIDX_RECENTLY_NULLABLE_ANNOTATION = fqName8;
        FqName fqName9 = new FqName("androidx.annotation.RecentlyNonNull");
        ANDROIDX_RECENTLY_NON_NULL_ANNOTATION = fqName9;
        plus = SetsKt___SetsKt.plus((Set) new LinkedHashSet(), (Iterable) listOf);
        plus2 = SetsKt___SetsKt.plus(plus, fqName5);
        plus3 = SetsKt___SetsKt.plus(plus2, (Iterable) listOf2);
        plus4 = SetsKt___SetsKt.plus(plus3, fqName6);
        plus5 = SetsKt___SetsKt.plus(plus4, fqName7);
        plus6 = SetsKt___SetsKt.plus(plus5, fqName8);
        plus7 = SetsKt___SetsKt.plus(plus6, fqName9);
        plus8 = SetsKt___SetsKt.plus(plus7, fqName);
        plus9 = SetsKt___SetsKt.plus(plus8, fqName2);
        plus10 = SetsKt___SetsKt.plus(plus9, fqName3);
        plus11 = SetsKt___SetsKt.plus(plus10, fqName4);
        NULLABILITY_ANNOTATIONS = plus11;
        of = SetsKt__SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION});
        READ_ONLY_ANNOTATIONS = of;
        of2 = SetsKt__SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION});
        MUTABLE_ANNOTATIONS = of2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(JvmAnnotationNames.TARGET_ANNOTATION, StandardNames.FqNames.target), TuplesKt.to(JvmAnnotationNames.RETENTION_ANNOTATION, StandardNames.FqNames.retention), TuplesKt.to(JvmAnnotationNames.DEPRECATED_ANNOTATION, StandardNames.FqNames.deprecated), TuplesKt.to(JvmAnnotationNames.DOCUMENTED_ANNOTATION, StandardNames.FqNames.mustBeDocumented));
        javaToKotlinNameMap = mapOf;
    }
}
