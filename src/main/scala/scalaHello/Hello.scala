package scalaHello

import com.typesafe.scalalogging.LazyLogging

object Main extends LazyLogging{

  def main(args: Array[String]): Unit = {
    logger.info("Scala - Hello world and testing")
    val am = new ArrayMath(Array(7, 6, 10, 11, 12))
    am.run

    logger.info("LRU Cache example")
    val lc = new LRUCache(3)
    lc.add(1,2)
    lc.add(3,4)
    lc.add(5, 6)
    logger.info(s"Cache value for 1 is ${lc.get(1)}")
    lc.get(3)
    lc.get(5)
    lc.add(4, 8)
    logger.info(s"Cache value for 1 is now ${lc.get(1)}")
    logger.info(s"Cache value for 4 is now ${lc.get(4)}")
  }
}
