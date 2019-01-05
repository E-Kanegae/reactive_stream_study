package reactivex.example.compeletable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

/**
 * reactive_stream_study
 * reactivex.example.compeletable.CompletableExampleObserver.java
 *
 * TODO ここにクラスの説明を書いてください。
 *
 * @author etsukanegae
 *
 */
public class CompletableExampleObserver implements CompletableObserver {

	/* (非 Javadoc)
	 * @see io.reactivex.CompletableObserver#onSubscribe(io.reactivex.disposables.Disposable)
	 */
	@Override
	public void onSubscribe(Disposable d) {
		System.out.println(Thread.currentThread().getName() + ":購読を開始します。");
	}

	/* (非 Javadoc)
	 * @see io.reactivex.CompletableObserver#onComplete()
	 */
	@Override
	public void onComplete() {
		System.out.println(Thread.currentThread().getName() + ": 購読を完了します。");
	}

	/* (非 Javadoc)
	 * @see io.reactivex.CompletableObserver#onError(java.lang.Throwable)
	 */
	@Override
	public void onError(Throwable e) {
		System.out.println(Thread.currentThread().getName() + "エラー：" + e);
	}

}
