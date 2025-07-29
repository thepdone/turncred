package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class GlideExperiments {
    private final Map<Class<?>, Experiment> experiments;

    interface Experiment {
    }

    GlideExperiments(Builder builder) {
        this.experiments = Collections.unmodifiableMap(new HashMap(builder.experiments));
    }

    <T extends Experiment> T get(Class<T> cls) {
        return (T) this.experiments.get(cls);
    }

    public boolean isEnabled(Class<? extends Experiment> cls) {
        return this.experiments.containsKey(cls);
    }

    static final class Builder {
        private final Map<Class<?>, Experiment> experiments = new HashMap();

        Builder() {
        }

        Builder update(Experiment experiment, boolean z) {
            if (z) {
                add(experiment);
            } else {
                this.experiments.remove(experiment.getClass());
            }
            return this;
        }

        Builder add(Experiment experiment) {
            this.experiments.put(experiment.getClass(), experiment);
            return this;
        }

        GlideExperiments build() {
            return new GlideExperiments(this);
        }
    }
}
