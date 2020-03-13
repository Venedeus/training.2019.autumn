package by.training2019.autumn.controller;

import by.training2019.autumn.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FacultyController {
    @Autowired
    private DAO facultyDAO;

    @RequestMapping(value = "getFaculties", method = RequestMethod.GET)
    public String addStudent(Model model){

        model.addAttribute("title", "List of faculties");
        model.addAttribute("faculties", facultyDAO.getAll());

        return "faculties";
    }
}
