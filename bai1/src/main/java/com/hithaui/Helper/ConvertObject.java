package com.hithaui.Helper;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class ConvertObject {
	
	private static final Pattern NON_LATIN = Pattern.compile("[^\\w-]");

	private static final Pattern WHITE_SPACE = Pattern.compile("[\\s]");

	public static String toSlug(String input) {
		input = input.trim().replaceAll("\\s+", " ");
		String noWhiteSpace = WHITE_SPACE.matcher(input).replaceAll("-");
		String normalized = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD);
		String slug = NON_LATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.ENGLISH);
	}

}
