package de.percsi.webEngine.persistence.file.tools
import org.slf4j.LoggerFactory
import java.nio.charset.StandardCharsets
import java.nio.file.*
import kotlin.streams.toList

class TextFileCRUD constructor(private val path: Path) {

    private val log = LoggerFactory.getLogger(TextFileCRUD::class.java)

    fun create(data: String): String? {
        return try {
            Files.write(path,data.toByteArray(StandardCharsets.UTF_8),StandardOpenOption.CREATE_NEW)
            log.info("File is created (${path})")
            data
        } catch (e: Exception) {
            log.error("File could not be created (${path}): ${e.localizedMessage}")
            null
        }
    }

    fun read(): String? {
        return try {
            val data = Files.lines(path).map { "$it\n" }.toList().joinToString(separator = "")
            log.info("File is read (${path})")
            data
        } catch (e: Exception) {
            log.error("File could not be read ($path): ${e.localizedMessage}")
            null
        }
    }

    fun update(data: String): String? {
        return try {
            return if (Files.isWritable(path)) {
                Files.write(path, data.toByteArray(StandardCharsets.UTF_8), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)
                log.info("File is updated ($path)")
                data
            }
            else
                throw NoSuchFileException("File does not exists ")
        } catch (e: Exception) {
            log.error("File could not be updated($path): ${e.localizedMessage}")
            null
        }
    }

    fun delete(): Boolean {
        return try {
            Files.delete(path)
            true
        } catch (e: Exception) {
            log.warn("File could not be deleted ($path): ${e.localizedMessage}")
            false
        }
    }
}