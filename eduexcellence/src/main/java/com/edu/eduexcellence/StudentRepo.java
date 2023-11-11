package com.edu.eduexcellence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo  extends JpaRepository<Student, Long> {
}
