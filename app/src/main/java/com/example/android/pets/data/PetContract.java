package com.example.android.pets.data;

import android.net.Uri;
import android.provider.BaseColumns;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static android.content.ContentResolver.CURSOR_DIR_BASE_TYPE;
import static android.content.ContentResolver.CURSOR_ITEM_BASE_TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by ruslan on 3/3/18.
 */

public final class PetContract {

    /**
     * Content provider values
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.pets";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    //Prevent from instantiating
    private PetContract() {}

    /**
     * Table Pets
     */
    public static abstract class PetEntry implements BaseColumns {

        /**
         * Name of the table.
         */
        public static final String TABLE_NAME = "pets";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, TABLE_NAME);
        public static final String CONTENT_TYPE = CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        public static final String CONTENT_ITEM_TYPE = CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;

        /**
         * The id of the pet. Column name.
         * <P>Type: INTEGER</P>
         */
        public static final String _ID = BaseColumns._ID;

        /**
         * The name of the pet. Column name.
         * <P>Type: STRING</P>
         */
        public static final String COLUMN_PET_NAME = "name";

        /**
         * The breed of the pet. Column name.
         * <P>Type: STRING</P>
         */
        public static final String COLUMN_PET_BREED = "breed";

        /**
         * The gender of the pet. Column name.
         * <P>Type: INTEGER</P>
         *
         */
        public static final String COLUMN_PET_GENDER = "gender";

        /**
         * The weight of the pet (kg). Column name.
         * <P>Type: INTEGER</P>
         */
        public static final String COLUMN_PET_WEIGHT = "weight";

        /**
         * The possible values for the {@link #COLUMN_PET_GENDER}
         */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

        @IntDef({GENDER_UNKNOWN, GENDER_MALE, GENDER_FEMALE})
        @Retention(SOURCE)
        public @interface PetGenders { }


        /**
         * Returns whether or not the given gender is {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE},
         * or {@link #GENDER_FEMALE}.
         */
        public static boolean isValidGender(int gender) {
            if (gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE) {
                return true;
            }
            return false;
        }
    }
}
