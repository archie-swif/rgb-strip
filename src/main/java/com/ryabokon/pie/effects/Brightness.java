package com.ryabokon.pie.effects;

import java.awt.*;
import java.io.*;

import com.ryabokon.pie.*;

public class Brightness extends Effect {

	private final long delay;
	private int startingBri = 0;

	public Brightness(FileOutputStream spi, long delay, int startingBri) {
		super(spi);
		this.delay = delay;
		this.startingBri = startingBri;
	}

	public Brightness(FileOutputStream spi, long delay) {
		super(spi);
		this.delay = delay;
	}

	@Override
	public void light() throws InterruptedException, IOException {
		Strip strip = new Strip();

		for (int b = startingBri; b <= 360; b++) {
			lightWithBri(strip, b);
		}
		startingBri = 0;

	}

	public void lightWithBri(Strip strip, int b) throws IOException, InterruptedException {
		Color c = ColorTools.getHSBPixel(40, 360, b);
		for (int j = 0; j < strip.getSize(); j++) {
			strip.setPixel(j, c);
		}
		flushStrip(strip);
		Thread.sleep(delay);
	}

}
