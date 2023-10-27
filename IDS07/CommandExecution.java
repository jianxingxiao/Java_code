package IDS07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandExecution {
    public static void main(String[] args) {
        String untrustedData = "d: && echo test";
        String validatedData = validateInput(untrustedData);
        executeCommand(validatedData);
    }

    // 输入验证和过滤
    private static String validateInput(String untrustedData) {
        // 此处可以根据实际需求进行输入验证和过滤，确保数据的安全性
        // 这里仅作示例，直接返回原始不受信任数据
        return untrustedData;
    }

    // 执行命令
    private static void executeCommand(String command) {
        try {
            // 根据操作系统确定命令
            String os = System.getProperty("os.name").toLowerCase();
            String[] cmd;
            if (os.contains("win")) {
                cmd = new String[]{"cmd.exe", "/c", command};
            } else {
                cmd = new String[]{"sh", "-c", command};
            }

            // 创建进程构建器
            ProcessBuilder pb = new ProcessBuilder(cmd);

            // 启动进程并等待其执行完成
            Process process = pb.start();
            int result = process.waitFor();

            // 处理命令执行结果
            if (result == 0) {
                // 读取命令输出
                String output = readCommandOutput(process.getInputStream());
                System.out.println("命令执行成功");
                System.out.println("输出：\n" + output);
            } else {
                // 读取错误输出
                String errorOutput = readCommandOutput(process.getErrorStream());
                System.out.println("命令执行失败");
                System.out.println("错误输出：\n" + errorOutput);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 逐行读取输入流的内容
    private static String readCommandOutput(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}