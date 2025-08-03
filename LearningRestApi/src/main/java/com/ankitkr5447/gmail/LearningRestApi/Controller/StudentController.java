package com.ankitkr5447.gmail.LearningRestApi.Controller;

import com.ankitkr5447.gmail.LearningRestApi.Dto.RequestStudentDto;
import com.ankitkr5447.gmail.LearningRestApi.Dto.StudentDto;

import com.ankitkr5447.gmail.LearningRestApi.Entity.Student;
import com.ankitkr5447.gmail.LearningRestApi.Reposistory.StudentRepository;
import com.ankitkr5447.gmail.LearningRestApi.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;



    @GetMapping("/students")
    public
    ResponseEntity
            <List<StudentDto>> getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudentDto());
    }

    @GetMapping("/students/{id}")
    public
    ResponseEntity
            <com.ankitkr5447.gmail.LearningRestApi.Dto.StudentDto> getStudentbyId(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid RequestStudentDto requestStudentDto){
      return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(requestStudentDto));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void>  deleteStudent(@PathVariable long id){

        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable long id , @RequestBody @Valid RequestStudentDto requestStudentDto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id,requestStudentDto));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudentPartial(@PathVariable long id ,
                                                           @RequestBody Map<String,Object> updates)
    {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudentPartial(id,updates));
    }


}
