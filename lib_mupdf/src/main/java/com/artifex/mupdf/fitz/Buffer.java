package com.artifex.mupdf.fitz;

import android.support.annotation.Keep;

@Keep
public class Buffer {
    static {
        Context.init();
    }

    private long pointer;

    public Buffer(int n) {
        pointer = newNativeBuffer(n);
    }

    public Buffer() {
        pointer = newNativeBuffer(0);
    }

    protected native void finalize();

    public void destroy() {
        finalize();
        pointer = 0;
    }

    private native long newNativeBuffer(int n);

    public native int getLength();

    public native int readByte(int at);

    public native int readBytes(int at, byte[] bs);

    public native int readBytesInto(int at, byte[] bs, int off, int len);

    public native void writeByte(byte b);

    public native void writeBytes(byte[] bs);

    public native void writeBytesFrom(byte[] bs, int off, int len);

    public native void writeBuffer(Buffer buf);

    public native void writeRune(int rune);

    public native void writeLine(String line);

    public native void writeLines(String... lines);

    public native void save(String filename);
}
