package com.ryabokon.pie.effects;

import java.awt.*;
import java.io.*;

import com.ryabokon.pie.*;

public class Chase extends Effect {

	private final long delay;

	public Chase(FileOutputStream spi, long delay) {
		super(spi);
		this.delay = delay;
	}

	@Override
	public void light() throws InterruptedException, IOException {
		Strip strip = new Strip();

		Color pi = ColorTools.getRandomBrightPixel();

		for (int i = 0; i < strip.getSize(); i++) {
			for (int j = 0; j < strip.getSize(); j++) {
				if (i == j) {
					strip.setPixel(j, pi);

				} else {
					strip.setPixel(j, new Color(0, 0, 0));
				}

			}
			flushStrip(strip);
			Thread.sleep(delay);
		}

	}

}
