package demo;

import entities.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestaoCursosMain {
    public static void main(String[] args) {
        Telefone telefone = new Telefone();
        Endereco endereco = new Endereco();
        List<Telefone> telefoneList = new ArrayList<>();
        List<Endereco> enderecoList = new ArrayList<>();
        telefoneList.add(telefone);
        enderecoList.add(endereco);

        Aluno a = new Aluno();
        a.setTelefones(telefoneList);
        a.setEnderecos(enderecoList);

        Set<Aluno> alunoSet = new HashSet<>();
        alunoSet.add(a);

        Professor p = new Professor();
        p.setNomeCompleto("Pasquale Silva");
        Curso c = new Curso();
        List<Curso> cursoList = new ArrayList<>();
        cursoList.add(c);
        c.setProfessor(p);
        c.setAlunos(alunoSet);

        p.setCursos(cursoList);
    }
}
