package br.com.fiap.traveller.entities;

import br.com.fiap.traveller.entities.enums.Role;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_TRV_USER")
public class Usuario {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_user", length = 40)
    private String nome;

    @Column(name = "ds_sobrenome", length = 40)
    private String sobrenome;

    @Column(name = "ds_email", length = 80)
    private String email;

    @Column(name = "ds_password", length = 80)
    private String password;

    @Column(name = "ds_genero", length = 40)
    private String genero;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_role", length = 40)
    private Role role;

    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;

    @CreationTimestamp
    @Column(name = "dt_cadastro")
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "id.usuario")
    private List<Avaliacao> avaliacoes = new ArrayList<>();


    public Usuario(Long id, String nome, String sobrenome, String email, String password, String genero, Role role, LocalDate dtNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.password = password;
        this.genero = genero;
        this.role = role;
        this.dtNascimento = dtNascimento;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", genero='" + genero + '\'' +
                ", role=" + role +
                ", dtNascimento=" + dtNascimento +
                ", timestamp=" + timestamp +
                '}';
    }
}
