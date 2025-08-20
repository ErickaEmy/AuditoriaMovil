package com.uv.v7;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class MMKVOptimizer {
    private static final String TAG = "SplitCompatDexLoader";
    private static int sPatchDexCount;

    /* loaded from: classes.dex */
    public static final class n3 {
        public static void n3(ClassLoader classLoader, List<File> list, File file, Boolean bool) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            String[] list2;
            int size = list.size();
            file.setWritable(bool.booleanValue());
            for (int i = 0; i < size; i++) {
                list.get(i).setReadOnly();
            }
            long currentTimeMillis = System.currentTimeMillis();
            Object obj = u6.y.n3(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            Object[] zn2 = zn(obj, new ArrayList(list), file, arrayList);
            if (!bool.booleanValue()) {
                u6.y.y(obj, "dexElements", zn2);
            }
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    Log.e(MMKVOptimizer.TAG, "Exception in makePathElement", iOException);
                    throw iOException;
                }
            }
            Log.i("Dex2oatTest", "needOpt = " + bool + " , cost = " + (System.currentTimeMillis() - currentTimeMillis));
            file.setWritable(true);
            for (String str : file.list()) {
                Log.i("Dex2oatTest", "filename = " + str);
            }
        }

        public static Object[] zn(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Method zn2;
            try {
                zn2 = u6.y.zn(obj, "makePathElements", List.class, File.class, List.class);
            } catch (NoSuchMethodException unused) {
                Log.e(MMKVOptimizer.TAG, "NoSuchMethodException: makePathElements(List,File,List) failure");
                try {
                    zn2 = u6.y.zn(obj, "makePathElements", ArrayList.class, File.class, ArrayList.class);
                } catch (NoSuchMethodException unused2) {
                    Log.e(MMKVOptimizer.TAG, "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                    try {
                        Log.w(MMKVOptimizer.TAG, "NoSuchMethodException: try use v19 instead");
                        return y.gv(obj, arrayList, file, arrayList2);
                    } catch (NoSuchMethodException e2) {
                        Log.e(MMKVOptimizer.TAG, "NoSuchMethodException: makeDexElements(List,File,List) failure");
                        throw e2;
                    }
                }
            }
            return (Object[]) zn2.invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* loaded from: classes.dex */
    public static final class y {
        public static Object[] gv(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Method zn2;
            try {
                zn2 = u6.y.zn(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } catch (NoSuchMethodException unused) {
                Log.e(MMKVOptimizer.TAG, "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                try {
                    zn2 = u6.y.zn(obj, "makeDexElements", List.class, File.class, List.class);
                } catch (NoSuchMethodException e2) {
                    Log.e(MMKVOptimizer.TAG, "NoSuchMethodException: makeDexElements(List,File,List) failure");
                    throw e2;
                }
            }
            return (Object[]) zn2.invoke(obj, arrayList, file, arrayList2);
        }

        public static void zn(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            Object obj = u6.y.n3(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            u6.y.y(obj, "dexElements", gv(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    Log.e(MMKVOptimizer.TAG, "Exception in makeDexElement", iOException);
                    throw iOException;
                }
            }
        }
    }

    public static void load(ClassLoader classLoader, File file, List<File> list, Boolean bool) throws Throwable {
        if (!list.isEmpty()) {
            if (Build.VERSION.SDK_INT >= 23) {
                n3.n3(classLoader, list, file, bool);
            } else {
                y.zn(classLoader, list, file);
            }
            sPatchDexCount = list.size();
        }
    }

    public static void unLoad(ClassLoader classLoader) throws Throwable {
        if (sPatchDexCount <= 0) {
            return;
        }
        u6.y.gv(u6.y.n3(classLoader, "pathList").get(classLoader), "dexElements", sPatchDexCount);
    }
}
