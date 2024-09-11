package com.example.firsttask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private LocalDate dataNascimento;
    @Column(nullable = false)
    private String email;

    public User(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{"+
                "id = "+ id +
                ", nome = "+ nome + '/' +
                ", dataNascimento = "+ dataNascimento +
                ", email = "+ email +
                "}";
    }
}
