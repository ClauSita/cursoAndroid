package com.cmz.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_codigo, et_descripcion, et_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo = (EditText)findViewById(R.id.et_cod);
        et_descripcion = (EditText)findViewById(R.id.et_des);
        et_precio = (EditText)findViewById(R.id.et_pre);

    }

    public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper( this, "administracion", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty()&& !descripcion.isEmpty() && !precio.isEmpty() ){  //Signo de admiracion para invertir

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            BaseDeDatos.insert("articulos", null, registro);

            BaseDeDatos.close();

            et_precio.setText("");
            et_descripcion.setText("");
            et_codigo.setText("");

        }else{
            Toast.makeText(this,"Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }




    }

    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDataBase = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){

            Cursor fila = BaseDeDataBase.rawQuery("SELECT descripcion, precio FROM articulos WHERE codigo = " + codigo, null);

            if(fila.moveToFirst()){ //si tiene valores la respuesta
                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));

                BaseDeDataBase.close();

            }else {
                BaseDeDataBase.close();
                Toast.makeText(this, "No existe el artículo.", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Debes introducir el código del artículo.", Toast.LENGTH_SHORT).show();

        }

    }

    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);

        SQLiteDatabase BasDEDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();

        if(!codigo.isEmpty()){
            int cantidad = BasDEDatos.delete("articulos", "codigo=" + codigo, null);
            BasDEDatos.close();

            et_precio.setText("");
            et_descripcion.setText("");
            et_codigo.setText("");

            if(cantidad == 1){
                Toast.makeText(this,"Se ha eliminado el producto.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "No existe el producto.", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this,"Debes introducir el codigo del articulo.", Toast.LENGTH_SHORT).show();
            BasDEDatos.close();
        }

    }

    public void Modificar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            int cantidad = baseDeDatos.update("articulos", registro, "codigo="+codigo,null);

            baseDeDatos.close();

            if(cantidad == 1){

                Toast.makeText(this, "Se modifico el producto.", Toast.LENGTH_SHORT).show();
                et_precio.setText("");
                et_descripcion.setText("");
                et_codigo.setText("");

            }else {
                Toast.makeText(this,"No existe el elemento.", Toast.LENGTH_SHORT).show();
            }

        }else{
            baseDeDatos.close();
            Toast.makeText(this, "Debes llenar todos los campos.", Toast.LENGTH_SHORT).show();

        }

    }

}
