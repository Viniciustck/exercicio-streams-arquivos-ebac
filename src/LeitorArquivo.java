import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivo {
    public static void main(String[] args) {
        // Caminho do arquivo (supondo que esteja na raiz do projeto)
        File arquivo = new File("funcionarios.csv");

        List<Funcionario> listaFuncionarios = new ArrayList<>();

        // try-with-resources garante que o arquivo será fechado ao final
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            String linha;
            // Lê linha por linha até o final do arquivo
            while ((linha = br.readLine()) != null) {

                // Requisito: Regra de separação (usando vírgula)
                String[] dados = linha.split(",");

                // Verifica se a linha tem os 4 campos esperados para evitar erros
                if (dados.length == 4) {
                    // Convertendo os dados (String -> int/double)
                    int id = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    String setor = dados[2];
                    double salario = Double.parseDouble(dados[3]);

                    // Requisito: Transformar dados lidos em objetos Java
                    Funcionario func = new Funcionario(id, nome, setor, salario);

                    listaFuncionarios.add(func);
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Exibição final
        System.out.println("--- SAÍDA EM XML DOS OBJETOS LIDOS ---");
        for (Funcionario f : listaFuncionarios) {
            // Requisito: Exibir em formato XML
            System.out.println(f.toXML());
        }
    }
}