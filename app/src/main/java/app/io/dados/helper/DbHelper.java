package app.io.dados.helper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import app.io.dados.constants.ConstantsDB;

/**
 * Helper de la BD
 */


public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, ConstantsDB.DB_NAME, null, ConstantsDB.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstantsDB.PLAYER_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ConstantsDB.PLAYER_SQL_DELETE);
        onCreate(db);
    }
}
