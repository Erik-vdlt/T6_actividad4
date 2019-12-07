package e.root.bd_sqlite_room;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import androidx.room.Room;

import bd_room.EscuelaBD;
import entidades.Alumno;

public class ActivityAltas extends Activity implements AdapterView.OnItemSelectedListener {
    EditText ed_num_control,ed_nom,ed_primer_ap,ed_segundo_ap,ed_edad;
    Spinner spin_carrera,spin_semestre;
    private static final String TAG = "Agregar Alumno";
    EscuelaBD bd = Room.databaseBuilder(getApplicationContext(),EscuelaBD.class,"escuela").allowMainThreadQueries().build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_altas);



        ed_num_control = findViewById(R.id.edit_no_control);
        ed_nom = findViewById(R.id.edit_nombre);
        ed_primer_ap = findViewById(R.id.edit_primer_ap);
        ed_segundo_ap = findViewById(R.id.edit_segundo_ap);
        ed_edad = findViewById(R.id.edit_edad);
        spin_carrera = findViewById(R.id.sp_carrera);
        spin_semestre = findViewById(R.id.sp_semestre);


        spin_carrera.setOnItemSelectedListener(this);

        ArrayAdapter list = ArrayAdapter.createFromResource(this,R.array.listaCarrera,android.R.layout.simple_spinner_item);
        ArrayAdapter list_se = ArrayAdapter.createFromResource(this,R.array.listaSemestre,android.R.layout.simple_spinner_item);

        spin_carrera.setAdapter(list);
        spin_semestre.setAdapter(list_se);
    }

    public void altas(View view){
        //EscuelaBD bd = Room.databaseBuilder(getApplicationContext(),EscuelaBD.class,"escuela").allowMainThreadQueries().build();

        Alumno al = new Alumno();

        al.setNumControl(ed_num_control.getText().toString());
        al.setNombre(ed_nom.getText().toString());
        al.setPrimerAp(ed_primer_ap.getText().toString());
        al.setSegundoAp(ed_segundo_ap.getText().toString());
        al.setEdad(Byte.parseByte(ed_edad.getText().toString()));
        al.setCarrera(String.valueOf(spin_carrera.getSelectedItem()));
        al.setSemestre(Byte.parseByte(spin_semestre.getSelectedItem().toString()));
        Log.d(TAG,"alumno --> "+al.toString());

        bd.alumonDAO().insertOne(al);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        bd.alumonDAO().getFiltroCarrera(spin_carrera.getSelectedItem().toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
