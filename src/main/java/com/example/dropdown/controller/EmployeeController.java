package com.example.dropdown.controller;

import java.util.List;
import java.util.stream.Collectors;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dropdown.model.Employee;
import com.example.dropdown.model.EmployeeInfo;
import com.example.dropdown.repository.EmployeeInfoRepository;
import com.example.dropdown.repository.EmployeeRepository;
import com.example.dropdown.service.EmployeeService;


@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeInfoRepository employeeInfoRepository;
	
	@GetMapping("/employeeForm")
	public String showEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeform";
	}
	
	@PostMapping("/submitEmployee")
	public String submitEmployeeForm(@ModelAttribute("employee") Employee employee, Model model) {
		Employee savedEmployee = employeeRepository.save(employee);
		model.addAttribute("employeeInfo", new EmployeeInfo());
		model.addAttribute("id", savedEmployee.getEmployeeId());
		return "employeeInfo";
	}
	
	@PostMapping("/submitEmployeeInfo")
	public String submitEmployeeInfo(@ModelAttribute("employeeinfo") EmployeeInfo employeeInfo) {
		employeeInfoRepository.save(employeeInfo);
		return "redirect:/success";
	}
	
	@GetMapping("/success")
	public String showSuccessPage() {
		return "success";
	}
	
	@GetMapping("/employeeDetails")
	public String employeeDetails() {
		return "employeeDetails";
	}
}
	/*@GetMapping("/employeeDetails")
	public String employeeDetails(@RequestParam("name") String name, Model model) {
		//Optional<Employee> employee = employeeRepository.findByName(name);
		Employee employee = employeeRepository.findByName(name);
		if(employee != null) {
			Optional<EmployeeInfo> employeeInfo = employeeInfoRepository.findById(employee.getEmployeeId());
			model.addAttribute("employee", employee);
			model.addAttribute("employeeInfo", employeeInfo);
		}
		/*else {
			throw new ResourceNotFound("Employee", "Id");
		}
		return "employeeDetails";
	}*/

/*@GetMapping("/getEmployeeName")
public String getEmployeeName(@RequestParam("name") String name) {
    // Retrieve employee name from the database based on the provided employeeId
   // String employeeName = employeeRepository.findBy(null, null)
Employee employeeName=employeeRepository.findByEmployeeName(name);
						//.orElseThrow(()->ResourceNotFoundException("employee not found with name"+name));
    // Add the employee name to the model to be rendered in the HTML
    //model.addAttribute("employeeName", employeeName);

    // Return the name of the Thymeleaf template to render (in this case, the same HTML file)
    return "fetchEmployeeName";
}}*/
	
		/*(@Autowired
		private EmployeeService employeeService;
		
	    @GetMapping("/employeeDetails1")
	    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name) {
	        List<Employee> employees = employeeService.getEmployeeByName(name);
	        if (employees.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(employees);
	    }}
	
	/*@GetMapping("/employeeDetails")
    public String dropdownEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        
        // Fetch user names from the database
        List<Employee> users = employeeRepository.findAll();
        List<String> userNames = users.stream().map(Employee::getName).collect(Collectors.toList());
        model.addAttribute("userNames", userNames);
        
        return "employeeForm";
    }
}*/