package com.springTrainingG.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springTrainingG.MyData;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {

}
