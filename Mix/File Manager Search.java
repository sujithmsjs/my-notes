package com.suji.perfectsearch;

import java.io.File;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class PerfectSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfectSearchApplication.class, args);
		File root = new File("D:\\Notes\\my-notes");
		log.info("File existed : " + root.exists());

		// Exact Word Search
//		Pattern pattern = Pattern.compile("(\\s|[^a-z])" + "java" + "(\\s|[^a-z])", Pattern.CASE_INSENSITIVE);
//		String input = "import JaVa.util.Ar java rayList 4545JAVA34";
//		Matcher matcher = pattern.matcher(input);
//
//		while (matcher.find()) {
//			int start = matcher.start();
//			int end = matcher.end();
//
//			start = start - 20 <= 0 ? 0 : start - 20;
//			end = end + 20 >= input.length() ? input.length() : end + 20;
//
//			log.info("Check : " + matcher.group() + " " + start + "-" + end + " > " + input.substring(start, end));
//		}

		search(root);
		System.out.println("Search END");
		
	}

	public static void search(File root) {
		if (root.isFile()) {
			// System.out.println("File: "+root.getName());
			String search = "love";

			try {
				String data = Files.readString(root.toPath());

				// boolean find = Pattern.compile(Pattern.quote(search),
				// Pattern.CASE_INSENSITIVE).matcher(data).find();

				Pattern pattern = Pattern.compile("(\\s|[^a-z])" + search + "(\\s|[^a-z])", Pattern.CASE_INSENSITIVE);
				Matcher matcher = pattern.matcher(data);

//				if (matcher.find()) {
//
//					matcher.regionStart();
//					System.out.println(
//							"___________________________________________________________________________________");
//					System.out.println(root.getPath());
//					int of = data.indexOf(search);
//					int start = of - 40 <= 0 ? 0 : of - 40;
//					int end = data.length() > of + search.length() + 40 ? of + 40 + search.length() : data.length();
//					System.out.println("Content(" + matcher.group() + ") '" + data.substring(start, end) + "' ");
//					System.out.println();
//
//				}

				boolean find = matcher.find();
				if (find) {
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println("---------------------------------------------------------------------");
					System.out.println(root.getPath());
					System.out.println("---------------------------------------------------------------------");
				}
				int index = 1;
				while (find) {
					
					if (find) {
						System.out.println("___(" + index + ")___");
						index++;
					}
					
					int start = matcher.start();
					int end = matcher.end();

					start = start - 20 <= 0 ? 0 : start - 20;
					end = end + 20 >= data.length() ? data.length() : end + 20;

					System.out.println("Check : " + matcher.group() + " " + start + "-" + end + " > "
							+ data.substring(start, end));

					System.out.println();

					find = matcher.find();
					
				}

			} catch (Exception e) {
				// log.error(root.getPath() + " " + e.getMessage());
			}

		} else if (root.isDirectory()) {
			// System.out.println("Folder : "+root.getName());
			File[] listFiles = root.listFiles();
			for (File f : listFiles) {
				search(f);
			}

		}

	}

}
