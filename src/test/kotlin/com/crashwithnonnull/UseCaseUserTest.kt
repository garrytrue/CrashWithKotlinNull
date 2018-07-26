package com.crashwithnonnull

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.then
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class UseCaseUserTest {
    private val getDataUseCase: GetDataUseCase = mock()
    private val sut = UseCaseUser(getDataUseCase)

    @Test
    @DisplayName("test fetchData shall ask for data to use case")
    fun fetchData() {
        sut.fetchData()

        then(getDataUseCase).should().execute(any(), eq(null))
    }
}