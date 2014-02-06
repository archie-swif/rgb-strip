package com.ryabokon.pie.effects;

import java.io.*;

import com.ryabokon.pie.*;

public abstract class Effect {

	private final FileOutputStream spi;

	public Effect(FileOutputStream spi) {
		this.spi = spi;
	}

	public abstract void light() throws Throwable;

	public void flushStrip(Strip strip) throws IOException {
		byte[] data;
		data = strip.toArray();
		spi.write(data);
		spi.flush();
	}

}