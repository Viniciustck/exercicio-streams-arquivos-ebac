public class Funcionario {
    private int id;
    private String nome;
    private String setor;
    private double salario;

    public Funcionario(int id, String nome, String setor, double salario) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.salario = salario;
    }

    // Requisito: Exibir esse objeto em formato XML
    public String toXML() {
        return "<funcionario>\n" +
                "  <id>" + id + "</id>\n" +
                "  <nome>" + nome + "</nome>\n" +
                "  <setor>" + setor + "</setor>\n" +
                "  <salario>" + salario + "</salario>\n" +
                "</funcionario>";
    }

    // Sobrescrevendo toString apenas para debug, se precisar
    @Override
    public String toString() {
        return "Funcionario{id=" + id + ", nome='" + nome + "'}";
    }
}