package br.edu.fatecguarulhos.unihelper.activities;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fatecguarulhos.unihelper.DAOs.MateriaDAO;
import br.edu.fatecguarulhos.unihelper.models.Materia;
import br.edu.fatecguarulhos.unihelper.R;

public class ManutecaoMateria extends AppCompatActivity {

    private EditText edtMateriaManu, edtNotaManu, edtDataManu, edtFormulaManu;
    private Button btnAlterar, btnDeletar;
    private String idMateria;
    private MateriaDAO materiaDAO;
    private Materia materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manutecao_materia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        idMateria = getIntent().getStringExtra("idMateria");
        edtMateriaManu = findViewById(R.id.edtMateriaManu);
        edtNotaManu = findViewById(R.id.edtNotaManu);
        edtDataManu = findViewById(R.id.edtDataManu);
        edtFormulaManu = findViewById(R.id.edtFormulaManu);
        btnDeletar = findViewById(R.id.btnDeletar);
        btnAlterar = findViewById(R.id.btnAlterar);
    }

    public void voltar(View view){
        finish();
    }
}