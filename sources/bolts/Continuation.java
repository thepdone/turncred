package bolts;

/* loaded from: classes4.dex */
public interface Continuation<TTaskResult, TContinuationResult> {
    TContinuationResult then(Task<TTaskResult> task) throws Exception;
}
