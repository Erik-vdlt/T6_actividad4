package e.root.bd_sqlite_room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirActivities(View view){

        switch (view.getId()){
            case R.id.btn_agregar:
                Intent i = new Intent(this, ActivityAltas.class);
                startActivity(i);
                break;
            case R.id.btn_consultar:
                Intent i1 = new Intent(this,ActivityConsultas.class);
                startActivity(i1);
                break;
        }
    }
}
