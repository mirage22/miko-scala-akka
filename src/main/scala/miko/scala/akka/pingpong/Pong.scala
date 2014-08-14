package miko.scala.akka.pingpong

import akka.actor.Actor

/**
 * @author miroslavkopecky
 *
 * Modified Example from ScalaCookbook
 * http://shop.oreilly.com/product/0636920026914.do
 * inspired by threading example in the book by James Gosling et al., The Java
 * Programming Language (Addison-Wesley Professional)
 */
class Pong extends Actor{
  def receive = {
    case PingMessage =>
      println(" pong")
      sender ! PongMessage
    case StopMessage =>
      println(" pong stopped")
      context.stop(self)
  }
}
