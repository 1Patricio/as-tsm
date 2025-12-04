package com.`as`.tsm.data

import com.`as`.tsm.data.model.Book

class BookRepository {
    val bookList = mutableListOf(
        Book(1, "1984", "George Orwell", 1949, "Uma distopia sobre vigilância e controle."),
        Book(2, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "A jornada épica para destruir o Um Anel."),
        Book(3, "Dom Casmurro", "Machado de Assis", 1899, "A história de Bentinho e a dúvida eterna sobre Capitu."),
        Book(4, "Orgulho e Preconceito", "Jane Austen", 1813, "Um romance sobre classe social e amor."),
        Book(5, "O Hobbit", "J.R.R. Tolkien", 1937, "A aventura de Bilbo Bolseiro com anões e um dragão."),
        Book(6, "A Revolução dos Bichos", "George Orwell", 1945, "Uma sátira política sobre totalitarismo."),
        Book(7, "Crime e Castigo", "Fiódor Dostoiévski", 1866, "Raskólnikov enfrenta culpa após cometer um crime."),
        Book(8, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, "Uma fábula poética sobre amor e amizade."),
        Book(9, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997, "O início da história do jovem bruxo Harry."),
        Book(10, "Moby Dick", "Herman Melville", 1851, "A obsessão do capitão Ahab pela baleia branca."),
        Book(11, "O Apanhador no Campo de Centeio", "J.D. Salinger", 1951, "Holden Caulfield em uma jornada introspectiva."),
        Book(
            12,
            "O Nome do Vento",
            "Patrick Rothfuss",
            2007,
            "Kvothe narra sua história desde a infância."
        ),
        Book(13, "Coraline", "Neil Gaiman", 2002, "Uma menina descobre um mundo paralelo assustador."),
        Book(14, "It: A Coisa", "Stephen King", 1986, "Um mal antigo assombra uma pequena cidade."),
        Book(15, "O Código Da Vinci", "Dan Brown", 2003, "Um suspense envolvendo simbologia e segredos religiosos."),
        Book(16, "A Menina que Roubava Livros", "Markus Zusak", 2005, "A história de Liesel contada pela própria Morte."),
        Book(17, "O Poder do Hábito", "Charles Duhigg", 2012, "Como hábitos moldam nossas vidas."),
        Book(18, "Sapiens", "Yuval Noah Harari", 2011, "Um panorama da história da humanidade."),
        Book(19, "O Alquimista", "Paulo Coelho", 1988, "Santiago segue sua lenda pessoal."),
        Book(20, "A Arte da Guerra", "Sun Tzu", -500, "Estratégias militares aplicáveis até hoje."),
        Book(21, "Drácula", "Bram Stoker", 1897, "O clássico romance gótico sobre o vampiro."),
        Book(22, "Frankenstein", "Mary Shelley", 1818, "Um cientista cria vida e enfrenta as consequências."),
        Book(23, "Admirável Mundo Novo", "Aldous Huxley", 1932, "Uma distopia tecnológica e biologicamente controlada."),
        Book(24, "As Crônicas de Nárnia", "C.S. Lewis", 1950, "Um mundo mágico acessado por um guarda-roupa."),
        Book(25, "A Biblioteca da Meia-Noite", "Matt Haig", 2020, "Uma mulher visita vidas alternativas."),
        Book(26, "Neuromancer", "William Gibson", 1984, "O livro que definiu o cyberpunk."),
        Book(27, "Duna", "Frank Herbert", 1965, "Uma intriga política em um deserto cheio de perigos."),
        Book(28, "O Lobo de Wall Street", "Jordan Belfort", 2007, "A história real do corretor polêmico."),
        Book(29, "O Sol é Para Todos", "Harper Lee", 1960, "Um drama sobre racismo e justiça."),
        Book(30, "A Metamorfose", "Franz Kafka", 1915, "Um homem desperta transformado em inseto.")
    )
    fun getAllBooks() = bookList
}
