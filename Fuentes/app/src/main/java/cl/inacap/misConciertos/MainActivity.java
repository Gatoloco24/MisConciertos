package cl.inacap.misconciertos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static cl.inacap.misconciertos.R.id.artista;

public class MainActivity extends AppCompatActivity {

    private List<Registro> registros = new ArrayList<>();
    private EditText EditText_artista;
    private EditText EditText_fecha_dia;
    private EditText EditText_fecha_mes;
    private EditText EditText_fecha_año;
    private EditText EditText_valor;
    private Spinner Spinner_musica;
    private ListView ListView_lista;
    private ArrayAdapter<Registro> registrosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        // La actividad está Creada.

        this.EditText_artista = findViewById(artista);
        this.EditText_fecha_dia = findViewById(R.id.fecha_dia);
        this.EditText_fecha_mes = findViewById(R.id.fecha_mes);
        this.EditText_fecha_año = findViewById(R.id.fecha_año);
        this.EditText_valor = findViewById(R.id.valor);
        this.Spinner_musica = findViewById(R.id.spinner);
        this.ListView_lista = findViewById(R.id.listView);
        this.registrosAdapter = new ArrayAdapter<>(this,R.layout.lista_item,registros);
        this.ListView_lista.setAdapter(registrosAdapter);


        //Spinner
        String [] generos = {"Rock","Jazz","Pop","Reguetoon","Salsa","Metal"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, generos);

        Spinner_musica.setAdapter(adapter);

    }

    //Este metodo realiza el ingreso
        public void Registrar(View view){

            List<String> errores = new ArrayList<>();
           if(EditText_artista.length() == 0){
               Toast.makeText(this, "Debe ingresar un Artista", Toast.LENGTH_SHORT).show();
               errores.add("debe ingresar un artista");
           }
           int dia = 0;
           try {
               dia = Integer.parseInt(EditText_fecha_dia.getText().toString());
           }catch (Exception ex){
           }

           if(dia <= 01 && dia >= 31 || dia == 0 ){
               Toast.makeText(this, "Debe ingresar un dia entre 01 y 31 ", Toast.LENGTH_SHORT).show();
               errores.add("Debe ingresar un dia entre 01 y 31");
           }

           int mes = 0;
           try{
               mes = Integer.parseInt(EditText_fecha_mes.getText().toString());
           }catch(Exception ex){

           }
            if( mes <= 01 && mes >= 12 || mes == 0){
                Toast.makeText(this, "Debe ingresar un mes entre 01 y 12 ", Toast.LENGTH_SHORT).show();
                errores.add("Debe ingresar un mes entre 01 y 12");
            }
            int año = 0;
            try{
                año = Integer.parseInt(EditText_fecha_año.getText().toString());
            }catch(Exception ex){

            }
            if(año <= 20 || año == 0 ){
                Toast.makeText(this, "Debe ingresar un año mayor o igual que  '20' ", Toast.LENGTH_SHORT).show();
                errores.add("Debe ingresar un año minimo '20'");
            }

            int valor = 0;
            try {
                valor = Integer.parseInt(EditText_valor.getText().toString());
            }catch(Exception ex){

            }

            if(valor <= 0){
                Toast.makeText(this, "Debe ingresar un valor mayor que 0 ", Toast.LENGTH_SHORT).show();
                errores.add("Debe ingresar un valor mayor que 0");
            }

            String fecha = (dia+" / "+ mes + " / " + año);
            String nombre_artista = EditText_artista.getText().toString();

            String genero = Spinner_musica.getSelectedItem().toString();


            if(errores.isEmpty()){
                Registro r = new Registro();
                r.setNombre(nombre_artista);
                r.setFecha(fecha);
                r.setGenero(genero);
                r.setValor(valor);
                registros.add(r);
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();

                registrosAdapter.notifyDataSetChanged();
            }
        }



    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora está "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }




}