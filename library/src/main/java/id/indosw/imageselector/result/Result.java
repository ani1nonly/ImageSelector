package id.indosw.imageselector.result;

import id.indosw.imageselector.PhotoSelector;

import java.io.File;

@SuppressWarnings({"FieldMayBeFinal", "NullableProblems"})
public abstract class Result<T> {

    private PhotoSelector.ResultCallback<T> callback;

    Result(PhotoSelector.ResultCallback<T> callback) {
        this.callback = callback;
    }

    public void run(File file) {
        new ResultAsyncTask<>(this, file).execute();
    }

    void callback(T t) {
        this.callback.onImageResult(t);
    }

    abstract T onImageResult(File file);

    @Override
    public String toString() {
        return "Result{" +
                "callback=" + callback +
                '}';
    }
}
