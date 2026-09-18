fun showMenu() {
    println("=== PLAYLIST ===")
    println("1 - Ver músicas")
    println("2 - Adicionar música")
    println("3 - Remover música")
    println("4 - Buscar música")
    println("5 - Música aleatória")
    println("0 - Sair")
}

fun showSongs(songs: List<String>) {
    if (songs.isEmpty()) {
        println("A playlist está vazia!")
    } else {
        for ((index, song) in songs.withIndex()) {
            println("${index + 1}: $song")
        }
    }
}

fun addSong(songs: MutableList<String>) {
    println("Adicione uma musica:")
    val song = readln()
    songs.add(song)
    println("Musica adicionada!")
}

fun removeSong(songs: MutableList<String>) {
    println("Remove uma musica ai:")
    showSongs(songs)
    val position = readln().toInt()
    if (position in 1..songs.size) {
        songs.removeAt(position - 1)
        println("Musica removida")
    } else {
        println("Posição Invalida")
    }
}

fun searchSong(songs: List<String>) {
    println("Procure sua musica:")
    val search = readln()

    var found = false

    for (song in songs) {
        if (song.contains(search)) {
            println("Musica encontrada: $song")
            found = true
        }
    }

    if (!found) {
        println("Musica ($search) não encontrada!")
    }
}
fun randomSong(songs: List<String>) {
    println("Escolhendo uma musica: ")
    val song = songs.random()
    println(song)
}


fun main() {
    val songs = mutableListOf<String>()

    var running = true

    while (running) {
        showMenu()
        val option = readln()
        when (option) {
            "1" -> {
                showSongs(songs)
            }
            "2" -> {
                addSong(songs)
            }
            "3" -> {
                removeSong(songs)
            }
            "4" -> {
                searchSong(songs)
            }
            "5" -> {
                randomSong(songs)
            }
            "0" -> {
                running = false
                println("Até logo")
            }
            else -> {
                println("Digite uma opção válida")
            }
        }
    }
}