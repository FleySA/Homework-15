package com.proftelran.org.homework_15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {

    public void createFileWithText(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            String text = "This is my first experience when I myself work with IO API. I can do everything!";
            fos.write(text.getBytes());
            System.out.println("Файл успешно создан: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File createFileOnDesktop(String fileName) {
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        File file = new File(desktopPath, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл успешно создан на рабочем столе: " + fileName);
            } else {
                System.out.println("Файл уже существует на рабочем столе: " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public void deleteFile(File file) {
        if (file.delete()) {
            System.out.println("Файл успешно удален: " + file.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить файл: " + file.getAbsolutePath());
        }
    }
}

