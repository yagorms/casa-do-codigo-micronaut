package br.com.alura.autor

//class DetalhesDoAutorResponse(autor: Autor) {
//
//    val nome = autor.nome
//    val email = autor.email
//    val descricao = autor.descricao
//
//}

class DetalhesDoAutorResponse(
    val nome: String,
    val email: String,
    val descricao: String
){
    constructor(autor: Autor) : this (autor.nome, autor.email, autor.descricao)
}
