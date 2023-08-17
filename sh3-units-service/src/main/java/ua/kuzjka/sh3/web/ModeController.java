package ua.kuzjka.sh3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ModeController {
    @Autowired
    private Environment environment;

    @GetMapping("/editable")
    public boolean isEditable() {
        return environment.matchesProfiles("editable");
    }
}
