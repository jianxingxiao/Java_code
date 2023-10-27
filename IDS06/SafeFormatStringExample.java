package IDS06;

import java.util.Scanner;

public class SafeFormatStringExample {
    public static void main(String[] args) {
        String userInput = getUserInput(); // 获取用户输入
        String formatString = getValidatedFormatString(userInput); // 进行验证的格式化字符串
        String output = String.format(formatString, someData); // 格式化输出
        System.out.println(output);
    }

    private static String getUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a valid format string: ");
            return scanner.nextLine();
        }
    }

    private static String getValidatedFormatString(String userInput) {
        // 在这里对用户输入的格式化字符串进行验证，确保它符合预期的格式
        if (userInput.contains("%s")) {
            return userInput;
        } else {
            System.out.println("Invalid format string. Using default format.");
            return "%s";
        }
    }

    private static String someData = "Some data";
}