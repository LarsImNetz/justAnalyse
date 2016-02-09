package clicker;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.text.NumberFormat;

public class MyClicker {
	public static void main(String[] argv) throws AWTException, InterruptedException {

//		calcCookies("Farms", 491);
//		calcCookies("Factory", 2941);
//		calcCookies("Mine", 9801);
//		calcCookies("Shipment", 39204);
		autoSpeedClicker();
	}


	private static void autoSpeedClicker() throws AWTException, InterruptedException {
		Robot robot = new Robot();

		Thread.sleep(3000);
int WAIT=0;

		int n = (1000 / (4 + 3 + WAIT)) * 60 * 60 * 24;
		while (n > 0) {
			robot.mousePress(InputEvent.BUTTON1_MASK);
			Thread.sleep(4);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			Thread.sleep(3 + WAIT);
			n--;
		}
		System.out.println("fertig!");
	}

	
	public static void calcCookies(String building, long start) {
		long value = start;
		System.out.println("Num: " + 1 + " Cookies:" + format(value));
		long sum = start;
		for (int i=0;i<200;i++) {
			Double nextValue = value * 1.15;
			value =+ nextValue.longValue();
			System.out.println("Num: " + (i + 1) + " Cookies:" + format(value));
			sum += value;
		}
		System.out.println("Sum of Cookies for "+ building +" need: " + format(sum));
	}
	
	public static String format(long number) {
		return  NumberFormat.getInstance().format(number);
	}
}
