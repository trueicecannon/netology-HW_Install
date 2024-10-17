import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstallation {

    public static void main(String[] args) {
        File gamesDirectory = new File("D://Games//GunRunner");
        StringBuilder log = new StringBuilder();

        if (gamesDirectory.exists() || gamesDirectory.mkdirs()) {
            log.append("Успешно создана директория Games.\n");

            File srcDirectory = new File(gamesDirectory, "src");
            if (srcDirectory.mkdirs()) {
                log.append("Успешно создана директория src.\n");

                File mainDirectory = new File(srcDirectory, "main");
                if (mainDirectory.mkdirs()) {
                    log.append("Успешно создана директория main.\n");

                    try {
                        File mainJavaFile = new File(mainDirectory, "Main.java");
                        if (mainJavaFile.createNewFile()) {
                            log.append("Успешно создан файл Main.java.\n");
                        } else {
                            log.append("Не удалось создать Main.java.\n");
                        }

                        File utilsJavaFile = new File(mainDirectory, "Utils.java");
                        if (utilsJavaFile.createNewFile()) {
                            log.append("Успешно создан файл Utils.java.\n");
                        } else {
                            log.append("Не удалось создать файл Utils.java.\n");
                        }
                    } catch (IOException e) {
                        log.append("Ошибка при создании файлов в директории main.\n");
                    }
                } else {
                    log.append("Не удалось создать директорию main.\n");
                }

                File resDirectory = new File(gamesDirectory, "res");
                if (resDirectory.mkdirs()) {
                    log.append("Успешно создана директория res.\n");

                } else {
                    log.append("Не удалось создать директорию res.\n");
                }

                File savegamesDirectory = new File(gamesDirectory, "savegames");
                if (savegamesDirectory.mkdirs()) {
                    log.append("Успешно создана директория savegames.\n");
                } else {
                    log.append("Не удалось создать директорию savegames.\n");
                }

                File tempDirectory = new File(gamesDirectory, "temp");
                if (tempDirectory.mkdirs()) {
                    log.append("Успешно создана директория temp.\n");

                    try {
                        File tempFile = new File(tempDirectory, "temp.txt");
                        if (tempFile.createNewFile()) {
                            log.append("Успешно создан файл temp.txt.\n");

                            FileWriter writer = new FileWriter(tempFile);
                            writer.write(log.toString());
                            writer.close();
                        } else {
                            log.append("Не удалось создать temp.txt.\n");
                        }
                    } catch (IOException e) {
                        log.append("Произошла ошибка при создании temp.txt.\n");
                    }
                } else {
                    log.append("Не удалось создать директорию temp.\n");
                }
            } else {
                log.append("Не удалось создать директорию src.\n");
            }
        } else {
            log.append("Не удалось создать директорию Games.\n");
        }

        System.out.println(log.toString());
    }
}