package reactivex.example.maybe;

import java.time.DayOfWeek;
import java.time.LocalDate;

import io.reactivex.Maybe;

/**
 * reactive_stream_study
 * reactivex.example.maybe.MaybeExampleMain.java
 *
 *　購読通知、通知せず完了、エラー通知どれかの操作を1件だけ通知を行うMaybeクラスのExample
 * for文で5回ループしているが、1回しか通知されない。
 *
 * @author etsukanegae
 *
 */
public class MaybeExampleMain {

	public static void main(String[] args) {
		Maybe<DayOfWeek> maybe = Maybe.create(emitter -> {
			for(int i=0 ; i<5 ; i++) {
					emitter.onSuccess(LocalDate.now().getDayOfWeek());
			}
		});

		maybe.subscribe(new MaybeExampleObserver<DayOfWeek>());

	}

}
