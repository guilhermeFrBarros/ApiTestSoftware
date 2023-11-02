package br.com.promeTecnology.api.domain;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode( of = "Id" )
@Entity
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer Id;

    //@Getter se coocar em cima do atributo gera somente para ele
    private String name;
    @Column( unique = true ) // não deve existir emails iguais na table
    private String email;
    private String password;

}
