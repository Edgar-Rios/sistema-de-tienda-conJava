package myLib;

import java.time.LocalTime;

public class HorasIguales {
	public static boolean test(LocalTime a, LocalTime b) {
		return a.getHour() == b.getHour() && a.getMinute() == b.getMinute();
	}
}
