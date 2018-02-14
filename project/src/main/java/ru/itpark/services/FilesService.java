package ru.itpark.services;

import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.forms.GalleryForm;
import ru.itpark.models.file.FileInfo;
import ru.itpark.models.user.User;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FilesService {
   String save(Authentication authentication, MultipartFile multipartFile, String destination, String modelId);

    void writeFileTOResponse(String fileName, HttpServletResponse response);

    List<FileInfo> getImagesByDestination(String destination);

    FileInfo getImageByDestinationAndUser(String destination, User user);

    String addViewName(GalleryForm galleryForm);

    String deleteImage(GalleryForm galleryForm);
}