package reactivex.example;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

/**
 * reactive_stream_study
 * reactivex.example.ExampleSubscriber.java
 *
 * SampleのMainクラス
 * Flowableを作成して、subscribeを開始する。<br>
 *
 * @author etsukanegae
 *
 */
public class ReactiveXExampleMain {

	public static void main(String[] args) throws InterruptedException {

		Flowable<String> flowable = Flowable.create(
				new ExampleFlowableOnSubscribe<String>() {}, BackpressureStrategy.BUFFER);

		flowable
			.observeOn(Schedulers.computation())
			.subscribe(new ExampleSubscriber(){});

		Thread.sleep(1000L);
		System.out.println(Thread.currentThread().getName() + ": 全処理完了。");
	}

}
