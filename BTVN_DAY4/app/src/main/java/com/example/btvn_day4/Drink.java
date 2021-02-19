package com.example.btvn_day4;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.ParameterizedType;

public class Drink implements Parcelable {
    int avt, count, core;
    String name;

    public Drink(int avt, int core, String name) {
        this.avt = avt;
        this.count = getCount();
        this.core = core;
        this.name = name;
    }

    public Drink() {
    }

    protected Drink(Parcel in) {
        avt = in.readInt();
        count = in.readInt();
        core = in.readInt();
        name = in.readString();
    }

    public static final Creator<Drink> CREATOR = new Creator<Drink>() {
        @Override
        public Drink createFromParcel(Parcel in) {
            return new Drink(in);
        }

        @Override
        public Drink[] newArray(int size) {
            return new Drink[size];
        }
    };

    public int getAvt() {
        return avt;
    }

    public void setAvt(int avt) {
        this.avt = avt;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(avt);
        dest.writeInt(count);
        dest.writeInt(core);
        dest.writeString(name);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "avt=" + avt +
                ", count=" + count +
                ", core=" + core +
                ", name='" + name + '\'' +
                '}';
    }
}
