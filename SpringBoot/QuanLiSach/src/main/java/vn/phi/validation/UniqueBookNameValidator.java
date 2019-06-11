package vn.phi.validation;

import org.springframework.beans.factory.annotation.Autowired;
import vn.phi.repository.BookRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueBookNameValidator implements ConstraintValidator<UniqueBookName, String> {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void initialize(UniqueBookName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if(bookRepository == null){
            return true;
        }
        return bookRepository.countByName(name) < 1;
    }
}
