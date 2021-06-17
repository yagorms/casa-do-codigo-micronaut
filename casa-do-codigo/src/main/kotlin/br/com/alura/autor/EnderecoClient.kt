package br.com.alura.autor

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("https://viacep.com.br/ws/")
interface EnderecoClient {

    @Get("{cep}/json")
    @Consumes(MediaType.APPLICATION_XML)
    fun consulta(cep: String) :HttpResponse<EnderecoResponse>
}