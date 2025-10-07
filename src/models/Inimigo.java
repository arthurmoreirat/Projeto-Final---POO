// Criação de inimigo simples
package models;

public class Inimigo {
    private String nome;
    private int PV;
    private int ataque; // bônus de ataque
    private int defesa; // classe de armadura

    public Inimigo(String nome, int PV, int ataque, int defesa) {
        this.nome = nome;
        this.PV = PV;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public boolean estaVivo() {
        return PV > 0;
    }
}
