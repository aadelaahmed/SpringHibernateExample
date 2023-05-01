package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView showRegisterationForm(){
        System.out.println("here is the showForm method in employeecontroller");
        return new ModelAndView("register","employee",new Employee());
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("employee")Employee employee,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
            //return "error";
        }
        System.out.println("employee data ->"+employee.toString());
        model.addAttribute("name", employee.getFirstName());
        model.addAttribute("contactNumber", employee.getPhone());
        model.addAttribute("id", employee.getId());
        employeeService.addEmployee(employee);
        return "employeeView";
    }
    @RequestMapping(value = "/cv",method = RequestMethod.GET)
    public ModelAndView showCvForm(){
        System.out.println("here is the showCvForm method in employee controller");
        return new ModelAndView("uploadfile","file",new MultipartFile[0]);
    }
    @RequestMapping(value = "/uploadcv",method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file")MultipartFile multipartFile,Model model){
        System.out.println("start uploading file....");
        model.addAttribute("file",multipartFile);
        System.out.println("Start uploading file....");
        // Get the bytes of the uploaded file
        byte[] fileBytes = new byte[0];
        try {
            fileBytes = multipartFile.getBytes();
            String uploadDir = "F:\\Adel\\ITI 9 Months";
            File file = new File(uploadDir + "\\" + multipartFile.getOriginalFilename());
            FileCopyUtils.copy(fileBytes, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("file", multipartFile);
        return "viewFileData";
    }
}
