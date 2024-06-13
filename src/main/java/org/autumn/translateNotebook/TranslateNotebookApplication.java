package org.autumn.translateNotebook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.autumn.translateNotebook.mapper")
public class TranslateNotebookApplication {
    public static void main(String[] args) {
        SpringApplication.run(TranslateNotebookApplication.class, args);
    }
}
