package codigo.entidades;

import codigo.entidades.Veiculo;
import java.util.ArrayList;

public class Garagem {
    private Double saldoEmCaixa;

    ArrayList<Veiculo>veiculos=new ArrayList<>();

    public Garagem() {
    }

    public Double getSaldoEmCaixa() {
        return saldoEmCaixa;
    }

    public void setSaldoEmCaixa(Double saldoEmCaixa) {
        this.saldoEmCaixa = saldoEmCaixa;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void addVeiculos(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }
    public void addVeiculos(ArrayList<Veiculo> veiculo) {
        this.veiculos.addAll(veiculo);
    }
}
