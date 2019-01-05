package reactivex.example.single;

import java.time.DayOfWeek;
import java.time.LocalDate;

import io.reactivex.Single;

/**
 * reactive_stream_study
 * reactivex.example.single.SingleExampleMain.java
 *
 * 1件だけ通知を行うSingleクラスのExample<br>
 * for文で5回ループしているが、1回しか通知されない。
 *
 * @author etsukanegae
 *
 */
public class SingleExampleMain {

	public static void main(String[] args) {
		Single<DayOfWeek> single = Single.create(emitter -> {
			for( int i = 0; i < 5; i++ ) {
				emitter.onSuccess(LocalDate.now().getDayOfWeek());
			}
		});

		single.subscribe(new ExampleSingleObserver<DayOfWeek>());
	}

}
