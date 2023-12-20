package com.proftelran.org.homework_15;

import java.io.File;

public class FileOperationsMain {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        fileManager.createFileWithText("testFile.txt");
        File desktopFile = fileManager.createFileOnDesktop("testFile.txt");
        fileManager.deleteFile(desktopFile);

       DirectoryManager directoryManager = new DirectoryManager();
        File directory = directoryManager.createDirectoryOnDesktop("testDirectory");
        directoryManager.deleteDirectory(directory);
    }
}
