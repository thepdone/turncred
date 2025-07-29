package io.sentry.android.core.internal.threaddump;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class Lines {
    private final ArrayList<? extends Line> mList;
    private final int mMax;
    private final int mMin = 0;
    public int pos;

    public static Lines readLines(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            Lines lines = readLines(bufferedReader);
            bufferedReader.close();
            return lines;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static Lines readLines(BufferedReader bufferedReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                i++;
                arrayList.add(new Line(i, line));
            } else {
                return new Lines(arrayList);
            }
        }
    }

    public Lines(ArrayList<? extends Line> arrayList) {
        this.mList = arrayList;
        this.mMax = arrayList.size();
    }

    public boolean hasNext() {
        return this.pos < this.mMax;
    }

    public Line next() {
        int i = this.pos;
        if (i < this.mMin || i >= this.mMax) {
            return null;
        }
        ArrayList<? extends Line> arrayList = this.mList;
        this.pos = i + 1;
        return arrayList.get(i);
    }

    public void rewind() {
        this.pos--;
    }
}
