package com.ryabokon.pie.effects;

import java.awt.*;
import java.io.*;

import com.ryabokon.pie.*;

public class HSB extends Effect {

	private final long delay;

	public HSB(FileOutputStream spi, long delay, int startingSat) {
		super(spi);
		this.delay = delay;

	}

	public HSB(FileOutputStream spi, long delay) {
		super(spi);
		this.delay = delay;
	}

	@Override
	public void light() throws InterruptedException, IOException {
		Strip strip = new Strip();

		for (int i = 0; i < 25; i++) {

			for (int b = 0; b <= 360; b++) {
				lightWithBri(strip, b, i * 15);
			}
			for (int s = 360; s >= 0; s--) {
				lightWithSat(strip, s, i * 15);
			}

			i++;
			for (int s = 0; s <= 360; s++) {
				lightWithSat(strip, s, i * 15);
			}
			for (int b = 360; b >= 0; b--) {
				lightWithBri(strip, b, i * 15);
			}

		}

	}

	public void lightWithSat(Strip strip, int sat, int hue) throws IOException, InterruptedException {
		Color c = ColorTools.getHSBPixel(hue, sat, 360);
		for (int j = 0; j < strip.getSize(); j++) {
			strip.setPixel(j, c);
		}
		flushStrip(strip);
		Thread.sleep(delay);
	}

	public void lightWithBri(Strip strip, int bri, int hue) throws IOException, InterruptedException {
		Color c = ColorTools.getHSBPixel(hue, 360, bri);
		for (int j = 0; j < strip.getSize(); j++) {
			strip.setPixel(j, c);
		}
		flushStrip(strip);
		Thread.sleep(delay);
	}

}
