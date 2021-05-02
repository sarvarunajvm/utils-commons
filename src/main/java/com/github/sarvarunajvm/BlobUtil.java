package com.github.sarvarunajvm;

import javax.xml.bind.DatatypeConverter;
import java.io.*;

public class BlobUtil {

    private BlobUtil() {

    }

    public static Object toObject(byte[] bytes) {
        String hexString = DatatypeConverter.printHexBinary(bytes);
        bytes = DatatypeConverter.parseHexBinary(hexString);
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream objInputStream = null;
        Object retObj = null;
        try {
            objInputStream = new ObjectInputStream(b);
            retObj = objInputStream.readObject(); //exception
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return retObj;
    }

    public static byte[] toBytes(Object object) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try {
            ObjectOutputStream o = new ObjectOutputStream(b);
            o.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b.toByteArray();
    }
}
