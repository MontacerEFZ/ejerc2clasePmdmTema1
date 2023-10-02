package montacer.elfazazi.ejerc2clasepmdmtema1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import montacer.elfazazi.ejerc2clasepmdmtema1.Actividades.CrearBiciActivity;
import montacer.elfazazi.ejerc2clasepmdmtema1.Actividades.CrearCocheActivity;
import montacer.elfazazi.ejerc2clasepmdmtema1.Actividades.CrearMotoActivity;
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
        btnCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCoches.launch(new Intent(MainActivity.this, CrearCocheActivity.class));
            }
        });

        btnCrearMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherMotos.launch(new Intent(MainActivity.this, CrearMotoActivity.class));
            }
        });

        btnCrearBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherBicis.launch(new Intent(MainActivity.this, CrearBiciActivity.class));
            }
        });

        launcherBicis = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){ //result.getData() comprueba q tiene intent
                                //result.getData().getExtras() comprueba q tiene bundle
                                Bici bici = (Bici) result.getData().getExtras().getSerializable("BICI");
                                if (bici != null){
                                    listaBicis.add(bici);
                                    lbCantidadBicis.setText("bicis: "+listaBicis.size());
                                }else {
                                    Toast.makeText(MainActivity.this, "no hay bici", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(MainActivity.this, "no hay datos", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "actividad cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        launcherMotos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){ //result.getData() comprueba q tiene intent
                                //result.getData().getExtras() comprueba q tiene bundle
                                Moto moto = (Moto) result.getData().getExtras().getSerializable("MOTO");
                                if (moto != null){
                                    listaMotos.add(moto);
                                    lbCantidadMotos.setText("motos: "+listaMotos.size());
                                }else {
                                    Toast.makeText(MainActivity.this, "no hay moto", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(MainActivity.this, "no hay datos", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "actividad cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        
        launcherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){ //result.getData() comprueba q tiene intent
                                                                                                    //result.getData().getExtras() comprueba q tiene bundle
                                Coche coche = (Coche) result.getData().getExtras().getSerializable("COCHE");
                                if (coche != null){
                                    listaCoches.add(coche);
                                    lbCantidadCoches.setText("coches: "+listaCoches.size());
                                }else {
                                    Toast.makeText(MainActivity.this, "no hay coche", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(MainActivity.this, "no hay datos", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "actividad cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
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