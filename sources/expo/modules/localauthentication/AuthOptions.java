package expo.modules.localauthentication;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* compiled from: LocalAuthenticationRecords.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\t8\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lexpo/modules/localauthentication/AuthOptions;", "Lexpo/modules/kotlin/records/Record;", "()V", "biometricsSecurityLevel", "Lexpo/modules/localauthentication/BiometricsSecurityLevel;", "getBiometricsSecurityLevel$annotations", "getBiometricsSecurityLevel", "()Lexpo/modules/localauthentication/BiometricsSecurityLevel;", "cancelLabel", "", "getCancelLabel$annotations", "getCancelLabel", "()Ljava/lang/String;", "disableDeviceFallback", "", "getDisableDeviceFallback$annotations", "getDisableDeviceFallback", "()Z", "promptMessage", "getPromptMessage$annotations", "getPromptMessage", "requireConfirmation", "getRequireConfirmation$annotations", "getRequireConfirmation", "expo-local-authentication_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthOptions implements Record {
    private final boolean disableDeviceFallback;
    private final String promptMessage = "";
    private final String cancelLabel = "";
    private final boolean requireConfirmation = true;
    private final BiometricsSecurityLevel biometricsSecurityLevel = BiometricsSecurityLevel.WEAK;

    @Field
    public static /* synthetic */ void getBiometricsSecurityLevel$annotations() {
    }

    @Field
    public static /* synthetic */ void getCancelLabel$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisableDeviceFallback$annotations() {
    }

    @Field
    public static /* synthetic */ void getPromptMessage$annotations() {
    }

    @Field
    public static /* synthetic */ void getRequireConfirmation$annotations() {
    }

    public final String getPromptMessage() {
        return this.promptMessage;
    }

    public final String getCancelLabel() {
        return this.cancelLabel;
    }

    public final boolean getDisableDeviceFallback() {
        return this.disableDeviceFallback;
    }

    public final boolean getRequireConfirmation() {
        return this.requireConfirmation;
    }

    public final BiometricsSecurityLevel getBiometricsSecurityLevel() {
        return this.biometricsSecurityLevel;
    }
}
