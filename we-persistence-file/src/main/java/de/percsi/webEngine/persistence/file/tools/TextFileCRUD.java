package de.percsi.webEngine.persistence.file.tools;


import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;

@Slf4j

public final class TextFileCRUD {

  private final Path path;

  TextFileCRUD(Path path) {
    this.path = path;
  }


  Option<String> create(String data) {
    return Try.of(() ->{
      Files.createFile(path);
      Files.write(path,data.getBytes(StandardCharsets.UTF_8));
      return Option.of(data);
    }).getOrElse(Option.none());
  }

  Option<String> read() {
    return Try.withResources(()-> Files.lines(path, StandardCharsets.UTF_8))
        .of(stringStream -> {
          StringBuilder sb = new StringBuilder();
          stringStream.forEach(strLine -> sb.append(strLine).append("\n"));
          return Option.of(sb.toString());
        }).getOrElse(Option.none());
  }

  Option<String> update(String data) {
    return Try.of(() ->{
      if (Files.isWritable(path)) {
        Files.write(path,data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.WRITE);
        return Option.of(data);
      } else {
        throw new NoSuchFileException(path.toString());
      }
    }).getOrElse(Option.none());
  }

  boolean delete(String fileName) {
    return Try.of(() -> {
      Files.delete(path);
      return true;
    }).getOrElse(false);
  }

}
