package ru.itpark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.models.file.FileInfo;
import ru.itpark.models.users.User;

import java.util.List;

public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
  FileInfo findOneByStorageName(String fileName);
  FileInfo findFirstByDestinationAndUser(String destination, User user);
  List<FileInfo> findAllByDestination(String destination);
}