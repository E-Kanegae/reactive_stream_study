package reactivex.example.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * reactive_stream_study
 * reactivex.example.single.ExampleSingleObserver.java
 *
 * TODO ここにクラスの説明を書いてください。
 *
 * @author etsukanegae
 * @param <T>
 *
 */
public class ExampleSingleObserver<T> implements SingleObserver<T> {

	/* (非 Javadoc)
	 * @see io.reactivex.SingleObserver#onSubscribe(io.reactivex.disposables.Disposable)
	 */
	@Override
	public void onSubscribe(Disposable d) {
		System.out.println("購読の準備ができました。");
	}

	/* (非 Javadoc)
	 * @see io.reactivex.SingleObserver#onSuccess(java.lang.Object)
	 */
	@Override
	public void onSuccess(T t) {
		System.out.println(t);
	}

	/* (非 Javadoc)
	 * @see io.reactivex.SingleObserver#onError(java.lang.Throwable)
	 */
	@Override
	public void onError(Throwable e) {
		System.out.println("エラー：" + e);
	}

}
