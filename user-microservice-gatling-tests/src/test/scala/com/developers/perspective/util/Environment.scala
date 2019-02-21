/**
  * Created by dmumma on 11/19/15.
  */

package com.developers.perspective.util

import java.util

object Environemnt {
  val baseURL = scala.util.Properties.envOrElse("baseURL", "http://localhost:1111/users")
  val users = scala.util.Properties.envOrElse("numberOfUsers", "500")
  val maxResponseTime = scala.util.Properties.envOrElse("maxResponseTime", "2000") // in milliseconds

}
