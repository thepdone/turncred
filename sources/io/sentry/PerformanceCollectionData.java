package io.sentry;

/* loaded from: classes5.dex */
public final class PerformanceCollectionData {
    private MemoryCollectionData memoryData = null;
    private CpuCollectionData cpuData = null;

    public void addMemoryData(MemoryCollectionData memoryCollectionData) {
        if (memoryCollectionData != null) {
            this.memoryData = memoryCollectionData;
        }
    }

    public void addCpuData(CpuCollectionData cpuCollectionData) {
        if (cpuCollectionData != null) {
            this.cpuData = cpuCollectionData;
        }
    }

    public CpuCollectionData getCpuData() {
        return this.cpuData;
    }

    public MemoryCollectionData getMemoryData() {
        return this.memoryData;
    }
}
