package ru.itpark.services;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.forms.GalleryForm;
import ru.itpark.models.FileInfo;
import ru.itpark.repositories.FilesInfoRepository;
import ru.itpark.repositories.UsersRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class FilesServiceImpl implements FilesService {

  @Autowired
  private FilesInfoRepository filesInfoRepository;

  @Autowired
  private UsersRepository usersRepository;

  @Value(value = "${storage.path}")
  private String storagePath;

  @Override
  @SneakyThrows
  public String save(Authentication authentication, MultipartFile multipartFile) {
    // создаем объект с иноформацией о файле
    // которая будет хранится в бд
    FileInfo fileInfo = FileInfo.builder()
            .originalName(multipartFile.getOriginalFilename())
            .size(multipartFile.getSize())
            .user(usersRepository.findByLogin(authentication.getName()).get())
            .type(multipartFile.getContentType())
            .build();
    // генерируем случайное имя файла чтобы не было коллизий
    String newName = UUID.randomUUID().toString().replace("-","");
    // забираем расширение файла
    String extension = multipartFile.getOriginalFilename()
            .substring(multipartFile.getOriginalFilename().lastIndexOf("."),
                    multipartFile.getOriginalFilename().length());
    // задаем новое имя с расширением
    fileInfo.setStorageName(newName + extension);
    // формируем url к файлу
    fileInfo.setUrl(storagePath + "\\" + fileInfo.getStorageName());
    // копируем его на диск
    Files.copy(multipartFile.getInputStream(),
            Paths.get(storagePath, fileInfo.getStorageName()));
    // сохраняем информацию в БД
    filesInfoRepository.save(fileInfo);
    // возвращаем клиенту имя файла
    return fileInfo.getStorageName();
  }

  @Override
  @SneakyThrows
  public void writeFileTOResponse(String fileName, HttpServletResponse response) {
    FileInfo fileInfo = filesInfoRepository.findOneByStorageName(fileName);
    response.setContentType(fileInfo.getType());
    InputStream inputStream = new FileInputStream(
            new File(fileInfo.getUrl()));
    IOUtils.copy(inputStream, response.getOutputStream());
    response.flushBuffer();
  }


  @Override
  public List<FileInfo> getAdminImages() {

    return filesInfoRepository.findAllByUser(usersRepository.findOne(1L));

  }

  @Override
  public String addViewName(GalleryForm galleryForm) {
    FileInfo fileInfo = filesInfoRepository.findOneByStorageName(galleryForm.getStorageName());
    fileInfo.setViewName(galleryForm.getViewName());
    filesInfoRepository.save(fileInfo);
    return fileInfo.getViewName();
  }

    @Override
    public String deleteImage(GalleryForm galleryForm) {
        FileInfo image = filesInfoRepository.findOneByStorageName(galleryForm.getStorageName());
        filesInfoRepository.delete(image);
        return image.getViewName();
    }
}
