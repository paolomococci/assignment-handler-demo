/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demo.controller

import local.example.demo.assembler.JobResourceAssembler
import local.example.demo.exception.JobNotFoundException
import local.example.demo.model.Job
import local.example.demo.repository.JobRepository
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.net.URISyntaxException

@RestController
@RequestMapping("/api/jobs")
class JobRestController internal constructor(
        val jobRepository: JobRepository,
        val jobResourceAssembler: JobResourceAssembler
) {

    @PostMapping
    @Throws(URISyntaxException::class)
    fun create(@RequestBody job: Job): ResponseEntity<Resource<Job>> {
        val resource = jobResourceAssembler.toResource(jobRepository.save(job))
        return ResponseEntity.created(URI(resource.id.expand().href)).body(resource)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun read(@PathVariable id: Long?): Resource<Job> {
        return jobResourceAssembler.toResource(jobRepository.findById(id!!)
                .orElseThrow { JobNotFoundException(id) })
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    fun readAll(): Resources<Resource<Job>> {
        val jobs = jobRepository.findAll()
                .asSequence()
                .map(jobResourceAssembler::toResource).toList()
        return Resources(jobs,
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(JobRestController::class.java)
                        .readAll()).withSelfRel())
    }

    @DeleteMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun delete(@PathVariable id: Long?): ResponseEntity<*> {
        when { id != null -> 
              jobRepository.deleteById(id) 
             }
        return ResponseEntity.noContent().build<Any>()
    }
}
