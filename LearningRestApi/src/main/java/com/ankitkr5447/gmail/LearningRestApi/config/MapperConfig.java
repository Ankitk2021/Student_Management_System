package com.ankitkr5447.gmail.LearningRestApi.config;


import com.ankitkr5447.gmail.LearningRestApi.Dto.RequestStudentDto;
import com.ankitkr5447.gmail.LearningRestApi.Entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(RequestStudentDto.class, Student.class)
                .addMappings(mapper -> mapper.skip(Student::setId));


        return modelMapper;

    }
}
