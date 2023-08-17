package ua.kuzjka.sh3.service;

import org.springframework.stereotype.Service;
import ua.kuzjka.sh3.dto.NationEntry;
import ua.kuzjka.sh3.dto.NewUnitRequest;
import ua.kuzjka.sh3.image.ImageService;
import ua.kuzjka.sh3.model.Nation;
import ua.kuzjka.sh3.repository.NationRepository;

import java.io.IOException;
import java.util.List;

@Service
public class NationsService {
    private NationRepository nationRepository;
    private ImageService imageService;

    public NationsService(NationRepository nationRepository, ImageService imageService) {
        this.nationRepository = nationRepository;
        this.imageService = imageService;
    }

    public List<NationEntry> getNations() {
        return this.nationRepository.findAllOrderByName().stream()
                .map(n -> new NationEntry(n.getName(), "/api/flags/" + imageService.getFilename(n.getId())))
                .toList();
    }

    public void saveNation(NewUnitRequest<String> request) {
        Nation nation = new Nation();
        nation.setName(request.getUnit());
        nation = nationRepository.save(nation);

        try {
            imageService.saveNationFlag(nation.getId(), request.getImage());
        } catch (IOException e) {
            throw new SH3ServiceException(e);
        }
    }
}
