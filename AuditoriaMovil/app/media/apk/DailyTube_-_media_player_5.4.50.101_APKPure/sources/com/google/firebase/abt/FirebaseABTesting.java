package com.google.firebase.abt;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class FirebaseABTesting {
    private final AnalyticsConnector analyticsConnector;
    @Nullable
    private Integer maxUserProperties;
    private final String originService;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OriginService {
    }

    public FirebaseABTesting(Context context, AnalyticsConnector analyticsConnector, String str) {
        this.analyticsConnector = analyticsConnector;
        this.originService = str;
    }

    private void addExperimentToAnalytics(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        this.analyticsConnector.setConditionalUserProperty(conditionalUserProperty);
    }

    private void addExperiments(List<AbtExperimentInfo> list) {
        ArrayDeque arrayDeque = new ArrayDeque(getAllExperimentsInAnalytics());
        int maxUserPropertiesInAnalytics = getMaxUserPropertiesInAnalytics();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            while (arrayDeque.size() >= maxUserPropertiesInAnalytics) {
                removeExperimentFromAnalytics(((AnalyticsConnector.ConditionalUserProperty) arrayDeque.pollFirst()).name);
            }
            AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = abtExperimentInfo.toConditionalUserProperty(this.originService);
            addExperimentToAnalytics(conditionalUserProperty);
            arrayDeque.offer(conditionalUserProperty);
        }
    }

    private static List<AbtExperimentInfo> convertMapsToExperimentInfos(List<Map<String, String>> list) throws AbtException {
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> map : list) {
            arrayList.add(AbtExperimentInfo.fromMap(map));
        }
        return arrayList;
    }

    private List<AnalyticsConnector.ConditionalUserProperty> getAllExperimentsInAnalytics() {
        return this.analyticsConnector.getConditionalUserProperties(this.originService, "");
    }

    private ArrayList<AbtExperimentInfo> getExperimentsToAdd(List<AbtExperimentInfo> list, Set<String> set) {
        ArrayList<AbtExperimentInfo> arrayList = new ArrayList<>();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            if (!set.contains(abtExperimentInfo.getExperimentId())) {
                arrayList.add(abtExperimentInfo);
            }
        }
        return arrayList;
    }

    private ArrayList<AnalyticsConnector.ConditionalUserProperty> getExperimentsToRemove(List<AnalyticsConnector.ConditionalUserProperty> list, Set<String> set) {
        ArrayList<AnalyticsConnector.ConditionalUserProperty> arrayList = new ArrayList<>();
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : list) {
            if (!set.contains(conditionalUserProperty.name)) {
                arrayList.add(conditionalUserProperty);
            }
        }
        return arrayList;
    }

    private int getMaxUserPropertiesInAnalytics() {
        if (this.maxUserProperties == null) {
            this.maxUserProperties = Integer.valueOf(this.analyticsConnector.getMaxUserProperties(this.originService));
        }
        return this.maxUserProperties.intValue();
    }

    private void removeExperimentFromAnalytics(String str) {
        this.analyticsConnector.clearConditionalUserProperty(str, null, null);
    }

    private void removeExperiments(Collection<AnalyticsConnector.ConditionalUserProperty> collection) {
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : collection) {
            removeExperimentFromAnalytics(conditionalUserProperty.name);
        }
    }

    private void replaceAllExperimentsWith(List<AbtExperimentInfo> list) throws AbtException {
        if (list.isEmpty()) {
            removeAllExperiments();
            return;
        }
        HashSet hashSet = new HashSet();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            hashSet.add(abtExperimentInfo.getExperimentId());
        }
        List<AnalyticsConnector.ConditionalUserProperty> allExperimentsInAnalytics = getAllExperimentsInAnalytics();
        HashSet hashSet2 = new HashSet();
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : allExperimentsInAnalytics) {
            hashSet2.add(conditionalUserProperty.name);
        }
        removeExperiments(getExperimentsToRemove(allExperimentsInAnalytics, hashSet));
        addExperiments(getExperimentsToAdd(list, hashSet2));
    }

    private void throwAbtExceptionIfAnalyticsIsNull() throws AbtException {
        if (this.analyticsConnector != null) {
            return;
        }
        throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
    }

    public List<AbtExperimentInfo> getAllExperiments() throws AbtException {
        throwAbtExceptionIfAnalyticsIsNull();
        List<AnalyticsConnector.ConditionalUserProperty> allExperimentsInAnalytics = getAllExperimentsInAnalytics();
        ArrayList arrayList = new ArrayList();
        for (AnalyticsConnector.ConditionalUserProperty conditionalUserProperty : allExperimentsInAnalytics) {
            arrayList.add(AbtExperimentInfo.fromConditionalUserProperty(conditionalUserProperty));
        }
        return arrayList;
    }

    public void removeAllExperiments() throws AbtException {
        throwAbtExceptionIfAnalyticsIsNull();
        removeExperiments(getAllExperimentsInAnalytics());
    }

    public void replaceAllExperiments(List<Map<String, String>> list) throws AbtException {
        throwAbtExceptionIfAnalyticsIsNull();
        if (list != null) {
            replaceAllExperimentsWith(convertMapsToExperimentInfos(list));
            return;
        }
        throw new IllegalArgumentException("The replacementExperiments list is null.");
    }

    public void reportActiveExperiment(AbtExperimentInfo abtExperimentInfo) throws AbtException {
        throwAbtExceptionIfAnalyticsIsNull();
        AbtExperimentInfo.validateAbtExperimentInfo(abtExperimentInfo);
        ArrayList arrayList = new ArrayList();
        Map<String, String> stringMap = abtExperimentInfo.toStringMap();
        stringMap.remove("triggerEvent");
        arrayList.add(AbtExperimentInfo.fromMap(stringMap));
        addExperiments(arrayList);
    }

    public void validateRunningExperiments(List<AbtExperimentInfo> list) throws AbtException {
        throwAbtExceptionIfAnalyticsIsNull();
        HashSet hashSet = new HashSet();
        for (AbtExperimentInfo abtExperimentInfo : list) {
            hashSet.add(abtExperimentInfo.getExperimentId());
        }
        removeExperiments(getExperimentsToRemove(getAllExperimentsInAnalytics(), hashSet));
    }
}
