
package com.doctorai.kisso.common.encrypt;

import java.util.ArrayList;

/**
 * <p>
 * 字节组处理
 * </p>
 *
 * @author zhaoshihao
 * @since 2015-01-09
 */
public class ByteGroup {

    private ArrayList<Byte> byteContainer = new ArrayList<Byte>();


    public byte[] toBytes() {
        byte[] bytes = new byte[byteContainer.size()];
        for (int i = 0; i < byteContainer.size(); i++) {
            bytes[i] = byteContainer.get(i);
        }
        return bytes;
    }


    public ByteGroup addBytes(byte[] bytes) {
        for (byte b : bytes) {
            byteContainer.add(b);
        }
        return this;
    }


    public int size() {
        return byteContainer.size();
    }
}