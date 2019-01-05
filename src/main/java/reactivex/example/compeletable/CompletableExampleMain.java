package reactivex.example.compeletable;

import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

/**
 * reactive_stream_study
 * reactivex.example.compeletable.CompletableExampleMain.java
 *
 *
 *
 * @author etsukanegae
 *
 */
public class CompletableExampleMain {

	public static void main(String[] args) throws InterruptedException {
		Completable comp = Completable.create(emitter -> {
			emitter.onComplete();
		});

		comp
			.subscribeOn(Schedulers.computation()) //別スレッドで起動する。
			.subscribe(new CompletableExampleObserver());
		Thread.sleep(500L);
		System.out.println(Thread.currentThread().getName() + ": Mainスレッドの処理を終了します。");
	}

}
