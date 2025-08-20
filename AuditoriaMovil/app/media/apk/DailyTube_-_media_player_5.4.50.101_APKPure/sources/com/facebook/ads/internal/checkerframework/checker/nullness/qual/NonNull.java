package com.facebook.ads.internal.checkerframework.checker.nullness.qual;

import com.facebook.ads.internal.checkerframework.framework.qual.DefaultFor;
import com.facebook.ads.internal.checkerframework.framework.qual.DefaultInUncheckedCodeFor;
import com.facebook.ads.internal.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import com.facebook.ads.internal.checkerframework.framework.qual.QualifierForLiterals;
import com.facebook.ads.internal.checkerframework.framework.qual.SubtypeOf;
import com.facebook.ads.internal.checkerframework.framework.qual.UpperBoundFor;
import com.facebook.ads.redexgen.X.C7J;
import com.facebook.ads.redexgen.X.C7X;
import com.facebook.ads.redexgen.X.C7Y;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@SubtypeOf({MonotonicNonNull.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@UpperBoundFor(typeKinds = {C7X.A0I, C7X.A0C, C7X.A04, C7X.A06, C7X.A08, C7X.A0B, C7X.A0E, C7X.A0J, C7X.A05})
@Retention(RetentionPolicy.RUNTIME)
@QualifierForLiterals({C7J.A0B})
@DefaultFor({C7Y.A05})
@DefaultQualifierInHierarchy
@DefaultInUncheckedCodeFor({C7Y.A0E, C7Y.A0C})
@Documented
/* loaded from: assets/audience_network.dex */
public @interface NonNull {
}
