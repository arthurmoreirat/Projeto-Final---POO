public abstract class Personagem {

    //Base 
    protected String nome;
    protected int idade;
    protected int raca;
    protected int PV;
    protected int CA;
    
    //Atributos 
    protected int força;
    protected int destreza;
    protected int inteligencia;
    protected int constituicao;
    protected int carisma;
    protected int sabedoria;

    public Personagem(String nome, int idade, int raca, int força) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.força = força;
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

    public int getRaca() {
        return raca;
    }

    public void setRaca(int raca) {
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

}
    
   
    

