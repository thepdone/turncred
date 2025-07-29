package expo.modules.splashscreen;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* compiled from: SplashScreenModule.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lexpo/modules/splashscreen/SplashScreenOptions;", "Lexpo/modules/kotlin/records/Record;", "()V", "duration", "", "getDuration$annotations", "getDuration", "()J", "fade", "", "getFade$annotations", "getFade", "()Z", "setFade", "(Z)V", "expo-splash-screen_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SplashScreenOptions implements Record {
    private final long duration = 400;
    private boolean fade = true;

    @Field
    public static /* synthetic */ void getDuration$annotations() {
    }

    @Field
    public static /* synthetic */ void getFade$annotations() {
    }

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getFade() {
        return this.fade;
    }

    public final void setFade(boolean z) {
        this.fade = z;
    }
}
