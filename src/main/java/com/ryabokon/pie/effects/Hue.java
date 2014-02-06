package com.ryabokon.pie.effects;

import java.awt.*;
import java.io.*;

import com.ryabokon.pie.*;

public class Hue extends Effect {

	private final long delay;
	private int startingHue = 0;

	public Hue(FileOutputStream spi, long delay, int startingHue) {
		super(spi);
		this.delay = delay;
		this.startingHue = startingHue;
	}

	public Hue(FileOutputStream spi, long delay) {
		super(spi);
		this.delay = delay;
	}

	@Override
	public void light() throws InterruptedException, IOException {
		Strip strip = new Strip();

		for (int h = startingHue; h <= 360; h++) {
			lightWithHue(strip, h);
		}
		startingHue = 0;

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
