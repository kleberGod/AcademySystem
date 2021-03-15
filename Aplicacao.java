package AcademySystem;

import java.io.IOException;

public class Aplicacao {

    private FileSystem fileSystem;


    public static void main(String[] args) throws IOException {
        Aplicacao aplicacao = new Aplicacao();
        aplicacao.init();
    }

    private void init() throws IOException {
        final String caminho = "C:/Users/win/Desktop/Arquivo.csv";
        this.fileSystem = new FileSystem();
        int tamArray = fileSystem.contaLinhas(caminho);
        fileSystem.importa(caminho,tamArray);
    }

}
