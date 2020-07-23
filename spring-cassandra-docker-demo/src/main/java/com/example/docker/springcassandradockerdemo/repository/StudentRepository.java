package com.example.docker.springcassandradockerdemo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.docker.springcassandradockerdemo.entity.Student;

public interface StudentRepository extends CassandraRepository<Student, Integer> {

}
