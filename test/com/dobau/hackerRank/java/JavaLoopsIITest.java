package com.dobau.hackerRank.java;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.dobau.hackerRank.java.JavaLoopsII;

public class JavaLoopsIITest {

	private JavaLoopsII app = new JavaLoopsII();
	
	private void execute(String input, List<String> expected) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		app.main(null);

		List<String> founded = Arrays.asList(outContent.toString().split("\\r?\\n"))
										.stream()
										.map(String::trim)
										.collect(Collectors.toList());
		
		assertEquals(expected, founded);
	}

	@Test
	public void shouldCompare() {
		execute("2\n0 2 10\n5 3 5",
				Arrays.asList("2 6 14 30 62 126 254 510 1022 2046",
						      "8 14 26 50 98"));
	}

}
