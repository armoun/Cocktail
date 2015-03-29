package com.magie_pooh.mylibrary.debuger.model.dto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by magie-pooh on 2015/03
 */
public class PrefData implements Parcelable {

    public static Creator<PrefData> CREATOR = new Creator<PrefData>() {
        @Override
        public PrefData createFromParcel(Parcel parcel) {
            return new PrefData(parcel);
        }

        @Override
        public PrefData[] newArray(int i) {
            return new PrefData[i];
        }
    };
    public String fileName;
    public String key;
    public String value;
    public PrefType dataType;

    public PrefData() {
        // do nothing
    }

    public PrefData(final Parcel in) {
        fileName = in.readString();
        key = in.readString();
        value = in.readString();
        dataType = PrefType.values()[in.readInt()];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fileName);
        parcel.writeString(key);
        parcel.writeString(value);
        parcel.writeInt(dataType.ordinal());
    }
}
