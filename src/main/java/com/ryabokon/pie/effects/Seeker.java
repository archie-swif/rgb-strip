package com.ryabokon.pie.effects;

import java.awt.*;
import java.io.*;
import java.util.*;

import com.ryabokon.pie.*;

public class Seeker extends Effect {

	private final long delay;

	public Seeker(FileOutputStream spi, long delay) {
		super(spi);
		this.delay = delay;
	}

	@Override
	public void light() throws InterruptedException, IOException {
		Strip strip = new Strip();

		Color seeker = ColorTools.getRandomBrightPixel();
		Boolean trapped = true;
		int postion = new Random().nextInt(strip.getSize());

		while (trapped) {

			for (int i = 0; i < strip.getSize(); i++) {
				if (i == postion) {
					strip.setPixel(i, seeker);
				} else {
					strip.setPixel(i, Color.BLACK);
				}
			}
			flushStrip(strip);
			Thread.sleep(delay);

			boolean direction = new Random().nextBoolean();
			if (direction) {
				postion++;
			} else {
				postion--;
			}

			if (postion < 0 || postion >= strip.getSize()) {
				break;
			}
		}

	}
}
