package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
/* loaded from: classes3.dex */
final class zbv implements LoaderManager.LoaderCallbacks {
    final /* synthetic */ SignInHubActivity zba;

    /* synthetic */ zbv(SignInHubActivity signInHubActivity, zbw zbwVar) {
        this.zba = signInHubActivity;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final Loader onCreateLoader(int i, Bundle bundle) {
        return new zbc(this.zba, GoogleApiClient.getAllClients());
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final /* bridge */ /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        SignInHubActivity signInHubActivity = this.zba;
        signInHubActivity.setResult(signInHubActivity.zbe, signInHubActivity.zbf);
        this.zba.finish();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final void onLoaderReset(Loader loader) {
    }
}
