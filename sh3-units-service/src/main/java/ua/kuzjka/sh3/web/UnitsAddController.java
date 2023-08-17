package ua.kuzjka.sh3.web;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import ua.kuzjka.sh3.dto.*;
import ua.kuzjka.sh3.service.UnitsService;

import java.util.List;

@Profile("editable")
@RestController
@RequestMapping("/api")
public class UnitsAddController {
    private UnitsService unitsService;

    public UnitsAddController(UnitsService unitsService) {
        this.unitsService = unitsService;
    }

    @GetMapping("/merchantSelection")
    public List<UnitSelectionEntry> getMerchantSelection() {
        return unitsService.getMerchantSelection();
    }

    @GetMapping("/warshipSelection")
    public List<UnitSelectionEntry> getWarshipSelection() {
        return unitsService.getWarshipSelection();
    }

    @GetMapping("/uboatSelection")
    public List<UnitSelectionEntry> getUBoatSelection() {
        return unitsService.getUBoatSelection();
    }

    @GetMapping("/aircraftSelection")
    public List<UnitSelectionEntry> getAircraftSelection() {
        return unitsService.getAircraftSelection();
    }

    @PostMapping("/merchant")
    public void addMerchant(@RequestBody NewUnitRequest<MerchantDto> request) {
        unitsService.saveMerchant(request);
    }

    @PostMapping("/warship")
    public void addWarship(@RequestBody NewUnitRequest<WarshipDto> request) {
        unitsService.saveWarship(request);
    }

    @PostMapping("/uboat")
    public void addUBoat(@RequestBody NewUnitRequest<UBoatDto> request) {
        unitsService.saveUBoat(request);
    }

    @PostMapping("/aircraft")
    public void addAircraft(@RequestBody NewUnitRequest<AircraftDto> request) {
        unitsService.saveAircraft(request);
    }
}
