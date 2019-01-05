package reactivex.example.compositeDisposable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * reactive_stream_study
 * reactivex.example.compositeDisposable.CompositeDisposableExampleMain.java
 *
 * No.1とMNo.2の2つの購読を作成し、それぞれ購読を開始する。<br>
 * そのあと任意の時間スレッドを停止してから購読を解除するプログラム。<br>
 *
 * @author etsukanegae
 *
 */
public class CompositeDisposableExampleMain {

	/**
	 * No.1とNo.2の購読の最大値
	 */
	private static final int FLOWABLE_RANGE_END_1 = 70;
	private static final int FLOWABLE_RANGE_END_2 = 100;

	/**
	 * No.1とNo.2の購読１回にかかる時間[ms]
	 */
	private static final long FLOWABLE_THREAD_STOPPING_TIME_1 = 10L;
	private static final long FLOWABLE_THREAD_STOPPING_TIME_2 = 10L;

	private static final long THREAD_STOP_TIME_TO_DISPOSE = 200L;

	public static void main(String[] args) {

		CompositeDisposable cd = new CompositeDisposable();
		cd.add(
					Flowable.range(1, FLOWABLE_RANGE_END_1)
						.doOnCancel(() -> System.out.println(Thread.currentThread().getName() + ", No.1 Canceled"))
						.observeOn(Schedulers.computation())
						.subscribe(data -> {
								Thread.sleep(FLOWABLE_THREAD_STOPPING_TIME_1);
								System.out.println(Thread.currentThread().getName() + ", No.1 :" + data);
						})
				);

		cd.add(
					Flowable.range(1, FLOWABLE_RANGE_END_2)
						.doOnCancel(() -> System.out.println(Thread.currentThread().getName() + ", No.2 Canceled"))
						.observeOn(Schedulers.computation())
						.subscribe(data -> {
								Thread.sleep(FLOWABLE_THREAD_STOPPING_TIME_2);
								System.out.println(Thread.currentThread().getName() + ", No.2 :" + data);
						})
				);

		try {
			Thread.sleep(THREAD_STOP_TIME_TO_DISPOSE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + ", Willing to dispose.");
		cd.dispose(); //購読解除

	}

}
