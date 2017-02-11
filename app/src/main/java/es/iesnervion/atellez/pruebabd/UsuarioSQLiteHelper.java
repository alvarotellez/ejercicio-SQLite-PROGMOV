package es.iesnervion.atellez.pruebabd;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alvarotellez on 11/2/17.
 */

public class UsuarioSQLiteHelper extends SQLiteOpenHelper {

    //Creamos una variable con la sentencia de creacion de la tabla
    String sql = "CREATE TABLE Cliente (Identificacion INTEGER, Nombre TEXT, Apellidos TEXT)";

    public UsuarioSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //El oncreate se ejecuta automaticamente cuando la BD no esta creada
        //Primero realiza la llamada a la clase, crea la BD y despues ya hara las acciones que nosotros queramos
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Este metodo se ejecuta cuando se detecta que la version de la BD ha cambiado
        //Aqui hay que definir el proceso de migacion de datos, para realizar una transaccion si la BD ha cambiado e insertar los datos en la nueva Bd

        db.execSQL("DROP TABLE IF EXISTS Cliente");
        db.execSQL(sql);



    }
}
