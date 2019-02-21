/**
  * Created by ankamma pallapu .
  */
package com.developers.perspective.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object PutUser {

  val userString = "{\"name\":\"Scala\", \"address\":\"hyderabad\"}"

  val putUserHttp = http("put user")
    .put("/user")
    .header("Content-Type", "application/json;charset=utf8")
    .body(StringBody(userString))
    .check(status is 200)

  val putUser = scenario("put user")
    .exec(putUserHttp)
}