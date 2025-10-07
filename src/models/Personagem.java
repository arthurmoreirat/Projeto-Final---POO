package models;

public abstract class Personagem {

    //Base 
    protected String nome;
    protected int idade;
    protected String raca;
    protected int PV;
    protected int CA;
    
    //Atributos 
    protected int força;
    protected int constituicao;
    protected int destreza;
    protected int inteligencia;
    protected int sabedoria;
    protected int carisma;

    public Personagem(String nome, int idade, String raca, int força, int destreza, int inteligencia, int constituicao, int carisma, int sabedoria) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.força = força;
        this.constituicao = constituicao;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
    }
    
    // Gets e Sets 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getForca() {
        return força;
    }

    public void setForca(int força) {
        this.força = força;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {
        this.sabedoria = sabedoria;
    }

     public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public int getCA() {
        return CA;
    }

    public void setCA(int CA) {
        this.CA = CA;
    }

    public void receberDano(int dano) {
        this.PV -= dano;
        
        if (this.PV < 0) {
            this.PV = 0;
            System.out.printf("%s foi derrotado!\n", nome);
        } 

        System.out.printf("%s recebeu %d de dano. PV restante: %d\n", nome, dano, PV);
    }

}
    
   
    

