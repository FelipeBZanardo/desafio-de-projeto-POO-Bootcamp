package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();       //Set não repete elementos. LinkedHashSet mantém a ordem
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    private Set<Certificado> certificados = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsIncritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo =  this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            Certificado certificado = new Certificado();
            certificado.setConteudo(conteudo.get());
            certificado.setDev(this);
            certificado.setDataConclusao(LocalDate.now());
            this.certificados.add(certificado);
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXP).sum();
    }

    public void imprimirCertificado (){
        if (!this.certificados.isEmpty()){
            for (Certificado certificado : certificados){
                System.out.println("***Certificado***");
                System.out.println("Curso: " + certificado.getConteudo().getTitulo());
                System.out.println("************************");
                System.out.println("Aluno: " + certificado.getDev().getNome());
                System.out.println("Professor responsável: " + certificado.getConteudo().getProfessor().getNome());
                System.out.println("************************");
                System.out.println("Data de conclusão: " + certificado.getDataConclusao());
                System.out.println();
            }
        } else {
            System.out.println("Não há certificados disponíveis");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public Set<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(Set<Certificado> certificados) {
        this.certificados = certificados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
