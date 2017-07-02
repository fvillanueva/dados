package app.io.dados.constants;


/**
 * Constantes para crear la BD
 */

public class ConstantsDB {

    public final static String DB_NAME = "database.db";
    public final static int DB_VERSION = 1;

    public final static String TABLE_NAME = "PLAYERS";

    public final static String PLAY_ID = "PLAY_ID";
    public final static String PLAY_NAME = "PLAY_NAME";
    public final static String PLAY_SCORE = "PLAY_SCORE";
    public final static String PLAY_DATE = "PLAY_DATE";

    public final static String PLAYER_SQL =
            "CREATE TABLE  " + TABLE_NAME + " ( " +
                    PLAY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PLAY_NAME + " TEXT NOT NULL, " +
                    PLAY_SCORE + " INTEGER NOT NULL, " +
                    PLAY_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP );";

    public final static String PLAYER_SQL_DELETE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


}
