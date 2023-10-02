package montacer.elfazazi.ejerc2clasepmdmtema1.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import montacer.elfazazi.ejerc2clasepmdmtema1.R;
import montacer.elfazazi.ejerc2clasepmdmtema1.modelos.Bici;
import montacer.elfazazi.ejerc2clasepmdmtema1.modelos.Moto;

public class CrearBiciActivity extends AppCompatActivity {
    private EditText txtMarca;
    private EditText txtPulgadas;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bici);

        inicializarVista();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sacar la informacion de la vista para crear una moto
                String marca = txtMarca.getText().toString();
                String pulgadas = txtPulgadas.getText().toString();

                if (marca.isEmpty() || pulgadas.isEmpty()) {
                    Toast.makeText(CrearBiciActivity.this, "faltan datos", Toast.LENGTH_SHORT).show();
                }else{
                    Bici bici = new Bici(marca, pulgadas);
                    //eviar el coche a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BICI", bici);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    //devolver un rsultado de ok
                    setResult(RESULT_OK, intent);

                    //terminar
                    finish();
                }

            }
        });
    }

    private void inicializarVista() {
        txtMarca = findViewById(R.id.txtMarcaCrearBici);
        txtPulgadas = findViewById(R.id.txtPulgadasCrearBici);

        btnCancelar = findViewById(R.id.btnCancelarCrearBici);
        btnCrear = findViewById(R.id.btnCrearCrearBici);
    }
}