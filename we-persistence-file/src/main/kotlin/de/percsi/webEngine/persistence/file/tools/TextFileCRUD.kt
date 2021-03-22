package de.percsi.webEngine.persistence.file.tools

import org.apache.log4j.LogManager
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import kotlin.streams.toList

class TextFileCRUD internal constructor(private val path: Path) {

    private val log = LogManager.getLogger(TextFileCRUD::class.java)

    fun create(data: String): String? {
        return try {
            Files.createFile(path)
            Files.write(path,data.toByteArray(StandardCharsets.UTF_8))
            log.info("File is created (${path})")
            data
        } catch (e: Exception) {
            log.error("File could not be created (${path}): ${e.message}")
            null
        }
    }

    fun read(): String? {
        return try {
            val data = Files.lines(path).map { "$it\n" }.toList().toString()
            log.info("File is read (${path})")
            data
        } catch (e: Exception) {
            log.error("File could not be read ($path): ${e.message}")
            null
        }
    }

    fun update(data: String): String? {
        return try {
            return if (Files.isWritable(path)) {
                Files.write(path, data.toByteArray(StandardCharsets.UTF_8), StandardOpenOption.WRITE)
                log.info("File is updated ($path)")
                data
            }
            else
                throw NoSuchFileException("File does not exists ")
        } catch (e: Exception) {
            log.error("File could not be updated($path): ${e.message}")
            null
        }
    }

    fun delete(): Boolean {
        return try {
            Files.delete(path)
            true
        } catch (e: Exception) {
            log.error("File could not be deleted ($path): ${e.message}")
            false
        }
    }
}