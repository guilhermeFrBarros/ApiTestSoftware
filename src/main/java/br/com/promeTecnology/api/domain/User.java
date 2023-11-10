package br.com.promeTecnology.api.domain;

import br.com.promeTecnology.api.domain.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode( of = "Id" )
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long Id;

    //@Getter se coocar em cima do atributo gera somente para ele
    private String name;
    @Column( unique = true ) // não deve existir emails iguais na table
    private String email;
    private String password;


    public void atulaizarInformacoes(UserDTO dados) {
        if (dados.getName() != null) { this.name = dados.getName(); }
        if (dados.getEmail() != null) this.email = dados.getEmail();
        if (dados.getPassword() != null) { this.password = dados.getPassword(); }
    }
}
