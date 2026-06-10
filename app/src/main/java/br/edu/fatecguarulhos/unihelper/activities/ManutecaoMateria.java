package br.edu.fatecguarulhos.unihelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

import br.edu.fatecguarulhos.unihelper.DAOs.MateriaDAO;
import br.edu.fatecguarulhos.unihelper.R;
import br.edu.fatecguarulhos.unihelper.formularios.FormularioMateria;
import br.edu.fatecguarulhos.unihelper.models.Materia;

public class ManutecaoMateria extends AppCompatActivity {

    private EditText edtMateriaManu, edtNotaManu, edtDataManu, edtFormulaManu;
    private Materia materia;
    private FormularioMateria formMateria;
    private MateriaDAO materiaDAO;
    private Button btnAlterar, btnDeletar;

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
        inicializarComponentes();
        configurarComponentes();
    }
    private void inicializarComponentes(){
        Intent it = getIntent();
        materia = new Gson().fromJson(it.getStringExtra("jsonMateria"),Materia.class);
        edtMateriaManu = findViewById(R.id.edtMateriaManu);
        edtNotaManu = findViewById(R.id.edtNotaManu);
        edtDataManu = findViewById(R.id.edtDataManu);
        edtFormulaManu = findViewById(R.id.edtFormulaManu);
        btnDeletar = findViewById(R.id.btnDeletar);
        btnAlterar = findViewById(R.id.btnAlterar);
        formMateria = new FormularioMateria(edtMateriaManu, edtNotaManu, edtDataManu, edtFormulaManu);
        materiaDAO = new MateriaDAO(this, FirebaseAuth.getInstance().getUid());
    }
    private void configurarComponentes(){
        edtMateriaManu.setText(materia.getNome());
        edtDataManu.setText(materia.getDataProva());
        edtFormulaManu.setText(materia.getFormulaMedia());
        edtNotaManu.setText(String.valueOf(materia.getQtdAvaliacoes()));
    }
    public void salvarMateria(View view){
        if(formMateria.camposValidos()){
            atualizarMateria();
            materiaDAO.atualizarMateria(materia);
        }
    }
    private void atualizarMateria(){
        materia.setNome(edtMateriaManu.getText().toString());
        materia.setQtdAvaliacoes(Integer.valueOf(edtNotaManu.getText().toString()));
        materia.setDataProva(edtDataManu.getText().toString());
        materia.setFormulaMedia(edtFormulaManu.getText().toString());
    }

    public void voltar(View view){
        finish();
    }
}