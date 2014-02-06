package com.ryabokon.pie;

import java.io.*;

import com.ryabokon.pie.effects.*;

public class Showtime {

	public Showtime() throws FileNotFoundException {

	}

	public static void main(String... args) throws Throwable {
		FileOutputStream spidev = new FileOutputStream(new File("/dev/spidev0.0"));

		Effect effect = new Seeker(spidev, 100);
		while (true) {
			effect.light();
		}

	}
}
