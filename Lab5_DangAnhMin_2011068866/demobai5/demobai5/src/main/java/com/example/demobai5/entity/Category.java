
package com.example.demobai5.entity;

        import jakarta.persistence.*;
        import java.util.List;
        import lombok.Data;
@Data
@Entity
@Table(name ="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;
}
