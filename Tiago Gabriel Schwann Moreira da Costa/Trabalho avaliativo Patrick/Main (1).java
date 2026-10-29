import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;

    public Livro(int novoId, String novoTitulo, String novoAutor, int novoAno) {
        id = novoId;
        titulo = novoTitulo;
        autor = novoAutor;
        ano = novoAno;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public void setTitulo(String novoTitulo) {
        titulo = novoTitulo;
    }

    public void setAutor(String novoAutor) {
        autor = novoAutor;
    }

    public void setAno(int novoAno) {
        ano = novoAno;
    }
}

public class Main {

    static ArrayList<Livro> livros = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int proximoId = 1;

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("gerenciamento de livros");
            System.out.println("1 - cadastrar");
            System.out.println("2 - listar todos");
            System.out.println("3 - buscar por ID");
            System.out.println("4 - atualizar");
            System.out.println("5 - excluir");
            System.out.println("0 - sair");
            opcao = lerNumero("escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    excluir();
                    break;
                case 0:
                    System.out.println("encerrando");
                    break;
                default:
                    System.out.println("opção inválida!");
            }
        }
    }

    static int lerNumero(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = sc.nextLine();
            if (texto.matches("[0-9]{1,9}")) {
                return Integer.parseInt(texto);
            }
            System.out.println("digite um número válido");
        }
    }

    static Livro procurar(int id) {
        for (Livro l : livros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    static void mostrar(Livro l) {
        System.out.println("ID: " + l.getId() + "titulo: " + l.getTitulo()
                + " | autor: " + l.getAutor() + "ano: " + l.getAno());
    }

    static void cadastrar() {
        System.out.print("titulo: ");
        String titulo = sc.nextLine();
        System.out.print("autor: ");
        String autor = sc.nextLine();
        int ano = lerNumero("ano: ");

        Livro novo = new Livro(proximoId, titulo, autor, ano);
        livros.add(novo);
        proximoId++;
        System.out.println("livro cadastrado, ID: " + novo.getId());
    }

    static void listar() {
        if (livros.isEmpty()) {
            System.out.println("nenhum registro cadastrado.");
            return;
        }
        for (Livro l : livros) {
            mostrar(l);
        }
    }

    static void buscar() {
        if (livros.isEmpty()) {
            System.out.println("nenhum registro cadastrado.");
            return;
        }
        int id = lerNumero("digite o ID: ");
        Livro l = procurar(id);
        if (l == null) {
            System.out.println("ID não encontrado.");
        } else {
            mostrar(l);
        }
    }

    static void atualizar() {
        if (livros.isEmpty()) {
            System.out.println("nenhum registro cadastrado.");
            return;
        }
        int id = lerNumero("digite o ID do livro: ");
        Livro l = procurar(id);
        if (l == null) {
            System.out.println("ID não encontrado.");
            return;
        }
        System.out.print("novo titulo: ");
        l.setTitulo(sc.nextLine());
        System.out.print("novo autor: ");
        l.setAutor(sc.nextLine());
        l.setAno(lerNumero("novo ano: "));
        System.out.println("livro atualizado!");
    }

    static void excluir() {
        if (livros.isEmpty()) {
            System.out.println("nenhum registro cadastrado.");
            return;
        }
        int id = lerNumero("digite o ID do livro: ");
        Livro l = procurar(id);
        if (l == null) {
            System.out.println("ID não encontrado.");
        } else {
            livros.remove(l);
            System.out.println("livro excluído!");
        }
    }
}