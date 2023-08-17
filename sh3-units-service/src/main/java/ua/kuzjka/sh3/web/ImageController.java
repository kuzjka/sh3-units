package ua.kuzjka.sh3.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kuzjka.sh3.image.ImageService;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/units/{id}/image", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable int id) throws IOException {
        return imageService.getUnitImage(id);
    }

    @GetMapping(value = "/units/{id}/thumb", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getThumbnail(@PathVariable int id) throws IOException {
        return imageService.getUnitThumbnail(id);
    }

    @GetMapping(value = "/nations/{id}/flag", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public byte[] getNationFlag(@PathVariable int id) throws IOException {
        return imageService.getNationFlag(id);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Void> handleFileNotFound(FileNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
