package ua.kuzjka.sh3.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kuzjka.sh3.dto.NationEntry;
import ua.kuzjka.sh3.service.NationsService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NationsController {
    private NationsService nationsService;

    public NationsController(NationsService nationsService) {
        this.nationsService = nationsService;
    }

    @GetMapping("/nations")
    public List<NationEntry> getNations() {
        return nationsService.getNations();
    }
}
