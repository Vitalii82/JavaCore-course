package com.solvd.course;

import com.solvd.course.logic.ArticleAnalyzer;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File input = new File("src/main/resources/article.txt");
        File output = new File("src/main/resources/analysis_output.txt");

        ArticleAnalyzer.analyze(input, output);

        System.out.println("Analysis complete. Check 'analysis_output.txt' for results.");
    }
}