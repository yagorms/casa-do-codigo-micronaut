package br.com.alura.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import javax.transaction.Transactional

@Controller("/autores")
class AtualizaAutorController(val autorRepository: AutorRepository) {

    @Put("/{id}")
    @Transactional
    fun atualiza(@PathVariable id: Long, descricao: String) : HttpResponse<Any> {
        val possivelAutor = autorRepository.findById(id)

        if (possivelAutor.isEmpty) {
            return HttpResponse.notFound()
        }

        val autor = possivelAutor.get()
        autor.descricao = descricao
//        *** A linha abaixo fica desnecessária quando usamos o transactional pois, quando fazemos a busca, qualquer alteração já é automaticamente gerenciada***
        autorRepository.update(autor)

        return HttpResponse.ok(DetalhesDoAutorResponse(autor))

    }
}