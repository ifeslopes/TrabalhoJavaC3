package codigo.entidades;

import codigo.entidades.Veiculo;

public class Carro extends Veiculo{
    private String tipoVeiculo;
    private Integer quantidadeDeportas;


    public Carro(String marca, String modelo, double diaria, double km, String seguro, String placa, Integer quantidadeDeportas, Integer valoPorKm) {
        super(marca, modelo, diaria, km, seguro, placa, valoPorKm);
        this.tipoVeiculo="C";
        this.quantidadeDeportas=quantidadeDeportas;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
    @Override
    public Double calcularTaxta(double valorEmprestiomo){
        return  1.2 * valorEmprestiomo;
    }
    public Integer getQuantidadeDeportas() {
        return quantidadeDeportas;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "tipoVeiculo='" + tipoVeiculo + '\'' +
                ", quantidadeDeportas=" + quantidadeDeportas +
                "} " + super.toString();
    }
}
