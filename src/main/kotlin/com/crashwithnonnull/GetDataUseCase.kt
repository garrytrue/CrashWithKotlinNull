package com.crashwithnonnull

import com.crashwithnonnull.data.Project
import io.reactivex.Observable


class GetDataUseCase constructor(
        private val repository: ProjectsRepository)
    : ObservableUseCase<List<Project>, Nothing>() {
    override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> =
            repository.getProjects()
}

interface ProjectsRepository {
    fun getProjects(): Observable<List<Project>>
}
