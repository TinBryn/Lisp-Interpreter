import scala.io.StdIn

object Prompt
{
  def main(args: Array[String]): Unit =
  {
    println("lispy v0.0.1\ntype 'q' to quit\n")

    def loop(): Unit =
    {
      val line = StdIn.readLine("lispy > ")
      if (interpret(line)) loop()
    }

    loop()

    println("goodbye")
  }

  private def interpret(line: String): Boolean =
  {
    if (line.length == 1 && line(0) == 'q')
      false
    else
    {
      println(line)
      true
    }
  }
}
