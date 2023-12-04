package com.josiah.training.exercises.katas.AOC_23;

import java.nio.file.Files;
import java.nio.file.Paths;

/****************************************************************************
 * <b>Title:</b> AOC
 * <b>Project:</b> intro-to-java
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2023
 * <b>Company:</b> Silicon Mountain Technologies
 *
 * @author Josiah Webb
 * @version 3.x
 * @since 12/4/23
 * <b>updates:</b>
 *
 ****************************************************************************/

public class AOC {
    public static void main(String[] args) throws Exception {
        System.out.println(day1(readFileAsString("./input.txt")));
    }

    public static String readFileAsString(String fileName) throws Exception {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static int day1(String input) {
        System.out.println(input);
        return 1;
    }
}
