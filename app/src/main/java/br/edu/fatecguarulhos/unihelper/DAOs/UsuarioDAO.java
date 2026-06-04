package br.edu.fatecguarulhos.unihelper.DAOs;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import br.edu.fatecguarulhos.unihelper.Models.Usuario;

public class UsuarioDAO {
    private CollectionReference usuariosCollection;
    public UsuarioDAO(){
        usuariosCollection = FirebaseFirestore.getInstance().collection("usuarios");
    }
    public void cadastrarUsuario(Usuario usuario){
        verificarDuplicidadeEmail(usuario.getEmail());
        usuariosCollection.add(usuario)
                .addOnSuccessListener(documentReference -> {

                }).addOnFailureListener( e ->{
                    throw new RuntimeException("Usuário não pôde ser cadastrado");
                });
    }
    private void verificarDuplicidadeEmail(String email){
        //TODO: implementar função que verifica se o email é duplicado,
        // no firebase não existe campo unique :/
    }
}
