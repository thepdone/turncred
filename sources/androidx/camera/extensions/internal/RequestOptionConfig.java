package androidx.camera.extensions.internal;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.extensions.internal.RequestOptionConfig;

/* loaded from: classes.dex */
public class RequestOptionConfig implements ReadableConfig {
    static final String CAPTURE_REQUEST_ID_STEM = "camera2.captureRequest.option.";
    private Config mConfig;

    private RequestOptionConfig(Config config) {
        this.mConfig = config;
    }

    @Override // androidx.camera.core.impl.ReadableConfig
    public Config getConfig() {
        return this.mConfig;
    }

    static Config.Option<Object> createOptionFromKey(CaptureRequest.Key<?> key) {
        return Config.Option.create("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }

    public static class Builder {
        private MutableOptionsBundle mMutableOptionsBundle = MutableOptionsBundle.create();

        public static Builder from(final Config config) {
            final Builder builder = new Builder();
            config.findOptions("camera2.captureRequest.option.", new Config.OptionMatcher() { // from class: androidx.camera.extensions.internal.RequestOptionConfig$Builder$$ExternalSyntheticLambda0
                @Override // androidx.camera.core.impl.Config.OptionMatcher
                public final boolean onOptionMatched(Config.Option option) {
                    return RequestOptionConfig.Builder.lambda$from$0(this.f$0, config, option);
                }
            });
            return builder;
        }

        static /* synthetic */ boolean lambda$from$0(Builder builder, Config config, Config.Option option) {
            builder.mMutableOptionsBundle.insertOption(option, config.getOptionPriority(option), config.retrieveOption(option));
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ValueT> Builder setCaptureRequestOption(CaptureRequest.Key<ValueT> key, ValueT valuet) {
            this.mMutableOptionsBundle.insertOption(RequestOptionConfig.createOptionFromKey(key), valuet);
            return this;
        }

        public RequestOptionConfig build() {
            return new RequestOptionConfig(OptionsBundle.from(this.mMutableOptionsBundle));
        }
    }
}
