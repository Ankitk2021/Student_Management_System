package com.ankitkr5447.gmail.LearningRestApi.Reposistory;

import com.ankitkr5447.gmail.LearningRestApi.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, Long> {
}
