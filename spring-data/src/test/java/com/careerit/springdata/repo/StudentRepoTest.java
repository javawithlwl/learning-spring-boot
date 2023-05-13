package com.careerit.springdata.repo;

import com.careerit.springdata.domain.Passport;
import com.careerit.springdata.domain.Student;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private PassportRepo passportRepo;

    @Test
    void addStudent(){
        System.out.println("Add student test");
        Passport passport = new Passport();
        passport.setNumber("123456789");
        passport.setFullName("Krish T");
        passport.setExpiryDate(LocalDate.of(2025, 10, 10));
        passport.setIssuedDate(LocalDate.of(2015, 10, 10));
        passport = passportRepo.save(passport);

        Student student = new Student();
        student.setName("Krish");
        student.setMobile("9876543210");
        student.setEmail("krish.t@gmail.com");
        student.setPassport(passport);
        student=studentRepo.save(student);

        Optional<Student> optStudent = studentRepo.findById(student.getId());
        if(optStudent.isPresent()){
          System.out.println(optStudent.get().getPassport());
        }
    }
}
