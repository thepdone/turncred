package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class DataSources {
    private DataSources() {
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        SimpleDataSource simpleDataSourceCreate = SimpleDataSource.create();
        simpleDataSourceCreate.setFailure(th);
        return simpleDataSourceCreate;
    }

    public static <T> DataSource<T> immediateDataSource(T t) {
        SimpleDataSource simpleDataSourceCreate = SimpleDataSource.create();
        simpleDataSourceCreate.setResult(t);
        return simpleDataSourceCreate;
    }

    public static DataSource<Void> immediateSuccessfulDataSource() {
        return SuccessfulVoidDataSource.INSTANCE;
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(final Throwable th) {
        return new Supplier<DataSource<T>>() { // from class: com.facebook.datasource.DataSources.1
            @Override // com.facebook.common.internal.Supplier
            public DataSource<T> get() {
                return DataSources.immediateFailedDataSource(th);
            }
        };
    }

    @Nullable
    public static <T> T waitForFinalResult(DataSource<T> dataSource) throws Throwable {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ValueHolder valueHolder = new ValueHolder();
        final ValueHolder valueHolder2 = new ValueHolder();
        dataSource.subscribe(new DataSubscriber<T>() { // from class: com.facebook.datasource.DataSources.2
            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource2) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource<T> dataSource2) {
                if (dataSource2.isFinished()) {
                    try {
                        valueHolder.value = dataSource2.getResult();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource<T> dataSource2) {
                try {
                    valueHolder2.value = (T) dataSource2.getFailureCause();
                } finally {
                    countDownLatch.countDown();
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource<T> dataSource2) {
                countDownLatch.countDown();
            }
        }, new Executor() { // from class: com.facebook.datasource.DataSources.3
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                runnable.run();
            }
        });
        countDownLatch.await();
        if (valueHolder2.value != null) {
            throw ((Throwable) valueHolder2.value);
        }
        return valueHolder.value;
    }

    private static class ValueHolder<T> {

        @Nullable
        public T value;

        private ValueHolder() {
            this.value = null;
        }
    }
}
