package com.developers.perspective.scenarios

/**
  * Created by ankamma pallapu
  */


import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetUsers {

  val getUsersHttp = http("get all users")
                        .get("/user")
                        .check(status is 200)

  val getUsers = scenario("Get All users")
                .exec(getUsersHttp)
}
