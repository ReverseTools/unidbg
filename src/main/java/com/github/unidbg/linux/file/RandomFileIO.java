package com.github.unidbg.linux.file;

import com.github.unidbg.Emulator;
import com.github.unidbg.file.FileIO;
import com.sun.jna.Pointer;
import unicorn.Unicorn;

import java.util.Random;

public class RandomFileIO extends DriverFileIO {

    private final Random random = new Random();

    RandomFileIO(Emulator emulator, String path) {
        super(emulator, FileIO.O_RDONLY, path);
    }

    @Override
    public int read(Unicorn unicorn, Pointer buffer, int count) {
        byte[] data = new byte[count];
        random.nextBytes(data);
        buffer.write(0, data, 0, data.length);
        return data.length;
    }

    @Override
    public int fstat(Emulator emulator, Unicorn unicorn, Pointer stat) {
        return 0;
    }
}
