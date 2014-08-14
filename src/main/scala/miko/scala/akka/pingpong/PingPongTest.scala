package miko.scala.akka.pingpong

import akka.actor.{Props, ActorSystem}
import org.slf4j.LoggerFactory

/**
 * @author miroslavkopecky
 *
 * Modified Example from Scala Cookbook
 * http://shop.oreilly.com/product/0636920026914.do
 * inspired by threading example in the book by James Gosling et al., The Java
 * Programming Language (Addison-Wesley Professional)
 */
object PingPongTest{
  private val logger = LoggerFactory.getLogger(getClass)
  def main(args: Array[String]): Unit = {
    logger.debug("---PingPong Game App Start---")
    val system = ActorSystem("PingPongSystem")
    val pong = system.actorOf(Props[Pong], name = "pong")
    val ping = system.actorOf(Props(new Ping(pong)), name = "ping")

    // Start the game
    ping ! StartMessage
    logger.debug("---PingPong Game App End---")
    system.shutdown()
  }
}
