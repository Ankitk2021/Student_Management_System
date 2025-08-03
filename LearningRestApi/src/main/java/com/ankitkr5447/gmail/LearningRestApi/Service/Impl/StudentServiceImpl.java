package com.ankitkr5447.gmail.LearningRestApi.Service.Impl;

import com.ankitkr5447.gmail.LearningRestApi.Dto.RequestStudentDto;
import com.ankitkr5447.gmail.LearningRestApi.Dto.StudentDto;
import com.ankitkr5447.gmail.LearningRestApi.Entity.Student;
import com.ankitkr5447.gmail.LearningRestApi.Reposistory.StudentRepository;
import com.ankitkr5447.gmail.LearningRestApi.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service //Ye persistence Layer se baat Karegi.
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public StudentDto getStudentById(long id) {
        Student student;

        student = studentRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found of Id : " + id));


        return new StudentDto(student.getId(), student.getEmail(), student.getName());
    }

    @Override
    public List<StudentDto> getAllStudentDto() {

        List<Student> studentList = studentRepository.findAll();

        List<StudentDto> studentDtos = studentList
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
        return studentDtos;
    }

    @Override
    public StudentDto createNewStudent(RequestStudentDto requestStudentDto) {

        Student newStudent = modelMapper.map(requestStudentDto, Student.class);
        Student student = studentRepository.save(newStudent);

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No Student have id : " + id);
        }
    }

    @Override
    public StudentDto updateStudent(long id, RequestStudentDto requestStudentDto) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No student found with this id : " + id));


        modelMapper.map(requestStudentDto, student);
        student = studentRepository.save(student);

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updateStudentPartial(long id, Map<String, Object> updates) {

        Student student = studentRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("No student found with this id : " + id));

        updates.forEach(( field, value)->{

            switch (field){
                case "name" :
                    student.setName(value.toString());
                    break;
                case "email" :
                    student.setEmail(value.toString());
                    break;
                default: throw new IllegalArgumentException("Not Supported Updated.");
            }

        });

        Student savedstudent = studentRepository.save(student);

        return modelMapper.map(savedstudent,StudentDto.class);
    }


}
