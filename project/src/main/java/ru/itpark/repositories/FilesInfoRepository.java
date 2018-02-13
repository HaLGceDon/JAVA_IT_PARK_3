package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.file.FileInfo;
import ru.itpark.models.user.User;

import java.util.List;

public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
  FileInfo findOneByStorageName(String fileName);
  List<FileInfo> findAllByUser(User user);
}