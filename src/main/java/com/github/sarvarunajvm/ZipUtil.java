package com.github.sarvarunajvm;

import java.io.*;
import java.net.URI;
import java.util.Deque;
import java.util.LinkedList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    private ZipUtil() {
    }

    public static File zipFolder(File folderToZip) {

        File outFolder = new File(folderToZip + ".zip");
        URI base = folderToZip.toURI();
        Deque<File> queue = new LinkedList<>();
        queue.push(folderToZip);
        OutputStream out = null;
        try {
            out = new FileOutputStream(outFolder);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        Closeable res = out;
        try (ZipOutputStream zout = new ZipOutputStream(out)) {
            res = zout;
            while (!queue.isEmpty()) {
                folderToZip = queue.pop();
                for (File kid : folderToZip.listFiles()) {
                    String name = base.relativize(kid.toURI()).getPath();
                    if (kid.isDirectory()) {
                        queue.push(kid);
                        name = name.endsWith("/") ? name : name + "/";
                        zout.putNextEntry(new ZipEntry(name));
                    } else {
                        zout.putNextEntry(new ZipEntry(name));
                        copy(kid, zout);
                        zout.closeEntry();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                res.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outFolder;
    }

    private static void copy(InputStream in, OutputStream out) throws IOException {

        byte[] buffer = new byte[1024];
        while (true) {
            int readCount = in.read(buffer);
            if (readCount < 0) {
                break;
            }
            out.write(buffer, 0, readCount);
        }
    }

    private static void copy(File file, OutputStream out) throws IOException {
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            copy(in, out);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String zipFile(File file) {
        try (FileInputStream in = new FileInputStream(file);
             ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file + ".zip"))) {

            out.putNextEntry(new ZipEntry(file.getName()));

            byte[] b = new byte[1024];
            int count;
            while ((count = in.read(b)) > 0) {
                out.write(b, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file + ".zip";
    }
}