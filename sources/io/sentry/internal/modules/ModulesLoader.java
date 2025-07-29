package io.sentry.internal.modules;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public abstract class ModulesLoader implements IModulesLoader {
    public static final String EXTERNAL_MODULES_FILENAME = "sentry-external-modules.txt";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private Map<String, String> cachedModules = null;
    protected final ILogger logger;

    protected abstract Map<String, String> loadModules();

    public ModulesLoader(ILogger iLogger) {
        this.logger = iLogger;
    }

    @Override // io.sentry.internal.modules.IModulesLoader
    public Map<String, String> getOrLoadModules() {
        Map<String, String> map = this.cachedModules;
        if (map != null) {
            return map;
        }
        Map<String, String> mapLoadModules = loadModules();
        this.cachedModules = mapLoadModules;
        return mapLoadModules;
    }

    protected Map<String, String> parseStream(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader;
        TreeMap treeMap = new TreeMap();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
        } catch (IOException e) {
            this.logger.log(SentryLevel.ERROR, "Error extracting modules.", e);
        } catch (RuntimeException e2) {
            this.logger.log(SentryLevel.ERROR, e2, "%s file is malformed.", EXTERNAL_MODULES_FILENAME);
        }
        try {
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                int iLastIndexOf = line.lastIndexOf(58);
                treeMap.put(line.substring(0, iLastIndexOf), line.substring(iLastIndexOf + 1));
            }
            this.logger.log(SentryLevel.DEBUG, "Extracted %d modules from resources.", Integer.valueOf(treeMap.size()));
            bufferedReader.close();
            return treeMap;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
