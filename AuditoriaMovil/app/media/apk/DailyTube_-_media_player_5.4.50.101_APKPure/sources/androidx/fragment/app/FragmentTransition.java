package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b.a;
import cr.v;
import hw.co;
import hw.i4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import z.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FragmentTransition {
    private static final int[] INVERSE_OPS = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    static final FragmentTransitionImpl PLATFORM_IMPL = new FragmentTransitionCompat21();
    static final FragmentTransitionImpl SUPPORT_IMPL = resolveSupportImpl();

    /* loaded from: classes.dex */
    public interface Callback {
        void onComplete(@NonNull Fragment fragment, @NonNull a aVar);

        void onStart(@NonNull Fragment fragment, @NonNull a aVar);
    }

    /* loaded from: classes.dex */
    public static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;
    }

    private FragmentTransition() {
    }

    private static void addSharedElementsWithMatchingNames(ArrayList<View> arrayList, y<String, View> yVar, Collection<String> collection) {
        for (int size = yVar.size() - 1; size >= 0; size--) {
            View xc2 = yVar.xc(size);
            if (collection.contains(i4.yt(xc2))) {
                arrayList.add(xc2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0039, code lost:
        if (r0.mAdded != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003b, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0052, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x008f, code lost:
        if (r0.mHidden == false) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void addToFirstInLastOut(androidx.fragment.app.BackStackRecord r8, androidx.fragment.app.FragmentTransaction.Op r9, android.util.SparseArray<androidx.fragment.app.FragmentTransition.FragmentContainerTransition> r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentTransition.addToFirstInLastOut(androidx.fragment.app.BackStackRecord, androidx.fragment.app.FragmentTransaction$Op, android.util.SparseArray, boolean, boolean):void");
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z2) {
        int size = backStackRecord.mOps.size();
        for (int i = 0; i < size; i++) {
            addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(i), sparseArray, false, z2);
        }
    }

    private static y<String, String> calculateNameOverrides(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i5, int i6) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        y<String, String> yVar = new y<>();
        for (int i8 = i6 - 1; i8 >= i5; i8--) {
            BackStackRecord backStackRecord = arrayList.get(i8);
            if (backStackRecord.interactsWith(i)) {
                boolean booleanValue = arrayList2.get(i8).booleanValue();
                ArrayList<String> arrayList5 = backStackRecord.mSharedElementSourceNames;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.mSharedElementSourceNames;
                        arrayList4 = backStackRecord.mSharedElementTargetNames;
                    } else {
                        ArrayList<String> arrayList6 = backStackRecord.mSharedElementSourceNames;
                        arrayList3 = backStackRecord.mSharedElementTargetNames;
                        arrayList4 = arrayList6;
                    }
                    for (int i10 = 0; i10 < size; i10++) {
                        String str = arrayList4.get(i10);
                        String str2 = arrayList3.get(i10);
                        String remove = yVar.remove(str2);
                        if (remove != null) {
                            yVar.put(str, remove);
                        } else {
                            yVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return yVar;
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z2) {
        if (!backStackRecord.mManager.getContainer().onHasView()) {
            return;
        }
        for (int size = backStackRecord.mOps.size() - 1; size >= 0; size--) {
            addToFirstInLastOut(backStackRecord, backStackRecord.mOps.get(size), sparseArray, true, z2);
        }
    }

    public static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z2, y<String, View> yVar, boolean z3) {
        if (z2) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static boolean canHandleAll(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static y<String, View> captureInSharedElements(FragmentTransitionImpl fragmentTransitionImpl, y<String, String> yVar, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList<String> arrayList;
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (!yVar.isEmpty() && obj != null && view != null) {
            y<String, View> yVar2 = new y<>();
            fragmentTransitionImpl.findNamedViews(yVar2, view);
            BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
            if (fragmentContainerTransition.lastInIsPop) {
                fragment.getExitTransitionCallback();
                arrayList = backStackRecord.mSharedElementSourceNames;
            } else {
                fragment.getEnterTransitionCallback();
                arrayList = backStackRecord.mSharedElementTargetNames;
            }
            if (arrayList != null) {
                yVar2.p(arrayList);
                yVar2.p(yVar.values());
            }
            retainValues(yVar, yVar2);
            return yVar2;
        }
        yVar.clear();
        return null;
    }

    private static y<String, View> captureOutSharedElements(FragmentTransitionImpl fragmentTransitionImpl, y<String, String> yVar, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        ArrayList<String> arrayList;
        if (!yVar.isEmpty() && obj != null) {
            Fragment fragment = fragmentContainerTransition.firstOut;
            y<String, View> yVar2 = new y<>();
            fragmentTransitionImpl.findNamedViews(yVar2, fragment.requireView());
            BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
            if (fragmentContainerTransition.firstOutIsPop) {
                fragment.getEnterTransitionCallback();
                arrayList = backStackRecord.mSharedElementTargetNames;
            } else {
                fragment.getExitTransitionCallback();
                arrayList = backStackRecord.mSharedElementSourceNames;
            }
            if (arrayList != null) {
                yVar2.p(arrayList);
            }
            yVar.p(yVar2.keySet());
            return yVar2;
        }
        yVar.clear();
        return null;
    }

    private static FragmentTransitionImpl chooseImpl(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = PLATFORM_IMPL;
        if (fragmentTransitionImpl != null && canHandleAll(fragmentTransitionImpl, arrayList)) {
            return fragmentTransitionImpl;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = SUPPORT_IMPL;
        if (fragmentTransitionImpl2 != null && canHandleAll(fragmentTransitionImpl2, arrayList)) {
            return fragmentTransitionImpl2;
        }
        if (fragmentTransitionImpl == null && fragmentTransitionImpl2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList<View> configureEnteringExitingViews(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View view2 = fragment.getView();
            if (view2 != null) {
                fragmentTransitionImpl.captureTransitioningViews(arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                arrayList2.add(view);
                fragmentTransitionImpl.addTargets(obj, arrayList2);
                return arrayList2;
            }
            return arrayList2;
        }
        return null;
    }

    private static Object configureSharedElementsOrdered(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, final View view, final y<String, String> yVar, final FragmentContainerTransition fragmentContainerTransition, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object sharedElementTransition;
        y<String, String> yVar2;
        Object obj3;
        Rect rect;
        final Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z2 = fragmentContainerTransition.lastInIsPop;
        if (yVar.isEmpty()) {
            yVar2 = yVar;
            sharedElementTransition = null;
        } else {
            sharedElementTransition = getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, z2);
            yVar2 = yVar;
        }
        y<String, View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl, yVar2, sharedElementTransition, fragmentContainerTransition);
        if (yVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(captureOutSharedElements.values());
            obj3 = sharedElementTransition;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z2, captureOutSharedElements, true);
        if (obj3 != null) {
            rect = new Rect();
            fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
            setOutEpicenter(fragmentTransitionImpl, obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            if (obj != null) {
                fragmentTransitionImpl.setEpicenter(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        final Rect rect2 = rect;
        co.y(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.6
            @Override // java.lang.Runnable
            public void run() {
                y<String, View> captureInSharedElements = FragmentTransition.captureInSharedElements(FragmentTransitionImpl.this, yVar, obj4, fragmentContainerTransition);
                if (captureInSharedElements != null) {
                    arrayList2.addAll(captureInSharedElements.values());
                    arrayList2.add(view);
                }
                FragmentTransition.callSharedElementStartEnd(fragment, fragment2, z2, captureInSharedElements, false);
                Object obj5 = obj4;
                if (obj5 != null) {
                    FragmentTransitionImpl.this.swapSharedElementTargets(obj5, arrayList, arrayList2);
                    View inEpicenterView = FragmentTransition.getInEpicenterView(captureInSharedElements, fragmentContainerTransition, obj, z2);
                    if (inEpicenterView != null) {
                        FragmentTransitionImpl.this.getBoundsOnScreen(inEpicenterView, rect2);
                    }
                }
            }
        });
        return obj3;
    }

    private static Object configureSharedElementsReordered(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, y<String, String> yVar, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object sharedElementTransition;
        Object obj3;
        final View view2;
        final Rect rect;
        final Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z2 = fragmentContainerTransition.lastInIsPop;
        if (yVar.isEmpty()) {
            sharedElementTransition = null;
        } else {
            sharedElementTransition = getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, z2);
        }
        y<String, View> captureOutSharedElements = captureOutSharedElements(fragmentTransitionImpl, yVar, sharedElementTransition, fragmentContainerTransition);
        final y<String, View> captureInSharedElements = captureInSharedElements(fragmentTransitionImpl, yVar, sharedElementTransition, fragmentContainerTransition);
        if (yVar.isEmpty()) {
            if (captureOutSharedElements != null) {
                captureOutSharedElements.clear();
            }
            if (captureInSharedElements != null) {
                captureInSharedElements.clear();
            }
            obj3 = null;
        } else {
            addSharedElementsWithMatchingNames(arrayList, captureOutSharedElements, yVar.keySet());
            addSharedElementsWithMatchingNames(arrayList2, captureInSharedElements, yVar.values());
            obj3 = sharedElementTransition;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        callSharedElementStartEnd(fragment, fragment2, z2, captureOutSharedElements, true);
        if (obj3 != null) {
            arrayList2.add(view);
            fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
            setOutEpicenter(fragmentTransitionImpl, obj3, obj2, captureOutSharedElements, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            Rect rect2 = new Rect();
            View inEpicenterView = getInEpicenterView(captureInSharedElements, fragmentContainerTransition, obj, z2);
            if (inEpicenterView != null) {
                fragmentTransitionImpl.setEpicenter(obj, rect2);
            }
            rect = rect2;
            view2 = inEpicenterView;
        } else {
            view2 = null;
            rect = null;
        }
        co.y(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.5
            @Override // java.lang.Runnable
            public void run() {
                FragmentTransition.callSharedElementStartEnd(Fragment.this, fragment2, z2, captureInSharedElements, false);
                View view3 = view2;
                if (view3 != null) {
                    fragmentTransitionImpl.getBoundsOnScreen(view3, rect);
                }
            }
        });
        return obj3;
    }

    private static void configureTransitionsOrdered(@NonNull ViewGroup viewGroup, FragmentContainerTransition fragmentContainerTransition, View view, y<String, String> yVar, final Callback callback) {
        Object obj;
        Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        FragmentTransitionImpl chooseImpl = chooseImpl(fragment2, fragment);
        if (chooseImpl == null) {
            return;
        }
        boolean z2 = fragmentContainerTransition.lastInIsPop;
        boolean z3 = fragmentContainerTransition.firstOutIsPop;
        Object enterTransition = getEnterTransition(chooseImpl, fragment, z2);
        Object exitTransition = getExitTransition(chooseImpl, fragment2, z3);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object configureSharedElementsOrdered = configureSharedElementsOrdered(chooseImpl, viewGroup, view, yVar, fragmentContainerTransition, arrayList, arrayList2, enterTransition, exitTransition);
        if (enterTransition == null && configureSharedElementsOrdered == null) {
            obj = exitTransition;
            if (obj == null) {
                return;
            }
        } else {
            obj = exitTransition;
        }
        ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(chooseImpl, obj, fragment2, arrayList, view);
        Object obj2 = (configureEnteringExitingViews == null || configureEnteringExitingViews.isEmpty()) ? null : null;
        chooseImpl.addTarget(enterTransition, view);
        Object mergeTransitions = mergeTransitions(chooseImpl, enterTransition, obj2, configureSharedElementsOrdered, fragment, fragmentContainerTransition.lastInIsPop);
        if (fragment2 != null && configureEnteringExitingViews != null && (configureEnteringExitingViews.size() > 0 || arrayList.size() > 0)) {
            final a aVar = new a();
            callback.onStart(fragment2, aVar);
            chooseImpl.setListenerForTransitionEnd(fragment2, mergeTransitions, aVar, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.3
                @Override // java.lang.Runnable
                public void run() {
                    Callback.this.onComplete(fragment2, aVar);
                }
            });
        }
        if (mergeTransitions != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            chooseImpl.scheduleRemoveTargets(mergeTransitions, enterTransition, arrayList3, obj2, configureEnteringExitingViews, configureSharedElementsOrdered, arrayList2);
            scheduleTargetChange(chooseImpl, viewGroup, fragment, view, arrayList2, enterTransition, arrayList3, obj2, configureEnteringExitingViews);
            chooseImpl.setNameOverridesOrdered(viewGroup, arrayList2, yVar);
            chooseImpl.beginDelayedTransition(viewGroup, mergeTransitions);
            chooseImpl.scheduleNameReset(viewGroup, arrayList2, yVar);
        }
    }

    private static void configureTransitionsReordered(@NonNull ViewGroup viewGroup, FragmentContainerTransition fragmentContainerTransition, View view, y<String, String> yVar, final Callback callback) {
        Object obj;
        Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        FragmentTransitionImpl chooseImpl = chooseImpl(fragment2, fragment);
        if (chooseImpl == null) {
            return;
        }
        boolean z2 = fragmentContainerTransition.lastInIsPop;
        boolean z3 = fragmentContainerTransition.firstOutIsPop;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object enterTransition = getEnterTransition(chooseImpl, fragment, z2);
        Object exitTransition = getExitTransition(chooseImpl, fragment2, z3);
        Object configureSharedElementsReordered = configureSharedElementsReordered(chooseImpl, viewGroup, view, yVar, fragmentContainerTransition, arrayList2, arrayList, enterTransition, exitTransition);
        if (enterTransition == null && configureSharedElementsReordered == null) {
            obj = exitTransition;
            if (obj == null) {
                return;
            }
        } else {
            obj = exitTransition;
        }
        ArrayList<View> configureEnteringExitingViews = configureEnteringExitingViews(chooseImpl, obj, fragment2, arrayList2, view);
        ArrayList<View> configureEnteringExitingViews2 = configureEnteringExitingViews(chooseImpl, enterTransition, fragment, arrayList, view);
        setViewVisibility(configureEnteringExitingViews2, 4);
        Object mergeTransitions = mergeTransitions(chooseImpl, enterTransition, obj, configureSharedElementsReordered, fragment, z2);
        if (fragment2 != null && configureEnteringExitingViews != null && (configureEnteringExitingViews.size() > 0 || arrayList2.size() > 0)) {
            final a aVar = new a();
            callback.onStart(fragment2, aVar);
            chooseImpl.setListenerForTransitionEnd(fragment2, mergeTransitions, aVar, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.1
                @Override // java.lang.Runnable
                public void run() {
                    Callback.this.onComplete(fragment2, aVar);
                }
            });
        }
        if (mergeTransitions != null) {
            replaceHide(chooseImpl, obj, fragment2, configureEnteringExitingViews);
            ArrayList<String> prepareSetNameOverridesReordered = chooseImpl.prepareSetNameOverridesReordered(arrayList);
            chooseImpl.scheduleRemoveTargets(mergeTransitions, enterTransition, configureEnteringExitingViews2, obj, configureEnteringExitingViews, configureSharedElementsReordered, arrayList);
            chooseImpl.beginDelayedTransition(viewGroup, mergeTransitions);
            chooseImpl.setNameOverridesReordered(viewGroup, arrayList2, arrayList, prepareSetNameOverridesReordered, yVar);
            setViewVisibility(configureEnteringExitingViews2, 0);
            chooseImpl.swapSharedElementTargets(configureSharedElementsReordered, arrayList2, arrayList);
        }
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition == null) {
            FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
            sparseArray.put(i, fragmentContainerTransition2);
            return fragmentContainerTransition2;
        }
        return fragmentContainerTransition;
    }

    public static String findKeyForValue(y<String, String> yVar, String str) {
        int size = yVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(yVar.xc(i))) {
                return yVar.f(i);
            }
        }
        return null;
    }

    private static Object getEnterTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z2) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z2) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return fragmentTransitionImpl.cloneTransition(enterTransition);
    }

    private static Object getExitTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z2) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z2) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return fragmentTransitionImpl.cloneTransition(exitTransition);
    }

    public static View getInEpicenterView(y<String, View> yVar, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z2) {
        ArrayList<String> arrayList;
        String str;
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj != null && yVar != null && (arrayList = backStackRecord.mSharedElementSourceNames) != null && !arrayList.isEmpty()) {
            if (z2) {
                str = backStackRecord.mSharedElementSourceNames.get(0);
            } else {
                str = backStackRecord.mSharedElementTargetNames.get(0);
            }
            return yVar.get(str);
        }
        return null;
    }

    private static Object getSharedElementTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z2) {
        Object sharedElementEnterTransition;
        if (fragment != null && fragment2 != null) {
            if (z2) {
                sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
            } else {
                sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
            }
            return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(sharedElementEnterTransition));
        }
        return null;
    }

    private static Object mergeTransitions(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z2) {
        boolean z3;
        if (obj != null && obj2 != null && fragment != null) {
            if (z2) {
                z3 = fragment.getAllowReturnTransitionOverlap();
            } else {
                z3 = fragment.getAllowEnterTransitionOverlap();
            }
        } else {
            z3 = true;
        }
        if (z3) {
            return fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3);
        }
        return fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    private static void replaceHide(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            co.y(fragment.mContainer, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.2
                @Override // java.lang.Runnable
                public void run() {
                    FragmentTransition.setViewVisibility(arrayList, 4);
                }
            });
        }
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        try {
            return (FragmentTransitionImpl) v.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void retainValues(@NonNull y<String, String> yVar, @NonNull y<String, View> yVar2) {
        for (int size = yVar.size() - 1; size >= 0; size--) {
            if (!yVar2.containsKey(yVar.xc(size))) {
                yVar.tl(size);
            }
        }
    }

    private static void scheduleTargetChange(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, final Fragment fragment, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        co.y(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransition.4
            @Override // java.lang.Runnable
            public void run() {
                Object obj3 = obj;
                if (obj3 != null) {
                    fragmentTransitionImpl.removeTarget(obj3, view);
                    arrayList2.addAll(FragmentTransition.configureEnteringExitingViews(fragmentTransitionImpl, obj, fragment, arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        fragmentTransitionImpl.replaceTargets(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static void setOutEpicenter(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, y<String, View> yVar, boolean z2, BackStackRecord backStackRecord) {
        String str;
        ArrayList<String> arrayList = backStackRecord.mSharedElementSourceNames;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z2) {
                str = backStackRecord.mSharedElementTargetNames.get(0);
            } else {
                str = backStackRecord.mSharedElementSourceNames.get(0);
            }
            View view = yVar.get(str);
            fragmentTransitionImpl.setEpicenter(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.setEpicenter(obj2, view);
            }
        }
    }

    public static void setViewVisibility(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    public static void startTransitions(@NonNull Context context, @NonNull FragmentContainer fragmentContainer, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i5, boolean z2, Callback callback) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i6 = i; i6 < i5; i6++) {
            BackStackRecord backStackRecord = arrayList.get(i6);
            if (arrayList2.get(i6).booleanValue()) {
                calculatePopFragments(backStackRecord, sparseArray, z2);
            } else {
                calculateFragments(backStackRecord, sparseArray, z2);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i8 = 0; i8 < size; i8++) {
                int keyAt = sparseArray.keyAt(i8);
                y<String, String> calculateNameOverrides = calculateNameOverrides(keyAt, arrayList, arrayList2, i, i5);
                FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i8);
                if (fragmentContainer.onHasView() && (viewGroup = (ViewGroup) fragmentContainer.onFindViewById(keyAt)) != null) {
                    if (z2) {
                        configureTransitionsReordered(viewGroup, fragmentContainerTransition, view, calculateNameOverrides, callback);
                    } else {
                        configureTransitionsOrdered(viewGroup, fragmentContainerTransition, view, calculateNameOverrides, callback);
                    }
                }
            }
        }
    }

    public static boolean supportsTransition() {
        if (PLATFORM_IMPL == null && SUPPORT_IMPL == null) {
            return false;
        }
        return true;
    }
}
