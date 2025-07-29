package com.facebook.soloader;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedByInterruptException;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes3.dex */
public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;
    private static final String TAG = "MinElf";

    public interface ISA {
        public static final String AARCH64 = "arm64-v8a";
        public static final String ARM = "armeabi-v7a";
        public static final String X86 = "x86";
        public static final String X86_64 = "x86_64";
    }

    public static String[] extract_DT_NEEDED(File file) throws IOException {
        ElfFileChannel elfFileChannel = new ElfFileChannel(file);
        try {
            String[] strArrExtract_DT_NEEDED = extract_DT_NEEDED(elfFileChannel);
            elfFileChannel.close();
            return strArrExtract_DT_NEEDED;
        } catch (Throwable th) {
            try {
                elfFileChannel.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String[] extract_DT_NEEDED_with_retries(ElfFileChannel elfFileChannel) throws IOException {
        int i = 0;
        while (true) {
            try {
                return extract_DT_NEEDED_no_retries(elfFileChannel);
            } catch (ClosedByInterruptException e) {
                i++;
                if (i > 4) {
                    throw e;
                }
                Thread.interrupted();
                LogUtil.e(TAG, "retrying extract_DT_NEEDED due to ClosedByInterruptException", e);
                elfFileChannel.openChannel();
            }
        }
    }

    public static String[] extract_DT_NEEDED(ElfByteChannel elfByteChannel) throws IOException {
        if (elfByteChannel instanceof ElfFileChannel) {
            return extract_DT_NEEDED_with_retries((ElfFileChannel) elfByteChannel);
        }
        return extract_DT_NEEDED_no_retries(elfByteChannel);
    }

    private static String[] extract_DT_NEEDED_no_retries(ElfByteChannel elfByteChannel) throws IOException {
        long j;
        long j2;
        String str;
        long j3;
        long j4;
        long j5;
        String str2;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long j12 = getu32(elfByteChannel, byteBufferAllocate, 0L);
        if (j12 != 1179403647) {
            throw new ElfError("file is not ELF: magic is 0x" + Long.toHexString(j12) + ", it should be " + Long.toHexString(1179403647L));
        }
        boolean z = getu8(elfByteChannel, byteBufferAllocate, 4L) == 1;
        if (getu8(elfByteChannel, byteBufferAllocate, 5L) == 2) {
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        }
        long j13 = z ? getu32(elfByteChannel, byteBufferAllocate, 28L) : get64(elfByteChannel, byteBufferAllocate, 32L);
        long j14 = z ? getu16(elfByteChannel, byteBufferAllocate, 44L) : getu16(elfByteChannel, byteBufferAllocate, 56L);
        int i = getu16(elfByteChannel, byteBufferAllocate, z ? 42L : 54L);
        if (j14 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            long j15 = z ? getu32(elfByteChannel, byteBufferAllocate, 32L) : get64(elfByteChannel, byteBufferAllocate, 40L);
            if (z) {
                j14 = getu32(elfByteChannel, byteBufferAllocate, j15 + 28);
            } else {
                j14 = getu32(elfByteChannel, byteBufferAllocate, j15 + 44);
            }
        }
        long j16 = j13;
        long j17 = 0;
        while (true) {
            if (j17 >= j14) {
                j = 0;
                break;
            }
            if (z) {
                j11 = getu32(elfByteChannel, byteBufferAllocate, j16);
            } else {
                j11 = getu32(elfByteChannel, byteBufferAllocate, j16);
            }
            if (j11 != 2) {
                j16 += i;
                j17++;
            } else if (z) {
                j = getu32(elfByteChannel, byteBufferAllocate, j16 + 4);
            } else {
                j = get64(elfByteChannel, byteBufferAllocate, j16 + 8);
            }
        }
        if (j == 0) {
            throw new ElfError("ELF file does not contain dynamic linking information");
        }
        long j18 = j;
        int i2 = 0;
        long j19 = 0;
        do {
            j2 = z ? getu32(elfByteChannel, byteBufferAllocate, j18) : get64(elfByteChannel, byteBufferAllocate, j18);
            if (j2 == 1) {
                if (i2 != Integer.MAX_VALUE) {
                    i2++;
                    str = "malformed DT_NEEDED section";
                } else {
                    throw new ElfError("malformed DT_NEEDED section");
                }
            } else if (j2 == 5) {
                str = "malformed DT_NEEDED section";
                j19 = z ? getu32(elfByteChannel, byteBufferAllocate, j18 + 4) : get64(elfByteChannel, byteBufferAllocate, j18 + 8);
            } else {
                str = "malformed DT_NEEDED section";
            }
            j18 += z ? 8L : 16L;
        } while (j2 != 0);
        if (j19 == 0) {
            throw new ElfError("Dynamic section string-table not found");
        }
        long j20 = j13;
        int i3 = 0;
        while (true) {
            if (i3 >= j14) {
                j3 = j;
                j4 = 0;
                j5 = 0;
                break;
            }
            if (z) {
                j6 = getu32(elfByteChannel, byteBufferAllocate, j20);
            } else {
                j6 = getu32(elfByteChannel, byteBufferAllocate, j20);
            }
            if (j6 == 1) {
                if (z) {
                    j7 = j14;
                    j8 = getu32(elfByteChannel, byteBufferAllocate, j20 + 8);
                } else {
                    j7 = j14;
                    j8 = get64(elfByteChannel, byteBufferAllocate, j20 + 16);
                }
                if (z) {
                    j3 = j;
                    j9 = getu32(elfByteChannel, byteBufferAllocate, j20 + 20);
                } else {
                    j3 = j;
                    j9 = get64(elfByteChannel, byteBufferAllocate, j20 + 40);
                }
                if (j8 <= j19 && j19 < j9 + j8) {
                    if (z) {
                        j10 = getu32(elfByteChannel, byteBufferAllocate, j20 + 4);
                    } else {
                        j10 = get64(elfByteChannel, byteBufferAllocate, j20 + 8);
                    }
                    j5 = j10 + (j19 - j8);
                    j4 = 0;
                }
            } else {
                j7 = j14;
                j3 = j;
            }
            j20 += i;
            i3++;
            j14 = j7;
            j = j3;
        }
        if (j5 == j4) {
            throw new ElfError("did not find file offset of DT_STRTAB table");
        }
        String[] strArr = new String[i2];
        long j21 = j3;
        int i4 = 0;
        while (true) {
            long j22 = z ? getu32(elfByteChannel, byteBufferAllocate, j21) : get64(elfByteChannel, byteBufferAllocate, j21);
            if (j22 == 1) {
                strArr[i4] = getSz(elfByteChannel, byteBufferAllocate, (z ? getu32(elfByteChannel, byteBufferAllocate, j21 + 4) : get64(elfByteChannel, byteBufferAllocate, j21 + 8)) + j5);
                if (i4 == Integer.MAX_VALUE) {
                    throw new ElfError(str);
                }
                i4++;
                str2 = str;
            } else {
                str2 = str;
            }
            j21 += z ? 8L : 16L;
            if (j22 == 0) {
                if (i4 == i2) {
                    return strArr;
                }
                throw new ElfError(str2);
            }
            str = str2;
        }
    }

    private static String getSz(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short u8Var = getu8(elfByteChannel, byteBuffer, j);
            if (u8Var != 0) {
                sb.append((char) u8Var);
                j = j2;
            } else {
                return sb.toString();
            }
        }
    }

    private static void read(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        int i2;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (i2 = elfByteChannel.read(byteBuffer, j)) != -1) {
            j += i2;
        }
        if (byteBuffer.remaining() > 0) {
            throw new ElfError("ELF file truncated");
        }
        byteBuffer.position(0);
    }

    private static long get64(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 8, j);
        return byteBuffer.getLong();
    }

    private static long getu32(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 4, j);
        return byteBuffer.getInt() & 4294967295L;
    }

    private static int getu16(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 2, j);
        return byteBuffer.getShort() & UShort.MAX_VALUE;
    }

    private static short getu8(ElfByteChannel elfByteChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(elfByteChannel, byteBuffer, 1, j);
        return (short) (byteBuffer.get() & 255);
    }

    protected static class ElfError extends UnsatisfiedLinkError {
        ElfError(String str) {
            super(str);
        }
    }
}
