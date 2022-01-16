package com.flow.backend.controller;

import com.flow.backend.domain.Fix;
import com.flow.backend.domain.Variable;
import com.flow.backend.repository.FixRepository;
import com.flow.backend.repository.VariableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {


    @RequestMapping("/")
    public String Home(Model model){
        return "index";
    }
}
