package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itpark.forms.GalleryForm;
import ru.itpark.models.file.FileInfo;
import ru.itpark.models.user.User;
import ru.itpark.services.AuthenticationService;
import ru.itpark.services.FilesService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class FileController {

  @Autowired
  private AuthenticationService authenticationService;

  @Autowired
  private FilesService filesService;




  @PostMapping(value = "/files")
  @ResponseStatus(value = HttpStatus.ACCEPTED)
  @ResponseBody // нужен, потому что мы возвращаем
  // не имя view, а название сохраненного файла
  // чтобы ViewResolver не пытался найти ftl
  // с таким названием
  // принимаем file как Multipart
  public String handleFileUpload(@RequestParam("file") MultipartFile multipartFile,
                                 @RequestParam("destination") String destination,
                                 String ticketId,
                                 Authentication authentication) {
    // отправляем логику сохранения на слой сервисов

    String modelId = ticketId;

      return filesService.save(authentication, multipartFile, destination, modelId);
  }


  @GetMapping("/files/{file-name:.+}")
  public void getFile(@PathVariable("file-name") String fileName,
                      HttpServletResponse response) {
    filesService.writeFileTOResponse(fileName, response);
  }


  @GetMapping ("/gallery")
  public String getGallery(@ModelAttribute("model") ModelMap model,
                           Authentication authentication) {
    if (authentication != null) {
      User user = authenticationService.getUserByAuthentication(authentication);
      model.addAttribute("user", user);
    }
    model.addAttribute("select", "gallery");
    String destination = "gallery";
    List<FileInfo> images = filesService.getImagesByDestination(destination);
    model.addAttribute("images", images);
    return "galleryPages/gallery";
  }


  @PostMapping("/add_view_name")
  public String addViewName (@ModelAttribute("model") ModelMap model,
                             Authentication authentication,
                             GalleryForm galleryForm) {
    if (authentication != null) {
      User user = authenticationService.getUserByAuthentication(authentication);
      model.addAttribute("user", user);
    }
    String viewName = filesService.addViewName(galleryForm);
    model.addAttribute("select", "gallery");
    String destination = "gallery";
    List<FileInfo> images = filesService.getImagesByDestination(destination);
    model.addAttribute("images", images);
    return "galleryPages/gallery";
  }



  @PostMapping("/delete_image")
  public String deleteImage (@ModelAttribute("model") ModelMap model,
                             Authentication authentication,
                             GalleryForm galleryForm) {
    if (authentication != null) {
      User user = authenticationService.getUserByAuthentication(authentication);
      model.addAttribute("user", user);
    }
    model.addAttribute("select", "gallery");
    String storageName = filesService.deleteImage (galleryForm);
    String destination = "gallery";
    List<FileInfo> images = filesService.getImagesByDestination(destination);
    model.addAttribute("images", images);
    return "galleryPages/gallery";
  }

}