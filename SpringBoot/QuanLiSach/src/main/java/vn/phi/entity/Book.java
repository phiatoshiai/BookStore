package vn.phi.entity;

import vn.phi.validation.Create;
import vn.phi.validation.UniqueBookName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @UniqueBookName(groups = {Create.class})
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "year")
    private String year;

    @NotNull
    @Column(name = "price")
    private long price;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "book_has_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private List<Author> authorList;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "category_id")
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
