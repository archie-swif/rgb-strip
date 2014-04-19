package com.ryabokon.pie.effects;

import java.awt.*;
import java.io.*;

import com.ryabokon.pie.*;

public class SingleHue extends Effect {

	private final long delay;
	private int hue = 15;

	public SingleHue(FileOutputStream spi, long delay, int hue) {
		super(spi);
		this.delay = delay;
		this.hue = hue;
	}

	public SingleHue(FileOutputStream spi, long delay) {
		super(spi);
		this.delay = delay;
	}

	@Override
	public void light() throws InterruptedException, IOException {
		Strip strip = new Strip();

		int left = hue - 5;
		int right = hue + 10;

		for (int i = left; i <= right; i++) {
			int h = i;

			if (h < 0) {
				h += 360;
			}

			else if (h > 360) {
				h -= 360;
			}
			lightWithHue(strip, h);
		}

		for (int i = right; i >= left; i--) {
			int h = i;

			if (h < 0) {
				h += 360;
			}

			else if (h > 360) {
				h -= 360;
			}
			lightWithHue(strip, h);
		}

	}

	public void lightWithHue(Strip strip, int h) throws IOException, InterruptedException {
		Color c = ColorTools.getHSBPixel(h, 360, 360);
		System.out.println(h + " : " + c);
		for (int j = 0; j < strip.getSize(); j++) {
			strip.setPixel(j, c);
		}
		flushStrip(strip);
		Thread.sleep(delay);
	}

}
