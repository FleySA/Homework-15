package com.proftelran.org.homework_15;

import java.io.File;

public class DirectoryManager {
    public File createDirectoryOnDesktop(String directoryName) {
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        File directory = new File(desktopPath, directoryName);
        if (directory.mkdir()) {
            System.out.println("Директория успешно создана на рабочем столе: " + directoryName);
        } else {
            System.out.println("Директория уже существует на рабочем столе: " + directoryName);
        }
        return directory;
    }

    public void deleteDirectory(File directory) {
        if (!directory.exists()) {
            System.out.println("Директория не существует: " + directory.getAbsolutePath());
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    new FileManager().deleteFile(file);
                }
            }
        }

        if (directory.delete()) {
            System.out.println("Директория успешно удалена: " + directory.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить директорию: " + directory.getAbsolutePath());
        }
    }
}
