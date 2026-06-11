package br.edu.fatecguarulhos.unihelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Comparator;

import br.edu.fatecguarulhos.unihelper.models.Materia;
import br.edu.fatecguarulhos.unihelper.R;

public class MainActivity extends AppCompatActivity {

    private ListView lwMaterias;
    private ArrayList<Materia> listaMaterias;
    private ArrayAdapter<String> adapter;

    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lwMaterias = findViewById(R.id.lwMaterias);
        listaMaterias = new ArrayList<>();

        lwMaterias.setOnItemClickListener((parent, view, position, id) -> {
            Materia materiaSelecionada = listaMaterias.get(position);
            Intent intent = new Intent(MainActivity.this, ManutecaoMateria.class);
            intent.putExtra("idMateria", materiaSelecionada.getId());
            startActivity(intent);
        });
    }

    public void perfil(){
        it = new Intent(getApplicationContext(), PerfilActivity.class);
        startActivity(it);
    }
    public void cadastrarMaterias(){
        it = new Intent(getApplicationContext(), CadastroMateriaActivity.class);
        startActivity(it);
    }
    public void chat(View view){
        it = new Intent(getApplicationContext(), ChatActivities.class);
        startActivity(it);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item_perfil) perfil();
        if(item.getItemId() == R.id.item_novaMateria) cadastrarMaterias();
        return super.onOptionsItemSelected(item);
    }
}