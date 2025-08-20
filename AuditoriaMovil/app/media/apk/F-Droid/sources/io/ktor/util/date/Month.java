package io.ktor.util.date;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Date.kt */
/* loaded from: classes.dex */
public enum Month {
    JANUARY("Jan"),
    FEBRUARY("Feb"),
    MARCH("Mar"),
    APRIL("Apr"),
    MAY("May"),
    JUNE("Jun"),
    JULY("Jul"),
    AUGUST("Aug"),
    SEPTEMBER("Sep"),
    OCTOBER("Oct"),
    NOVEMBER("Nov"),
    DECEMBER("Dec");
    
    public static final Companion Companion = new Companion(null);
    private final String value;

    Month(String str) {
        this.value = str;
    }

    /* compiled from: Date.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Month from(int i) {
            return Month.values()[i];
        }
    }
}
