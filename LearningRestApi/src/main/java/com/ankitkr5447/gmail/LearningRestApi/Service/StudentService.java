package com.ankitkr5447.gmail.LearningRestApi.Service;

import com.ankitkr5447.gmail.LearningRestApi.Dto.RequestStudentDto;
import com.ankitkr5447.gmail.LearningRestApi.Dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {

     StudentDto getStudentById(long id);

    List<StudentDto> getAllStudentDto();



    StudentDto createNewStudent(RequestStudentDto requestStudentDto);

    void deleteStudentById(long id);

    StudentDto updateStudent(long id, RequestStudentDto requestStudentDto);

    StudentDto updateStudentPartial(long id, Map<String, Object> updates);
}
