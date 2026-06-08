package br.edu.fatecguarulhos.unihelper.DAOs;

import android.content.Context;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import br.edu.fatecguarulhos.unihelper.models.Materia;
import br.edu.fatecguarulhos.unihelper.models.Usuario;

public class MateriaDAO {

    private CollectionReference materiaColletion;
    private Context context;


    public MateriaDAO(Context context, String idAluno){
        materiaColletion = FirebaseFirestore.getInstance().collection(idAluno);
        this.context = context;
    }

    public void cadastrarMateria(Materia materia, String idAluno){
        salvarMateriaFirestore(materia,idAluno);
    }
    private void salvarMateriaFirestore(Materia materia, String idAluno){
        /*
        materiaColletion.add(materia)
                .addOnSuccessListener(documentReference -> {
                }).addOnFailureListener( e ->{System.out.println("Erro -> " + e.getStackTrace());});
         */
        materiaColletion.document(materia.getNome()).set(materia)
                .addOnSuccessListener(documentReference -> {
                }).addOnFailureListener(
                        e ->{System.out.println("Erro -> " + e.getStackTrace());}
                );


    }
    public List<Materia> buscarMateriasPorAluno(String idAluno){
        List<Materia> materias = new ArrayList<>();
        materiaColletion.whereEqualTo("", idAluno).get().addOnCompleteListener(task -> {
            materias.add(new Materia());
        });
        return materias;
    }
}
