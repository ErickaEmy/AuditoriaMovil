package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import b.a;
import hw.c;
import hw.co;
import hw.i4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vl.s;
import z.y;
/* loaded from: classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AnimationInfo extends SpecialEffectsInfo {
        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        public AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull a aVar, boolean z2) {
            super(operation, aVar);
            this.mIsPop = z2;
        }

        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            boolean z2;
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            Fragment fragment = getOperation().getFragment();
            if (getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                z2 = true;
            } else {
                z2 = false;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, fragment, z2, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    /* loaded from: classes.dex */
    public static class SpecialEffectsInfo {
        @NonNull
        private final SpecialEffectsController.Operation mOperation;
        @NonNull
        private final a mSignal;

        public SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull a aVar) {
            this.mOperation = operation;
            this.mSignal = aVar;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        public a getSignal() {
            return this.mSignal;
        }

        public boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            if (from != finalState && (from == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state)) {
                return false;
            }
            return true;
        }
    }

    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z2, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        final boolean z3;
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z4 = false;
        for (final AnimationInfo animationInfo : list) {
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation == null) {
                    animationInfo.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        final SpecialEffectsController.Operation operation = animationInfo.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation))) {
                            FragmentManager.isLoggingEnabled(2);
                            animationInfo.completeSpecialEffect();
                        } else {
                            if (operation.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                list2.remove(operation);
                            }
                            final View view = fragment.mView;
                            container.startViewTransition(view);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    container.endViewTransition(view);
                                    if (z3) {
                                        operation.getFinalState().applyState(view);
                                    }
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            animationInfo.getSignal().zn(new a.n3() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                                @Override // b.a.n3
                                public void onCancel() {
                                    animator.end();
                                }
                            });
                            z4 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final AnimationInfo animationInfo2 = (AnimationInfo) it.next();
            SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z2) {
                FragmentManager.isLoggingEnabled(2);
                animationInfo2.completeSpecialEffect();
            } else if (z4) {
                FragmentManager.isLoggingEnabled(2);
                animationInfo2.completeSpecialEffect();
            } else {
                final View view2 = fragment2.mView;
                Animation animation2 = (Animation) s.fb(((FragmentAnim.AnimationOrAnimator) s.fb(animationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation3) {
                            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    container.endViewTransition(view2);
                                    animationInfo2.completeSpecialEffect();
                                }
                            });
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation3) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation3) {
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().zn(new a.n3() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    @Override // b.a.n3
                    public void onCancel() {
                        view2.clearAnimation();
                        container.endViewTransition(view2);
                        animationInfo2.completeSpecialEffect();
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, final boolean z2, @Nullable final SpecialEffectsController.Operation operation, @Nullable final SpecialEffectsController.Operation operation2) {
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        SpecialEffectsController.Operation operation3;
        SpecialEffectsController.Operation operation4;
        View view2;
        Object mergeTransitionsTogether;
        y yVar;
        ArrayList<View> arrayList3;
        SpecialEffectsController.Operation operation5;
        ArrayList<View> arrayList4;
        Rect rect;
        View view3;
        FragmentTransitionImpl fragmentTransitionImpl;
        SpecialEffectsController.Operation operation6;
        final View view4;
        boolean z3 = z2;
        SpecialEffectsController.Operation operation7 = operation;
        SpecialEffectsController.Operation operation8 = operation2;
        HashMap hashMap = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl2 != handlingImpl) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo transitionInfo2 : list) {
                hashMap.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return hashMap;
        }
        View view5 = new View(getContainer().getContext());
        final Rect rect2 = new Rect();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayList<View> arrayList6 = new ArrayList<>();
        y yVar2 = new y();
        Object obj3 = null;
        View view6 = null;
        boolean z4 = false;
        for (TransitionInfo transitionInfo3 : list) {
            if (!transitionInfo3.hasSharedElementTransition() || operation7 == null || operation8 == null) {
                yVar = yVar2;
                arrayList3 = arrayList6;
                operation5 = operation7;
                arrayList4 = arrayList5;
                rect = rect2;
                view3 = view5;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                operation6 = operation8;
                view6 = view6;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(transitionInfo3.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                View view7 = view6;
                int i = 0;
                while (i < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i));
                    }
                    i++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (!z3) {
                    operation.getFragment().getExitTransitionCallback();
                    operation2.getFragment().getEnterTransitionCallback();
                } else {
                    operation.getFragment().getEnterTransitionCallback();
                    operation2.getFragment().getExitTransitionCallback();
                }
                int i5 = 0;
                for (int size = sharedElementSourceNames.size(); i5 < size; size = size) {
                    yVar2.put(sharedElementSourceNames.get(i5), sharedElementTargetNames2.get(i5));
                    i5++;
                }
                y<String, View> yVar3 = new y<>();
                findNamedViews(yVar3, operation.getFragment().mView);
                yVar3.p(sharedElementSourceNames);
                yVar2.p(yVar3.keySet());
                final y<String, View> yVar4 = new y<>();
                findNamedViews(yVar4, operation2.getFragment().mView);
                yVar4.p(sharedElementTargetNames2);
                yVar4.p(yVar2.values());
                FragmentTransition.retainValues(yVar2, yVar4);
                retainMatchingViews(yVar3, yVar2.keySet());
                retainMatchingViews(yVar4, yVar2.values());
                if (yVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    yVar = yVar2;
                    arrayList3 = arrayList6;
                    operation5 = operation7;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    view6 = view7;
                    obj3 = null;
                    operation6 = operation8;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z3, yVar3, true);
                    yVar = yVar2;
                    ArrayList<View> arrayList8 = arrayList6;
                    co.y(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z2, yVar4, false);
                        }
                    });
                    arrayList5.addAll(yVar3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view6 = view7;
                    } else {
                        view6 = yVar3.get(sharedElementSourceNames.get(0));
                        fragmentTransitionImpl2.setEpicenter(wrapTransitionInSet, view6);
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(yVar4.values());
                    if (!sharedElementTargetNames2.isEmpty() && (view4 = yVar4.get(sharedElementTargetNames2.get(0))) != null) {
                        co.y(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                            @Override // java.lang.Runnable
                            public void run() {
                                fragmentTransitionImpl2.getBoundsOnScreen(view4, rect2);
                            }
                        });
                        z4 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(wrapTransitionInSet, view5, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(wrapTransitionInSet, null, null, null, null, wrapTransitionInSet, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    operation5 = operation;
                    hashMap.put(operation5, bool);
                    operation6 = operation2;
                    hashMap.put(operation6, bool);
                    obj3 = wrapTransitionInSet;
                }
            }
            operation7 = operation5;
            arrayList5 = arrayList4;
            rect2 = rect;
            view5 = view3;
            operation8 = operation6;
            yVar2 = yVar;
            z3 = z2;
            arrayList6 = arrayList3;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
        }
        View view8 = view6;
        y yVar5 = yVar2;
        Collection<?> collection = arrayList6;
        SpecialEffectsController.Operation operation9 = operation7;
        Collection<?> collection2 = arrayList5;
        Rect rect3 = rect2;
        View view9 = view5;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        SpecialEffectsController.Operation operation10 = operation8;
        ArrayList arrayList9 = new ArrayList();
        Object obj4 = null;
        Object obj5 = null;
        for (TransitionInfo transitionInfo4 : list) {
            if (transitionInfo4.isVisibilityUnchanged()) {
                hashMap.put(transitionInfo4.getOperation(), Boolean.FALSE);
                transitionInfo4.completeSpecialEffect();
            } else {
                Object cloneTransition = fragmentTransitionImpl3.cloneTransition(transitionInfo4.getTransition());
                SpecialEffectsController.Operation operation11 = transitionInfo4.getOperation();
                boolean z5 = obj3 != null && (operation11 == operation9 || operation11 == operation10);
                if (cloneTransition == null) {
                    if (!z5) {
                        hashMap.put(operation11, Boolean.FALSE);
                        transitionInfo4.completeSpecialEffect();
                    }
                    arrayList2 = collection;
                    arrayList = collection2;
                    view = view9;
                    mergeTransitionsTogether = obj4;
                    operation3 = operation10;
                    view2 = view8;
                } else {
                    final ArrayList<View> arrayList10 = new ArrayList<>();
                    Object obj6 = obj4;
                    captureTransitioningViews(arrayList10, operation11.getFragment().mView);
                    if (z5) {
                        if (operation11 == operation9) {
                            arrayList10.removeAll(collection2);
                        } else {
                            arrayList10.removeAll(collection);
                        }
                    }
                    if (arrayList10.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(cloneTransition, view9);
                        arrayList2 = collection;
                        arrayList = collection2;
                        view = view9;
                        operation4 = operation11;
                        obj2 = obj5;
                        operation3 = operation10;
                        obj = obj6;
                    } else {
                        fragmentTransitionImpl3.addTargets(cloneTransition, arrayList10);
                        view = view9;
                        obj = obj6;
                        arrayList = collection2;
                        obj2 = obj5;
                        arrayList2 = collection;
                        operation3 = operation10;
                        fragmentTransitionImpl3.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList10, null, null, null, null);
                        if (operation11.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation4 = operation11;
                            list2.remove(operation4);
                            ArrayList<View> arrayList11 = new ArrayList<>(arrayList10);
                            arrayList11.remove(operation4.getFragment().mView);
                            fragmentTransitionImpl3.scheduleHideFragmentView(cloneTransition, operation4.getFragment().mView, arrayList11);
                            co.y(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    FragmentTransition.setViewVisibility(arrayList10, 4);
                                }
                            });
                        } else {
                            operation4 = operation11;
                        }
                    }
                    if (operation4.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList9.addAll(arrayList10);
                        if (z4) {
                            fragmentTransitionImpl3.setEpicenter(cloneTransition, rect3);
                        }
                        view2 = view8;
                    } else {
                        view2 = view8;
                        fragmentTransitionImpl3.setEpicenter(cloneTransition, view2);
                    }
                    hashMap.put(operation4, Boolean.TRUE);
                    if (transitionInfo4.isOverlapAllowed()) {
                        obj5 = fragmentTransitionImpl3.mergeTransitionsTogether(obj2, cloneTransition, null);
                        mergeTransitionsTogether = obj;
                    } else {
                        mergeTransitionsTogether = fragmentTransitionImpl3.mergeTransitionsTogether(obj, cloneTransition, null);
                        obj5 = obj2;
                    }
                }
                operation10 = operation3;
                obj4 = mergeTransitionsTogether;
                view8 = view2;
                view9 = view;
                collection2 = arrayList;
                collection = arrayList2;
            }
        }
        ArrayList<View> arrayList12 = collection;
        ArrayList<View> arrayList13 = collection2;
        SpecialEffectsController.Operation operation12 = operation10;
        Object mergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj5, obj4, obj3);
        for (final TransitionInfo transitionInfo5 : list) {
            if (!transitionInfo5.isVisibilityUnchanged()) {
                Object transition = transitionInfo5.getTransition();
                SpecialEffectsController.Operation operation13 = transitionInfo5.getOperation();
                boolean z7 = obj3 != null && (operation13 == operation9 || operation13 == operation12);
                if (transition != null || z7) {
                    if (!i4.q9(getContainer())) {
                        FragmentManager.isLoggingEnabled(2);
                        transitionInfo5.completeSpecialEffect();
                    } else {
                        fragmentTransitionImpl3.setListenerForTransitionEnd(transitionInfo5.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo5.getSignal(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                            @Override // java.lang.Runnable
                            public void run() {
                                transitionInfo5.completeSpecialEffect();
                            }
                        });
                    }
                }
            }
        }
        if (i4.q9(getContainer())) {
            FragmentTransition.setViewVisibility(arrayList9, 4);
            ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList12);
            fragmentTransitionImpl3.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
            fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList13, arrayList12, prepareSetNameOverridesReordered, yVar5);
            FragmentTransition.setViewVisibility(arrayList9, 0);
            fragmentTransitionImpl3.swapSharedElementTargets(obj3, arrayList13, arrayList12);
            return hashMap;
        }
        return hashMap;
    }

    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (c.y(viewGroup)) {
                if (!arrayList.contains(view)) {
                    arrayList.add(viewGroup);
                    return;
                }
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    captureTransitioningViews(arrayList, childAt);
                }
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z2) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int i = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation3.getFinalState().ordinal()];
            if (i != 1 && i != 2 && i != 3) {
                if (i == 4 && from != SpecialEffectsController.Operation.State.VISIBLE) {
                    operation2 = operation3;
                }
            } else if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                operation = operation3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList<SpecialEffectsController.Operation> arrayList3 = new ArrayList(list);
        for (final SpecialEffectsController.Operation operation4 : list) {
            a aVar = new a();
            operation4.markStartedSpecialEffect(aVar);
            arrayList.add(new AnimationInfo(operation4, aVar, z2));
            a aVar2 = new a();
            operation4.markStartedSpecialEffect(aVar2);
            boolean z3 = false;
            if (z2) {
                if (operation4 != operation) {
                    arrayList2.add(new TransitionInfo(operation4, aVar2, z2, z3));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z3 = true;
                arrayList2.add(new TransitionInfo(operation4, aVar2, z2, z3));
                operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new TransitionInfo(operation4, aVar2, z2, z3));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z3 = true;
                arrayList2.add(new TransitionInfo(operation4, aVar2, z2, z3));
                operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            }
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z2, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        for (SpecialEffectsController.Operation operation5 : arrayList3) {
            applyContainerChanges(operation5);
        }
        arrayList3.clear();
    }

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String yt2 = i4.yt(view);
        if (yt2 != null) {
            map.put(yt2, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@NonNull y<String, View> yVar, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = yVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(i4.yt(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        @Nullable
        private final Object mSharedElementTransition;
        @Nullable
        private final Object mTransition;

        public TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull a aVar, boolean z2, boolean z3) {
            super(operation, aVar);
            Object exitTransition;
            Object enterTransition;
            boolean allowEnterTransitionOverlap;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z2) {
                    enterTransition = operation.getFragment().getReenterTransition();
                } else {
                    enterTransition = operation.getFragment().getEnterTransition();
                }
                this.mTransition = enterTransition;
                if (z2) {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = allowEnterTransitionOverlap;
            } else {
                if (z2) {
                    exitTransition = operation.getFragment().getReturnTransition();
                } else {
                    exitTransition = operation.getFragment().getExitTransition();
                }
                this.mTransition = exitTransition;
                this.mOverlapAllowed = true;
            }
            if (z3) {
                if (z2) {
                    this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
                    return;
                } else {
                    this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
                    return;
                }
            }
            this.mSharedElementTransition = null;
        }

        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            if (this.mSharedElementTransition != null) {
                return true;
            }
            return false;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl == null || !fragmentTransitionImpl.canHandle(obj)) {
                FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
                if (fragmentTransitionImpl2 == null || !fragmentTransitionImpl2.canHandle(obj)) {
                    throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
                }
                return fragmentTransitionImpl2;
            }
            return fragmentTransitionImpl;
        }
    }
}
