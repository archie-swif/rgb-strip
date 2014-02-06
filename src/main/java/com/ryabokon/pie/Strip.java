package com.ryabokon.pie;

import java.awt.*;
import java.util.*;

public class Strip {

	final int size = 25;

	private final HashMap<Integer, Color> pixels;

	public Strip() {
		this.pixels = new HashMap<Integer, Color>(size);
	}

	public void setPixel(int position, Color color) throws IndexOutOfBoundsException {
		if (doesPixelFitStrip(position)) {
			pixels.put(position, color);
		}
	}

	public void setPixel(int position, int red, int green, int blue) {
		setPixel(position, new Color(red, green, blue));
	}

	public Color getPixel(int position) {
		return pixels.get(position);
	}

	public int getSize() {
		return size;
	}

	public HashMap<Integer, Color> getPixels() {
		return pixels;
	}

	private boolean doesPixelFitStrip(int position) {
		if (position < 0 || position >= size) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.pixels.toString();
	}

	public byte[] toArray() {
		byte[] data = new byte[size * 3];
		for (Integer i : pixels.keySet()) {
			Color pixel = pixels.get(i);
			byte[] src = new byte[] { (byte) pixel.getRed(), (byte) pixel.getGreen(), (byte) pixel.getBlue() };
			System.arraycopy(src, 0, data, i * 3, 3);
		}
		return data;
	}

}
