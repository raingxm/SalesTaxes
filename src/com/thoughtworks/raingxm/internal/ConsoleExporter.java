package com.thoughtworks.raingxm.internal;

import com.thoughtworks.raingxm.Exporter;

public class ConsoleExporter implements Exporter {

	@Override
	public void output(String words) {
		System.out.println(words);
	}

	@Override
	public void end() {
		
	}
}
