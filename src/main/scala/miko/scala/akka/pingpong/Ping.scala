package miko.scala.akka.pingpong

import akka.actor.{Actor, ActorRef}

/**
 * @author miroslavkopecky
 *
 * Modified Example from ScalaCookbook
 * http://shop.oreilly.com/product/0636920026914.do
 * inspired by threading example in the book by James Gosling et al., The Java
 * Programming Language (Addison-Wesley Professional)
 *
 * ! is used here as a binary operator with an actor and a message as arguments.
 */
class Ping(pong: ActorRef) extends Actor{
  var count = 0
  def incrementAndPrint() = {
    count += 1
    println("ping")
  }
  def receive = {
    case StartMessage =>
      incrementAndPrint()
      pong ! PingMessage
    case PongMessage =>
      incrementAndPrint()
      if(count > 7) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      } else {
        sender ! PingMessage
      }

  }
}
