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

package local.example.demo.model

import org.neo4j.ogm.annotation.*

@RelationshipEntity(type = "JOB")
class Job {

    @Id
    @GeneratedValue
    var id: Long? = null

    var rank: Int? = null

    @StartNode
    var employee: Employee? = null

    @EndNode
    var workOrder: WorkOrder? = null

    constructor()

    constructor(rank: Int?) {
        this.rank = rank
    }

    constructor(
            rank: Int?,
            employee: Employee?,
            workOrder: WorkOrder?
    ) {
        this.rank = rank
        this.employee = employee
        this.workOrder = workOrder
    }
}
