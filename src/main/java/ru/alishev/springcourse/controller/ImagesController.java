package ru.alishev.springcourse.controller;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)

public class ImagesController {

    @Value("${upload.path}")
    private String uploadPatch; //путь сохранения файла , задается в "application.properties"

    @Value("${patterns.patch.images}") // формат запроса доступа к картинкам
    private String patternsImages;

    @Value("${name_start_server}") // данные сервера
    private String nameServer;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public  String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {

        String imageUri = null; // URI картинки

        if (!file.isEmpty()) { // проверяем существование файла , если существует

            File uploadDir = new File(uploadPatch); // создаем директорию, записываем файл

            //если  директории не существут - создаем

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            //используем UUID , избавимся от коллизий

            String uuidFile = UUID.randomUUID().toString(); // парсируем строку
            String resultFilename = uuidFile + "." + file.getOriginalFilename(); // file_name . UUID
            //загрузка файла
            file.transferTo(new File(uploadPatch +"/" + resultFilename));
            // сборка URI
            imageUri = nameServer + patternsImages + resultFilename;

        }
        return "imageUri:"+ imageUri;
    }
}







