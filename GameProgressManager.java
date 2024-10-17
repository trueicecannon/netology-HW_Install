import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgressManager {

    public static void main(String[] args) {
        GameProgress game1 = new GameProgress(100, 3, 5, 256.78);
        GameProgress game2 = new GameProgress(80, 2, 3, 128.34);
        GameProgress game3 = new GameProgress(120, 4, 8, 512.99);

        saveGame("D://Games//GunRunner/savegames/save1.dat", game1);
        saveGame("D://Games//GunRunner/savegames/save2.dat", game2);
        saveGame("D://Games//GunRunner/savegames/save3.dat", game3);

        ArrayList<String> filesToZip = new ArrayList<>();
        filesToZip.add("D://Games//GunRunner/savegames/save1.dat");
        filesToZip.add("D://Games//GunRunner/savegames/save2.dat");
        filesToZip.add("D://Games//GunRunner/savegames/save3.dat");

        zipFiles("D://Games//GunRunner/savegames/files.zip", filesToZip);

        // Delete files that are not in the zip archive
        for (String file : filesToZip) {
            File f = new File(file);
            if (f.exists() && !f.getPath().equals("/Users/admin/Games/GunRunner/savegames/zip.zip")) {
                f.delete();
            }
        }
    }

    public static void saveGame(String filePath, GameProgress game) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(game);
            System.out.println("Игра сохранена в: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipFiles(String zipFilePath, ArrayList<String> filesToZip) {
        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            for (String file : filesToZip) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    ZipEntry entry = new ZipEntry(new File(file).getName());
                    zos.putNextEntry(entry);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, length);
                    }
                    zos.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Файлы успешно запакованы в локации: " + zipFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}