package br.edu.fatecguarulhos.unihelper.Models;

import java.util.Date;

public class Materia {

    private String nome, formulaMedia;
    private float nota;
    private Date dataProva;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getFormulaMedia() { return formulaMedia; }

    public void setFormulaMedia(String formulaMedia) { this.formulaMedia = formulaMedia; }

    public float getNota() { return nota; }

    public void setNota(float nota) { this.nota = nota; }

    public Date getData() { return dataProva; }

    public void setData(Date data) { this.dataProva = data; }

}
