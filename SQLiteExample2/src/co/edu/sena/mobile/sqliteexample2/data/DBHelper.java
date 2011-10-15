package co.edu.sena.mobile.sqliteexample2.data;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    public static final String TAG = "DBHelper";
	public static final String DB_NAME = "w_jukebox";
    public static final String DB_TABLE = "w_songs";
    public static final int DB_VERSION = 1;

    private static final String CLASSNAME = DBHelper.class.getSimpleName();
    private static final String[] COLS = new String[] { "_id", "name", "author", "genre", "album", "year","track" };

    private SQLiteDatabase db;
    private final DBOpenHelper dbOpenHelper;

    // 
    // inner classes
    //

    public static class Song {

        public long id;//INTEGER en Sqlite
        public String name; //TEXT en Sqlite
        public String author;
        public String genre;
        public String album;
        public long year; //INTEGER en Sqlite
        public long track;//INTEGER en Sqlite
        
        
        public long lastalert;
        public int alertenabled;
        public String zip;

        public String city;
        public String region;

        public Song() {
        }

        public Song(final long id, final String name, final String author, final String genre,final String album,final long year, final long track) {
            this.id = id;
            this.name =name;
            this.author =author;
            this.genre =genre;
            this.album = album;
            this.year = year;
            this.track = track;
        }

        @Override
        public String toString() {
            return this.name + " " + this.author + ", " + this.album;
        }
    }

    private static class DBOpenHelper extends SQLiteOpenHelper {

        private static final String DB_CREATE = "CREATE TABLE "
            + DBHelper.DB_TABLE
            + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE NOT NULL, author TEXT, genre TEXT,  album TEXT, year INTEGER, track INTEGER);";

        public DBOpenHelper(final Context context) {
            super(context, DBHelper.DB_NAME, null, DBHelper.DB_VERSION);
        }

        @Override
        public void onCreate(final SQLiteDatabase db) {
            try {
                db.execSQL(DBOpenHelper.DB_CREATE);
            } catch (SQLException e) {
                Log.e(TAG, DBHelper.CLASSNAME, e);
            }
        }

        @Override
        public void onOpen(final SQLiteDatabase db)
        {
          super.onOpen(db);
          if (!db.isReadOnly())
          {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
          }
        }


        @Override
        public void onUpgrade(final SQLiteDatabase db, final int oldVersion, final int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DBHelper.DB_TABLE);
            onCreate(db);
        }
    }

    //
    // end inner classes
    //

    public DBHelper(final Context context) {
        this.dbOpenHelper = new DBOpenHelper(context);
        establishDb();
    }

    private void establishDb() {
        if (this.db == null) {
            this.db = this.dbOpenHelper.getWritableDatabase();
        }
    }

    public void cleanup() {
        if (this.db != null) {
            this.db.close();
            this.db = null;
        }
    }

    public void insert(final Song song) {
        ContentValues values = new ContentValues();
        values.put("name", song.name);
        values.put("author", song.author);
        values.put("genre", song.genre);
        values.put("album", song.album);
        values.put("year", song.year);
        values.put("track", song.track);
        
        this.db.insert(DBHelper.DB_TABLE, null, values);
    }

    public void update(final Song song) {
        ContentValues values = new ContentValues();
        values.put("name", song.name);
        values.put("author", song.author);
        values.put("genre", song.genre);
        values.put("album", song.album);
        values.put("year", song.year);
        values.put("track", song.track);
        this.db.update(DBHelper.DB_TABLE, values, "_id=" + song.id, null);
    }

    public void delete(final long id) {
        this.db.delete(DBHelper.DB_TABLE, "_id=" + id, null);
    }

    public void delete(final String name) {
        this.db.delete(DBHelper.DB_TABLE, "name='" + name + "'", null);
    }

    public Song get(final String name) {
        Cursor c = null;
        Song location = null;
        try {
            c = this.db.query(true, DBHelper.DB_TABLE, DBHelper.COLS, "name = '" + name + "'", null, null, null, null,
                null);
            if (c.getCount() > 0) {
                c.moveToFirst();
                location = new Song();
                location.id = c.getLong(0);
                location.name = c.getString(1);
                location.author = c.getString(2);
                location.genre = c.getString(3);
                location.year = c.getLong(4);
                location.track = c.getLong(5);
            }
        } catch (SQLException e) {
            Log.v(TAG, DBHelper.CLASSNAME, e);
        } finally {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        }
        return location;
    }

    public List<Song> getAll() {
        ArrayList<Song> ret = new ArrayList<Song>();
        Cursor c = null;
        try {
            c = this.db.query(DBHelper.DB_TABLE, DBHelper.COLS, null, null, null, null, null);
            int numRows = c.getCount();
            c.moveToFirst();
            for (int i = 0; i < numRows; ++i) {
                Song location = new Song();
                location.id = c.getLong(0);
                location.name = c.getString(1);
                location.author = c.getString(2);
                location.genre = c.getString(3);
                location.year = c.getLong(4);
                location.track = c.getLong(5);
             
                c.moveToNext();
            }
        } catch (SQLException e) {
            Log.v(TAG, DBHelper.CLASSNAME, e);
        } finally {
            if (c != null && !c.isClosed()) {
                c.close();
            }
        }
        return ret;
    }

  
}
