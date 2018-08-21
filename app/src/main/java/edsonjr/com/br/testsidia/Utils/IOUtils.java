package edsonjr.com.br.testsidia.Utils;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class IOUtils {

    private static final String TAG = "IOUtils";


    public static String toString(InputStream in, String charset) throws IOException {
        byte[] bytes = toBytes(in);
        String texto = new String(bytes, charset);
        return texto;
    }


    public static byte[] toBytes(InputStream in) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }
            byte[] bytes = bos.toByteArray();
            return bytes;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return null;
        } finally {
            try {
                bos.close();
                in.close();
            } catch (IOException e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    public static void writeString(OutputStream out, String string) {
        writeBytes(out, string.getBytes());
    }

    public static void writeBytes(OutputStream out, byte[] bytes) {
        try {
            out.write(bytes);
            out.flush();
            out.close();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }


    public static void writeString(File file, String string) {
        writeBytes(file, string.getBytes());
    }




    public static void writeBytes(File file, byte[] bytes) {
        try {
            FileOutputStream out = new FileOutputStream(file);
            out.write(bytes);
            out.flush();
            out.close();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public static String readString(File file) {
        try {
            if (file == null || !file.exists()) {
                return null;
            }
            InputStream in = new FileInputStream(file);
            String s = toString(in, "UTF-8");
            return s;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
            return null;
        }
    }



    public interface Callback {
        public void onFileSaved(File file, boolean exists);
    }


    public static boolean downloadToFile(String url, File file) {
        try {
            InputStream in = new URL(url).openStream();
            byte[] bytes = IOUtils.toBytes(in);
            IOUtils.writeBytes(file, bytes);
            Log.d(TAG, "downloadToFile: " + file);
            return true;
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    public static void checkMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("Qualquer operação de I/O não pode ser executado na UI Thread.");
        }
    }
}
