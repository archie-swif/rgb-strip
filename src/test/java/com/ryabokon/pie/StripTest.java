package com.ryabokon.pie;

import java.awt.*;

import junit.framework.*;

import org.testng.annotations.Test;

public class StripTest {

	@Test
	public void testBlueStrip() {

		Strip strip = new Strip();
		for (int i = 0; i < strip.getSize(); i++) {
			strip.setPixel(i, Color.BLUE);
		}

		byte[] data = strip.toArray();

		for (int i = 0; i < data.length; i++) {
			byte color = data[i];
			System.out.println(color);
			if ((i + 1) % 3 == 0) {
				Assert.assertEquals(-1, color);
			} else {
				Assert.assertEquals(0, color);
			}

		}

	}

	@Test
	public void testUncompleteStrip() {

		Strip strip = new Strip();
		strip.setPixel(5, Color.WHITE);

		byte[] data = strip.toArray();

		for (int i = 0; i < data.length; i++) {
			byte color = data[i];
			System.out.println(color);
			if (i >= 15 && i <= 17) {
				Assert.assertEquals(-1, color);
			} else {
				Assert.assertEquals(0, color);
			}

		}

	}
}
