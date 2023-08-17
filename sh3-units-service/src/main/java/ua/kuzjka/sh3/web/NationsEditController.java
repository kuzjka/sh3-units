package ua.kuzjka.sh3.web;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kuzjka.sh3.dto.NewUnitRequest;
import ua.kuzjka.sh3.dto.OrderOfBattleDto;
import ua.kuzjka.sh3.service.NationsService;

@Profile("editable")
@RestController
@RequestMapping("/api")
public class NationsEditController {
    private NationsService nationsService;

    public NationsEditController(NationsService nationsService) {
        this.nationsService = nationsService;
    }

    @PostMapping("/nation")
    public void addNation(NewUnitRequest<String> request) {
        nationsService.saveNation(request);
    }

    @PutMapping("/order")
    public void editOrderOfBattle(OrderOfBattleDto request) {
        nationsService.saveOrderOfBattle(request);
    }
}
