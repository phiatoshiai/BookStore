package vn.phi.entity;

import vn.phi.validation.UniqueAuthorName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @UniqueAuthorName
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "age")
    private String age;

    @NotNull
    @Column(name = "province")
    private String province;

    @ManyToMany(mappedBy = "authorList")
    private List<Book> bookList;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
