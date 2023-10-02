package montacer.elfazazi.ejerc2clasepmdmtema1.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import montacer.elfazazi.ejerc2clasepmdmtema1.R;
import montacer.elfazazi.ejerc2clasepmdmtema1.modelos.Coche;
import montacer.elfazazi.ejerc2clasepmdmtema1.modelos.Moto;

public class CrearMotoActivity extends AppCompatActivity {
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCilindrada;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_moto);
        
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
                String modelo = txtModelo.getText().toString();
                String cilindrada = txtCilindrada.getText().toString();

                if (marca.isEmpty() || modelo.isEmpty() || cilindrada.isEmpty()) {
                    Toast.makeText(CrearMotoActivity.this, "faltan datos", Toast.LENGTH_SHORT).show();
                }else{
                    Moto moto = new Moto(marca, modelo, cilindrada);
                    //eviar el coche a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MOTO", moto);
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
        txtModelo = findViewById(R.id.txtModeloCrearMoto);
        txtMarca = findViewById(R.id.txtMarcaCrearMoto);
        txtCilindrada = findViewById(R.id.txtCilindradaCrearMoto);

        btnCancelar = findViewById(R.id.btnCancelarCrearMoto);
        btnCrear = findViewById(R.id.btnCrearCrearMoto);
    }
}