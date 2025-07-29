package expo.modules.taskManager.exceptions;

/* loaded from: classes5.dex */
public class TaskRegisteringFailedException extends Exception {
    public TaskRegisteringFailedException(Class cls, Exception exc) {
        super("Initializing task consumer '" + cls.getName() + "' failed. Inherited error: " + exc.getMessage());
    }
}
