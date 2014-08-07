package com.ryabokon.pie.effects;

import java.awt.*;
import java.io.*;

import com.ryabokon.pie.*;

public class Ukraine extends Effect {

	public Ukraine(FileOutputStream spi) {
		super(spi);
	}

	@Override
	public void light() throws InterruptedException, IOException {
		Strip strip = new Strip();
		Color colorOne = new Color(0, 128, 255);
		Color colorTwo = new Color(255, 128, 0);
		for (int i = 0; i < strip.getSize(); i++) {

			if (i < (strip.getSize() / 2)) {
				strip.setPixel(i, colorOne);
			} else {
				strip.setPixel(i, colorTwo);
			}

		}

		flushStrip(strip);
		Thread.sleep(5000);

	}

}
