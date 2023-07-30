package codigo.entidades;

import codigo.entidades.Veiculo;

public class Moto extends Veiculo{
    private String tipoVeiculo;
    private Integer quantidadeCapacetes;


    public Moto(String marca, String modelo, double diaria, double km, String seguro,String placa,Integer quantidadeCapacetes, Integer valoPorKm) {
        super(marca, modelo, diaria, km, seguro, placa, valoPorKm);
        this.tipoVeiculo="M";
        this.quantidadeCapacetes = quantidadeCapacetes;
    }


    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
    public Integer getQuantidadeCapacetes() {
        return quantidadeCapacetes;
    }

    @Override
    public Double calcularTaxta(double valorEmprestiomo){
        return  1.1 * valorEmprestiomo;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "tipoVeiculo='" + tipoVeiculo + '\'' +
                ", quantidadeCapacetes=" + quantidadeCapacetes +
                "} " + super.toString();
    }
}
