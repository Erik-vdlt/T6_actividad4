package controlador;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

import entidades.Alumno;

@Dao
public interface AlumonDAO {

    @Query("SELECT * FROM tabla_alumno")
    List<Alumno> getAll();

    @Query("SELECT * FROM tabla_alumno GROUP BY carrera")
    LiveData<List<Alumno>> getCarreras();

    @Query("SELECT * FROM TABLA_ALUMNO WHERE carrera like :car")
    ArrayList getFiltroCarrera(String car);

   /* @Query("SELECT * FROM alumno WHERE numControl IN (:nc)")
    List<Alumno> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Alumno WHERE n LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    Alumno findByName(String first, String last);*/

    @Insert
    void insertOne(Alumno alumno);

    @Insert
    void insertAll(Alumno... users);

    @Delete
    void delete(Alumno user);
}
