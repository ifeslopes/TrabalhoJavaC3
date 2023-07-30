package codigo.servico;

import codigo.entidades.Carro;
import codigo.entidades.Garagem;
import codigo.entidades.Moto;
import codigo.entidades.Veiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoCSV {


    /**
     *  Este método "salvar" é responsável por criar um arquivo CSV chamado "garagem.csv" no diretório "/src"
     *  e escrever nele o conteúdo passado como parâmetro.
     *  O parâmetro "salvar" representa o conteúdo a ser salvo no arquivo.
     *  parâmetro "novoAtualizar" é um booleano que determina se o arquivo será substituído (false) ou atualizado (true) caso já exista.
     *  **/

    private static void salvar(String salvar, boolean novoAtualizar) {
        File diretorio = new File(System.getProperty("user.dir")+"/src");
        // Criar diretório
        // diretorio.mkdirs();
        File arquivo = new File(diretorio, "garagem.csv");

        try {
            arquivo.createNewFile();
            FileWriter arquivoEscrita = new FileWriter(arquivo, novoAtualizar);
            PrintWriter escrever = new PrintWriter(arquivoEscrita);

            escrever.print(salvar);
            escrever.flush();
            escrever.close();
        } catch (IOException e) {
            System.out.println("Erro de I/O: " + e.getMessage());
        }
    }


    /**
     * Carrega o conteúdo de um arquivo "garagem.csv" em uma lista de strings.
     * O arquivo é lido linha por linha e cada linha é adicionada à lista de resultado.
     * Retorna a lista de strings contendo o conteúdo do arquivo.
     * Em caso de erro de I/O ao ler o arquivo, exibe uma mensagem de erro e encerra o programa.
     */
    private static List<String> carregarArquivo(){

        List<String> resultado =new ArrayList<>();
        try {
            File diretorio =new File(System.getProperty("user.dir")+"/src");
            File arquivo = new File(diretorio, "garagem.csv");

            FileReader lerArquivo = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(lerArquivo);

            String linha = "";


            while ((linha = bufferedReader.readLine()) != null) {
                resultado.add(linha);
            }
            bufferedReader.close();
            lerArquivo.close();

        }catch (IOException e){
            System.out.println("Erro de I/O ");
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return resultado;
    }

        /** mota or arquivos e cria os objetos carro  e moto e adiciona na garragem**/
    public static Garagem carregarVeiculos() {
        Garagem garagem = new Garagem(); // Cria uma instância da classe Garagem

        List<String> listas = carregarArquivo(); // Obtém uma lista de strings do método carregarArquivo()
        for (String list : listas) {
            String[] iten = list.split(";"); // Divide cada string em partes separadas com base no caractere ";"

            if (iten[6].equalsIgnoreCase("C")) {
                // Se o valor do índice 6 for "C", cria um objeto Carro com base nas informações fornecidas
                Carro carro = new Carro(iten[0], iten[1], Double.parseDouble(iten[2]), Double.parseDouble(iten[3]),
                        iten[4], iten[5], Integer.parseInt(iten[7]),Integer.parseInt(iten[9]));

                carro.setAlugado(Boolean.parseBoolean(iten[8])); // Define se o carro está alugado ou não com base no valor do índice 8
                garagem.addVeiculos(carro); // Adiciona o carro à lista de veículos da garagem
            } else {
                // Se o valor do índice 6 não for "C", cria um objeto Mot com base nas informações fornecidas
                Moto moto = new Moto(iten[0], iten[1], Double.parseDouble(iten[2]), Double.parseDouble(iten[3]),
                        iten[4], iten[5], Integer.parseInt(iten[7]), Integer.parseInt(iten[9]));

                moto.setAlugado(Boolean.parseBoolean(iten[8])); // Define se a moto está alugada ou não com base no valor do índice 8
                garagem.addVeiculos(moto); // Adiciona a moto à lista de veículos da garagem
            }
        }

        return garagem; // Retorna a lista de veículos da garagem
    }



    /**
     * Salva os dados da garagem em um arquivo CSV.
     *
     *  garagem           A garagem contendo os veículos a serem salvos.
     * salvaAtualizar    Indica se o arquivo CSV deve ser salvo como uma nova versão ou atualizado.
     */
    public static void salvarGaragemCsv(Garagem garagem, boolean salvaAtualizar) {
        // Variável para armazenar os dados da garagem em formato de string
        String dadosGaragem = "";

        // Itera sobre os veículos da garagem
        for (Veiculo veiculo : garagem.getVeiculos()) {
            if (veiculo instanceof Moto) {
                // Se o veículo for uma moto, converte para o tipo Mot
                Moto moto = (Moto) veiculo;
                // Concatena os atributos da moto separados por ponto e vírgula
                dadosGaragem += moto.getMarca() + ";" + moto.getModelo() + ";" + moto.getDiaria() + ";"
                        + moto.getKm() + ";" + moto.getSeguro() + ";" + moto.getPlaca() + ";" + moto.getTipoVeiculo() + ";"
                        + moto.getQuantidadeCapacetes() + ";" + moto.isAlugado() +";"+moto.getValoPorKm()+ "\n";
            } else if (veiculo instanceof Carro) {
                // Se o veículo for um carro, converte para o tipo Carro
                Carro carro = (Carro) veiculo;
                // Concatena os atributos do carro separados por ponto e vírgula
                dadosGaragem += carro.getMarca() + ";" + carro.getModelo() + ";" + carro.getDiaria() + ";"
                        + carro.getKm() + ";" + carro.getSeguro() + ";" + carro.getPlaca() + ";" + carro.getTipoVeiculo() + ";"
                        + carro.getQuantidadeDeportas() + ";" + carro.isAlugado() +";"+carro.getValoPorKm()+ "\n";
            }
        }

        // Chama o método salvar() para salvar os dados no arquivo
        salvar(dadosGaragem, salvaAtualizar);
    }





}
