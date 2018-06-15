package grupo.merco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class ajudanteDoBD extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "teste";
    public static final String TABLE_NAME = "Itens";
    public static final String COLUMN1 = "produtoID";
    public static final String COLUMN2 = "produtoNome";

    //initialize the database
    public ajudanteDoBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN1 + " INTEGER PRIMARY KEY, " + COLUMN2 + " TEXT ); ";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int velho, int novo) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void updateData(String novoNome){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN2,novoNome);
        db.update(TABLE_NAME,contentValues,"ID = ?", new String[] {novoNome});
    }


    public String loadHandler() {
        String result = "";
        String query = " Select*FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator" );
        }
        cursor.close();
        db.close();
        return result;
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return data;
    }

        public void addData(String item, int num)
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN1,num);
            contentValues.put(COLUMN2,item);
            db.insert(TABLE_NAME,null,contentValues );
        }

    public void addHandler(bdProduto produto) {
        ContentValues values = new ContentValues();
        values.put(COLUMN1, produto.getID());
        values.put(COLUMN2, produto.getProdutoNome());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public bdProduto findHandler(String produtoName) {
        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN1 + " = " + "'" + produtoName + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        bdProduto produto = new bdProduto();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            produto.setID(Integer.parseInt(cursor.getString(0)));
            produto.setProdutoNome(cursor.getString(1));
            cursor.close();
        } else {
            produto = null;
        }
        db.close();
        return produto;
    }

    public boolean deleteHandler(int ID) {
        boolean result = false;
        String query = "Select*FROM" + TABLE_NAME + "WHERE" + COLUMN1 + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        bdProduto produto = new bdProduto();
        if (cursor.moveToFirst()) {
            produto.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NAME, COLUMN1 + "=?",
                    new String[]{
                            String.valueOf(produto.getID())
                    });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public boolean updateHandler(int ID, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN1, ID);
        args.put(COLUMN2, name);
        return db.update(TABLE_NAME, args, COLUMN1 + "=" + ID, null) > 0;
    }
}