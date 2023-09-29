package montacer.elfazazi.ejerc2clasepmdmtema1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import montacer.elfazazi.ejerc2clasepmdmtema1.modelos.Bici;
import montacer.elfazazi.ejerc2clasepmdmtema1.modelos.Coche;
import montacer.elfazazi.ejerc2clasepmdmtema1.modelos.Moto;

public class MainActivity extends AppCompatActivity {

    private Button btnCrearCoche;
    private Button btnCrearMoto;
    private Button btnCrearBici;

    private TextView lbCantidadCoches;
    private TextView lbCantidadMotos;
    private TextView lbCantidadBicis;

    //atributos para loa launchers
    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBicis;

    //atributois para logica
    private ArrayList<Coche> listaCoches;
    private ArrayList<Moto> listaMotos;
    private ArrayList<Bici> listaBicis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariables();
    }

    private void inicializarVariables() {
        lbCantidadCoches = findViewById(R.id.lbCantidadCochesMain);
        lbCantidadMotos = findViewById(R.id.lbCantidadMotosMain);
        lbCantidadBicis = findViewById(R.id.lbCantidadBicisMain);

        btnCrearCoche = findViewById(R.id.btnCrearCocheMain);
        btnCrearMoto = findViewById(R.id.btnCrearMotoMain);
        btnCrearBici = findViewById(R.id.btnCrearBiciMain);

        listaCoches = new ArrayList<>();
        listaMotos = new ArrayList<>();
        listaBicis = new ArrayList<>();


    }
}