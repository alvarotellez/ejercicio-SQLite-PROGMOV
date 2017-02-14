package es.iesnervion.atellez.pruebabd;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText id, nombre, apellidos;
    Button btnGuardar, btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.edtIdentificador);
        nombre = (EditText) findViewById(R.id.edtNombre);
        apellidos = (EditText) findViewById(R.id.edApellidos);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnListar = (Button) findViewById(R.id.btnListar);
        btnGuardar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnGuardar:
                String iden = id.getText().toString();
                String name = id.getText().toString();
                String surname = id.getText().toString();

                if (iden.length()>0 && name.length()>0 && surname.length()>0){
                    UsuarioSQLiteHelper nuevoUsuario = new UsuarioSQLiteHelper(this, "DBClientes", null, 1);
                    SQLiteDatabase db = nuevoUsuario.getWritableDatabase();

                    db.execSQL("INSERT INTO Cliente(Identificacion, Nombre, Apellidos) VALUES ('"+iden+"','"+name+"','"+surname+"')");
                    db.close();

                    Toast.makeText(this, "El usuario se ha creado con exito",Toast.LENGTH_SHORT).show();
                    id.setText("");
                    nombre.setText("");
                    apellidos.setText("");
                }else{
                    Toast.makeText(this, "El usuario no se ha podido crear",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnListar:
                Intent intent = new Intent(this, Lista.class);
                startActivity(intent);
                break;
        }


        }
}
