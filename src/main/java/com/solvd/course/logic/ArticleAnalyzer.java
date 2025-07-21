package com.solvd.course.logic;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ArticleAnalyzer {

    private static final List<String> SPECIAL_WORDS = Arrays.asList("Europe", "flight", "business", "economy");

    public static void analyze(File inputFile, File outputFile) {
        try {
            String content = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
            int count = 0;
            for (String word : SPECIAL_WORDS) {
                count += StringUtils.countMatches(content, word);
            }

            String result = String.format("[%s] Total special words found: %d%n", LocalDateTime.now(), count);
            FileUtils.writeStringToFile(outputFile, result, StandardCharsets.UTF_8, true); // append = true

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}