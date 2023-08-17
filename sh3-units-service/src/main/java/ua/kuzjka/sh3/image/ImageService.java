package ua.kuzjka.sh3.image;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@Service
public class ImageService {
    private static final int THUMB_WIDTH = 200;
    private static final int FLAG_WIDTH = 24;
    private static final int FLAG_HEIGHT = 16;

    private File imagesDir;
    private File unitImagesDir;
    private File unitThumbnailsDir;
    private File nationFlagsDir;

    public ImageService(@Value("${sh3.dataDir}") String dataDir) throws IOException {
        this.imagesDir = new File(new File(dataDir), "images");
        this.unitImagesDir = new File(imagesDir, "units");
        this.unitThumbnailsDir = new File(imagesDir, "unitThumbs");
        this.nationFlagsDir = new File(imagesDir, "nationFlags");

        if (!this.imagesDir.mkdirs()) throw new IOException("Cannot create images dir");
        if (!this.unitImagesDir.mkdir()) throw new IOException("Cannot create unit images dir");
        if (!this.unitThumbnailsDir.mkdir()) throw new IOException("Cannot create unit thumbnail dir");
        if (!this.nationFlagsDir.mkdir()) throw new IOException("Cannot create nation flags dir");
    }

    public void saveUnitImage(int id, byte[] image) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(image)) {
            try (FileOutputStream imageOutput = new FileOutputStream(new File(imagesDir, getFilename(id)))) {
                bais.transferTo(imageOutput);
            }
            bais.reset();
            BufferedImage bufferedImage = ImageIO.read(bais);
            float ratio = (float) THUMB_WIDTH / bufferedImage.getWidth();
            int thumbHeight = Math.round(bufferedImage.getHeight() * ratio);
            Image thumbnail = bufferedImage.getScaledInstance(THUMB_WIDTH, thumbHeight, Image.SCALE_DEFAULT);
            BufferedImage bufferedThumb = new BufferedImage(THUMB_WIDTH, thumbHeight, BufferedImage.TYPE_INT_RGB);
            bufferedThumb.getGraphics().drawImage(thumbnail, 0, 0, null);
            ImageIO.write(bufferedThumb, "png", new File(unitThumbnailsDir, getFilename(id)));
        }
    }

    public byte[] getUnitImage(int id) throws IOException {
        try (InputStream is = new BufferedInputStream(new FileInputStream(new File(unitImagesDir, getFilename(id))))) {
            return is.readAllBytes();
        }
    }

    public byte[] getUnitThumbnail(int id) throws IOException {
        try (InputStream is = new FileInputStream(new File(unitThumbnailsDir, getFilename(id)))) {
            return is.readAllBytes();
        }
    }

    public void saveNationFlag(int id, byte[] flag) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(flag)) {
            BufferedImage bufferedImage = ImageIO.read(bais);
            Image resized = bufferedImage.getScaledInstance(FLAG_WIDTH, FLAG_HEIGHT, Image.SCALE_DEFAULT);
            BufferedImage bufferedFlag = new BufferedImage(FLAG_WIDTH, FLAG_HEIGHT, BufferedImage.TYPE_INT_RGB);
            bufferedFlag.getGraphics().drawImage(resized, 0, 0, null);
            ImageIO.write(bufferedFlag, "png", new File(nationFlagsDir, getFilename(id)));
        }
    }

    public byte[] getNationFlag(int id) throws IOException {
        try (InputStream is = new FileInputStream(new File(nationFlagsDir, getFilename(id)))) {
            return is.readAllBytes();
        }
    }

    public String getFilename(int id) {
        return String.format("%06d.png", id);
    }
}
