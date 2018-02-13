package ru.itpark.services;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.forms.GalleryForm;
import ru.itpark.models.file.FileInfo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FilesService {
   String save(Authentication authentication, MultipartFile multipartFile);

    void writeFileTOResponse(String fileName, HttpServletResponse response);

    List<FileInfo> getAdminImages();

    String addViewName(GalleryForm galleryForm);

    String deleteImage(GalleryForm galleryForm);
}