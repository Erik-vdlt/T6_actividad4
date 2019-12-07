package e.root.bd_sqlite_room;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;

import bd_room.EscuelaBD;
import entidades.Alumno;


public class ActivityConsultas extends Activity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<Alumno> alumnos;
    RecyclerView.LayoutManager layoutManager;
    private static final String TAG = "Agregar Alumno";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        recyclerView = findViewById(R.id.recicler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        EscuelaBD bd = Room.databaseBuilder(this,EscuelaBD.class,"escuela").allowMainThreadQueries().build();

        alumnos = new ArrayList<>();

        for (int i = 0; i < bd.alumonDAO().getAll().size(); i++) {
        alumnos.add(bd.alumonDAO().getAll().get(i));
        }

        Log.d(TAG,"lista --> "+alumnos);

        adapter = new MyAdapter(alumnos);
        recyclerView.setAdapter(adapter);

    }

}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.textview_registros, parent, false);

        TextView tv = v.findViewById(R.id.textview_datos);

        MyViewHolder vh = new MyViewHolder(tv);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.textView.setText(mDataset[position]);
        holder.textView.setText(mDataset.get(position).toString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}


