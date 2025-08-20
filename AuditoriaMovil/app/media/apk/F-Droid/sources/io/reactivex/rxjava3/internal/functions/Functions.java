package io.reactivex.rxjava3.internal.functions;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.fdroid.fdroid.Preferences;
import org.reactivestreams.Subscription;
/* loaded from: classes.dex */
public abstract class Functions {
    static final Function IDENTITY = new Identity();
    public static final Runnable EMPTY_RUNNABLE = new EmptyRunnable();
    public static final Action EMPTY_ACTION = new EmptyAction();
    static final Consumer EMPTY_CONSUMER = new EmptyConsumer();
    public static final Consumer ERROR_CONSUMER = new ErrorConsumer();
    public static final Consumer ON_ERROR_MISSING = new OnErrorMissingConsumer();
    public static final LongConsumer EMPTY_LONG_CONSUMER = new EmptyLongConsumer();
    static final Predicate ALWAYS_TRUE = new TruePredicate();
    static final Predicate ALWAYS_FALSE = new FalsePredicate();
    static final Supplier NULL_SUPPLIER = new NullProvider();
    public static final Consumer REQUEST_MAX = new MaxRequestSubscription();

    /* loaded from: classes.dex */
    static final class EmptyAction implements Action {
        EmptyAction() {
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* loaded from: classes.dex */
    static final class EmptyConsumer implements Consumer {
        EmptyConsumer() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* loaded from: classes.dex */
    static final class EmptyLongConsumer implements LongConsumer {
        EmptyLongConsumer() {
        }
    }

    /* loaded from: classes.dex */
    static final class EmptyRunnable implements Runnable {
        EmptyRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* loaded from: classes.dex */
    static final class FalsePredicate implements Predicate {
        FalsePredicate() {
        }

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object obj) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    static final class Identity implements Function {
        Identity() {
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* loaded from: classes.dex */
    static final class NullProvider implements Supplier {
        NullProvider() {
        }

        @Override // io.reactivex.rxjava3.functions.Supplier
        public Object get() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    static final class TruePredicate implements Predicate {
        TruePredicate() {
        }

        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Object obj) {
            return true;
        }
    }

    public static Consumer emptyConsumer() {
        return EMPTY_CONSUMER;
    }

    /* loaded from: classes.dex */
    static final class ErrorConsumer implements Consumer {
        ErrorConsumer() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            RxJavaPlugins.onError(th);
        }
    }

    /* loaded from: classes.dex */
    static final class OnErrorMissingConsumer implements Consumer {
        OnErrorMissingConsumer() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            RxJavaPlugins.onError(new OnErrorNotImplementedException(th));
        }
    }

    /* loaded from: classes.dex */
    static final class MaxRequestSubscription implements Consumer {
        MaxRequestSubscription() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public /* bridge */ /* synthetic */ void accept(Object obj) {
            ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
            accept((Subscription) null);
        }

        public void accept(Subscription subscription) {
            subscription.request(Preferences.UPDATE_INTERVAL_DISABLED);
        }
    }
}
