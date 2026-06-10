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

import java.util.Date;
import java.util.Locale;

import br.edu.fatecguarulhos.unihelper.DAOs.MateriaDAO;
import br.edu.fatecguarulhos.unihelper.Models.Materia;
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

    public void alterar(View view){
        materia = new Materia();
        materia.setId(idMateria);
        materia.setNome(edtMateriaManu.getText().toString());
        materia.setNota(Float.parseFloat(edtNotaManu.getText().toString()));
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date dataProva = formato.parse(edtDataManu.getText().toString());
            materia.setData(dataProva);
        } catch (ParseException e) {
            edtDataManu.setError("Data inválida");
            return;
        }
        materia.setFormulaMedia(edtFormulaManu.getText().toString());

        materiaDAO = new MateriaDAO(this);
        materiaDAO.alterarMateria(materia);

        finish();
    }


    public void deletar(View view){
        MateriaDAO dao = new MateriaDAO(this);
        dao.deletarMateria(idMateria);
        finish();
    }

    public void voltar(View view){
        finish();
    }
}