package bmnn.armorcalc;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * baumann
 * 6/13/16
 */
public class ArmorDataSource {

    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] allColumns = { DBHelper.COLUMN_ID, DBHelper.COLUMN_NAME,
            DBHelper.COLUMN_PHYSICAL, DBHelper.COLUMN_STRIKE, DBHelper.COLUMN_SLASH,
            DBHelper.COLUMN_THRUST, DBHelper.COLUMN_MAGIC, DBHelper.COLUMN_FIRE,
            DBHelper.COLUMN_LIGHTNING, DBHelper.COLUMN_DARK, DBHelper.COLUMN_BLEED,
            DBHelper.COLUMN_POISON, DBHelper.COLUMN_FROST, DBHelper.COLUMN_CURSE,
            DBHelper.COLUMN_POISE, DBHelper.COLUMN_DURABILITY, DBHelper.COLUMN_WEIGHT};

    public ArmorDataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    private Head cursorToHead(Cursor cursor) {

        Head head = new Head();

//        Log.i("getting head", cursor.getString(1));

        head.setId(cursor.getInt(0));
        head.setName(cursor.getString(1));
        head.setPhysical(cursor.getDouble(2));
        head.setStrike(cursor.getDouble(3));
        head.setSlash(cursor.getDouble(4));
        head.setThrust(cursor.getDouble(5));
        head.setMagic(cursor.getDouble(6));
        head.setFire(cursor.getDouble(7));
        head.setLightning(cursor.getDouble(8));
        head.setDark(cursor.getDouble(9));
        head.setBleed(cursor.getInt(10));
        head.setPoison(cursor.getInt(11));
        head.setFrost(cursor.getInt(12));
        head.setCurse(cursor.getInt(13));
        head.setPoise(cursor.getDouble(14));
        head.setDurability(cursor.getInt(15));
        head.setWeight(cursor.getDouble(16));

        return head;
    }

    private Chest cursorToChest(Cursor cursor) {

        Chest chest = new Chest();

        chest.setId(cursor.getInt(0));
        chest.setName(cursor.getString(1));
        chest.setPhysical(cursor.getDouble(2));
        chest.setStrike(cursor.getDouble(3));
        chest.setSlash(cursor.getDouble(4));
        chest.setThrust(cursor.getDouble(5));
        chest.setMagic(cursor.getDouble(6));
        chest.setFire(cursor.getDouble(7));
        chest.setLightning(cursor.getDouble(8));
        chest.setDark(cursor.getDouble(9));
        chest.setBleed(cursor.getInt(10));
        chest.setPoison(cursor.getInt(11));
        chest.setFrost(cursor.getInt(12));
        chest.setCurse(cursor.getInt(13));
        chest.setPoise(cursor.getDouble(14));
        chest.setDurability(cursor.getInt(15));
        chest.setWeight(cursor.getDouble(16));

        return chest;
    }

    private Arms cursorToArms(Cursor cursor) {

        Arms arms = new Arms();

        arms.setId(cursor.getInt(0));
        arms.setName(cursor.getString(1));
        arms.setPhysical(cursor.getDouble(2));
        arms.setStrike(cursor.getDouble(3));
        arms.setSlash(cursor.getDouble(4));
        arms.setThrust(cursor.getDouble(5));
        arms.setMagic(cursor.getDouble(6));
        arms.setFire(cursor.getDouble(7));
        arms.setLightning(cursor.getDouble(8));
        arms.setDark(cursor.getDouble(9));
        arms.setBleed(cursor.getInt(10));
        arms.setPoison(cursor.getInt(11));
        arms.setFrost(cursor.getInt(12));
        arms.setCurse(cursor.getInt(13));
        arms.setPoise(cursor.getDouble(14));
        arms.setDurability(cursor.getInt(15));
        arms.setWeight(cursor.getDouble(16));

        return arms;
    }

    private Legs cursorToLegs(Cursor cursor) {

        Legs legs = new Legs();

        legs.setId(cursor.getInt(0));
        legs.setName(cursor.getString(1));
        legs.setPhysical(cursor.getDouble(2));
        legs.setStrike(cursor.getDouble(3));
        legs.setSlash(cursor.getDouble(4));
        legs.setThrust(cursor.getDouble(5));
        legs.setMagic(cursor.getDouble(6));
        legs.setFire(cursor.getDouble(7));
        legs.setLightning(cursor.getDouble(8));
        legs.setDark(cursor.getDouble(9));
        legs.setBleed(cursor.getInt(10));
        legs.setPoison(cursor.getInt(11));
        legs.setFrost(cursor.getInt(12));
        legs.setCurse(cursor.getInt(13));
        legs.setPoise(cursor.getDouble(14));
        legs.setDurability(cursor.getInt(15));
        legs.setWeight(cursor.getDouble(16));

        return legs;
    }

    public List<Head> getAllHeads() {
        open();

        List<Head> heads = new ArrayList<>();

        Cursor cursor = database.query(DBHelper.TABLE_HEAD,
                allColumns, null, null, null, null, null);


        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Head head = cursorToHead(cursor);
            heads.add(head);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();

        close();
        return heads;
    }

    public List<Chest> getAllChests() {
        List<Chest> chests = new ArrayList<>();

        open();
        Cursor cursor = database.query(DBHelper.TABLE_CHEST,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Chest chest = cursorToChest(cursor);
            chests.add(chest);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        close();
        return chests;
    }

    public List<Arms> getAllArms() {
        List<Arms> armses = new ArrayList<>();
        open();

        Cursor cursor = database.query(DBHelper.TABLE_ARMS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Arms arms = cursorToArms(cursor);
            armses.add(arms);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        close();
        return armses;
    }

    public List<Legs> getAllLegs() {
        List<Legs> legses = new ArrayList<>();
        open();

        Cursor cursor = database.query(DBHelper.TABLE_LEGS,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Legs legs = cursorToLegs(cursor);
            legses.add(legs);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        close();
        return legses;
    }




}
