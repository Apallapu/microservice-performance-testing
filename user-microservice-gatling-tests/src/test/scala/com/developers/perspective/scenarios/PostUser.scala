/**
  * Created by ankamma pallapu .
  */
package com.developers.perspective.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object PostUser {

  val userString = "{\"name\":\"Scala\", \"address\":\"Java\"}"

  val postUserHttp = http("post user")
    .post("/user")
    .header("Content-Type", "application/json;charset=utf8")
    .body(StringBody(userString))
    .check(status is 200)

  val postUser = scenario("post user")
    .exec(postUserHttp)
}