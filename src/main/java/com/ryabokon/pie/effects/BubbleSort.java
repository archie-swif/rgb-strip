package com.ryabokon.pie.effects;

import java.awt.*;
import java.io.*;

import com.ryabokon.pie.*;

public class BubbleSort extends Effect {

	private final long delay;
	private Strip strip;

	public BubbleSort(FileOutputStream spi, long delay) {
		super(spi);
		this.delay = delay;
	}

	@Override
	public void light() throws Throwable {
		this.strip = ColorTools.getShuffledFullRainbowStrip();

		flushStrip(strip);
		Thread.sleep(delay);

		for (int i = 0; i <= strip.getSize(); i++) {
			for (int j = 0; j < strip.getSize() - 1 - i; j++) {
				Color a = strip.getPixel(j);
				Color b = strip.getPixel(j + 1);
				float hueA = Color.RGBtoHSB(a.getRed(), a.getGreen(), a.getBlue(), null)[0];
				float hueB = Color.RGBtoHSB(b.getRed(), b.getGreen(), b.getBlue(), null)[0];
				if (hueA < hueB) {
					flash(j, j + 1, 2, delay / 10);
					strip.setPixel(j, b);
					strip.setPixel(j + 1, a);
					flushStrip(strip);
				} else {
					flash(j, j + 1, 1, delay / 10);
				}
				Thread.sleep(delay);
			}

		}

	}

	private void flash(int a, int b, int flashes, long sleepTime) throws Throwable {
		Color colorA = strip.getPixel(a);
		Color colorB = strip.getPixel(b);

		for (int i = 0; i < flashes; i++) {
			strip.setPixel(a, Color.black);
			strip.setPixel(b, Color.black);
			flushStrip(strip);
			Thread.sleep(sleepTime);

			strip.setPixel(a, colorA);
			strip.setPixel(b, colorB);
			flushStrip(strip);
			Thread.sleep(sleepTime);
		}

	}

}
