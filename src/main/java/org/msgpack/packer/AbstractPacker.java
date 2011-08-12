//
// MessagePack for Java
//
// Copyright (C) 2009-2011 FURUHASHI Sadayuki
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//
package org.msgpack.packer;

import java.io.IOException;
import org.msgpack.type.Value;
import org.msgpack.MessagePack;
import org.msgpack.template.Template;


public abstract class AbstractPacker implements Packer {
    protected MessagePack msgpack;

    protected AbstractPacker(MessagePack msgpack) {
	this.msgpack = msgpack;
    }

    public void writeByteArray(byte[] b) throws IOException {
        writeByteArray(b, 0, b.length);
    }


    public void writeArrayEnd() throws IOException {
        writeArrayEnd(true);
    }

    public void writeMapEnd() throws IOException {
        writeMapEnd(true);
    }

    public Packer write(Object o) throws IOException {
        if(o == null) {
            writeNil();
            return this;
        }
        Template tmpl = msgpack.lookup(o.getClass());
        tmpl.write(this, o);
        return this;
    }

    public Packer write(Value v) throws IOException {
        if(v == null) {
            writeNil();
            return this;
        }
        v.writeTo(this);
        return this;
    }


    public void close() throws IOException {
    }

//    public Packer write(Object o) throws IOException {
//        msgpack.lookup(o.getClass()).write(this, o);
//        return this;
//    }
//
//    public Packer write(Value v) throws IOException {
//        v.writeTo(this);
//        return this;
//    }
//
//    public Packer write(MessagePackable v) throws IOException {
//        v.writeTo(this);
//        return this;
//    }
//
//    public Packer write(boolean v) throws IOException {
//        writeBoolean(v);
//        return this;
//    }
//
//    public Packer write(byte v) throws IOException {
//        writeByte(v);
//        return this;
//    }
//
//    public Packer write(short v) throws IOException {
//        writeShort(v);
//        return this;
//    }
//
//    public Packer write(int v) throws IOException {
//        writeInt(v);
//        return this;
//    }
//
//    public Packer write(long v) throws IOException {
//        writeLong(v);
//        return this;
//    }
//
//    public Packer write(float v) throws IOException {
//        writeFloat(v);
//        return this;
//    }
//
//    public Packer write(double v) throws IOException {
//        writeDouble(v);
//        return this;
//    }
//
//    public Packer write(Boolean v) throws IOException {
//        if(v == null) {
//            writeNil();
//        } else {
//            writeBoolean(v);
//        }
//        return this;
//    }
//
//    public Packer write(Byte v) throws IOException {
//        if(v == null) {
//            writeNil();
//        } else {
//            writeByte(v);
//        }
//        return this;
//    }
//
//    public Packer write(Short v) throws IOException {
//        if(v == null) {
//            writeNil();
//        } else {
//            writeShort(v);
//        }
//        return this;
//    }
//
//    public Packer write(Integer v) throws IOException {
//        if(v == null) {
//            writeNil();
//        } else {
//            writeInt(v);
//        }
//        return this;
//    }
//
//    public Packer write(Long v) throws IOException {
//        if(v == null) {
//            writeNil();
//        } else {
//            writeLong(v);
//        }
//        return this;
//    }
//
//    public Packer write(Float v) throws IOException {
//        if(v == null) {
//            writeNil();
//        } else {
//            writeFloat(v);
//        }
//        return this;
//    }
//
//    public Packer write(Double v) throws IOException {
//        if(v == null) {
//            writeNil();
//        } else {
//            writeDouble(v);
//        }
//        return this;
//    }
//
//    public Packer write(String s) throws IOException {
//        writeString(s);
//        return this;
//    }
//
//    public Packer write(byte[] b) throws IOException {
//        writeByteArray(b);
//        return this;
//    }
//
//    public Packer write(byte[] b, int off, int len) throws IOException {
//        writeByteArray(b, off, len);
//        return this;
//    }
//
//    //public Packer write(ByteBuffer b) throws IOException {
//    //    writeByteBuffer(b);
//    //    return this;
//    //}
}

