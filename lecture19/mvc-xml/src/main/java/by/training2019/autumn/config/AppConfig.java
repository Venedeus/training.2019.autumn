package by.training2019.autumn.config;

import by.training2019.autumn.dao.DAO;
import by.training2019.autumn.dao.FacultyDAOImpl;
import by.training2019.autumn.dao.StudentDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class AppConfig {
    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean(name = "facultyDAO")
    public DAO getFaculties(){
        return new FacultyDAOImpl();
    }
    
    @Bean(name = "studentDAO")
    public DAO getStudents(){
        return new StudentDAOImpl(getFaculties());
    }
}
