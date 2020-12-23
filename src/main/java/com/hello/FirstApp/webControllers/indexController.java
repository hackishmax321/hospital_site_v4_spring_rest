package com.hello.FirstApp.webControllers;

import com.hello.FirstApp.exception.CustomExceptionRequest;
import com.hello.FirstApp.exception.ExceptionControl;
import com.hello.FirstApp.functionalities.PDFGen;
import com.hello.FirstApp.modals.*;
import com.hello.FirstApp.services.*;
import com.sun.deploy.util.SessionState;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Need to handle Incorrect and Null value acceptances

@Controller
@SessionAttributes({"username", "role", "extra"})
public class indexController {
    Log log = LogFactory.getLog(ExceptionControl.class);

    @Autowired
    private AppointmentService appoint_serve;

    @Autowired
    private DoctorService doctor_serve;

    @Autowired
    private PatientService patient_serve;

    @Autowired
    private TestService test_serve;

    @Autowired
    private TechnicianService tech_serve;

    @Autowired
    private ReceiptService receipt_serve;

//    List<Doctor> doctor_list = doctor_serve.readAllDoctors();
//    List<Technician> tech_list = tech_serve.readAllTechnicians();
//    List<Patient> pat_list = patient_serve.readAllPatients();

    @RequestMapping("/")
    public RedirectView index(){
        return new RedirectView("/home");
    }

    @RequestMapping("home")
    public ModelAndView indexLoad(){
        List<Doctor> doctor_list = doctor_serve.readAllDoctors();
        ModelAndView mv = new ModelAndView();
        mv.addObject("doctors", doctor_list);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("appointments/{page}")
    public ModelAndView appointmentsLoad(@PathVariable("page") Optional<Integer> page){

        Page<Appointment> appoint_list = appoint_serve.getAppointmentsPages(new PageRequest(page.orElse(0), 10));
//        Page<Appointment> p = new PageImpl<>(appoint_list, pageable, 10);
//        List<Appointment> userSubList = appoint_list.subList((pageable.getPageNumber())*pageable.getPageSize(), (pageable.getPageNumber()*pageable.getPageSize()));
//        final Page<Appointment> p = new PageImpl<>(userSubList, pageable,appoint_list.size());
        ModelAndView mv = new ModelAndView();
        mv.addObject("appointlist",appoint_list);
        mv.setViewName("appointments");
        return mv;
    }

    @GetMapping("appointments/order")
    @ResponseBody
    public ModelAndView appointmentsOrderLoad(@RequestParam(name = "page") Optional<Integer> page){


        Page<Appointment> appoint_list = appoint_serve.orderAppointments(new PageRequest(page.orElse(0), 10));
        List<Appointment> asList = appoint_serve.readAllAppointments();

        int page_count = (asList.size()/10)+1;

        ModelAndView mv = new ModelAndView();

//        System.out.println("VAL - "+asList.size());
        mv.addObject("appointlist",appoint_list);
        mv.addObject("pagecount", page_count);
        mv.setViewName("appointments");

        return mv;

    }

    @RequestMapping("tests")
    public ModelAndView testsLoad(){

        List<Test> test_list = test_serve.readAllTests();

        ModelAndView mv = new ModelAndView();
        mv.addObject("testlist",test_list);
        mv.setViewName("tests");
        return mv;
    }

    @RequestMapping("tests/testform")
    public ModelAndView testSingleLoad(){
        List<Doctor> doctor_list = doctor_serve.readAllDoctors();
        List<Technician> tech_list = tech_serve.readAllTechnicians();
        List<Patient> pat_list = patient_serve.readAllPatients();

        ModelAndView mv = new ModelAndView();
        mv.addObject("doctors", doctor_list);
        mv.addObject("patients", pat_list);
        mv.addObject("techs", tech_list);
        mv.setViewName("test_form");
        return mv;
    }

    @RequestMapping("tests/receiptform")
    public ModelAndView receiptSingleLoad(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("receipt_form");
        return mv;
    }

    @RequestMapping("medicines")
    public ModelAndView medicinesLoad(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("medicines");
        return mv;
    }

    @RequestMapping("appointments/appointment")
    public ModelAndView appointmentLoad(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("medicines");
        return mv;
    }

    @RequestMapping("appointmentSubmit")
    public ModelAndView makeAppointment(Appointment appoint, @RequestParam("doctor") String doc, @RequestParam("patient") String patient){

//        Set a Doctor
        Integer docInt = Integer.parseInt(doc);
        Optional<Doctor> appoint_doc = doctor_serve.readDoctor(docInt);

//        Set a Patient
        Integer patInt = Integer.parseInt(patient);
        Optional<Patient> appoint_pat = patient_serve.readPatient(patInt);

//        Time time = Time.valueOf(time_form);
//        System.out.println(time);

//        To DB
        appoint.setId_doctor(appoint_doc.get());
        appoint.setId_patient(appoint_pat.get());
//        appoint.setDue_time(time);
        appoint_serve.createAppointment(appoint);

        ModelAndView mv = new ModelAndView();
        System.out.println("DF DATA - "+appoint.getDate());
        mv.addObject("appointment", appoint);
        mv.setViewName("appointment_valid");
        return mv;
    }

    @RequestMapping("tests/testSubmit")
    public ModelAndView makeTest(Test test, @RequestParam("doctor") String doc, @RequestParam("patient") String patient, @RequestParam("tech") String tech){

//        Set a Doctor
        Integer docInt = Integer.parseInt(doc);
        Optional<Doctor> test_doc = doctor_serve.readDoctor(docInt);

//        Set a Patient
        Integer patInt = Integer.parseInt(patient);
        Optional<Patient> test_pat = patient_serve.readPatient(patInt);

//      Technician
//        Integer techInt = Integer.parseInt(tech);
//        Optional<Technician> test_tech = tech_serve.readTechnician(techInt);

//        To DB
        test.setId_doctor(test_doc.get());
        test.setId_patient(test_pat.get());
//        test.setId_tech(test_tech.get());
        test_serve.createTest(test);

        ModelAndView mv = new ModelAndView();
        mv.addObject("test", test);
        mv.setViewName("tests");
        return mv;
    }

    @RequestMapping("tests/receiptSubmit")
    public ModelAndView makeReceipt(Receipt receipt, @RequestParam("patient") String patient){

//        Set a Patient
        Integer patInt = Integer.parseInt(patient);
        Optional<Patient> test_pat = patient_serve.readPatient(patInt);

        receipt.setId_patient(test_pat.get());
        receipt_serve.createReceipt(receipt);

//        Create PDF
//        PDFGen pdf = new PDFGen();
//        pdf.createPDF(4555, "Something");

        ModelAndView mv = new ModelAndView();
        mv.addObject("receipt", receipt);
        mv.setViewName("receipt_single");
        return mv;
    }


    public String confirmAppointment(){
        return "index";
    }

    @RequestMapping("user_open")
    public ModelAndView userOpenPageLoad(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user_choice");
        return mv;
    }

    @RequestMapping("register_staff")
    public ModelAndView registerStaffLoad(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register_s");
        return mv;
    }

    @RequestMapping("registerStaffSubmit")
    public ModelAndView registerStaffSubmitLoad(Doctor doctor){
        doctor_serve.createDoctor(doctor);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", doctor);
        mv.setViewName("register_confirm");
        return mv;
    }

    @RequestMapping("register_user")
    public ModelAndView registerLoad(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping("registerUserSubmit")
    public ModelAndView registerSubmitLoad(Patient patient){
        patient_serve.createPatient(patient);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", patient);
        mv.setViewName("register_confirm");
        return mv;
    }

    @RequestMapping("login")
    public ModelAndView loginLoad(){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("loginSubmit")
    public ModelAndView loginSubmitLoad(@RequestParam("email") String email, @RequestParam("auth_code") String code, ModelMap mv){
//        Validation
        Pattern patdoc = Pattern.compile("SHDOC*");
        Pattern pattec = Pattern.compile("SHTEC");
        Pattern patpat = Pattern.compile("SHPAT");



        Matcher match = patdoc.matcher(code);
        if(Pattern.matches("(SHDOC)(\\d+)", code)){
            System.out.println("LOAD DOCTOR");
            List<Doctor> doc = doctor_serve.readAllDoctors();
            for (Doctor user : doc) {
                if ((user.getEmail().equals(email))&&(user.getAuth_code().equals(code))) {
//                    Set Session
                    System.out.println("LOGIN COMPLETED");

                    mv.addAttribute("username", user.getName());
                    mv.addAttribute("role", "Doctor");
                    return new ModelAndView("redirect:/home", mv);
                }
            }

        } if(Pattern.matches("(SHPAT)(\\d+)", code)){
            System.out.println("LOAD PATIENT");
            List<Patient> pat = patient_serve.readAllPatients();
            for (Patient user : pat) {
                if ((user.getEmail().equals(email))&&(user.getAuth_code().equals(code))) {
//                    Set Session
                    System.out.println("LOGIN COMPLETED");

                    mv.addAttribute("username", user.getInitial_name());
                    mv.addAttribute("role", "Patient");
                    return new ModelAndView("redirect:/home", mv);
                }
            }

        } else if(Pattern.matches("(SHTEC)(\\d+)", code)){
            System.out.println("LOAD TECHNICIAN");
            List<Technician> tec = tech_serve.readAllTechnicians();
            for (Technician user : tec) {
                if ((user.getEmail().equals(email))&&(user.getAuth_code().equals(code))) {
//                    Set Session
                    System.out.println("LOGIN COMPLETED");

                    mv.addAttribute("username", user.getName());
                    mv.addAttribute("role", "Technician");
                    return new ModelAndView("redirect:/home", mv);
                }
            }
        }

//        Session

//        mv.addObject("user", email);
//        ModelAndView mv = new ModelAndView("redirect:/login");
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping("/logout")
    public RedirectView logoutLoad(SessionStatus status){
        status.setComplete();
        RedirectView mv = new RedirectView("/home");

        return mv;
    }

//    Throw Controller specific exceptions
    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleSpecificExceptions(HttpServletRequest req, Exception ex, Model model){
        HttpStatus badReq = HttpStatus.BAD_REQUEST;

        log.error(ex);
        model.addAttribute("status", badReq.value());
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("cause", ex.getCause());
        return new ModelAndView("redirect:/error");
    }


}
