package com.example.android.pets.data;

import android.provider.BaseColumns;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by ruslan on 3/3/18.
 */

public final class PetContract {

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
        @Retention(SOURCE)
        @IntDef({GENDER_UNKNOWN, GENDER_MALE, GENDER_FEMALE})
        public @interface PetGenders {}

        // Declare the constants
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }
}
