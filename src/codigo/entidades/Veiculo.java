package codigo.entidades;

public abstract class Veiculo {

    private String marca;
    private String modelo;

    private String placa;
    private double diaria;
    private double km;
    private String seguro;
    private boolean alugado;

    private Integer valoPorKm;

    public Veiculo(String marca, String modelo, double diaria, double km, String seguro, String placa, Integer valoPorKm
) {
        this.marca = marca;
        this.modelo = modelo;
        this.diaria = diaria;
        this.km = km;
        this.placa = placa;
        this.seguro = seguro;
        this.alugado = false;
        this.valoPorKm =valoPorKm;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public boolean isAlugado() {
        return alugado;
    }


    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }


    public Integer getValoPorKm() {
        return valoPorKm;
    }


    public void setValoPorKm(Integer valoPorKm) {
        this.valoPorKm = valoPorKm;
    }

    public String getPlaca() {
        return placa;
    }

    public Double calcularTaxta(double valorEmprestiomo){
        return  valorEmprestiomo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", diaria=" + diaria +
                ", km=" + km +
                ", seguro='" + seguro + '\'' +
                ", alugado=" + alugado +
                ", valoPorKm=" + valoPorKm +
                '}';
    }
}
