import java.util.ArrayList;


abstract class Conteudo {
    private String titulo;
    private String diretor;
    private int lancamento;

    public Conteudo(String titulo, String diretor, int lancamento) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.lancamento = lancamento;
    }

    public String getTitulo() { 
    	return titulo; 
    	}
    public String getDiretor() { 
    	return diretor; 
    	}
    public int getLancamento() { 
    	return lancamento; 
    	}


    public abstract String detalhes();

    @Override
    public String toString() {
        return detalhes();
    }
}


class Filme extends Conteudo {
    private int duracao;

    public Filme(String titulo, String diretor, int lancamento, int duracao) {
        super(titulo, diretor, lancamento);
        this.duracao = duracao;
    }

    @Override
    public String detalhes() {
        return "Filme: " + getTitulo() + ", Diretor: " + getDiretor() + ", Lançamento: " + getLancamento() + ", Duração: " + duracao + " minutos.";
    }
}


class Serie extends Conteudo {
    private int temporadas;

    public Serie(String titulo, String diretor, int lancamento, int temporadas) {
        super(titulo, diretor, lancamento);
        this.temporadas = temporadas;
    }

    @Override
    public String detalhes() {
        return "Série: " + getTitulo() + ", Autor: " + getDiretor() + ", Lançamento: " + getLancamento() + ", Temporadas: " + temporadas;
    }
}


class Usuario {
    private String nome;
    private boolean infantil;
    private ArrayList<String> historico;
    private ArrayList<String> favoritos;

    public Usuario(String nome, boolean infantil) {
        this.nome = nome;
        this.infantil = infantil;
        this.historico = new ArrayList<>();
        this.favoritos = new ArrayList<>();
    }

    public void assistir(String conteudo) {
        historico.add(conteudo);
        System.out.println(nome + " assistiu: " + conteudo);
    }

    public void adicionarFavorito(String conteudo) {
        favoritos.add(conteudo);
        System.out.println(nome + " adicionou aos favoritos: " + conteudo);
    }

    @Override
    public String toString() {
        return "Usuário: " + nome + ", Infantil: " + (infantil ? "Sim" : "Não") +
                "\nHistórico: " + historico +
                "\nFavoritos: " + favoritos;
    }
}


class Conta {
    private int id;
    private int qtd;
    private String nome;
    private int senha;
    private ArrayList<Usuario> usuarios;

    public Conta(int id, int qtd, String nome, int senha) {
        this.id = id;
        this.qtd = qtd;
        this.nome = nome;
        this.senha = senha;
        this.usuarios = new ArrayList<>();
    }

    public int getId() { 
    	return id; 
    	}
    public void setId(int id) { 
    	this.id = id; 
    	}

    public int getQtd() { 
    	return qtd; 
    	}
    public void setQtd(int qtd) { 
    	this.qtd = qtd; 
    	}

    public String getNome() { 
    	return nome; 
    	}
    public void setNome(String nome) { 
    	this.nome = nome; 
    	}

    public int getSenha() { 
    	return senha; 
    	}
    public void setSenha(int senha) { 
    	this.senha = senha; 
    	}

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public String tipoPlano() {
        if (qtd == 1) {
            return "Plano Basic por R$19,90 (1 dispositivo)";
        } else if (qtd > 1 && qtd <= 3) {
            return "Plano Standard por R$29,90 (até 3 dispositivos)";
        } else if (qtd > 3 && qtd <= 5) {
            return "Plano Premium por R$49,90 (até 5 dispositivos)";
        } else {
            return "Plano inválido. Número de dispositivos deve ser maior que 0.";
        }
    }

    @Override
    public String toString() {
        return "Conta ID: " + id +
                "\nQuantidade de usuários: " + qtde +
                "\nNome: " + nome +
                "\nPlano: " + tipoPlano();
    }
}


public class Streaming {
    public static void main(String[] args) {

        Conta conta = new Conta(1, 3, "Marcos", 1234);


        Usuario usuario1 = new Usuario("João", false);
        Usuario usuario2 = new Usuario("Ana", true);
        conta.adicionarUsuario(usuario1);
        conta.adicionarUsuario(usuario2);


        Filme filme = new Filme("A Origem", "Christopher Nolan", 2010, 148);
        Serie serie = new Serie("Breaking Bad", "Vince Gilligan", 2008, 5);


        System.out.println(conta);
        usuario1.assistir(filme.toString());
        usuario1.adicionarFavorito(filme.toString());

        usuario2.assistir(serie.toString());
        usuario2.adicionarFavorito(serie.toString());
    }
}
