import java.io.File;

public class FileOrganizer {
    public static void main(String[] args) {


        String path = "C:\\Users\\Vidya\\Downloads";
        File folder = new File(path);

        if (!folder.exists()) {
            System.out.println("Folder not found!");
            return;
        }

        File[] files = folder.listFiles();

        for (File file : files) {
            if (file.isFile()) {

                String name = file.getName().toLowerCase();

                if (name.endsWith(".jpg") || name.endsWith(".png")) {
                    moveFile(file, path + "\\Images");
                }
                else if (name.endsWith(".pdf") || name.endsWith(".docx")) {
                    moveFile(file, path + "\\Documents");
                }
                else if (name.endsWith(".mp4") || name.endsWith(".mkv")) {
                    moveFile(file, path + "\\Videos");
                }
                else {
                    moveFile(file, path + "\\Others");
                }
            }
        }

        System.out.println("✅ Files Organized Successfully!");
    }

    public static void moveFile(File file, String folderPath) {

        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();
        }

        File newFile = new File(folderPath + "\\" + file.getName());
        file.renameTo(newFile);
    }
}