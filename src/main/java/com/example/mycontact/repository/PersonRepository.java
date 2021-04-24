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

    @Query(value = "select person from Person  person where person.birthday.monthOfBirthday = :month")
    List<Person> findByMonthOfBirthday(@Param("month") Integer month);

    @Query(value = "select person from Person  person where person.birthday.monthOfBirthday = ?1 and person.birthday.dayOfBirthday= ?2")
    List<Person> findByDayOfBirthday(int month, Integer day);

    //네이비트 쿼리는 전부 소문자 & 중간에 있는 대문자는 소문자로 바꾸고 앞에 _붙임
    @Query(value = "select * from person where year_of_birthday = :year", nativeQuery = true)
    List<Person> findByYearOfBirthday(@Param("year") Integer year);

    //네이비트 쿼리는 전부 소문자 & 중간에 있는 대문자는 소문자로 바꾸고 앞에 _붙임
    @Query(value = "select * from person where deleted = true", nativeQuery = true)
    List<Person> findPeopleDeleted();

    @Query(value = "select person from Person  person where person.birthday.monthOfBirthday = ?1 and person.birthday.dayOfBirthday= ?2 or person.birthday.monthOfBirthday = ?3 and person.birthday.dayOfBirthday= ?4 ")
    List<Person> findBirthdayTodayTomorrow( Integer todayMonth, Integer todayDay, Integer tomorrowMonth, Integer tomorrowDay);
}
