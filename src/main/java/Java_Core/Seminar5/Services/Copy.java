package Java_Core.Seminar5.Services;

import java.io.*;

public class Copy {
    public void copyFilesAndFolders(File from, File where) throws IOException {
        if (from.isDirectory()) {
            copyDirectory(from, where);
        } else {
            copyFile(from, where);
        }
    }

    private void copyFile(File from, File where) throws IOException {
        try (InputStream in = new FileInputStream(from);
                OutputStream out = new FileOutputStream(where)) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }

    private void copyDirectory(File from, File where) throws IOException {
        if (!where.exists()) {
            where.mkdir();
        }
        for (String f : from.list()) {
            copyFilesAndFolders(new File(from, f), new File(where, f));
        }
    }
}
