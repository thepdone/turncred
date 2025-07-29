package io.sentry.transport;

import io.sentry.util.Objects;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/* loaded from: classes5.dex */
final class ProxyAuthenticator extends Authenticator {
    private final String password;
    private final String user;

    ProxyAuthenticator(String str, String str2) {
        this.user = (String) Objects.requireNonNull(str, "user is required");
        this.password = (String) Objects.requireNonNull(str2, "password is required");
    }

    @Override // java.net.Authenticator
    protected PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType() == Authenticator.RequestorType.PROXY) {
            return new PasswordAuthentication(this.user, this.password.toCharArray());
        }
        return null;
    }

    String getUser() {
        return this.user;
    }

    String getPassword() {
        return this.password;
    }
}
