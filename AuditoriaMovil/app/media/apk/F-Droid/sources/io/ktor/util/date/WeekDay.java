package io.ktor.util.date;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Date.kt */
/* loaded from: classes.dex */
public enum WeekDay {
    MONDAY("Mon"),
    TUESDAY("Tue"),
    WEDNESDAY("Wed"),
    THURSDAY("Thu"),
    FRIDAY("Fri"),
    SATURDAY("Sat"),
    SUNDAY("Sun");
    
    public static final Companion Companion = new Companion(null);
    private final String value;

    WeekDay(String str) {
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

        public final WeekDay from(int i) {
            return WeekDay.values()[i];
        }
    }
}
