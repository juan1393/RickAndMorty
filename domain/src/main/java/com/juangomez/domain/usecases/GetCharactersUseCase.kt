package com.juangomez.domain.usecases

import com.juangomez.common.Either
import com.juangomez.common.Failure
import com.juangomez.domain.models.Character
import com.juangomez.domain.repositories.CharacterRepository

class GetCharacterUseCase(private val characterRepository: CharacterRepository) :
    BaseUseCase<List<Character>, GetCharacterUseCase.Params>() {

    override suspend fun run(params: Params): Either<Failure, List<Character>> =
        characterRepository.getCharactersById(params.ids)

    data class Params(val ids: List<Int>)
}