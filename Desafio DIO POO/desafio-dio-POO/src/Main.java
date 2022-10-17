import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Criado o Professor1
        Professor professor1 = new Professor();
        professor1.setNome("Professor Manoel");

        //Criado o Professor2
        Professor professor2 = new Professor();
        professor2.setNome("Professor Carlos");

        //Criado o Professor3
        Professor professor3 = new Professor();
        professor3.setNome("Professora Renata");

        //Criado o curso1
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Curso de Java para iniciantes");
        curso1.setCargaHoraria(8);
        curso1.setProfessor(professor1);

        //Criado o curso2
        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Curso de JavaScript para iniciantes");
        curso2.setCargaHoraria(4);
        curso2.setProfessor(professor2);

        //Criado a mentoria1
        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria de Java");
        mentoria1.setDescricao("Descrição mentoria de Java");
        mentoria1.setData(LocalDate.now());
        mentoria1.setProfessor(professor3);

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria1);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Develepor");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev devFelipe = new Dev();
        devFelipe.setNome("Felipe");
        devFelipe.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos: " + devFelipe.getConteudosInscritos());
        devFelipe.progredir();
        devFelipe.progredir();
        System.out.println("Conteúdos Inscritos: " + devFelipe.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos: " + devFelipe.getConteudosConcluidos());
        System.out.println("XP: " + devFelipe.calcularTotalXp());

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos: " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        System.out.println("Conteúdos Inscritos: " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos: " + devJoao.getConteudosConcluidos());
        System.out.println("XP: " + devJoao.calcularTotalXp());
    }
}
