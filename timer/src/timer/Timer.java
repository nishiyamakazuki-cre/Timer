package timer;

import java.time.LocalDateTime;

public class Timer {

	public static int time() {
		int[] hour = new int[6];
		int[] minute = new int[6];
		int flag = 0;

		hour[0] = 10;
		hour[1] = 11;
		hour[2] = 12;
		hour[3] = 14;
		hour[4] = 15;
		hour[5] = 16;

		minute[0] = 20;
		minute[1] = 20;
		minute[2] = 20;
		minute[3] = 10;
		minute[4] = 10;
		minute[5] = 10;

		LocalDateTime i1 = LocalDateTime.now();

		int h = i1.getHour();
		int m = i1.getMinute();

		int ha = 0;
		int ma = 0;

		for (int a = 0; a < 6; a++) {
			if (hour[a] == h) {
				if (minute[a] < m) {
					ha = hour[a + 1];
					ma = minute[a + 1];
				} else if (minute[a] >= m) {
					ha = hour[a];
					ma = minute[a];
				}
			}
		}

		if (ha != h) {
			flag = 0;
		} else if (ha == h) {
			if (ma - m > 10) {
				flag = 0;
			} else {
				if (ma - m > 1) {
					flag = 1;
				} else if (ma == m) {
					flag = 3;
				} else {
					flag = 2;
				}
			}
		}

		return flag;
	}
	
	public static void wait(int flag)throws Exception {
		switch (flag) {
		case 0:
			Thread.sleep(600000);
			break;
		case 1:
			Thread.sleep(60000);
			break;
		case 2:
			Thread.sleep(300);
			break;
		case 3:
			Music.music();
			break;
		}
	}

}
