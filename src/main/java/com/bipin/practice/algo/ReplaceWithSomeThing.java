package com.bipin.practice.algo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReplaceWithSomeThing {

	public static void main(String[] args) throws IOException {
		Map<String, String> m = replaceWith();
		for (String s : getAllFiles()) {
			Path filePath = Paths.get(s);
			List<String> lines = Files.lines(filePath, Charset.forName("UTF-8")).collect(Collectors.toList());
			List<String> repalcedLines = lines.stream().map(line -> replaceWords(filePath, line, m))
					.collect(Collectors.toList());

			Files.write(filePath, repalcedLines, Charset.forName("UTF-8"));

		}
	}

	private static String replaceWords(Path filePath, String line, Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (line.contains(entry.getKey())) {
				line = line.replace(entry.getKey(), entry.getValue());
				System.out.println(filePath.toString());
			}
		}
		return line;
	}

	private static List<String> getAllFiles() throws IOException {
		List<String> propFileList = new LinkedList<String>();
		Files.walk(Paths.get("D:\\workspace\\trainingPython\\projects\\lovescloud\\azure-data-explorer-bug"))
				.filter(Files::isRegularFile).forEach(f -> {
					if (!f.toString().contains("venv") && f.toString().endsWith(".py")) {
						propFileList.add(f.toString());
					}
				});

		return propFileList;
	}

	private static Map<String, String> replaceWith() {
		Map<String, String> map = new HashMap<>();
		map.put("rollbar.", "# rollbar.");
		//map.put("# rollbar.", "rollbar.");
		return map;
	}

}
