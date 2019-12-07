package bd_room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import controlador.AlumonDAO;
import entidades.Alumno;

@Database(entities = {Alumno.class},version = 1)
public abstract class EscuelaBD extends RoomDatabase {
    public abstract AlumonDAO alumonDAO();
}
