package AcademySystem;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class FileSystem {

    private Aluno aluno;
    private int qtde = 0;
    private String LineFile = new String();


    public void importa(String caminho, int tamArray) {

        {

            File fileCSV = new File(caminho);

            try {
                Scanner reader = new Scanner(fileCSV);
                Aluno[] alunos1 = new Aluno[tamArray];
                while (reader.hasNext()){
                    LineFile = reader.nextLine();
                    String alunos[] = LineFile.split(";");

                    String nome = alunos[0];
                    if (nome.length() == 0){
                        nome = "null";
                        System.err.println("O campo nome está vazio");
                    }

                    int matricula;
                    String matriculaString = alunos[1];
                    if (matriculaString.length() == 0) {
                        matricula = 0;
                        System.err.println("O campo Matrícula está vazio");
                    }else{
                        matricula = Integer.parseInt(alunos[1]);
                    }

                    String email;
                    if (alunos.length <3){
                        email = "null";
                        System.err.println("O campo E-mail está vazio");
                    } else{
                        email = alunos[2];
                    }

                    Aluno aluno = new Aluno(nome,matricula,email);


                    if (qtde >= 0) {
                        alunos1[this.qtde] = aluno;
                        this.qtde = this.qtde + 1;
                    }
                }
                Arrays.sort(alunos1, new Comparator() {
                    public int compare(Object o1, Object o2) {
                        Aluno p1 = (Aluno) o1;
                        Aluno p2 = (Aluno) o2;
                        return p1.getMatricula() < p2.getMatricula() ? -1 : (p1.getMatricula() > p2.getMatricula() ? +1 : 0);
                    }
                });

                System.out.println(alunos1[0]);
                System.out.println(alunos1[1]);
                System.out.println(alunos1[2]);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int contaLinhas(String caminho) throws IOException {

        int tamArray;

        LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(new FileInputStream(caminho)));
        String nextLine = null;

        try {
            while ((nextLine = lineCounter.readLine()) != null) {
                if (nextLine == null)
                    break;
            }
        } catch (Exception done) {
            done.printStackTrace();
        }
        return lineCounter.getLineNumber();
    }
}

