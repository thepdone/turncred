package com.nimbusds.jose.util;

import net.jcip.annotations.Immutable;

@Immutable
/* loaded from: classes5.dex */
public class Resource {
    private final String content;
    private final String contentType;

    public Resource(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("The resource content must not be null");
        }
        this.content = str;
        this.contentType = str2;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }
}
