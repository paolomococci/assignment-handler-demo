/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demo.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.voodoodyne.jackson.jsog.JSOGGenerator
import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@JsonIdentityInfo(generator = JSOGGenerator::class)
@NodeEntity(label = "Employee")
class Employee {

    @Id
    @GeneratedValue
    var id: Long? = null

    var name: String? = null
    var surname: String? = null

    @Relationship(type = "JOB")
    val jobs: MutableSet<Job> = hashSetOf()

    constructor()

    constructor(
            name: String?,
            surname: String?
    ) {
        this.name = name
        this.surname = surname
    }
}
