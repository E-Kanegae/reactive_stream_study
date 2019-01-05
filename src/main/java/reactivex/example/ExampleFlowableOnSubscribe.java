package reactivex.example;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/**
 * reactive_stream_study
 * reactivex.example.ExampleFlowableOnSubscribe.java
 *
 * TODO ここにクラスの説明を書いてください。
 *
 * @author etsukanegae
 *
 */
public class ExampleFlowableOnSubscribe<T> implements FlowableOnSubscribe<String> {

	/* (非 Javadoc)
	 * @see io.reactivex.FlowableOnSubscribe#subscribe(io.reactivex.FlowableEmitter)
	 */
	public void subscribe(FlowableEmitter<String> emitter) throws Exception {
		List<String> datas = new ArrayList<String>();
		datas.add((String) "Hello World");
		datas.add((String) "こんにちは");

		for(String data : datas) {
			if(emitter.isCancelled()) {
				System.out.println(Thread.currentThread().getName() + "," + this.getClass().getName() + ": 解除します。");
				return;
			}
			System.out.println(Thread.currentThread().getName() + "," + this.getClass().getName() + ": 次のデータを通知します。");
			emitter.onNext(data);
		}
		System.out.println(Thread.currentThread().getName() + "," + this.getClass().getName() + ": 処理を完了します。");
		emitter.onComplete();
	}
}
