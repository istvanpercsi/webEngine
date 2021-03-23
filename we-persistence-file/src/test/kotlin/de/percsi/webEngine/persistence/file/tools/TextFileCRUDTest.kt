package de.percsi.webEngine.persistence.file.tools

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.nio.file.Paths

class TextFileCRUDTest : FunSpec({

    val path = "./test.txt"
    val testText = "{\n" +
            "  id: 1,\n" +
            "  apple: {\n" +
            "    type: Computer\n" +
            "  }\n" +
            "}\n"

    beforeEach {
        val tfcrud = TextFileCRUD(Paths.get(path))
        tfcrud.delete()

    }

    afterEach {
        val tfcrud = TextFileCRUD(Paths.get(path))
        tfcrud.delete()
    }

    test("Test write file") {
        // arrange
        val tfcrud = TextFileCRUD(Paths.get(path))

        // act
        val ret = tfcrud.create(testText)

        // assert
        ret shouldBe testText
    }

    test("Test write and read file") {
        // arrange
        val tfcrud = TextFileCRUD(Paths.get(path))
        tfcrud.create(testText)

        // act
        val ret = tfcrud.read()

        // assert
        ret shouldBe testText
    }

    test("Test write and update and read file") {
        // arrange
        val tfcrud = TextFileCRUD(Paths.get(path))
        tfcrud.create(testText)
        val alterText = "Alter Text"

        // act
        val retU = tfcrud.update(alterText)
        val retR = tfcrud.read()

        // assert
        retU shouldBe alterText
        retR shouldBe "$alterText\n"
    }
})
