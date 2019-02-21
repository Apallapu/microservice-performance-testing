package com.developers.perspective.simulation

/**
  * Created by ankamma pallapu
  */

import com.developers.perspective.util._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import com.developers.perspective.scenarios.{GetUsers, PostUser}

class UserMicroserviceSimulation extends Simulation {

  val httpConf = http.baseURL(Environemnt.baseURL)
                      .headers(Headers.commonHeader)

  val userMicroserviceScenarios = List(

    GetUsers.getUsers.inject(
      atOnceUsers(1),
      rampUsersPerSec(1) to 100 during(30 seconds) // 6
    ),

    PostUser.postUser.inject(atOnceUsers(Environemnt.users.toInt))
      .throttle(reachRps(600) in (20 seconds), holdFor(60 seconds))
  )

  setUp(userMicroserviceScenarios)
    .protocols(httpConf)
    .maxDuration(1 minutes)
    .assertions(
      global.responseTime.max.lessThan(Environemnt.maxResponseTime.toInt)
    )
}