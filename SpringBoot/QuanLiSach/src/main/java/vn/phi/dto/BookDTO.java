package vn.phi.dto;

import lombok.Data;
import org.modelmapper.ModelMapper;
import vn.phi.entity.Author;
import vn.phi.entity.Book;
import vn.phi.entity.Category;

import java.util.List;

@Data
public class BookDTO {
    private int id;

    private String name;

    private String year;

    private List<Author> authorList;

    private Category category;

    private long price;

    ModelMapper modelMapper = new ModelMapper();
    BookDTO bookDTO = modelMapper.map(book,BookDTO.class);
}
