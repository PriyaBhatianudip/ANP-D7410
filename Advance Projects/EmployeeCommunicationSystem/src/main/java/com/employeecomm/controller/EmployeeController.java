package com.employeecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeecomm.entity.Employee;
import com.employeecomm.repository.EmployeeRepository;
import com.employeecomm.repository.PendingRegistrationRepository;
import com.employeecomm.service.OtpService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PendingRegistrationRepository pendingRepository;

    @Autowired
    private OtpService otpService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute("employee", new Employee());

        return "register";
    }

    @PostMapping("/register")
    public String registerEmployee(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult result,
            Model model,
            HttpSession session) {

        if (result.hasErrors()) {
            return "register";
        }

        if (employeeRepository.existsById(
                employee.getEmployeeId())
                || pendingRepository.existsByEmployeeId(
                employee.getEmployeeId())) {

            model.addAttribute("error",
                    "Employee ID already exists or registration is pending!"+employee.getEmployeeId());

            return "register";
        }

        if (employeeRepository.existsByEmail(
                employee.getEmail())
                || pendingRepository.existsByEmail(
                employee.getEmail())) {

            model.addAttribute("error",
                    "Email is already registered or registration is pending!");

            return "register";
        }

        try {

            String registrationId =
                    otpService.startRegistration(employee);

            session.setAttribute(
                    "pendingRegistrationId", registrationId);

            return "redirect:/employee/verify-otp";

        } catch (Exception e) {

            model.addAttribute("error",
                    "Unable to send OTP. Please try again."+e.getMessage());

            return "register";
        }
    }

    @GetMapping("/verify-otp")
    public String showOtpPage(HttpSession session) {

        if (session.getAttribute(
                "pendingRegistrationId") == null) {

            return "redirect:/employee/register";
        }

        return "verify-otp";
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(
            @RequestParam String otp,
            HttpSession session,
            Model model) {

        String registrationId = (String)
                session.getAttribute("pendingRegistrationId");

        if (registrationId == null) {
            return "redirect:/employee/register";
        }

        String result = otpService.verifyOtp(
                registrationId, otp);

        if (result.equals("SUCCESS")) {

            session.removeAttribute("pendingRegistrationId");

            return "redirect:/employee/registration-success";
        }

        if (result.equals("INVALID")) {
            model.addAttribute("error",
                    "Incorrect OTP. Please try again.");
        }
        else if (result.equals("EXPIRED")) {
            session.removeAttribute("pendingRegistrationId");
            model.addAttribute("error",
                    "OTP expired. Please register again.");
        }
        else if (result.equals("MAX_ATTEMPTS")) {
            session.removeAttribute("pendingRegistrationId");
            model.addAttribute("error",
                    "Maximum attempts exceeded. Please register again.");
        }
        else if (result.equals("DUPLICATE")) {
            session.removeAttribute("pendingRegistrationId");
            model.addAttribute("error",
                    "Employee ID or email is already registered.");
        }
        else {
            session.removeAttribute("pendingRegistrationId");
            model.addAttribute("error",
                    "Registration session not found.");
        }

        return "verify-otp";
    }

    @GetMapping("/registration-success")
    public String registrationSuccess() {
        return "registration-success";
    }
}