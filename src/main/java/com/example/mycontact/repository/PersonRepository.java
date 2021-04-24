package com.example.mycontact.repository;

import com.example.mycontact.domain.Block;
import com.example.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findByName(String name);
    List<Person> findByBlockIsNull();
    List<Person> findByBloodType(String bloodType);
    @Query(value = "select person from Person  person where person.birthday.month = :month")
    List<Person> findByMonthOfBirthday(@Param("month") int month);

    @Query(value = "select person from Person  person where person.birthday.month = ?1 and person.birthday.day= ?2")
    List<Person> findByDayOfBirthday(int month, int day);

    //네이비트 쿼리는 전부 소문자 & 중간에 있는 대문자는 소문자로 바꾸고 앞에 _붙임
    @Query(value = "select * from person where year = :year", nativeQuery = true)
    List<Person> findByYearOfBirthday(@Param("year") int year);
}
