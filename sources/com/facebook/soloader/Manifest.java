package com.facebook.soloader;

import com.facebook.soloader.MinElf;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UShort;

/* loaded from: classes3.dex */
public class Manifest {
    public final String arch;
    public final List<String> libs;

    Manifest(String str, List<String> list) {
        this.arch = str;
        this.libs = Collections.unmodifiableList(list);
    }

    public static Manifest read(InputStream inputStream) throws IOException {
        return read(new DataInputStream(inputStream));
    }

    public static Manifest read(DataInputStream dataInputStream) throws IOException {
        String arch = readArch(dataInputStream);
        int i = dataInputStream.readShort() & UShort.MAX_VALUE;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(readLib(dataInputStream));
        }
        return new Manifest(arch, arrayList);
    }

    private static String readArch(DataInputStream dataInputStream) throws IOException {
        byte b = dataInputStream.readByte();
        if (b == 1) {
            return MinElf.ISA.AARCH64;
        }
        if (b == 2) {
            return MinElf.ISA.ARM;
        }
        if (b == 3) {
            return MinElf.ISA.X86_64;
        }
        if (b == 4) {
            return MinElf.ISA.X86;
        }
        throw new RuntimeException("Unrecognized arch id: " + ((int) b));
    }

    private static String readLib(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[dataInputStream.readShort() & UShort.MAX_VALUE];
        dataInputStream.readFully(bArr);
        return new String(bArr, StandardCharsets.UTF_8);
    }
}
