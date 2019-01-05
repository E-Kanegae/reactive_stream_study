package reactivex.example.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

/**
 * reactive_stream_study
 * reactivex.example.maybe.MaybeExampleObserver.java
 *
 * TODO ここにクラスの説明を書いてください。
 *
 * @author etsukanegae
 *
 */
public class MaybeExampleObserver<DayOfWeek> implements MaybeObserver<DayOfWeek> {

	/* (非 Javadoc)
	 * @see io.reactivex.MaybeObserver#onSubscribe(io.reactivex.disposables.Disposable)
	 */
	@Override
	public void onSubscribe(Disposable d) {
		System.out.println("購読を開始します。");
	}

	/* (非 Javadoc)
	 * @see io.reactivex.MaybeObserver#onSuccess(java.lang.Object)
	 */
	@Override
	public void onSuccess(DayOfWeek d) {
		System.out.println(d);
	}

	/* (非 Javadoc)
	 * @see io.reactivex.MaybeObserver#onError(java.lang.Throwable)
	 */
	@Override
	public void onError(Throwable e) {
		System.out.println("エラー：" + e);

	}

	/* (非 Javadoc)
	 * @see io.reactivex.MaybeObserver#onComplete()
	 */
	@Override
	public void onComplete() {
		System.out.println("購読完了");
	}

}
