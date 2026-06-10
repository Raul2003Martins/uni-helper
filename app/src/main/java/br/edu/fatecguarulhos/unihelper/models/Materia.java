package br.edu.fatecguarulhos.unihelper.models;

import java.util.UUID;

public class Materia {

    private String nome, formulaMedia, id, dataProva;
    private int qtdAvaliacoes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void generateId(){
        UUID uniqueKey = UUID.randomUUID();
        id = uniqueKey.toString();
    }

    public String getDataProva() {
        return dataProva;
    }

    public void setDataProva(String dataProva) {
        this.dataProva = dataProva;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getFormulaMedia() { return formulaMedia; }

    public void setFormulaMedia(String formulaMedia) { this.formulaMedia = formulaMedia; }

    public int getQtdAvaliacoes() { return qtdAvaliacoes; }

    public void setQtdAvaliacoes(int qtdAvaliacoes) { this.qtdAvaliacoes = qtdAvaliacoes; }

}
