package com.ryabokon.pie.effects;

import java.awt.*;
import java.io.*;

import com.ryabokon.pie.*;

public class Sat extends Effect {

	private final long delay;
	private int startingSat = 0;

	public Sat(FileOutputStream spi, long delay, int startingSat) {
		super(spi);
		this.delay = delay;
		this.startingSat = startingSat;
	}

	public Sat(FileOutputStream spi, long delay) {
		super(spi);
		this.delay = delay;
	}

	@Override
	public void light() throws InterruptedException, IOException {
		Strip strip = new Strip();

		for (int s = 360; s >= 0; s--) {
			lightWithSat(strip, s);
		}
		startingSat = 0;

	}

	public void lightWithSat(Strip strip, int s) throws IOException, InterruptedException {
		Color c = ColorTools.getHSBPixel(40, s, 360);
		System.out.println(s);
		for (int j = 0; j < strip.getSize(); j++) {
			strip.setPixel(j, c);
		}
		flushStrip(strip);
		Thread.sleep(delay);
	}

}
