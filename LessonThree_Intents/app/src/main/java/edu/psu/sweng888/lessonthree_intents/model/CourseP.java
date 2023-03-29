package edu.psu.sweng888.lessonthree_intents.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CourseP implements Parcelable {

    private int ID;
    private int credits;
    private String description;


    protected CourseP(Parcel in) {
        ID = in.readInt();
        credits = in.readInt();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID);
        dest.writeInt(credits);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CourseP> CREATOR = new Creator<CourseP>() {
        @Override
        public CourseP createFromParcel(Parcel in) {
            return new CourseP(in);
        }

        @Override
        public CourseP[] newArray(int size) {
            return new CourseP[size];
        }
    };
}
