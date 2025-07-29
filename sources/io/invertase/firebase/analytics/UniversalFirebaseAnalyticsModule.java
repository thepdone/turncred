package io.invertase.firebase.analytics;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.invertase.firebase.common.UniversalFirebaseModule;
import java.util.EnumMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public class UniversalFirebaseAnalyticsModule extends UniversalFirebaseModule {
    UniversalFirebaseAnalyticsModule(Context context, String str) {
        super(context, str);
    }

    Task<Void> logEvent(final String str, final Bundle bundle) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$logEvent$0(str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$logEvent$0(String str, Bundle bundle) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).logEvent(str, bundle);
        return null;
    }

    Task<Void> setAnalyticsCollectionEnabled(final Boolean bool) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$setAnalyticsCollectionEnabled$1(bool);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$setAnalyticsCollectionEnabled$1(Boolean bool) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).setAnalyticsCollectionEnabled(bool.booleanValue());
        return null;
    }

    Task<Void> setSessionTimeoutDuration(final long j) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$setSessionTimeoutDuration$2(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$setSessionTimeoutDuration$2(long j) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).setSessionTimeoutDuration(j);
        return null;
    }

    Task<String> getAppInstanceId() {
        return FirebaseAnalytics.getInstance(getContext()).getAppInstanceId();
    }

    Task<Long> getSessionId() {
        return FirebaseAnalytics.getInstance(getContext()).getSessionId();
    }

    Task<Void> setUserId(final String str) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$setUserId$3(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$setUserId$3(String str) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).setUserId(str);
        return null;
    }

    Task<Void> setUserProperty(final String str, final String str2) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$setUserProperty$4(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$setUserProperty$4(String str, String str2) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).setUserProperty(str, str2);
        return null;
    }

    Task<Void> setUserProperties(final Bundle bundle) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$setUserProperties$5(bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$setUserProperties$5(Bundle bundle) throws Exception {
        Set<String> setKeySet = bundle.keySet();
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(getContext());
        for (String str : setKeySet) {
            firebaseAnalytics.setUserProperty(str, (String) bundle.get(str));
        }
        return null;
    }

    Task<Void> resetAnalyticsData() {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$resetAnalyticsData$6();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$resetAnalyticsData$6() throws Exception {
        FirebaseAnalytics.getInstance(getContext()).resetAnalyticsData();
        return null;
    }

    Task<Void> setDefaultEventParameters(final Bundle bundle) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$setDefaultEventParameters$7(bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$setDefaultEventParameters$7(Bundle bundle) throws Exception {
        FirebaseAnalytics.getInstance(getContext()).setDefaultEventParameters(bundle);
        return null;
    }

    Task<Void> setConsent(final Bundle bundle) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.analytics.UniversalFirebaseAnalyticsModule$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$setConsent$8(bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$setConsent$8(Bundle bundle) throws Exception {
        boolean z = bundle.getBoolean("analytics_storage");
        boolean z2 = bundle.getBoolean("ad_storage");
        boolean z3 = bundle.getBoolean("ad_user_data");
        boolean z4 = bundle.getBoolean("ad_personalization");
        EnumMap enumMap = new EnumMap(FirebaseAnalytics.ConsentType.class);
        enumMap.put((EnumMap) FirebaseAnalytics.ConsentType.ANALYTICS_STORAGE, (FirebaseAnalytics.ConsentType) (z ? FirebaseAnalytics.ConsentStatus.GRANTED : FirebaseAnalytics.ConsentStatus.DENIED));
        enumMap.put((EnumMap) FirebaseAnalytics.ConsentType.AD_STORAGE, (FirebaseAnalytics.ConsentType) (z2 ? FirebaseAnalytics.ConsentStatus.GRANTED : FirebaseAnalytics.ConsentStatus.DENIED));
        enumMap.put((EnumMap) FirebaseAnalytics.ConsentType.AD_USER_DATA, (FirebaseAnalytics.ConsentType) (z3 ? FirebaseAnalytics.ConsentStatus.GRANTED : FirebaseAnalytics.ConsentStatus.DENIED));
        enumMap.put((EnumMap) FirebaseAnalytics.ConsentType.AD_PERSONALIZATION, (FirebaseAnalytics.ConsentType) (z4 ? FirebaseAnalytics.ConsentStatus.GRANTED : FirebaseAnalytics.ConsentStatus.DENIED));
        FirebaseAnalytics.getInstance(getContext()).setConsent(enumMap);
        return null;
    }
}
