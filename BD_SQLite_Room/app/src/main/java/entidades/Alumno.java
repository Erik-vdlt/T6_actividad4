package entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabla_alumno")
public class Alumno {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "numControl")
    private String numControl;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "primerAp")
    private String primerAp;
    @ColumnInfo(name = "segundoAp")
    private String segundoAp;
    @ColumnInfo(name = "edad")
    private byte edad;
    @ColumnInfo(name = "semestre")
    private byte semestre;
    @ColumnInfo(name = "carrera")
    private String carrera;

    public Alumno(){

    }

    public Alumno(@NonNull String numControl, String nombre, String primerAp, String segundoAp, byte edad, byte semestre, String carrera) {
        this.numControl = numControl;
        this.nombre = nombre;
        this.primerAp = primerAp;
        this.segundoAp = segundoAp;
        this.edad = edad;
        this.semestre = semestre;
        this.carrera = carrera;
    }

    @NonNull
    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(@NonNull String numControl) {
        this.numControl = numControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerAp() {
        return primerAp;
    }

    public void setPrimerAp(String primerAp) {
        this.primerAp = primerAp;
    }

    public String getSegundoAp() {
        return segundoAp;
    }

    public void setSegundoAp(String segundoAp) {
        this.segundoAp = segundoAp;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public byte getSemestre() {
        return semestre;
    }

    public void setSemestre(byte semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "numControl='" + numControl + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerAp='" + primerAp + '\'' +
                ", segundoAp='" + segundoAp + '\'' +
                ", edad=" + edad +
                ", semestre=" + semestre +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
