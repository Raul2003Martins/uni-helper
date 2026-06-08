package br.edu.fatecguarulhos.unihelper.Formularios;

import android.widget.EditText;

public class FormularioMateria {

    private EditText edtMateria, edtNota, edtData, edtFormula;

    public FormularioMateria(EditText edtMateria, EditText edtNota, EditText edtData, EditText edtFormula) {
        this.edtMateria = edtMateria;
        this.edtNota = edtNota;
        this.edtData = edtData;
        this.edtFormula = edtFormula;
    }

    public boolean camposValidos(){
        boolean campoVazio = false;
        campoVazio = campoVazio(edtMateria, campoVazio);
        campoVazio = campoVazio(edtNota, campoVazio);
        campoVazio = campoVazio(edtData, campoVazio);
        campoVazio = campoVazio(edtFormula, campoVazio);
        return !campoVazio;
    }
    private boolean campoVazio(EditText campo, boolean campoVazio){
        if(campo.getText().toString().equals("") || campo.getText().toString().isEmpty()){
            campo.setError("Campo obrigatório");
            campoVazio =  true;
        }
        return campoVazio;
    }
}
