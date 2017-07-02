package app.io.dados.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import app.io.dados.constants.ConstantsDB;
import app.io.dados.entity.Player;

/**
 * Manager de la BD
 * Permite realizar el CRUD
 */

public class DataBaseManager {
    private DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DataBaseManager(Context context) {
        dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    /**
     * @param player Insertar el Jugador en la BD
     */
    public void insert(Player player) {
        ContentValues values = new ContentValues();
        values.put(ConstantsDB.PLAY_NAME, player.getName());
        values.put(ConstantsDB.PLAY_SCORE, player.getScore());
        sqLiteDatabase.insert(ConstantsDB.TABLE_NAME, null, values);
    }

    /**
     * @return Retorna todos los Jugadores
     * Order By PLAY_SCORE (Ordenado por Puntajes)
     * Orden: DESC (Descendente)
     */
    public Cursor getDataPlayer() {
        String[] columns = new String[]{
                ConstantsDB.PLAY_ID,
                ConstantsDB.PLAY_NAME,
                ConstantsDB.PLAY_SCORE,
                ConstantsDB.PLAY_DATE};

        return sqLiteDatabase.query(ConstantsDB.TABLE_NAME, columns, null, null, null, null, ConstantsDB.PLAY_SCORE + " DESC");
    }


}
