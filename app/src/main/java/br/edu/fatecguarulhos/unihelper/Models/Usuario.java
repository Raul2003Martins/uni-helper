package br.edu.fatecguarulhos.unihelper.Models;

public class Usuario {
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        validarSenha(senha);
        this.senha = senha;
    }
    private void validarSenha(String senha){
        if(senha.isBlank()) throw new RuntimeException("Senha não pode estar vazia!");
    }
}
