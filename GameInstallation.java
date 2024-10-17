import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstallation {

    public static void main(String[] args) {
        File gamesDirectory = new File("D://Games//NewJavaGame");
        StringBuilder log = new StringBuilder();

        if (gamesDirectory.exists() || gamesDirectory.mkdirs()) {
            log.append("Directory 'Games' created successfully.\n");

            File srcDirectory = new File(gamesDirectory, "src");
            if (srcDirectory.mkdirs()) {
                log.append("Directory 'src' created successfully.\n");

                File mainDirectory = new File(srcDirectory, "main");
                if (mainDirectory.mkdirs()) {
                    log.append("Directory 'main' created successfully.\n");

                    try {
                        File mainJavaFile = new File(mainDirectory, "Main.java");
                        if (mainJavaFile.createNewFile()) {
                            log.append("File 'Main.java' created successfully.\n");
                        } else {
                            log.append("Failed to create file 'Main.java'.\n");
                        }

                        File utilsJavaFile = new File(mainDirectory, "Utils.java");
                        if (utilsJavaFile.createNewFile()) {
                            log.append("File 'Utils.java' created successfully.\n");
                        } else {
                            log.append("Failed to create file 'Utils.java'.\n");
                        }
                    } catch (IOException e) {
                        log.append("An error occurred while creating files in 'main'.\n");
                    }
                } else {
                    log.append("Failed to create directory 'main'.\n");
                }

                File resDirectory = new File(gamesDirectory, "res");
                if (resDirectory.mkdirs()) {
                    log.append("Directory 'res' created successfully.\n");

                } else {
                    log.append("Failed to create directory 'res'.\n");
                }

                File savegamesDirectory = new File(gamesDirectory, "savegames");
                if (savegamesDirectory.mkdirs()) {
                    log.append("Directory 'savegames' created successfully.\n");
                } else {
                    log.append("Failed to create directory 'savegames'.\n");
                }

                File tempDirectory = new File(gamesDirectory, "temp");
                if (tempDirectory.mkdirs()) {
                    log.append("Directory 'temp' created successfully.\n");

                    try {
                        File tempFile = new File(tempDirectory, "temp.txt");
                        if (tempFile.createNewFile()) {
                            log.append("File 'temp.txt' created successfully.\n");

                            FileWriter writer = new FileWriter(tempFile);
                            writer.write(log.toString());
                            writer.close();
                        } else {
                            log.append("Failed to create file 'temp.txt'.\n");
                        }
                    } catch (IOException e) {
                        log.append("An error occurred while creating 'temp.txt'.\n");
                    }
                } else {
                    log.append("Failed to create directory 'temp'.\n");
                }
            } else {
                log.append("Failed to create directory 'src'.\n");
            }
        } else {
            log.append("Failed to create directory 'Games'.\n");
        }

        System.out.println(log.toString());
    }
}