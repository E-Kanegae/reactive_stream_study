package reactivex.example;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * reactive_stream_study
 * reactivex.example.ExampleSubscriber.java
 *
 * TODO ここにクラスの説明を書いてください。
 *
 * @author etsukanegae
 *
 */
public class ExampleSubscriber implements Subscriber<String> {

	/**
	 *
	 */
	private Subscription subscription;

	/* (非 Javadoc)
	 * @see org.reactivestreams.Subscriber#onSubscribe(org.reactivestreams.Subscription)
	 */
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		System.out.println(Thread.currentThread().getName() + "," + this.getClass().getName() + ": 購読開始をお願いします。");
		this.subscription.request(1L);
	}

	/* (非 Javadoc)
	 * @see org.reactivestreams.Subscriber#onNext(java.lang.Object)
	 */
	public void onNext(String data) {
		System.out.println(Thread.currentThread().getName() + "," + this.getClass().getName() + ": データを受信しました。");
		System.out.println(Thread.currentThread().getName() +  "," + this.getClass().getName() + ": " + data);
		this.subscription.request(1L);
	}

	/* (非 Javadoc)
	 * @see org.reactivestreams.Subscriber#onError(java.lang.Throwable)
	 */
	public void onError(Throwable e) {
		e.printStackTrace();
	}

	/* (非 Javadoc)
	 * @see org.reactivestreams.Subscriber#onComplete()
	 */
	public void onComplete() {
		System.out.println(Thread.currentThread().getName() + "," + this.getClass().getName() + ": 購読完了通知を受けました。");
	}

}
