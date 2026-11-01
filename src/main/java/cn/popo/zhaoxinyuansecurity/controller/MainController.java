package cn.popo.zhaoxinyuansecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping({"/", "/index"})
    public String index() { return "index"; }

    @GetMapping("/normal")
    public String normal() { return "normal/index"; }

    @GetMapping("/admin")
    public String admin() { return "admin/index"; }

    @GetMapping("/403")
    public String accessDeny() { return "403"; }
}