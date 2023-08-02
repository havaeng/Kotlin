/**
 * A very simple CLI with object(s) from one class.
 */

package booksCLI

class Book() {
    var ISBN: String? = null
    var title: String? = null
    var author: String? = null
    var yearOfPublication: String? = null

    constructor(ISBN: String, title: String, author: String, year: String) : this() {
        this.ISBN = ISBN
        this.title = title
        this.author = author
        this.yearOfPublication = year
    }
}

fun addBook(ISBN: String, title: String, author: String, year: String): Book {
    return Book(ISBN, title, author, year)
}

fun main(args: Array<String>) {
    val bookInventory: ArrayList<Book> = ArrayList()

    do {

        println("\nMenu:\n1. Add book\n2. Display details\n3. Exit program")

        var choice: Int? = readlnOrNull()?.toIntOrNull()

        when (choice) {
            1 -> {
                println("Adding new book")
                println("ISBN: ")
                var ISBN = readlnOrNull()
                println("Title: ")
                var title = readlnOrNull()
                println("Author: ")
                var author = readlnOrNull()
                println("Year: ")
                var year = readlnOrNull()
                bookInventory.add(
                    addBook(
                        ISBN.toString(),
                        title.toString(),
                        author.toString(),
                        year.toString()
                    )
                )
            }
            2 -> {
                println("Enter ISBN of book you would like to see details for:")
                var ISBN = readln()
                var bookFound = false

                for (book in bookInventory)
                    if (book.ISBN == ISBN) {
                        println("ISBN: ${book.ISBN}")
                        println("Title: ${book.title}")
                        println("Author: ${book.author}")
                        println("Publication Year: ${book.yearOfPublication}")
                        bookFound = true
                        break
                    }
                if (bookFound == false)
                    println("Book not found")
            }
            else -> {
                println("Wrong input")
            }
        }
    } while (choice != 3)
}
