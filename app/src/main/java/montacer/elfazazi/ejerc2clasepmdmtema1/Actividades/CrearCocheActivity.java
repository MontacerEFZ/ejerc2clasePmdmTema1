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

public class CrearCocheActivity extends AppCompatActivity {

    //variables de vista
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_coche);

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
                //sacar la informacion de la vista para crear un coche
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                if (marca.isEmpty() || modelo.isEmpty() || color.isEmpty()) {
                    Toast.makeText(CrearCocheActivity.this, "faltan datos", Toast.LENGTH_SHORT).show();
                }else{
                    Coche coche = new Coche(marca, modelo, color);
                    //eviar el coche a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", coche);
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
        txtModelo = findViewById(R.id.txtModeloCrearCoche);
        txtMarca = findViewById(R.id.txtMarcaCrearCoche);
        txtColor = findViewById(R.id.txtColorCrearCoche);

        btnCancelar = findViewById(R.id.btnCancelarCrearCoche);
        btnCrear = findViewById(R.id.btnCrearCrearCoche);
    }
}